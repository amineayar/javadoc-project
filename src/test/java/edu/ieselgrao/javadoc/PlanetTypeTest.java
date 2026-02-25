package edu.ieselgrao.javadoc;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlanetTypeTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsSanity() {
        assertEquals(8, PlanetType.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(PlanetType.class.getDeclaredField("description").getModifiers()));
            assertFalse(Modifier.isStatic(PlanetType.class.getDeclaredField("description").getModifiers()));
            assertTrue(Modifier.isFinal(PlanetType.class.getDeclaredField("description").getModifiers()));
            assertEquals(String.class, PlanetType.class.getDeclaredField("description").getType());

            assertTrue(Modifier.isPrivate(PlanetType.class.getDeclaredField("magneticFieldStrength").getModifiers()));
            assertFalse(Modifier.isStatic(PlanetType.class.getDeclaredField("magneticFieldStrength").getModifiers()));
            assertTrue(Modifier.isFinal(PlanetType.class.getDeclaredField("magneticFieldStrength").getModifiers()));
            assertEquals(double.class, PlanetType.class.getDeclaredField("magneticFieldStrength").getType());

            assertTrue(Modifier.isPrivate(PlanetType.class.getDeclaredField("averageDistanceFromStar").getModifiers()));
            assertFalse(Modifier.isStatic(PlanetType.class.getDeclaredField("averageDistanceFromStar").getModifiers()));
            assertTrue(Modifier.isFinal(PlanetType.class.getDeclaredField("averageDistanceFromStar").getModifiers()));
            assertEquals(double.class, PlanetType.class.getDeclaredField("averageDistanceFromStar").getType());

            assertTrue(Modifier.isPrivate(PlanetType.class.getDeclaredField("averageTemperature").getModifiers()));
            assertFalse(Modifier.isStatic(PlanetType.class.getDeclaredField("averageTemperature").getModifiers()));
            assertTrue(Modifier.isFinal(PlanetType.class.getDeclaredField("averageTemperature").getModifiers()));
            assertEquals(double.class, PlanetType.class.getDeclaredField("averageTemperature").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(1, PlanetType.class.getDeclaredConstructors().length);
        assertEquals(8, Arrays.stream(PlanetType.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(PlanetType.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isStatic(PlanetType.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isFinal(PlanetType.class.getDeclaredMethod("getDescription").getModifiers()));
            assertEquals(String.class, PlanetType.class.getDeclaredMethod("getDescription").getReturnType());

            assertTrue(Modifier.isPublic(PlanetType.class.getDeclaredMethod("getMagneticFieldStrength").getModifiers()));
            assertFalse(Modifier.isStatic(PlanetType.class.getDeclaredMethod("getMagneticFieldStrength").getModifiers()));
            assertFalse(Modifier.isFinal(PlanetType.class.getDeclaredMethod("getMagneticFieldStrength").getModifiers()));
            assertEquals(double.class, PlanetType.class.getDeclaredMethod("getMagneticFieldStrength").getReturnType());

            assertTrue(Modifier.isPublic(PlanetType.class.getDeclaredMethod("getAverageDistanceFromStar").getModifiers()));
            assertFalse(Modifier.isStatic(PlanetType.class.getDeclaredMethod("getAverageDistanceFromStar").getModifiers()));
            assertFalse(Modifier.isFinal(PlanetType.class.getDeclaredMethod("getAverageDistanceFromStar").getModifiers()));
            assertEquals(double.class, PlanetType.class.getDeclaredMethod("getAverageDistanceFromStar").getReturnType());

            assertTrue(Modifier.isPublic(PlanetType.class.getDeclaredMethod("getAverageTemperature").getModifiers()));
            assertFalse(Modifier.isStatic(PlanetType.class.getDeclaredMethod("getAverageTemperature").getModifiers()));
            assertFalse(Modifier.isFinal(PlanetType.class.getDeclaredMethod("getAverageTemperature").getModifiers()));
            assertEquals(double.class, PlanetType.class.getDeclaredMethod("getAverageTemperature").getReturnType());

            assertTrue(Modifier.isPublic(PlanetType.class.getDeclaredMethod("getType", String.class).getModifiers()));
            assertTrue(Modifier.isStatic(PlanetType.class.getDeclaredMethod("getType", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(PlanetType.class.getDeclaredMethod("getType", String.class).getModifiers()));
            assertEquals(PlanetType.class, PlanetType.class.getDeclaredMethod("getType", String.class).getReturnType());

            assertTrue(Modifier.isPublic(PlanetType.class.getDeclaredMethod("getNextExpectedType").getModifiers()));
            assertFalse(Modifier.isStatic(PlanetType.class.getDeclaredMethod("getNextExpectedType").getModifiers()));
            assertFalse(Modifier.isFinal(PlanetType.class.getDeclaredMethod("getNextExpectedType").getModifiers()));
            assertEquals(PlanetType.class, PlanetType.class.getDeclaredMethod("getNextExpectedType").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Planet type - Description")
    void testPlanetTypeDescription() {
        assertEquals("Rocky Planet", PlanetType.ROCKY.getDescription());
        assertEquals("Gas Giant", PlanetType.GAS_GIANT.getDescription());
        assertEquals("Ice Giant", PlanetType.ICE_GIANT.getDescription());
    }

    @Test
    @Order(4)
    @DisplayName("Planet type - Magnetic field strength")
    void testPlanetTypeMagneticFieldStrength() {
        assertEquals(15, PlanetType.ROCKY.getMagneticFieldStrength());
        assertEquals(50, PlanetType.GAS_GIANT.getMagneticFieldStrength());
        assertEquals(40, PlanetType.ICE_GIANT.getMagneticFieldStrength());
    }

    @Test
    @Order(5)
    @DisplayName("Planet type - Average distance from star")
    void testPlanetTypeAverageDistanceFromStar() {
        assertEquals(1000, PlanetType.ROCKY.getAverageDistanceFromStar());
        assertEquals(3000, PlanetType.GAS_GIANT.getAverageDistanceFromStar());
        assertEquals(5000, PlanetType.ICE_GIANT.getAverageDistanceFromStar());
    }

    @Test
    @Order(6)
    @DisplayName("Planet type - Average temperature")
    void testPlanetTypeAverageTemperature() {
        assertEquals(300, PlanetType.ROCKY.getAverageTemperature());
        assertEquals(-150, PlanetType.GAS_GIANT.getAverageTemperature());
        assertEquals(-200, PlanetType.ICE_GIANT.getAverageTemperature());
    }

    @Test
    @Order(7)
    @DisplayName("Planet type - Get type")
    void testPlanetTypeGetType() {
        assertEquals(PlanetType.ROCKY, PlanetType.getType("Rocky Planet"));
        assertEquals(PlanetType.GAS_GIANT, PlanetType.getType("Gas Giant"));
        assertEquals(PlanetType.ICE_GIANT, PlanetType.getType("Ice Giant"));
        assertNull(PlanetType.getType("Unknown"));
    }

    @Test
    @Order(8)
    @DisplayName("Planet type - Get next expected type")
    void testPlanetTypeGetNextExpectedType() {
        assertEquals(PlanetType.GAS_GIANT, PlanetType.ROCKY.getNextExpectedType());
        assertEquals(PlanetType.ICE_GIANT, PlanetType.GAS_GIANT.getNextExpectedType());
        assertEquals(PlanetType.ROCKY, PlanetType.ICE_GIANT.getNextExpectedType());
    }

}
