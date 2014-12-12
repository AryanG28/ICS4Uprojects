/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u6;

import edu.hdsb.gwss.muir.ics4u.u6.QueueInterface;

/**
 *
 * @author 1GHAHREMANZA
 */
public class Queue implements QueueInterface {

    int[] data;
    int tail;
    int head;

    public Queue(int size) {
        this.data = new int[size];
        this.head = -1;
        this.tail = -1;
    }

    @Override
    public void enqueue(int value) {
        if (isEmpty()) {
            data[0] = value;
            this.head = 0;
            this.tail = 0;
        } else if (!isFull()) {
            this.tail++;
            if (this.tail >= data.length) {
                this.tail = 0;
            }
            data[this.tail] = value;
        } else {
            System.out.println("Queue is full!");
        }

    }

    @Override
    public int dequeue() {
        int value;
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            //what to return??
            value = -1;
        } else if (head == tail) {
            value = data[head];
            makeEmpty();
        } else {
            value = data[head];
            this.head++;
            if (this.head >= data.length) {
                this.head = 0;
            }
        }
        return value;
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        if (head <= tail) {
            return tail - head + 1;
        } else {
            return (data.length) - head + tail + 1;
        }
    }

    @Override
    public boolean isEmpty() {
        return (head == -1 && tail == -1);
    }

    @Override
    public boolean isFull() {
        return (size() == data.length);
    }

    @Override
    public void makeEmpty() {
//        for (int i = 0; i < data.length; i++) {
//            data[i] = 0;
//        }
        this.head = -1;
        this.tail = -1;

    }


    public void displayQueue() {
        for (int i = 0; i < data.length; i++) {
            if (this.head == i && this.tail == i) {
                System.out.format("%4s", "FB");
            } else if (this.head == i) {
                System.out.format("%4s", "F-");
            } else if (this.tail == i) {
                System.out.format("%4s", "B-");
            } else {
                System.out.format("%4s", "");
            }
        }
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.format("%4s", data[i] + "-");
        }
        System.out.println();
    }

    @Override
    public int front() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int back() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int capacity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        public static void main(String[] args) {
        Queue q = new Queue(5);

        System.out.println("Adding to the queue...");
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        for (int i = 0; i < 6; i++) {
            System.out.println(q.dequeue());
        }
        q.displayQueue();

    }

        
}
