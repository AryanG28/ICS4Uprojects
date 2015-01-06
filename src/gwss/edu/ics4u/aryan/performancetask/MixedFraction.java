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
public class MixedFraction extends Fraction {

    public MixedFraction() {
        this(2,1,2);
    }

    public MixedFraction(int wholeNumber, int numerator, int denominator) {
        super(numerator, denominator);
        this.wholeNumber = wholeNumber;
    }

    public Fraction toImproper() {
        ImproperFraction f = new ImproperFraction();
        if (Math.abs(wholeNumber) > 0) {
            f.setNumerator(this.wholeNumber * getDenominator() + this.numerator);

        }
        return f;
    }
    
    

    @Override
    public String toString() {
        return "Fraction: " + wholeNumber + " " + numerator + "/" + denominator;
    }

    
}
