/*
 * Android PIN Lock
 *  - three digit lock code
 *  
 * Version: 0.3; NOT THE FINAL VERSION
 */
package gwss.edu.ics4u.aryan.android;

/**
 */
public class AndroidLock {

    // CLASS CONSTANTS
    public static final String LOCK_MANUFACTURER = "ANDROID";
    public static final int MIN_COMBO_VALUE = 0;
    public static final int MAX_COMBO_VALUE = 9;
    public static final int NUMBER_OF_DIGITS = 3;

    // CLASS VARIABLES
    private static int numberOfLocksCreated;

    // OBJECT VARIABLE
    private boolean configurableCombo;
    private boolean open;
    private boolean digit01Revealed;
    private boolean digit02Revealed;
    private boolean digit03Revealed;
    private int serialNumber;
    private int invalidAttempts;
    private int digit01;
    private int digit02;
    private int digit03;

    /*
     * Android Lock
     *      - 3 digit combo (0-9)
     *      - you can reset code, only when lock is open
     *      - default combo values are random
     *      - serial number is DISTINCT for all instances
     */
    public AndroidLock() {
        this(
                (int) (Math.random() * 10),
                (int) (Math.random() * 10),
                (int) (Math.random() * 10)
        );
    }

    /*
     * Android Lock
     *      - 3 digit combo (0-9)
     *      - you can reset code, only when lock
     *      - if the code is not set, combo values are -1
     *      - serial number is DISTINCT for all instances
     */
    public AndroidLock(int digit01, int digit02, int digit03) {
        System.out.println("CREATED: " + LOCK_MANUFACTURER + " Lock");
        this.open = true;
        this.configurableCombo = true;
        numberOfLocksCreated++;
        this.serialNumber = 1000000 + numberOfLocksCreated; // TODO
        this.invalidAttempts = 0;
        this.digit01Revealed = false;
        this.digit02Revealed = false;
        this.digit03Revealed = false;
        this.setCombo(digit01, digit02, digit03);
        System.out.println("\tYour Combo: " + this.getCombo() + " | SN: " + this.serialNumber);
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    /*
     * Setting Combo:
     *      - must be valid values (0-9)
     *      - can only set the combo when the lock is OPEN
     *      - can only be set if the lock is configurable
     */
    public void setCombo(int digit01, int digit02, int digit03) {
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
        } else {
            this.digit01 = digit01;
            this.digit02 = digit02;
            this.digit03 = digit03;
            System.out.println("\tYour Combo: " + this.getCombo() + " | SN: " + this.serialNumber);
        }
    }

    /*
     * Digit 01; only revealed ONCE.
     *      -1 returned if revealed.
     */
    public int getDigit01() {
        int digit = -1;
        if (this.digit01Revealed) {
            System.out.println("ERROR: Digit 01 Revealed to the client. ");
        } else {
            this.digit01Revealed = true;
            digit = this.digit01;
        }
        return digit;
    }

    /*
     * Digit 01; only revealed ONCE.
     *      -1 returned if revealed.
     */
    public int getDigit02() {
        int digit = -1;
        if (this.digit02Revealed) {
            System.out.println("ERROR: Digit 02 Revealed to the client. ");
        } else {
            this.digit02Revealed = true;
            digit = this.digit02;
        }
        return digit;
    }

    /*
     * Digit 03; only revealed ONCE.
     *      -1 returned if revealed.
     */
    public int getDigit03() {
        int digit = -1;
        if (this.digit03Revealed) {
            System.out.println("ERROR: Digit 03 Revealed to the client. ");
        } else {
            this.digit03Revealed = true;
            digit = this.digit03;
        }
        return digit;
    }

    /*
     * Getting Combo:
     *      - nobody should see the combo; except when the lock is created.
     */
    private String getCombo() {
        if (this.digit01Revealed && this.digit02Revealed && this.digit03Revealed) {
            return this.digit01 + "-" + this.digit02 + "-" + this.digit03;
        } else {
            System.out.println("Cannot get combo, combo is not created yet!");
            return null;
        }
    }

    public boolean isOpen() {
        return open;
    }

    /*
     * Lock
     */
    public boolean lock() {
        this.open = false;
        return true;
    }

    /*
     * Unlock; 
     *      - unlock with correct combination
     *      - AFTER three invalid unlocking attempts; lock will not open
     */
    public boolean unlock(int digit01, int digit02, int digit03) {
        if (this.open) {
            System.out.println("Lock is already open!");
            return true;
        } else if (this.invalidAttempts >= 3) {
            System.out.println("Too many invalid attempts!");
            return false;
        } else if (this.digit01 != digit01 || this.digit02 != digit02 || this.digit03 != digit03) {
            System.out.println("Numbers do not match!");
            invalidAttempts++;
            return false;
        } else {
            this.open = true;
            return true;
        }
    }

    @Override
    public String toString() {
        return "AndroidLock{" + "serialNumber=" + serialNumber + '}';
    }

    /**
     * The method returns the number of locks created.
     *
     * @return the number of locks created.
     */
    public static int getNumberOfLocksCreated() {
        return numberOfLocksCreated;
    }

}
