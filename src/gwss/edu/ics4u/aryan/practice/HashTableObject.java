/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.practice;

import gwss.edu.ics4u.aryan.u6.*;
import edu.hdsb.gwss.muir.ics4u.u6.HashTableInterface;

/**
 *
 * @author Aryan
 */
public class HashTableObject {

    public Chair[] table;
    public int numberOfCollisions;

    public HashTableObject(int requestedInitialSize) {
        if (requestedInitialSize < 0) {
            System.out.println("Invalid initial size!");
        } else {
            int initialSize = findNextPrimeNumber(requestedInitialSize);
            table = new Chair[initialSize];
            makeEmpty();
        }

    }

    private static int findNextPrimeNumber(int i) {
        while (true) {
            if (isPrimeNumber(i)) {
                return i;
            }
            i++;
        }
    }

    private static boolean isPrimeNumber(int i) {
        int factors = 0;
        int j = 1;

        while (j <= i) {
            if (i % j == 0) {
                factors++;
            }
            j++;
        }
        return (factors == 2);
    }

//    public void displayArray() {
//        for (int i = 0; i < table.length; i++) {
//            System.out.println(table[Chair]);
//        }
   // }

    //@Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                counter++;
            }
        }
        return counter;
    }

   // @Override
    public void resize() {
        int newCapacity = (int) (size() / 0.25);
        newCapacity = findNextPrimeNumber(newCapacity);

        Chair[] old = this.table;

        this.table = new Chair[newCapacity];
        makeEmpty();

        for (int i = 0; i < old.length; i++) {
            if (old[i] != null) {
                put(old[i]);                                                   ////Come back
            }
        }
    }

    //@Override
    public int capacity() {
        return table.length;
    }

    //@Override
    public double loadFactor() {
        return (100 * ((double) size() / (double) capacity()));
    }

    //@Override
    public void makeEmpty() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
    }

   // @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    //@Override
    public Chair get(int key) {
        int initialIndex = hash(key);
        int startIndex = initialIndex;
        int endIndex = table.length;
        boolean keepGoing = true;
        while (true) {
            while (startIndex < endIndex) {//use inserted, resize at end
                if (table[startIndex].getSerialNumber() == key) {
                    return table[startIndex];
                }
                startIndex = (startIndex + 1) % capacity();
            }
            if (!keepGoing) {
                return null;
            }
            startIndex = 0;
            endIndex = initialIndex;
            keepGoing = false;
        }

    }

   // @Override
    public void put(Chair c) {
        int initialIndex = hash(c.hashCode());
        int index = initialIndex;
        boolean inserted = false;

        System.out.println( "Collisions: " + numberOfCollisions + "  Load Factor: " + loadFactor() + "%");

        while (!inserted) {
            while (!inserted && index < table.length) {//use inserted, resize at end
                if (table[index] == null) {
                    table[index] = c;
                    inserted = true;
                } else {
                    numberOfCollisions++;
                    index++;
                }
            }
            index = 0;
        }
        if (loadFactor() > 75) {
            resize();
        }
    }

    public boolean containsKey(int key) {
        int index = hash(key);
        while (true) {
            for (int i = index; i < table.length; i++) {
                if (table[i].getSerialNumber() == key) {
                    return true;
                }
                if (table[i] == null) {
                    return false;
                }
            }
            index = 0;
        }

    }

    //@Override
    public int hash(int key) { 
        return key % capacity();

    }

    public static void main(String[] args) {
//        HashTableObject h = new HashTableObject(20);
//        System.out.println(h.capacity());
//        h.put(2);
//        h.resize();
//        System.out.println(h.capacity());
//        System.out.println("Empty array: ");
//        System.out.println("IsEmpty: " + h.isEmpty());
//        System.out.println("Size: " + h.size() + "  capacity: " + h.capacity() + "  Collisions: " + h.numberOfCollisions + "  Load Factor: " + h.loadFactor());
//        h.displayArray();
//        System.out.println();
//
//        for (int i = 0; i < 50; i++) {
//            h.put((int) ((Math.random()) * 10000));
//        }
//        // System.out.println("added only 10 numbers. halfway there");
//        h.displayArray();
//        System.out.println("Size: " + h.size() + "  capacity: " + h.capacity() + "  Collisions: " + h.numberOfCollisions + "  Load Factor: " + h.loadFactor() + "%");
////        System.out.println();
////        for (int i = 0; i < 10; i++) {
////            h.put((int) (Math.random() * 5));
////        }
////
////        h.displayArray();
////        System.out.println("Size: " + h.size() + "  capacity: " + h.capacity() + "  Collisions: " + h.numberOfCollisions + "  Load Factor: " + h.loadFactor());
////
////        System.out.println();
////        System.out.println(h.get(55));
////
//        System.out.println("Making empty....");
//        h.makeEmpty();
//        System.out.println("Displaying array: ");
//        h.displayArray();
//        System.out.println("IsEmpty: " + h.isEmpty());
    }

}
