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
public class MasterULock extends AndroidLock {

    public static final String LOCK_MANUFACTURER = "MASTERU";
    public static final int MIN_COMBO_VALUE = 0;
    public static final int MAX_COMBO_VALUE = 9;
    public static final int NUMBER_OF_DIGITS = 4;

    private boolean configurableCombo;
    protected boolean open;
    private boolean digit01Revealed;
    private boolean digit02Revealed;
    private boolean digit03Revealed;
    private boolean digit04Revealed;
    private int serialNumber;
    private int invalidAttempts;
    protected int digit01;
    protected int digit02;
    protected int digit03;
    protected int digit04;

    public MasterULock() {
        this(
                (int) (Math.random() * 10),
                (int) (Math.random() * 10),
                (int) (Math.random() * 10),
                (int) (Math.random() * 10)
        );
    }

    public MasterULock(int digit01, int digit02, int digit03, int digit04) {
        System.out.println("CREATED: " + LOCK_MANUFACTURER + " Lock");
        this.open = true;
        this.configurableCombo = true;
        numberOfLocksCreated++;
        this.serialNumber = 1000000 + numberOfLocksCreated; 
        this.invalidAttempts = 0;
        this.digit01Revealed = false;
        this.digit02Revealed = false;
        this.digit03Revealed = false;
        this.digit04Revealed = false;
        this.setCombo(digit01, digit02, digit03, digit04);
        System.out.println("\tYour Combo: " + this.getCombo() + " | SN: " + this.serialNumber);
    }





    /*
     * Setting Combo:
     *      - must be valid values (0-9)
     *      - can only set the combo when the lock is OPEN
     *      - can only be set if the lock is configurable
     */
    public void setCombo(int digit01, int digit02, int digit03, int digit04) {
        if (this.open == false) {
            System.out.println("The lock must be open to set!");
        } else if (this.configurableCombo == false) {
            System.out.println("The lock must be configurable to set!");
        } else if (digit01 < MIN_COMBO_VALUE || digit01 > MAX_COMBO_VALUE) {
            System.out.println("Digit 1 is out of range!");
        } else if (digit02 < MIN_COMBO_VALUE || digit02 > MAX_COMBO_VALUE) {
            System.out.println("Digit 2 is out of range!");
        } else if (digit03 < MIN_COMBO_VALUE || digit03 > MAX_COMBO_VALUE) {
            System.out.println("Digit 3 is out of range!");
        } else if (digit04 < MIN_COMBO_VALUE || digit04 > MAX_COMBO_VALUE) {
            System.out.println("Digit 4 is out of range!");
        }   else {
            this.digit01 = digit01;
            this.digit02 = digit02;
            this.digit03 = digit03;
            this.digit04 = digit04;
            System.out.println("\tYour Combo: " + this.getCombo() + " | SN: " + this.serialNumber);
        }
    }

    
    public int getDigit04() {
        int digit = -1;
        if (this.digit04Revealed) {
            System.out.println("ERROR: Digit 04 Revealed to the client. ");
        } else {
            this.digit04Revealed = true;
            digit = this.digit03;
        }
        return digit;
    }
    

    /*
     * Getting Combo:
     *      - nobody should see the combo; except when the lock is created.
     */
    private String getCombo() {
        this.digit01 = getDigit01();
        this.digit02 = getDigit02();
        this.digit03 = getDigit03();
        this.digit04 = getDigit04();
        return this.digit01 + "-" + this.digit02 + "-" + this.digit03 + "-" + this.digit04;

    }
    
    /*
     * Unlock; 
     *      - unlock with correct combination
     *      - AFTER three invalid unlocking attempts; lock will not open
     */
    public boolean unlock(int digit01, int digit02, int digit03, int digit04) {
        if (this.open) {
            System.out.println("Lock is already open!");
            return true;
        }  else if (this.digit01 != digit01 || this.digit02 != digit02 || this.digit03 != digit03 || this.digit04 != digit04) {
            System.out.println("Numbers do not match!");
            return false;
        } else {
            this.open = true;
            return true;
        }
    }


}
