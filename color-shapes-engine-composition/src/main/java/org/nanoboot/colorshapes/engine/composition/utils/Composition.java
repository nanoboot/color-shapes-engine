
///////////////////////////////////////////////////////////////////////////////////////////////
// color-shapes-engine: A logic game based on Color linez game.
// Copyright (C) 2016-2022 the original author or authors.
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; version 2
// of the License only.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
///////////////////////////////////////////////////////////////////////////////////////////////

package org.nanoboot.colorshapes.engine.composition.utils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.nanoboot.colorshapes.engine.entity.exceptions.ColorShapesEngineException;
import org.nanoboot.powerframework.json.JsonObject;
import org.nanoboot.powerframework.json.JsonObjectSerializable;
import org.nanoboot.powerframework.random.generators.RandomGenerator;
import org.nanoboot.powerframework.reflection.ReflectionUtils;

import static org.nanoboot.colorshapes.engine.composition.utils.CompositionProcessors.DEFAULT_PROCESSOR;
import static org.nanoboot.colorshapes.engine.composition.utils.CompositionProcessors.RANDOM_PROCESSOR;
import static org.nanoboot.colorshapes.engine.composition.utils.CompositionProcessors.VALIDATE_PROCESSOR;

/**
 * Represents a composition.
 *
 * @param <C> class generic parameter
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 * <p>
 * Note: Every class implementing this interface must have at least:
 * one constructor without any parameter
 * and
 * one constructor with org.nanoboot.powerframework.json.JsonObject parameter,
 * which calls fromJsonObject(jo).
 * otherwise the reflection parts will be failing.
 * </p>
 * Example:
 * <pre>public AComposition() {
 *     }
 *
 *     public AComposition(JsonObject jo) {
 *         fromJsonObject(jo);
 *     }
 * </pre>
 */
public interface Composition<C extends Composition>
        extends JsonObjectSerializable, Lockable {
    String ID = "id";
    /**
     * Returns name of this composition.
     *
     * @return name of this composition
     * @implNote Must be unique in the children list
     * Default implementation uses the class name
     * and makes the first letter lowerCase.
     */
    default String getName() {
        String className = returnThis().getClass().getSimpleName();
        return makeFirstLetterLowerCase(className);
    }
    /**
     * Makes the first string lowerCase.
     * @param string given string
     * @return transformed string
     * todo: move to power-framework
     */
    private static String makeFirstLetterLowerCase(final String string) {
        return string.substring(0, 1)
                .toLowerCase() + string.substring(1, string.length());
    }
    /**
     * @return validates this composition
     * @author Robert Vokac
     * @since 0.0.0
     * @implNote This default implementation must be overridden in case,
     * the composition has no children, otherwise some exceptions
     * will be thrown.
     */
    default boolean validate() {
        return processChildren(VALIDATE_PROCESSOR) && additionalValidate();
    }

    /**
     * @return String containing the name of the root composition,
     * which is invalid.
     * If this composition is valid, empty String is returned
     */
    default String getInvalidReason() {
        if (validate()) {
            return "";
        }
        if (this.isLeaf()) {
            return this.getName();
        }
        for (Composition c : getChildren()) {
            if (!c.validate()) {
                return c.getInvalidReason();
            }
        }
        return getName();
    }

    //TODO
//    /**
//     * @return String containing the name of the root composition,
//     * which is invalid.
//     * If this composition is valid, empty String is returned
//     */
//    String getErrorCode();

    /**
     * @return root invalid composition
     */
    default Composition getInvalidComposition() {
        if (validate()) {
            return null;
        }
        if (this.isLeaf()) {
            return this;
        }
        for (Composition c : getChildren()) {
            if (!c.validate()) {
                return c;
            }
        }
        return null;
    }

    /**
     * @return Text description of possible reasons,
     * why this composition is not valid.
     */
    String describePossibleReasonsIfInvalid();

    /**
     * @return validates this composition (additional
     * @author Robert Vokac
     * @since 0.0.0
     * @implNote This method is called in validate().
     * Default implementation has empty body.
     * If you want to use additional validation,
     * you must override this default implementation.
     */
    default boolean additionalValidate() {
        return true;
    }
    /**
     * Sets random values.
     *
     * @return result of the operation
     * @author Robert Vokac
     * @since 0.0.0
     * @implNote This default implementation must be overridden in case,
     * the composition has no children, otherwise some exceptions
     * will be thrown.
     */
    default boolean setRandomValues() {
        return processChildren(RANDOM_PROCESSOR);
    }

    /**
     * Sets default values.
     *
     * @return result of the operation
     * @author Robert Vokac
     * @since 0.0.0
     * @implNote This default implementation must be overridden in case,
     * the composition has no children, otherwise some exceptions
     * will be thrown.
     */
    default boolean setDefaultValues() {
        return processChildren(DEFAULT_PROCESSOR);
    }

    /**
     * @return true, if this composition is default, otherwise false.
     * @implNote This default implementation must be overridden in case,
     * the composition has no children, otherwise some exceptions
     * will be thrown.
     */
    default boolean isDefault() {
        C c = createCopy();
        c.setDefaultValues();
        String defaultC = c.toJsonObject().toMinimalString();
        return defaultC.equals(this.toJsonObject().toMinimalString());
    }

    /**
     * Processes all children.
     *
     * @param compositionProcessor composition processor
     * @return result of this check
     * @implNote This implementation should not be
     * overridden in the implementing class. But this method is private.
     * @throws ColorShapesEngineException, if the composition has no children.
     * @author Robert Vokac
     * @since 0.0.0
     */
    private boolean processChildren(CompositionProcessor compositionProcessor) {
        if (this.isLeaf()) {
            String msg =
                    getName() + " has no child, cannot process children. "
                    + "The default implementation should not be "
                    + "called in this case.";
            throw new ColorShapesEngineException(msg);
        }
        List<Composition> list = this.getChildren();
        boolean result;
        for (Composition element : list) {
            result = compositionProcessor.apply(element);
            if (!result) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return copy of the object
     * @implNote This implementation should not be
     * overridden in the implementing class
     * @author Robert Vokac
     * @since 0.0.0
     */
    default C createCopy() {
        C emptyInstance = returnEmptyInstance();
        C copy = emptyInstance;
        copy.fromJsonObject(this.toJsonObject());
        return copy;
    }

    /**
     * Checks, if this composition is a leaf.
     *
     * @return true, if this composition has no children, otherwise false
     * @implNote This implementation should not be
     * overridden in the implementing class
     */
    default boolean isLeaf() {
        return getChildren() == null
                ||
                getChildren().isEmpty();
    }

    /**
     * @return all children compositions
     * @author Robert Vokac
     * @since 0.0.0
     * @implNote This method must be overridden,
     * if the composition has some children.
     */
    default List<Composition> getChildren() {
        return Collections.emptyList();
    }

    /**
     * Creates json object from this composition.
     *
     * @return json object representation of this composition
     * @implNote This implementation must be overridden,
     * if the composition has no children.
     * @author Robert Vokac
     * @since 0.0.0
     */
    default JsonObject toJsonObject() {
        if (this.isLeaf()) {
            String msg =
                    "Default implementation of toJsonObject() "
                            + "cannot be called, "
                            + "because isLeaf() returns true.";
            throw new ColorShapesEngineException(msg);
        }
        JsonObject jo = getInitialJsonObject();
        for (Composition c : getChildren()) {
            jo.add(c.getName(), c.toJsonObject());
        }
        return jo;
    }

    /**
     * Updates this composition by a json object.
     *
     * @param jo json object to be used
     *           to update this composition
     * @implNote This implementation must be overridden,
     * if the composition has no children.
     * @author Robert Vokac
     * @since 0.0.0
     */
    default void fromJsonObject(JsonObject jo) {
        if (this.isLeaf()) {
            String msg =
                    "Default implementation of fromJsonObject() "
                            + "cannot be called, "
                            + "because isLeaf() returns true.";
            throw new ColorShapesEngineException(msg);
        }
        for (String beanName : jo.keyList()) {
            if (beanName.equals("class")) {
                //class is not a bean name
                continue;
            }
            if (beanName.equals("id")) {
                Object child = jo.get(beanName);
                if(child != null) {
                    setId(jo.getString(beanName));
                }
                continue;
            }
            JsonObject child = jo.getObject(beanName);
            Class childClass = ReflectionUtils
                    .getClassForName(child.getString("class"));

            Constructor constructor = ReflectionUtils
                    .getConstructor(childClass, JsonObject.class);
            Composition bean = (Composition) ReflectionUtils
                    .newInstance(constructor, child);
            ReflectionUtils.setBean(returnThis(), beanName, bean);
        }
    }

    /**
     * @return Class object for the instance
     * @implNote This implementation must not be
     * overridden in the implementing class
     */
    default Class returnClass() {
        return returnThis().getClass();
    }

    /**
     * @return this instance
     */
    C returnThis();

    /**
     * @return empty instance of the object
     * @implNote This implementation must not be
     * overridden in the implementing class
     */
    default C returnEmptyInstance() {
        Class thisClass = returnClass();
        Constructor constructor = ReflectionUtils.getConstructor(thisClass);
        Composition emptyInstance = (Composition) ReflectionUtils
                .newInstance(constructor);
        return (C) emptyInstance;
    }

    /**
     * Returns starting json object used to create
     * the full json object representation.
     *
     * @return starting json object (contains only one property "class")
     * @implNote This implementation should not be
     * overridden in the implementing class
     */
    default JsonObject getInitialJsonObject() {
        JsonObject jo = new JsonObject();
        jo.add("class", returnClass().getName());
        jo.add("id", getId());
        return jo;
    }
    /**
     * Checks, if the value is in the given range.
     * @param value value
     * @param minValue min value
     * @param maxValue max value
     * @return true, if the value is in the range,
     * otherwise false.
     */
    //TODO : move to Power Framework
    static boolean isInRange(int value, int minValue, int maxValue) {
        return (value >= minValue) && (value <= maxValue);
    }

    /**
     * @return random generator
     */
    default RandomGenerator getRandom() {
        return RandomGenerator.getDefaultImplStatic();
    }

    /**
     * Returns list of children or null, if there is no child.
     * @return children
     */
    default List<Lockable> getLockableChildren() {
        List<Lockable> children = new ArrayList<>();
        for (Composition e : getChildren()) {
            children.add(e);
        }
        return children;
    }
    void setId(String id);
    String getId();
    //todo: prevent changes, if object is locked
}
