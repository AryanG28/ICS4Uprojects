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
public class FractionTester {

    public static void main(String[] args){

        System.out.println("Test Case #1: Instantiate different types of fractions");
        MixedFraction mixed = new MixedFraction(2, 1, 3);
        ProperFraction proper = new ProperFraction(1, 3);
        ImproperFraction improper = new ImproperFraction(6, 3);
        Fraction fraction = new Fraction(1, 3);

        System.out.println("Test Case #2: To string");
        System.out.println(mixed.toString());
        System.out.println(proper.toString());
        System.out.println(improper.toString());
        System.out.println(fraction.toString());
        
        System.out.println("Test Case #3: Equals");
        System.out.println(proper.equals(fraction));
        System.out.println(improper.equals(fraction));
        
        System.out.println("Test Case #4: Larger");
        System.out.println(improper.larger(fraction));
        
        System.out.println("Test Case #5: Times");
        System.out.println(improper.times(fraction));
        
        System.out.println("Test Case #6: Hash");
        System.out.println(proper.hashCode());
        
        System.out.println("Test Case #7: ");

    }
}