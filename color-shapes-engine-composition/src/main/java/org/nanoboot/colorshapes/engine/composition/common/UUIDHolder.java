
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

package org.nanoboot.colorshapes.engine.composition.common;

import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.nanoboot.colorshapes.engine.composition.AbstractComposition;
import org.nanoboot.colorshapes.engine.composition.utils.Composition;
import org.nanoboot.colorshapes.engine.composition.utils.Lockable;
import org.nanoboot.powerframework.json.JsonObject;

/**
 * Class holding an Integer value implementing Composition.
 * @param <C> composition type
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
public abstract class UUIDHolder<C extends Composition> extends AbstractComposition   
        implements Composition<C> {

     /**
     * The value to be hold.
     */
    @Getter
    @Setter
    private UUID value;

    /**
     * Constructor.
     *
     * @param value value to be hold
     */
    public UUIDHolder(
            final UUID value) {
        this.setValue(value);
    }

    /**
     * Constructor.
     */
    public UUIDHolder() {
    }
    /**
     * Constructor.
     *
     * @param jo json object
     */
    public UUIDHolder(final JsonObject jo) {
        fromJsonObject(jo);
    }

    /**
     * Can be overridden.
     * @return result of the validation
     */
    @Override
    public boolean validate() {
        return additionalValidate();
    }
    @Override
    public final String describePossibleReasonsIfInvalid() {
        return null;
    }

    /**
     * @return json object
     */
    @Override
    public JsonObject toJsonObject() {
        JsonObject jo = getInitialJsonObject();
        jo.add("value", this.getValue() == null ? null : this.getValue().toString());
        return jo;
    }

    /**
     * @param jsonObject json object
     */
    @Override
    public void fromJsonObject(final JsonObject jsonObject) {
        String str= jsonObject.get("value") == null ? null : jsonObject.getString("value");
        
        this.setValue(str == null ? null : UUID.fromString(str));
    }
    
        /**
     * Returns list of children or null, if there is no child.
     * @return children, if they exist, otherwise null
     */
    @Override
    public List<Lockable> getLockableChildren() {
        return null;
    }

}
