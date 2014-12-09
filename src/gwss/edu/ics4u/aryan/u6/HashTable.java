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
        int initialSize = findNextPrimeNumber(requestedInitialSize);
        table = new int[initialSize];
        makeEmpty();

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

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] == -1) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public void resize() {
      
        int newCapacity = (int) (size() / 0.25);
        int temp[] = new int[capacity()];
        for (int i = 0; i < table.length; i++) {
            temp[i] = table[i];
        }
        table = new int[newCapacity];
        for (int i = 0; i < temp.length; i++) {
            put(temp[i]);
        }
    }

    @Override
    public int capacity() {
        return table.length;
    }

    @Override
    public double loadFactor() {
        return (size() / capacity());
    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < table.length; i++) {
            table[i] = -1;
        }
    }

    @Override
    public void isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int get(int key) {
        return table[hash(key)];
    }

    @Override
    public void put(int value) {
        if (loadFactor() > 0.75 ) {
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
        int initialIndex = key % capacity();
        int index = initialIndex;
        while (index < table.length) {
            if (table[index] == -1) {
                return index;
            } else {
                index++;
            }
        }

        index = 0;
        while (index < initialIndex) {
            if (table[index] == -1) {
                return index;
            } else {
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

}
