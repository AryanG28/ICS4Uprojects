/*
 * Android PIN Lock
 *  - three digit lock code
 *  
 * Version: 0.3; NOT THE FINAL VERSION
 */
package gwss.edu.ics4u.aryan.android;

/**
 * objects - "locks"
Class vs object
	-Why?
- one variable/reference
		- use it anywhere!
		- pass ONE thing
          		- pass the data
          		- pass the behaviours

Class Definition; Properties vs Methods
-age, height, canGraduate, primitive data types
- data structures, 1..1, 1..N; relations to other objects!
-methods; getters/setters, calculateXX, displayXX

static vs. non-static
	-static: 
all objects SHARE the same properties (numberOfSides= traingle)
-CLASS method
-Triangle.calculateArea(2,5)
-calculateData() (int base, int height) (no need for its own cuz u pass info)
math functions are all static
	-non-static: 
- objects that need their OWN data (lengthOfSides = traingle)
Triangle t = new Triangle (2, 5)
calculateArea()
t.calculateArea()	


Encapsulation: 
-data protection
-private /public(anything) / protected
-when to use
- properties: PRIVATE!
	public width;
		t.width = -23; //PUBLIC!(want to force them to use getters/setters)
private width;
t.setWidth(-23);
METHODS:
private int getPinNumber();




Constructor
special method; its called ONCE at the creation 
Triangle t = new Triangle();
Triangle t = new Triangle (3,4,5);
Triangle t =new Triangle (3,4)
call other constructors
this(), this(3,4), this (3,4,5)
-allow to use SETTERS and GETTERS

Clients:
code that USES your objects

Inheritance 
use super(
	Vehicle: BEFORE:
numberOfWheels
numberOfSeats
numberOfDoors
operational
-poweredBy
topSpeed
on  
numberOfCylinders
---------------------------------------- (behaviours)
setters/getters
-turnOn
move
speedUp
slowDown
break
-fillUp
changeOil

Vehicle: AFTER::
numberOfWheels
numberOfSeats
numberOfDoors (move to Car sub-class)
operational
-poweredBy
topSpeed
on (move to Car sub-class)
numberOfCylinders
---------------------------------------- (behaviours)
setters/getters
-turnOn
move
speedUp
slowDown
break
-fillUp
changeOil




Polymorphism
	Car: move
		-press gas pedal
	Bike: move 
		-pedal or go down incline
		-super!
Abstract Class(es)
abtract objects can NOT exist!
abstract methods need to be implemented in sub-class
Class: Polygon     Method: abstract calculateArea(..)
Class: Triangle	Method:CalculateArea
Interface()
method signature
any class that implements the interace must have all the methods implemented




 */
public class AndroidLock {

    // CLASS CONSTANTS
    public static final String LOCK_MANUFACTURER = "ANDROID";
    public final int MIN_COMBO_VALUE = 0;
    public final int MAX_COMBO_VALUE = 9;
    public final int NUMBER_OF_DIGITS = 3;

// CLASS VARIABLES
    protected static int numberOfLocksCreated;

    // OBJECT VARIABLE
    private boolean configurableCombo;
    protected boolean open;
    private boolean digit01Revealed;
    private boolean digit02Revealed;
    private boolean digit03Revealed;
    private int serialNumber;
    private int invalidAttempts;
    protected int digit01;
    protected int digit02;
    protected int digit03;
    protected int maxCombo;

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
        this.digit01 = getDigit01();
        this.digit02 = getDigit02();
        this.digit03 = getDigit03();
        return this.digit01 + "-" + this.digit02 + "-" + this.digit03;

    }

    public boolean isOpen() {
        return open;
    }

    /*
     * Lock
     */
    public boolean lock() {
        this.open = false;
        System.out.println("Lock has been locked!");
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
            System.out.println("Lock has been unlocked!");
            this.open = true;
            return true;
        }
    }

    @Override
    public String toString() {
        return LOCK_MANUFACTURER + " lock " + "\n\tserialNumber= " + serialNumber + '}';
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
