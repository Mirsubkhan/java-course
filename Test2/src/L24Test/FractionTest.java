package L24Test;

import static org.junit.jupiter.api.Assertions.*;
import L24.Fraction;
import org.junit.jupiter.api.Test;

class FractionTest {

	@Test
    public void testAdd() {
        Fraction fr1 = new Fraction(2, 4);
        Fraction fr2 = new Fraction(4, 4);
        fr1.add(fr2);
        assertEquals("3/2", fr1.toString(), "2/4 + 4/4 should give 3/2");
    }

    @Test
    public void testSubtract() {
        Fraction fr1 = new Fraction(5, 4);
        Fraction fr2 = new Fraction(3, 4);
        fr1.subtract(fr2);
        assertEquals("1/2", fr1.toString(), "5/4 - 3/4 should give 1/2");
    }

    @Test
    public void testMultiply() {
        Fraction fr1 = new Fraction(2, 3);
        Fraction fr2 = new Fraction(4, 5);
        fr1.multiply(fr2);
        assertEquals("8/15", fr1.toString(), "2/3 * 4/5 should give 8/15");
    }
    
    @Test
    public void testDivide() {
        Fraction fr1 = new Fraction(2, 3);
        Fraction fr2 = new Fraction(4, 5);
        fr1.divide(fr2);
        assertEquals("5/6", fr1.toString(), "2/3 ÷ 4/5 should give 10/12 (simplified to 5/6)");
    }

    @Test
    public void testDivideByZeroFraction() {
        Fraction fr1 = new Fraction(2, 3);
        Fraction fr2 = new Fraction(0, 5);
        assertThrows(IllegalArgumentException.class, () -> fr1.divide(fr2), "Dividing by zero fraction should throw an exception");
    }

    @Test
    public void testSimplify() {
        Fraction fr1 = new Fraction(4, 8);  // Should simplify to 1/2
        assertEquals("1/2", fr1.toString(), "4/8 should simplify to 1/2");
    }

    @Test
    public void testNegativeFraction() {
        Fraction fr1 = new Fraction(-2, 4);
        Fraction fr2 = new Fraction(3, 4);
        fr1.add(fr2);
        assertEquals("1/4", fr1.toString(), "(-2/4) + (3/4) should give 1/4");
    }

    @Test
    public void testFractionDivisionByItself() {
        Fraction fr1 = new Fraction(4, 5);
        fr1.divide(fr1);
        assertEquals("1", fr1.toString(), "4/5 ÷ 4/5 should give 1");
    }

}
