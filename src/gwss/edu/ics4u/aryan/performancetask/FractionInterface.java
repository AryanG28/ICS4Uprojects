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
public interface FractionInterface {
    
    public double size();
    
    public Fraction larger( Fraction f);
    
    public Fraction larger( Fraction f, Fraction g);

    public Fraction times( Fraction f);
    
    public Fraction times( Fraction f, Fraction g);

    public boolean equals(Fraction f);
    
    public void invert(Fraction f);
    
}
