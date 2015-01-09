/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.practice2;

import gwss.edu.ics4u.aryan.practice.*;
import gwss.edu.ics4u.aryan.u6.*;
import edu.hdsb.gwss.muir.ics4u.u6.HashTableInterface;

/**
 *
 * @author Aryan
 */
public class HashTable2 {

    public Student[] table;
    public int numberOfCollisions;

    public HashTable2(int requestedInitialSize) {
        if (requestedInitialSize < 0) {
            System.out.println("Invalid initial size!");
        } else {
            int initialSize = findNextPrimeNumber(requestedInitialSize);
            table = new Student[initialSize];
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

        Student[] old = this.table;

        this.table = new Student[newCapacity];
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
    public Student get(int key) {
        int initialIndex = hash(key);
        int startIndex = initialIndex;
        int endIndex = table.length;
        boolean keepGoing = true;
        while (true) {
            while (startIndex < endIndex) {//use inserted, resize at end
                if (table[startIndex].getStudentId() == key) {
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
    public void put(Student s) {
        int initialIndex = hash(student.getKey());
        int index = initialIndex;
        boolean inserted = false;


        while (!inserted) {
            while (!inserted && index < data.length) {//use inserted, resize at end
                if (data[index] == null) {
                    LinkedListPT newLinkedList = new LinkedListPT();
                    data[index] = newLinkedList;
                    newLinkedList.addAtEnd(student);                  
                    inserted = true;
                } else {
                   // numberOfCollisions++;
                    index++;
                }
            }
            index = 0;
        }
    }

    public boolean containsKey(int key) {
        int index = hash(key);
        while (true) {
            for (int i = index; i < table.length; i++) {
                if (table[i] == null) {
                    return false;
                }
                
                if (table[i].getStudentId() == key) {
                    return true;
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
        Student[] valuesAdded = new Student[100];
        int nextSpot = 0;
        for (int i = 0; i < valuesAdded.length; i++) {
            valuesAdded[i] = null;
        }

        HashTable2 ht = new HashTable2(20);

        // EMPTY
        assert (ht.size() == 0);
        assert (ht.isEmpty());
        assert (ht.capacity() == 23);
        assert (ht.loadFactor() == 0.0);

        // HASH
        assert (ht.hash(0) == 0);
        assert (ht.hash(1) == 1);
        assert (ht.hash(ht.capacity()) == 0);
        assert (ht.hash(ht.capacity() - 1) == ht.capacity() - 1);

        // PUT
        Student c = new Student();
        ht.put(c);
        valuesAdded[nextSpot] = null;
        nextSpot++;
        assert (!ht.isEmpty());
        assert (ht.size() == 1);
        assert (ht.containsKey(0)== false);
        assert (ht.get(1000) == c);
        assert (ht.loadFactor() == (100.0 / (double) ht.capacity()));

        Student c1 = new Student();
        ht.put(c1);
        valuesAdded[nextSpot] = c1;
        nextSpot++;
        assert (!ht.isEmpty());
        assert (ht.size() == 2);
        assert (ht.containsKey(1001));
        assert (ht.get(1001) == c1);
        assert (ht.loadFactor() == (200.0 / (double) ht.capacity()));

        int size = 2;
        // for (; size < 17; size++) {
        Student c2 = new Student();
        int value = 1002;

        ht.put(c2);
        valuesAdded[nextSpot] = c2;
        nextSpot++;
        assert (ht.size() == size + 1);
        assert (ht.containsKey(value));
        assert (ht.get(value) == c2);

        System.out.println("Load Factor: " + ht.loadFactor());

        Student c3 = new Student();
        Student c4 = new Student();
        Student c5 = new Student();
        Student c6 = new Student();
        Student c7 = new Student();
        Student c8 = new Student();
        Student c10 = new Student();
        Student c11 = new Student();
        Student c12 = new Student();
        Student c13 = new Student();
        Student c14 = new Student();
        Student c15 = new Student();
        Student c16 = new Student();
        Student c17 = new Student();
        ht.put(c3);
        ht.put(c4);
        ht.put(c5);
        ht.put(c6);
        ht.put(c7);
        ht.put(c8);
        ht.put(c10);
        ht.put(c11);
        ht.put(c12);
        ht.put(c13);
        ht.put(c14);
        ht.put(c15);
        ht.put(c16);
        ht.put(c17);

        assert (ht.size() == 17);
        assert (ht.loadFactor() < 75);
        assert (ht.capacity() == 23);

        System.out.println("RESIZED");
        Student c18 = new Student();
        ht.put(c18);
        valuesAdded[nextSpot] = c18;
        nextSpot++;
        assert (ht.capacity() == 73);
        assert (ht.loadFactor() < 25);

        // MAKE SURE RESIZE WORKED; ALL VALUES ADDED CORRECTLY
        nextSpot = 0;
        Student value2;
        while (valuesAdded[nextSpot] != null) {
            value2 = valuesAdded[nextSpot];
            assert (ht.containsKey(value));
            assert (ht.get(value) == value2);
            nextSpot++;
        }
        // MAKE EMPTY
        ht.makeEmpty();
        // EMPTY
        assert (ht.size() == 0);
        assert (ht.isEmpty());
        assert (ht.capacity() == 73);
        assert (ht.loadFactor() == 0.0);

    }

}
