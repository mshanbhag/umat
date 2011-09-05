/***
 * This is COMPLEX method of last chapter.
 * 
 * @author Madhusoodan
 * 
 */

public class Complex {
    // Instance variable
    double real;
    double imag;

    /**
     * Constructor
     */
    public Complex() {
        this.real = 0.0;
        this.imag = 0.0;
    }

    /***
     * Constructor 2
     * @param real 
     * @param imag 
     */
    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    /**
     * This Methods gives out absolute value of complex number.
     * Class Method.
     * @param c
     * Complex Number input
     * @return returns absolute value as double.
     */
    public static double abs(Complex c) {
        return Math.sqrt(c.real * c.real + c.imag * c.imag);
    }

    /**
     * Object method for returning absolute value
     * @return absolute value as double.
     */
    public double abs() {
        return Math.sqrt(real * real + imag * imag);
    }

    /**
     * Addition of the complex numbers
     * @param a
     * @param b
     * @return the addition
     */
    public static Complex add(Complex a, Complex b) {
        return new Complex(a.real + b.real, a.imag + b.imag);
    }

    /**
     * Object Method for adding complex numbers
     * @param b
     * @return returns addition.
     */
    public Complex add(Complex b) {
        return new Complex(real + b.real, imag + b.imag);
    }

    /**
     * Conjugate of the Number (Class Method)
     * @param c 
     * Input Complex Number.
     */
    public static void conjugate(Complex c) {
        c.imag = -c.imag;
    }

    /**
     * Conjugate Of Complex Number (Object Method)
     * 
     */
    public void Conjugate() {
        imag = -imag;
    }

    /**
     * To String
     */
    public String toString() {
        return real + " + " + imag + " i ";
    }

    /**
     * Defines equality by comparing real and imaginary part of two Complex numbers.
     * Object Method.
     * @param b 
     * Another complex Number
     * @return True if both are equal. False if not equal.
     */
    public boolean equals(Complex b) {
        if (b == null) {
            return false;
        } else {
            return (real == b.real && imag == b.imag);
        }
    }

    /**
     * Normalisation of Complex Numbers
     */
    public void normalize() {
        double d = this.abs();

        real = real / d;
        imag = imag / d;
    }
}

