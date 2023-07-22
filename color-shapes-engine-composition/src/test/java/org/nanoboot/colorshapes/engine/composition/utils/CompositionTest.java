
///////////////////////////////////////////////////////////////////////////////////////////////
// color-shapes-engine: A logic game based on Color linez game.
// Copyright (C) 2016-2023 the original author or authors.
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

import org.nanoboot.colorshapes.engine.base.exceptions.ColorShapesEngineException;
import org.nanoboot.powerframework.collections.PowerList;
import org.nanoboot.powerframework.json.JsonObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author <a href="mailto:robertvokac@nanoboot.org">Robert Vokac</a>
 * @since 0.0.0
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class CompositionTest {

    @Spy
    private CompositionDummyImpl compositionDummyImpl;
    @Spy
    private PlusComposition plusComposition;
    @Spy
    private MinusComposition minusComposition;

    @Before
    public void setup() {
        this.compositionDummyImpl.setPlusComposition(plusComposition);
        this.compositionDummyImpl.setMinusComposition(minusComposition);
    }

    @Test
    public void getName() {
        //prepare
        //execute
        //assert
        assertEquals("compositionDummyImpl", compositionDummyImpl.getName());
        assertEquals("plusComposition", plusComposition.getName());
        assertEquals("minusComposition", minusComposition.getName());
    }

    @Test
    public void getName2() {
        //prepare
        //execute
        //assert
        assertEquals("compositionDummy2Impl", new CompositionDummy2Impl().getName());
    }

    @Test(expected = ColorShapesEngineException.class)
    public void validate_isLeaf() {
        //prepare
        when(compositionDummyImpl.isLeaf())
                .thenReturn(true);
        boolean result;
        //execute
        result = compositionDummyImpl.validate();
        //assert
    }

    @Test
    public void validate1() {
        //prepare
        boolean result;
        //
        when(plusComposition.validate()).thenReturn(false);
        when(minusComposition.validate()).thenReturn(false);
        //execute
        result = compositionDummyImpl.validate();
        //assert
        assertEquals(false, result);
        ////
        //prepare
        when(plusComposition.validate()).thenReturn(false);
        when(minusComposition.validate()).thenReturn(true);
        //execute
        result = compositionDummyImpl.validate();
        //assert
        assertEquals(false, result);
        ////
        //prepare
        when(plusComposition.validate()).thenReturn(true);
        when(minusComposition.validate()).thenReturn(false);
        //execute
        result = compositionDummyImpl.validate();
        //assert
        assertEquals(false, result);
        ////
        //prepare
        when(plusComposition.validate()).thenReturn(true);
        when(minusComposition.validate()).thenReturn(true);
        //execute
        result = compositionDummyImpl.validate();
        //assert
        assertEquals(true, result);
        ////
    }

    @Test
    public void validate2() {
        //prepare
        boolean result;
        //
        plusComposition.setValue(-100);
        minusComposition.setValue(100);
        //execute
        result = compositionDummyImpl.validate();
        //assert
        assertEquals(false, result);
        ////
        //prepare
        plusComposition.setValue(-100);
        minusComposition.setValue(-100);
        //execute
        result = compositionDummyImpl.validate();
        //assert
        assertEquals(false, result);
        ////
        //prepare
        plusComposition.setValue(100);
        minusComposition.setValue(100);
        //execute
        result = compositionDummyImpl.validate();
        //assert
        assertEquals(false, result);
        ////
        //prepare
        plusComposition.setValue(100);
        minusComposition.setValue(-100);
        //execute
        result = compositionDummyImpl.validate();
        //assert
        assertEquals(true, result);
    }

    @Test
    public void validate3() {
        //prepare
        when(plusComposition.validate()).thenReturn(true);
        when(minusComposition.validate()).thenReturn(true);
        when(compositionDummyImpl.additionalValidate())
                .thenReturn(true);
        boolean result;
        //execute
        result = compositionDummyImpl.validate();
        //assert
        assertEquals(true, result);
    }

    @Test
    public void validate4() {
        //prepare
        when(plusComposition.validate()).thenReturn(true);
        when(minusComposition.validate()).thenReturn(true);
        when(compositionDummyImpl.additionalValidate())
                .thenReturn(false);
        boolean result;
        //execute
        result = compositionDummyImpl.validate();
        //assert
        assertEquals(false, result);
    }

    @Test
    public void getInvalidReason() {
        //prepare
        Composition spyC = new Composition() {
            @Override
            public void lock() {

            }

            @Override
            public boolean isLocked() {
                return false;
            }

            @Override
            public String describePossibleReasonsIfInvalid() {
                return null;
            }

            @Override
            public Composition returnThis() {
                return null;
            }

            @Override
            public boolean validate() {
                return true;
            }

            @Override
            public void setId(String id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public String getId() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        //execute
        //assert
        assertEquals("", spyC.getInvalidReason());
    }

    @Test
    public void getInvalidReason2() {
        //prepare
        Composition spyC = new Composition() {
            @Override
            public void lock() {

            }

            @Override
            public boolean isLocked() {
                return false;
            }

            @Override
            public String describePossibleReasonsIfInvalid() {
                return null;
            }

            @Override
            public Composition returnThis() {
                return null;
            }

            @Override
            public boolean validate() {
                return false;
            }

            @Override
            public boolean isLeaf() {
                return true;
            }

            @Override
            public String getName() {
                return "test2";
            }

            @Override
            public void setId(String id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public String getId() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        //execute
        //assert
        assertEquals("test2", spyC.getInvalidReason());
    }

    @Test
    public void getInvalidReason3() {
        //prepare
        Composition spyC = new Composition() {
            @Override
            public void lock() {

            }

            @Override
            public boolean isLocked() {
                return false;
            }

            @Override
            public String describePossibleReasonsIfInvalid() {
                return null;
            }

            @Override
            public Composition returnThis() {
                return null;
            }

            @Override
            public boolean validate() {
                return false;
            }

            @Override
            public boolean isLeaf() {
                return false;
            }

            @Override
            public String getName() {
                return "test2";
            }

            @Override
            public void setId(String id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public String getId() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public List<Composition> getChildren() {
                return new PowerList<>(
                        new Composition() {

                    @Override
                    public void lock() {

                    }

                    @Override
                    public boolean isLocked() {
                        return false;
                    }

                    @Override
                    public String describePossibleReasonsIfInvalid() {
                        return "abc";
                    }

                    @Override
                    public Composition returnThis() {
                        return null;
                    }

                    @Override
                    public boolean validate() {
                        return false;
                    }

                    @Override
                    public String getName() {
                        return "reason_";
                    }

                    @Override
                    public void setId(String id) {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public String getId() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                }
                );
            }
        };
        //execute
        //assert
        assertEquals("reason_", spyC.getInvalidReason());
    }

    @Test
    public void getInvalidComposition() {
        //prepare
        Composition spyC = new Composition() {
            @Override
            public void lock() {

            }

            @Override
            public boolean isLocked() {
                return false;
            }

            @Override
            public String describePossibleReasonsIfInvalid() {
                return null;
            }

            @Override
            public Composition returnThis() {
                return null;
            }

            @Override
            public boolean validate() {
                return true;
            }

            @Override
            public void setId(String id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public String getId() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        //execute
        //assert
        assertEquals(null, spyC.getInvalidComposition());
    }

    @Test
    public void getInvalidComposition2() {
        //prepare
        Composition spyC = new Composition() {
            @Override
            public void lock() {

            }

            @Override
            public boolean isLocked() {
                return false;
            }

            @Override
            public String describePossibleReasonsIfInvalid() {
                return null;
            }

            @Override
            public Composition returnThis() {
                return null;
            }

            @Override
            public boolean validate() {
                return false;
            }

            @Override
            public boolean isLeaf() {
                return true;
            }

            @Override
            public String getName() {
                return "test2";
            }

            @Override
            public void setId(String id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public String getId() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        //execute
        //assert
        assertEquals("test2", spyC.getInvalidComposition().getName());
    }

    @Test
    public void getInvalidComposition3() {
        //prepare
        Composition spyC = new Composition() {
            @Override
            public void lock() {

            }

            @Override
            public boolean isLocked() {
                return false;
            }

            @Override
            public String describePossibleReasonsIfInvalid() {
                return null;
            }

            @Override
            public Composition returnThis() {
                return null;
            }

            @Override
            public boolean validate() {
                return false;
            }

            @Override
            public boolean isLeaf() {
                return false;
            }

            @Override
            public String getName() {
                return "test2";
            }

            @Override
            public void setId(String id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public String getId() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public List<Composition> getChildren() {
                return new PowerList<>(
                        new Composition() {

                    @Override
                    public void lock() {

                    }

                    @Override
                    public boolean isLocked() {
                        return false;
                    }

                    @Override
                    public String describePossibleReasonsIfInvalid() {
                        return "abc";
                    }

                    @Override
                    public Composition returnThis() {
                        return null;
                    }

                    @Override
                    public boolean validate() {
                        return false;
                    }

                    @Override
                    public String getName() {
                        return "reason_";
                    }

                    @Override
                    public void setId(String id) {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public String getId() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                }
                );
            }
        };
        //execute
        //assert
        assertEquals("reason_", spyC.getInvalidComposition().getName());
    }

    @Test
    public void getInvalidComposition4() {
        //prepare
        Composition spyC = new Composition() {
            @Override
            public void lock() {

            }

            @Override
            public boolean isLocked() {
                return false;
            }

            @Override
            public String describePossibleReasonsIfInvalid() {
                return null;
            }

            @Override
            public Composition returnThis() {
                return null;
            }

            @Override
            public boolean validate() {
                return false;
            }

            @Override
            public boolean isLeaf() {
                return false;
            }

            @Override
            public String getName() {
                return "test2";
            }

            @Override
            public void setId(String id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public String getId() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public List<Composition> getChildren() {
                return new PowerList<>(
                        new Composition() {

                    @Override
                    public void lock() {

                    }

                    @Override
                    public boolean isLocked() {
                        return false;
                    }

                    @Override
                    public String describePossibleReasonsIfInvalid() {
                        return "abc";
                    }

                    @Override
                    public Composition returnThis() {
                        return null;
                    }

                    @Override
                    public boolean validate() {
                        return true;
                    }

                    @Override
                    public String getName() {
                        return "reason_";
                    }

                    @Override
                    public void setId(String id) {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public String getId() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                }
                );
            }
        };
        //execute
        //assert
        assertEquals(null, spyC.getInvalidComposition());
    }

    @Test
    public void setRandomValues() {
        //prepare
        //execute
        compositionDummyImpl.setRandomValues();
        //assert
        assertEquals(1000, compositionDummyImpl.getPlusComposition().getValue());
        assertEquals(-1000, compositionDummyImpl.getMinusComposition().getValue());
    }

    @Test
    public void setDefaultValues() {
        //prepare
        //execute
        compositionDummyImpl.setDefaultValues();
        //assert
        assertEquals(10, compositionDummyImpl.getPlusComposition().getValue());
        assertEquals(-10, compositionDummyImpl.getMinusComposition().getValue());
    }

    @Test
    public void isDefault() {
        //prepare
        //execute
        //assert
        plusComposition = new PlusComposition();
        plusComposition.setValue(20);
        assertFalse(plusComposition.isDefault());
        plusComposition.setDefaultValues();
        assertTrue(plusComposition.isDefault());
    }

    @Test
    public void createCopy() {
        //prepare
        plusComposition = new PlusComposition();
        plusComposition.setValue(20);
        PlusComposition copy;
        //execute
        copy = plusComposition.createCopy();
        //assert
        assertNotNull(copy);
        assertNotEquals(plusComposition.hashCode(), copy.hashCode());
    }

    @Test
    public void isLeaf() {
        //prepare
        Composition composition1 = mock(Composition.class);
        Composition composition2 = mock(Composition.class);
        Composition composition3 = mock(Composition.class);
        Composition composition4 = mock(Composition.class);
        when(compositionDummyImpl.getChildren())
                .thenReturn(new PowerList<>(
                        composition1, composition2, composition3, composition4));
        boolean result;
        //execute
        result = compositionDummyImpl.isLeaf();
        //assert
        assertFalse(result);
    }

    @Test
    public void isLeaf2() {
        //prepare
        when(compositionDummyImpl.getChildren())
                .thenReturn(new PowerList<>());
        boolean result;
        //execute
        result = compositionDummyImpl.isLeaf();
        //assert
        assertTrue(result);
    }

    @Test
    public void isLeaf3() {
        //prepare
        when(compositionDummyImpl.getChildren())
                .thenReturn(null);
        boolean result;
        //execute
        result = compositionDummyImpl.isLeaf();
        //assert
        assertTrue(result);
    }

    @Test
    public void getChildren() {
        //prepare
        class CompositionT implements Composition {

            @Override
            public String getName() {
                return null;
            }

            @Override
            public Composition returnThis() {
                return null;
            }

            @Override
            public final String describePossibleReasonsIfInvalid() {
                return "test";
            }

            @Override
            public void lock() {

            }

            @Override
            public boolean isLocked() {
                return false;
            }

            @Override
            public void setId(String id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public String getId() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        }

        CompositionT composition = new CompositionT();
        //execute
        //assert
        assertEquals(0, composition.getChildren().size());
    }

    @Test
    public void toJsonObject() {
        //prepare
        String expectedJO = "{\"class\":\"org.nanoboot.colorshapes.engine.composition.utils.CompositionDummyImpl\",\"id\":null,\"plusComposition\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.utils.PlusComposition\",\"id\":null,\"value\":52},\"minusComposition\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.utils.MinusComposition\",\"id\":null,\"value\":-52}}";
        PlusComposition plusComposition = new PlusComposition();
        MinusComposition minusComposition = new MinusComposition();
        compositionDummyImpl = new CompositionDummyImpl();
        compositionDummyImpl.setPlusComposition(plusComposition);
        compositionDummyImpl.setMinusComposition(minusComposition);
        //execute
        plusComposition.setValue(52);
        minusComposition.setValue(-52);
        //assert
        assertEquals(expectedJO, compositionDummyImpl.toJsonObject().toMinimalString());
    }

    @Test(expected = ColorShapesEngineException.class)
    public void toJsonObject_exception() {
        //prepare
        String expectedJO = "{\"class\":\"org.nanoboot.colorshapes.engine.composition.utils.CompositionDummyImpl\",\"id\":null,\"plusComposition\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.utils.PlusComposition\",\"id\":null,\"value\":52},\"minusComposition\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.utils.MinusComposition\",\"id\":null,\"value\":-52}}";
        compositionDummyImpl.setPlusComposition(null);
        compositionDummyImpl.setMinusComposition(null);
        //execute
        plusComposition.setValue(52);
        minusComposition.setValue(-52);
        //assert
        assertEquals(expectedJO, compositionDummyImpl.toJsonObject().toMinimalString());
    }

    @Test
    public void fromJsonObject() {
        //prepare
        String expectedJO = "{\"class\":\"org.nanoboot.colorshapes.engine.composition.utils.CompositionDummyImpl\",\"plusComposition\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.utils.PlusComposition\",\"value\":52},\"minusComposition\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.utils.MinusComposition\",\"value\":-52}}";

        compositionDummyImpl = new CompositionDummyImpl();
        compositionDummyImpl.setPlusComposition(new PlusComposition());
        //execute
        compositionDummyImpl.fromJsonObject(new JsonObject(expectedJO));
        //assert
        assertEquals(52, compositionDummyImpl.getPlusComposition().getValue());
        assertEquals(-52, compositionDummyImpl.getMinusComposition().getValue());
    }

    @Test(expected = ColorShapesEngineException.class)
    public void fromJsonObject_exception() {
        //prepare
        String expectedJO = "{\"class\":\"org.nanoboot.colorshapes.engine.composition.utils.CompositionDummyImpl\",\"plusComposition\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.utils.PlusComposition\",\"value\":52},\"minusComposition\":{\"class\":\"org.nanoboot.colorshapes.engine.composition.utils.MinusComposition\",\"value\":-52}}";

        compositionDummyImpl.setPlusComposition(null);
        compositionDummyImpl.setMinusComposition(null);
        //execute
        compositionDummyImpl.fromJsonObject(new JsonObject(expectedJO));
        //assert
    }

//    //todo tests
    @Test
    public void returnClass() {
        //prepare
        CompositionDummyImpl emptyInstance;
        //execute
        compositionDummyImpl = new CompositionDummyImpl();
        compositionDummyImpl.setPlusComposition(plusComposition);
        compositionDummyImpl.setMinusComposition(minusComposition);
        //assert
        assertNotNull(compositionDummyImpl.returnClass());
        assertTrue(compositionDummyImpl.returnClass().getName().contains("ompositionDummyImpl"));

    }

    @Test
    public void returnEmptyInstance() {
        //prepare
        CompositionDummyImpl emptyInstance;
        //execute
        compositionDummyImpl = new CompositionDummyImpl();
        compositionDummyImpl.setPlusComposition(plusComposition);
        compositionDummyImpl.setMinusComposition(minusComposition);

        emptyInstance = compositionDummyImpl.returnEmptyInstance();
        //assert
        assertNotNull(emptyInstance);
        assertNotEquals(compositionDummyImpl.hashCode(), emptyInstance.hashCode());
        assertNull(emptyInstance.getPlusComposition());
        assertNull(emptyInstance.getMinusComposition());
    }

    @Test
    public void isInRange() {
        assertEquals(false, Composition.isInRange(39, 40, 60));
        assertEquals(true, Composition.isInRange(40, 40, 60));
        assertEquals(true, Composition.isInRange(50, 40, 60));
        assertEquals(true, Composition.isInRange(59, 40, 60));
        assertEquals(true, Composition.isInRange(60, 40, 60));
        assertEquals(false, Composition.isInRange(61, 40, 60));
    }

}
