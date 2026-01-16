import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutoTest {

    @Test
    void testLuxusautoWegenPreis() {
        Auto auto = new Auto("Porsche", "911 Turbo S", 650, 285000, false);
        assertTrue(auto.istLuxusauto());

    }

    @Test
    void testKeinLuxusauto() {
        Auto auto = new Auto("VW", "Golf", 150, 30000, false);
        assertFalse(auto.istLuxusauto());
    }

    @Test
    void testBMWLuxusautoTrue() {
        Auto auto = new Auto("BMW", "M4", 500, 78000, false);
        assertTrue(auto.istLuxusauto());
    }

    @Test
    void testAudiLuxusautoFalse() {
        Auto auto = new Auto("Audi", "A4", 85, 4000, false);
        assertFalse(auto.istLuxusauto());
    }

    @Test
    void testFerrariLuxusautoTrue() {
        Auto auto = new Auto("Ferrari", "488 GTB", 670, 220000, false);
        assertTrue(auto.istLuxusauto());
    }

    @Test
    void testVWLuxusautoFalse() {
        Auto auto = new Auto("VW", "Polo GTI", 207, 35000, false);
        assertFalse(auto.istLuxusauto());
    }

    @Test
    void testOpelLuxusautoFalse() {
        Auto auto = new Auto("Opel", "Corsa", 60, 4000, false);
        assertFalse(auto.istLuxusauto());
    }


}

