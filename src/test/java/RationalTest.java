import org.junit.Assert;
import org.junit.Test;

public class RationalTest {

    @Test
    public void testAdd() throws Rational.Illegal {
        Rational x = new Rational(1, 2);  // use constructor to initialize
        Rational y = new Rational(1, 4);  // use constructor
        x.add(y);
        Assert.assertEquals(3, x.numerator);
        Assert.assertEquals(4, x.denominator);  // expected result is 3/4 after addition
    }

    @Test
    public void testSubtract() throws Rational.Illegal {
        Rational x = new Rational(3, 2);  // 3/2
        Rational y = new Rational(2, 4);  // 1/2
        x.subtract(y);
        Assert.assertEquals(1, x.numerator);
        Assert.assertEquals(1, x.denominator);  // result should be 1/1 = 1
    }

    @Test
    public void testMultiply() throws Rational.Illegal {
        Rational x = new Rational(2, 3);  // 2/3
        Rational y = new Rational(9, 2);  // 9/2
        x.multiply(y);
        Assert.assertEquals(3, x.numerator);
        Assert.assertEquals(1, x.denominator);  // expected result is 3/1
    }

    @Test
    public void testDivision() throws Rational.Illegal {
        Rational x = new Rational(12, 3);  // 12/3
        Rational y = new Rational(2, 1);   // 2/1
        x.divide(y);
        Assert.assertEquals(2, x.numerator);
        Assert.assertEquals(1, x.denominator);  // result should be 2/1
    }

    @Test
    public void testEquals() throws Rational.Illegal {
        Rational x = new Rational(2, 6);  // simplified to 1/3
        Rational y = new Rational(4, 12); // simplified to 1/3
        Assert.assertEquals(x, y);  // should be equal

        x = new Rational(1, 2);  // 1/2
        y = new Rational(5, 9);  // 5/9
        Assert.assertNotEquals(x, y);  // should not be equal
    }

    @Test
    public void testCompare() throws Rational.Illegal {
        Rational x = new Rational(2, 4);  // simplified to 1/2
        Rational y = new Rational(1, 2);  // 1/2
        Assert.assertEquals(0, x.compareTo(y));  // should be equal

        x = new Rational(3, 4);  // 3/4
        y = new Rational(1, 2);  // 1/2
        Assert.assertEquals(1, x.compareTo(y));  // 3/4 is greater

        x = new Rational(1, 3);  // 1/3
        y = new Rational(1, 2);  // 1/2
        Assert.assertEquals(-1, x.compareTo(y));  // 1/3 is less
    }

    @Test
    public void testToString() throws Rational.Illegal {
        Rational x = new Rational(3, 6);  // simplified to 1/2
        String val = x.toString();
        Assert.assertEquals("1/2", val);
    }
}
