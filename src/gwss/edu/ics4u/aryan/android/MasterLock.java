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
public class MasterLock extends AndroidLock {

    public static final String LOCK_MANUFACTURER = "MASTER";
    public static final int MIN_COMBO_VALUE = 0;
    public static final int MAX_COMBO_VALUE = 39;
    public static final int NUMBER_OF_DIGITS = 3;

    public MasterLock() {
        this(
                (int) (Math.random() * 40),
                (int) (Math.random() * 40),
                (int) (Math.random() * 40)
        );
    }

    public MasterLock(int digit01, int digit02, int digit03) {
        super(digit01, digit02, digit03);
    }


    public boolean unlock(int digit01, int digit02, int digit03) {
        if (this.open) {
            System.out.println("Lock is already open!");
            return true;
        } else if (this.digit01 != digit01 || this.digit02 != digit02 || this.digit03 != digit03) {
            System.out.println("Numbers do not match!");
            return false;
        } else {
            this.open = true;
            return true;
        }

    }
    

    
}
