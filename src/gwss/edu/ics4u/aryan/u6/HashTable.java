/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u6;

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
        numberOfCollisions = 0;
        int newCapacity = (int) (size() / 0.25);
        int temp[] = new int[capacity()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = -1;
        }
        for (int i = 0; i < table.length; i++) {
            temp[i] = table[i];
        }
        table = new int[newCapacity];
        this.makeEmpty();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != -1) {
                table[hash(temp[i])] = temp[i];
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
        return table[hash(key)];
    }

    @Override
    public void put(int value) {
        if (loadFactor() > 75) {
            resize();
        }
        table[hash(value)] = value;
    }

    @Override
    public boolean containsKey(int key) {
        return (table[hash(key)] == key);
    }

    @Override
    public int hash(int key) {
        int initialIndex = Math.abs(key % capacity());
        int index = initialIndex;
        while (index < table.length) {
            if (table[index] == -1) {
                return index;
            } else {
                numberOfCollisions++;
                index++;
            }
        }

        index = 0;
        while (index < initialIndex) {
            if (table[index] == -1) {
                return index;
            } else {
                numberOfCollisions++;
                index++;
            }
        }
        return -1;

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
//        System.out.println("Empty array: ");
//        System.out.println("IsEmpty: " + h.isEmpty());
//        System.out.println("Size: " + h.size() + "  capacity: " + h.capacity() + "  Collisions: " + h.numberOfCollisions + "  Load Factor: " + h.loadFactor());
//        h.displayArray();
//        System.out.println();

        for (int i = 0; i < 19; i++) {
            h.put((int) ((Math.random()) * -5));
        }
        // System.out.println("added only 10 numbers. halfway there");
        h.displayArray();
        System.out.println("Size: " + h.size() + "  capacity: " + h.capacity() + "  Collisions: " + h.numberOfCollisions + "  Load Factor: " + h.loadFactor());
        System.out.println();
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
