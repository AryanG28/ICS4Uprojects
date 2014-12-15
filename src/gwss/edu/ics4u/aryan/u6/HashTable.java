/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u6;

import edu.hdsb.gwss.muir.ics4u.u6.HashTableInterface;

/**
 *
 * @author Aryan
 */
public class HashTable implements HashTableInterface {

    public int[] table;
    public int numberOfCollisions;

    public HashTable(int requestedInitialSize) {
        if (requestedInitialSize < 0) {
            System.out.println("Invalid initial size!");
        } else {
            int initialSize = findNextPrimeNumber(requestedInitialSize);
            table = new int[initialSize];
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

    public void displayArray() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i]);
        }
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != -1) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public void resize() {
        int newCapacity = (int) (size() / 0.25);
        newCapacity = findNextPrimeNumber(newCapacity);

        int[] old = this.table;

        this.table = new int[newCapacity];
        makeEmpty();

        for (int i = 0; i < old.length; i++) {
            if (old[i] != -1) {
                put(old[i]);
            }
        }
    }

    @Override
    public int capacity() {
        return table.length;
    }

    @Override
    public double loadFactor() {
        return (100 * ((double) size() / (double) capacity()));
    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < table.length; i++) {
            table[i] = -1;
        }
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public int get(int key) {
        int initialIndex = hash(key);
        int startIndex = initialIndex;
        int endIndex = table.length;
        boolean keepGoing = true;
        while (true) {
            while (startIndex < endIndex) {//use inserted, resize at end
                if (table[startIndex] == key) {
                    return table[startIndex];
                }

            }
            if (!keepGoing) {
                return -1;
            }
            startIndex = 0;
            endIndex = initialIndex;
            keepGoing = false;
        }
//        if (containsKey(key)) {
//
//            while (startIndex < table.length) {
//                if (table[startIndex] == key) {
//                    return table[startIndex];
//                }
//                startIndex++;
//            }
//
//            startIndex = 0;
//            while (startIndex < initialIndex) {
//                if (table[startIndex] == key) {
//                    return table[startIndex];
//                }
//                startIndex++;
//            }
//        }
///////?
    }

    @Override
    public void put(int value) { /////??
        int initialIndex = hash(value);
        int index = initialIndex;
        boolean inserted = false;

        while (!inserted) {
            while (!inserted && index < table.length) {//use inserted, resize at end
                if (table[index] == -1) {
                    table[index] = value;
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

    @Override
    public boolean containsKey(int key) {
        int index = hash(key);
        while (true) {
            for (int i = index; i < table.length; i++) {
                if (table[i] == key) {
                    return true;
                }
                if (table[i] == -1) {
                    return false;
                }
            }
            index = 0;
        }

        //return hash(key) != -1; //hash then go down until it equals value or negative one
//        int initialIndex = hash(key);
//        if (table[hash(key)] == -1) {
//            return false;
//        } else {
//            int index = initialIndex;
//            while (index < table.length) {
//                if (table[index] == key) {
//                    return true;
//                } else {
//                    index++;
//                }
//            }
//
//            index = 0;
//            while (index < initialIndex) {
//                if (table[index] == key) {
//                    return true;
//                } else {
//                    index++;
//                }
//            }
//            return false;
//        }
        //calls hash
    }

    @Override
    public int hash(int key) { //////??????
        return key % capacity();
//        int index = initialIndex;
//        while (index < table.length) {
//            if (table[index] == -1) {
//                return index;
//            } else {
//                numberOfCollisions++;
//                index++;
//            }
//        }
//
//        index = 0;
//        while (index < initialIndex) {
//            if (table[index] == -1) {
//                return index;
//            } else {
//                numberOfCollisions++;
//                index++;
//            }
//        }
//        return -1;

//
//        index = initialIndex;
//        while (index >= 0) {
//            if (table[index] == -1) {
//                return index;
//            } else {
//                index--;
//            }
//        }
    }

    public static void main(String[] args) {
        HashTable h = new HashTable(20);
        System.out.println(h.capacity());
        h.put(2);
        h.resize();
        System.out.println(h.capacity());
        System.out.println("Empty array: ");
        System.out.println("IsEmpty: " + h.isEmpty());
        System.out.println("Size: " + h.size() + "  capacity: " + h.capacity() + "  Collisions: " + h.numberOfCollisions + "  Load Factor: " + h.loadFactor());
        h.displayArray();
        System.out.println();

        for (int i = 0; i < 18; i++) {
            h.put((int) ((Math.random()) * 10000));
        }
        // System.out.println("added only 10 numbers. halfway there");
        h.displayArray();
        System.out.println("Size: " + h.size() + "  capacity: " + h.capacity() + "  Collisions: " + h.numberOfCollisions + "  Load Factor: " + h.loadFactor() + "%");
//        System.out.println();
//        for (int i = 0; i < 10; i++) {
//            h.put((int) (Math.random() * 5));
//        }
//
//        h.displayArray();
//        System.out.println("Size: " + h.size() + "  capacity: " + h.capacity() + "  Collisions: " + h.numberOfCollisions + "  Load Factor: " + h.loadFactor());
//
//        System.out.println();
//        System.out.println(h.get(55));
//
//        System.out.println("Making empty....");
//        h.makeEmpty();
//        System.out.println("Displaying array: ");
//        h.displayArray();
//        System.out.println("IsEmpty: " + h.isEmpty());
    }

}
