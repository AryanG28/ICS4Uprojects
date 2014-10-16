/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.android;

import static gwss.edu.ics4u.aryan.android.MasterLock.MAX_COMBO_VALUE;

/**
 *
 * @author 1GHAHREMANZA
 */
public class Lock extends AndroidLock {
    public static final String LOCK_MANUFACTURER = "ANDROID";
    public final int MIN_COMBO_VALUE = 0;
    public final int MAX_COMBO_VALUE = 9;
    public final int NUMBER_OF_DIGITS = 3;
    
    public Lock() {
        this(
                (int) (Math.random() * 40),
                (int) (Math.random() * 40),
                (int) (Math.random() * 40)
        );
    }

    public Lock(int digit01, int digit02, int digit03) {
        super(digit01, digit02, digit03);
    }
    
    
    
}
