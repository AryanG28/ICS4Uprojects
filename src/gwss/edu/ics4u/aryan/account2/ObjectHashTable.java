/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.account2;

/**
 *
 * @author Aryan
 */
public class ObjectHashTable {

    int collisions;
    Car[] carTable;

    public ObjectHashTable(int wantedSize) {
        int actualSize = nextPrime(wantedSize);
        carTable = new Car[actualSize];
        this.makeEmpty();
    }

    public int size() {
        int size = 0;

        for (Car carTable1 : carTable) {
            if (carTable1 != null) {
                size++;
            }
        }

        return size;
    }

    public void resize() {
        int newCapacity = nextPrime((int) (this.size() / 0.25));
        Car [] temp = this.carTable;
        
        this.carTable = new Car [newCapacity];
        this.makeEmpty();
        
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null) {
                put(temp[i]);
            }
        }
        
    }

    public int capacity() {
        return carTable.length;
    }

    public double loadFactor() {
        return 100 * ((((double) (this.size())) / ((double) (this.capacity()))));
    }

    public void makeEmpty() {
        if (!this.isEmpty()) {
            for (int i = 0; i < carTable.length; i++) {
                carTable[i] = null;
            }
        }
    }

    public boolean isEmpty() {
        for (int i = 0; i < carTable.length - 1; i++) {
            if (carTable[i] != null) {
                return false;
            }
        }

        return true;
    }

    public Car get(Car c) {
        int i = c.getSerialNumber();
        boolean found = false;
        Car c2 = null;

        do {
            if (carTable[i].equals(c)) {
                found = true;
                c2 = carTable[i];
            } else {
                i = (i + 1) % this.capacity();
            }

        } while (!found);

        return c2;
    }

    public int hash(Car c) {
        return c.getSerialNumber() % this.capacity();
    }

    public void put(Car c) {

        int index = hash(c);
        boolean found = false;

        do {
            if (carTable[index] == null) {
                carTable[index] = c;
                found = true;
            } else {
                collisions++;
                index += (index + 1) % this.capacity();
            }
        } while (!found);

        if (this.loadFactor() > 75) {
            this.resize();
        }
    }

    public boolean containsKey(Car c) {
        boolean found = false;
        int index = hash(c);

        do {
            if (carTable[index].equals(c)) {
                found = true;
            } else {
                index = (index + 1) % this.capacity();
            }
        } while (!found);

        return found;
    }

    public int nextPrime(int num) {

        int i = num;
        boolean foundPrime = false;

        do {
            if (isPrime(i)) {
                foundPrime = true;
            } else {
                i++;
            }
        } while (!foundPrime);

        return i;
    }

    public boolean isPrime(int num) {

        if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; (i * i) <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void displayHash() {
        for (int i = 0; i < this.capacity(); i++) {
            if (carTable[i] != null) {
                System.out.print(carTable[i].toString());
            } else {
                System.out.println("NULL");
            }
            System.out.println("____________________");
        }
        
        System.out.println("COLLISIONS: " + this.collisions);
        System.out.println("LOAD FACTOR: " + this.loadFactor());
    }
    
    public static void main(String[] args) {
        ObjectHashTable oht = new ObjectHashTable(8);

        Car c = new Car("08J7 345", "Bugatti Veyron", 0);
        Car c1 = new Car("BJJJ 706", "Nissan Altima", 1);
        Car c2 = new Car("AKNN 461", "Honda Accord", 2);
        Car c3 = new Car("AH76 385", "Ferrari Enzo", 3);
        Car c4 = new Car("Z73N 492", "Lambo Aventador", 4);
        Car c5 = new Car("BMNS 345", "Honda Venza", 5);
        Car c6 = new Car("JHSD 298", "Subaru Impreza", 6);
        
        oht.put(c);
        oht.put(c1);
        oht.put(c2);
        oht.put(c3);
        oht.put(c4);
        oht.put(c5);
        oht.put(c6);
        oht.displayHash();
        
        
        /*
         oht.put(c);
         oht.put(c1);
         oht.put(c2);
         oht.put(c3);
         */

    }
}
