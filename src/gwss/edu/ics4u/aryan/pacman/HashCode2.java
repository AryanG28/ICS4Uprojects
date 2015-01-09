/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.pacman;

/**
 *
 * @author Aryan
 */
public class HashCode2 {

    public static final int EMPTY = -1;
    public static final double MAX_FACTOR = 0.75;
    public int expectedNumberInputs;
    public Chair valueCausingResize;
    public int collisions = 0;
    public Chair array[];
    public int size = 0;

    public HashCode2(int x) {
        this.expectedNumberInputs = x;
        this.array = new Chair[primeNumberInRange(this.expectedNumberInputs)];
        System.out.println("New hastable made. Expect: " + x + ". Size: " + capacity());

        makeEmpty();
        System.out.println("length: " + this.array.length);
    }

    public Chair get(int key) {//pass it a key (has value)
        boolean found = false;
        Chair ch = null;
        int x = hash(53 * (3 + key));

        while (!found && array[x] != null){
            if (array[x].getSerialNumber() == key) {
                found = true;
                ch = array[x];
            } else {
                x = (x + 1) % capacity();
            };
        } 
        return ch;
        
    }
    
    public boolean containsKey(int key){
        boolean exists = false;
        
        int x = hash(53 * (3 + key));

        while (!exists && array[x] != null){
            if (array[x].getSerialNumber() == key) {
                exists = true;
                
            } else {
                x = (x + 1) % capacity();
            };
        } 
        return exists;
        
    }

    public int capacity() {
        return this.array.length;
    }

    public double loadFactor() {
        double loadFactor = (double) this.size() / (double) this.capacity();
        return loadFactor;
    }

    public int primeNumberInRange(int number) {
        boolean prime = false;
        number = (int) (number / 0.76);

        while (prime == false) {

            if (isPrime(number) == true) {
                prime = true;
            } else {
                number++;
            }

        }
        return number;
    }

    public void resize() {//at 0.75 load factor. make to 0.5 load factor, or 1.5 x
        System.out.println("resizing...");
        Chair[] copyArray = this.array;
        Chair[] largerArray = new Chair [primeNumberInRange(this.expectedNumberInputs * 3)];

        for (int i = 0; i < largerArray.length; i++) {
            largerArray[i] = null;
        }
        
        this.array = largerArray;
        expectedNumberInputs *= 3;
        for (int i = 0; i < copyArray.length; i++) {
                if (copyArray[i] != null) {
                    put(copyArray[i]);
                    //this.array[hash(copyArray[i].hashCode())] = copyArray[i];

            }
        }


       
    }

    public int size() {
        return this.size;
    }

    public static boolean isPrime(int number) {//not my code I do not take credit for this
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                // number is even - no prime
                return false;
            }
        }
        return true;
    }

    public void makeEmpty() {
        this.size = 0;
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = null;
        }
    }

    public boolean indexLocationFull(int x) {
        if (x <= capacity() && x >= 0) {
            if (this.array[x] == null) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public int hash(int value) {
        return value % capacity();
    }

    public void displayArray() {
        for (int i = 0; i < capacity(); i++) {
            if (array[i] != null) {
                System.out.println("indx: " + i + ", " + array[i].toString());
            } else {
                System.out.println("indx: " + i + "--");
            }
        }
    }

    public void put(Chair c) {
        int x = hash(c.hashCode());
        if (!indexLocationFull(x)) {
            this.array[x] = c; // that spot is free
            size++;
        } else {//spot is full

            while (indexLocationFull(x)) {
                if (x == capacity() - 1) {//at the end so go to beginning
                    x = -1;
                }
                collisions++;
                x++;
            }
            this.array[x] = c;
            size++;

        }
        if (loadFactor() > MAX_FACTOR) {
            resize();
        }

    }

    public static void main(String[] args) {
        HashCode2 h = new HashCode2(17);
        Chair c1 = new Chair(15, 22.2, "Maple");
        Chair c2 = new Chair(15, 22.2, "Maple");
        Chair c3 = new Chair(44, 33.676, "Oak");
        Chair c4 = new Chair(1, 1.2, "A");
        Chair c5 = new Chair(33, 234423.2, "Red");
        Chair c6 = new Chair (123, 321, "asdf");
        Chair c7 = new Chair (99, 99, "99");
        Chair c8 = new Chair (55, 15.2, "Yellow Submarine");
        System.out.println(h.capacity());
        h.put(c1);
        h.put(c2);
        h.put(c3);
        h.put(c4);
        h.put(c5);
        //h.resize();
        //h.put(c4);
        h.displayArray();
        System.out.println("getting: " + h.get(1));
        System.out.println("Contains key (2) " + h.containsKey(2));
        System.out.println("number collisions: " + h.collisions);
        System.out.println("load factor " + h.loadFactor() + " size: " + h.size());
//        h.put(c1);
//        h.put(c6);
//        h.put(c5);
//        h.put(c7);
//        h.put(c8);
//        h.displayArray();
//        System.out.println(h.capacity());
//    }
    }

}
