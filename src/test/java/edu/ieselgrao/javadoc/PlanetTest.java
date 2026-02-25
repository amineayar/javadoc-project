package edu.ieselgrao.javadoc;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlanetTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsSanity() {
        assertEquals(18, Planet.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(Planet.class.getDeclaredField("INVALID_PLANET_TYPE").getModifiers()));
            assertTrue(Modifier.isStatic(Planet.class.getDeclaredField("INVALID_PLANET_TYPE").getModifiers()));
            assertTrue(Modifier.isFinal(Planet.class.getDeclaredField("INVALID_PLANET_TYPE").getModifiers()));
            assertEquals(String.class, Planet.class.getDeclaredField("INVALID_PLANET_TYPE").getType());
            assertEquals("[ERROR] Invalid planet type", Planet.INVALID_PLANET_TYPE);

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredField("type").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredField("type").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredField("type").getModifiers()));
            assertEquals(PlanetType.class, Planet.class.getDeclaredField("type").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructors")
    void checkConstructorsSanity() {
        assertEquals(2, Planet.class.getConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Planet.class.getDeclaredConstructor(String.class, int.class, double.class, double.class, double.class, LocalDate.class, boolean.class, PlanetType.class).getModifiers()));
            assertTrue(Modifier.isPublic(Planet.class.getDeclaredConstructor(String.class, int.class, double.class, double.class, double.class, LocalDate.class, boolean.class, PlanetType.class, String.class, LocalDate.class, int.class, double.class, double.class, boolean.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(9, Arrays.stream(Planet.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());
        assertEquals(9, Arrays.stream(Planet.class.getDeclaredMethods()).filter(m -> Modifier.isPrivate(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(Planet.class.getDeclaredMethod("getType").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("getType").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("getType").getModifiers()));
            assertEquals(PlanetType.class, Planet.class.getDeclaredMethod("getType").getReturnType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredMethod("setType", PlanetType.class).getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("setType", PlanetType.class).getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("setType", PlanetType.class).getModifiers()));
            assertEquals(void.class, Planet.class.getDeclaredMethod("setType", PlanetType.class).getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Planet - Type")
    void checkPlanetType() {
        Planet planet = new Planet("Earth", 1, 5.97e24, 6371, 9.81, LocalDate.now(), false, PlanetType.ROCKY);
        assertEquals(PlanetType.ROCKY, planet.getType());

        planet = new Planet("Mars", 2, 6.42e23, 3389, 3.71, LocalDate.now(), false, PlanetType.ROCKY, "CO2", LocalDate.now(), 10, 0.01, 0.01, false);
        assertEquals(PlanetType.ROCKY, planet.getType());

        planet = new Planet("Jupiter", 79, 1.90e27, 69911, 24.79, LocalDate.now(), true, PlanetType.GAS_GIANT);
        assertEquals(PlanetType.GAS_GIANT, planet.getType());

        planet = new Planet("Saturn", 82, 5.68e26, 58232, 10.44, LocalDate.now(), true, PlanetType.GAS_GIANT, "N, H", LocalDate.now(), 5, 1.00, 1.25, true);
        assertEquals(PlanetType.GAS_GIANT, planet.getType());

        planet = new Planet("Neptune", 14, 1.02e26, 24622, 11.15, LocalDate.now(), false, PlanetType.ICE_GIANT);
        assertEquals(PlanetType.ICE_GIANT, planet.getType());

        planet = new Planet("Uranus", 27, 8.68e25, 25362, 8.69, LocalDate.now(), false, PlanetType.ICE_GIANT, "H2O", LocalDate.now(), 7, 0.75, 1.00, false);
        assertEquals(PlanetType.ICE_GIANT, planet.getType());
    }

}
