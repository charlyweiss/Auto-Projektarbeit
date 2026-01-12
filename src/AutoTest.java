import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutoTest {

    @Test
    void testLuxusautoTruewegenPreis() {
        Auto auto = new Auto("Porsche", "911 Turbo S", 650, 285000, false);
        assertTrue(auto.istLuxusauto());

    }
    @Test
    void testKeinLuxusauto() {
        Auto auto = new Auto("VW", "Golf", 150, 30000, false);
        assertFalse(auto.istLuxusauto());
    }

    @Test
    void testBMWLuxusauto() {
        Auto auto = new Auto("BMW", "M4", 500, 120000, false);
    }

    @Test
    void testAudiLuxusauto() {
        Auto auto = new Auto("Audi", "A4", 85, 4000, false);
    }

}

