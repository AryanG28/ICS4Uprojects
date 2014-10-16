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
public class LockClient {

    public static void main(String[] args) {
        Lock androidLock = new Lock();

        System.out.println("Test Case #1");
        System.out.println("Checking set combo with out of range numbers");
        androidLock.setCombo(0, 12, 1);
        System.out.println("");

        System.out.println("Test Case #2");
        androidLock.toString();
        System.out.println("Checking set combo with right numbers");
        androidLock.setCombo(0, 2, 1);
        androidLock.toString();
        System.out.println("");

        System.out.println("Test Case #3");
        System.out.println("Is lock Open:" + androidLock.isOpen());
        System.out.println("Checking lock");
        androidLock.lock();
        System.out.println("Is lock Open:" + androidLock.isOpen());
        System.out.println("");

        System.out.println("Test Case #4");
        System.out.println("Checking unlock with right combination");
        System.out.println("Is lock Open:" + androidLock.isOpen());
        androidLock.unlock(0, 2, 1);
        System.out.println("Is lock Open:" + androidLock.isOpen());
        System.out.println("");

        System.out.println("Test Case #5");
        System.out.println("Checking unlock with right combination");
        System.out.println("Is lock Open:" + androidLock.isOpen());
        androidLock.unlock(0, 2, 1);
        System.out.println("Is lock Open:" + androidLock.isOpen());
        System.out.println("");
        
        System.out.println("Test Case #6");
        System.out.println("Can lock be unlcoked when already unlocked");
        System.out.println("Is lock Open:" + androidLock.isOpen());
        androidLock.unlock(0, 2, 1);
        System.out.println("Is lock Open:" + androidLock.isOpen());
        System.out.println("");
        
        System.out.println("Test Case #7");
        System.out.println("Can lock be unlocked with 3 invalid attempts");
        androidLock.lock();
        System.out.println("Is lock Open:" + androidLock.isOpen());
        androidLock.unlock(0, 4, 1);
        androidLock.unlock(0, 4, 1);
        androidLock.unlock(0, 4, 1);
        System.out.println("Is lock Open:" + androidLock.isOpen());
        androidLock.unlock(0, 2, 1);
        System.out.println("Is lock Open:" + androidLock.isOpen());
        System.out.println("");

        
    }
}
