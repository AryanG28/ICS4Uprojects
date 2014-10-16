/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.android;

/**
 *
 * @author 1GHAHREMANZA
 */
public class DubdlyLock extends MasterLock {

    public static final String LOCK_MANUFACTURER = "DUBDLY";
    public static final int MIN_COMBO_VALUE = 0;
    public static final int MAX_COMBO_VALUE = 59;
    public static final int NUMBER_OF_DIGITS = 3;
    
    public DubdlyLock() {
        this(
                (int) (Math.random() * 60),
                (int) (Math.random() * 60),
                (int) (Math.random() * 60)
        );
    }

    public DubdlyLock(int digit01, int digit02, int digit03) {
        super(digit01, digit02, digit03);
        this.maxCombo = MAX_COMBO_VALUE;
    }
       

    
}
