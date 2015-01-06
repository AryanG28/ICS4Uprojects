/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.performancetask;

/**
 *
 * @author Aryan
 */
public class Fraction implements FractionInterface {

    public int numerator;
    public int denominator;
    public int numberOfFractions;
    public int wholeNumber;

    public Fraction() {
        this(1,2);
    }

    public Fraction(int numerator, int denominator) {
        
        this.numerator = numerator;
        this.denominator = denominator;
        numberOfFractions++;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {

        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double size() {
        double result = ((double) this.numerator / (double) this.denominator);
        return result;
    }

    public Fraction larger(Fraction f) {
        if (this.size() < f.size()) {
            System.out.println("Fraction is smaller");
            return f;
        } else if (this.size() == f.size()) {
            System.out.println("Fraction is the same size");
            return this;
        } else if (this.size() > f.size()) {
            System.out.println("Fraction is larger");
            return this;
        }
        return null;
    }

    public Fraction larger(Fraction f, Fraction g) {
        if (g.size() > f.size() && g.size() > this.size()) {
            return g;
        }
        if (f.size() > g.size() && f.size() > this.size()) {
            return f;
        }
        if (this.size() > g.size() && this.size() > g.size()) {
            return f;
        }
        return null;
    }

    public Fraction times(Fraction f) {
        Fraction g = new Fraction();
        g.setNumerator(this.numerator * f.numerator);
        g.setDenominator(this.denominator * f.denominator);
        return g;
    }

    public Fraction times(Fraction f, Fraction g) {
        Fraction h = new Fraction();
        h.setNumerator(this.numerator * f.numerator * g.numerator);
        h.setDenominator(this.denominator * f.denominator * g.denominator);
        return g;
    }

    public boolean equals(Fraction f) {
        if (this.numerator == f.numerator && this.denominator == f.denominator) {
            return true;
        } else {
            return false;
        }
    }

    public void invert(Fraction f) {
        boolean negative = false;
        if (this.numerator < 0) {
            negative = true;
        }
        int temp = this.numerator;
        this.setNumerator((this.getDenominator()));
        this.setDenominator(Math.abs(temp));
        if (negative) {
            setNumerator(getNumerator() * -1);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.numerator;
        hash = 43 * hash + this.denominator;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fraction other = (Fraction) obj;
        return true;
    }


    @Override
    public String toString() {
        return "Fraction: " + numerator + "/" + denominator;
    }

    public Fraction reduce() {

// if not 0 then find common divisor
        while (this.denominator != 0) { // exits when denominator is zero because numerator will be GCD
            if (this.numerator > this.denominator) { //always decreases other amount from the bigger of either the numerator or denominator until denominator becomes zero
                this.setNumerator(numerator - denominator);
            } else {
                this.setDenominator(denominator - numerator);
            }
        }
        return this;
    }

}

