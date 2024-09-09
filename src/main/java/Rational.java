class Rational {
    long numerator, denominator;

    class Illegal extends Exception {
        String reason;

        Illegal(String reason) {
            this.reason = reason;
        }
    }

    // Default constructor, sets the rational number to 0/1
    Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    // Constructor with numerator and denominator, throws Illegal exception if denominator is zero
    Rational(long numerator, long denominator) throws Illegal {
        if (denominator == 0) {
            throw new Illegal("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplestForm();
    }

    // Find the reduced form of the rational number
    private void simplestForm() {
        long computeGCD = GCD(Math.abs(numerator), denominator);
        numerator /= computeGCD;
        denominator /= computeGCD;
    }

    // Compute the greatest common divisor (GCD)
    private long GCD(long a, long b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    // Add another rational number to the current rational number
    public void add(Rational x) {
        numerator = (numerator * x.denominator) + (x.numerator * denominator);
        denominator = denominator * x.denominator;
        simplestForm();
    }

    // Subtract another rational number from the current rational number
    public void subtract(Rational x) {
        numerator = (numerator * x.denominator) - (x.numerator * denominator);
        denominator = denominator * x.denominator;
        simplestForm();
    }

    // Multiply another rational number with the current rational number
    public void multiply(Rational x) {
        numerator = numerator * x.numerator;
        denominator = denominator * x.denominator;
        simplestForm();
    }

    // Divide the current rational number by another rational number
    public void divide(Rational x) throws Illegal {
        if (x.numerator == 0) {
            throw new Illegal("Cannot divide by zero");
        }
        numerator = numerator * x.denominator;
        denominator = denominator * x.numerator;
        simplestForm();
    }

    // Check if another object is equal to the current rational number
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rational)) return false;
        Rational x = (Rational) obj;
        return this.numerator == x.numerator && this.denominator == x.denominator;
    }

    // Compare two rational numbers
    public long compareTo(Rational x) {
        long lhs = this.numerator * x.denominator;
        long rhs = x.numerator * this.denominator;
        return Long.compare(lhs, rhs);
    }

    // Return a string representation of the rational number
    @Override
    public String toString() {
        if (denominator == 1) {
            return Long.toString(numerator);
        } else {
            return numerator + "/" + denominator;
        }
    }

    public static void main(String[] args) {
        try {
            Rational r1 = new Rational(1, 2);
            Rational r2 = new Rational(3, 4);

            System.out.println("r1: " + r1);
            System.out.println("r2: " + r2);

            r1.add(r2);
            System.out.println("r1 + r2 = " + r1);

            r1.subtract(r2);
            System.out.println("r1 - r2 = " + r1);

            r1.multiply(r2);
            System.out.println("r1 * r2 = " + r1);

            r1.divide(r2);
            System.out.println("r1 / r2 = " + r1);

        } catch (Illegal e) {
            System.err.println("Error: " + e.reason);
        }
    }
}
