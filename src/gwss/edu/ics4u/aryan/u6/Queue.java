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
    int back;
    int front;

    public Queue(int size) {
        this.data = new int[size];
        this.front = -1;
        this.back = -1;
    }

    @Override
    public void enqueue(int value) {
        if (isEmpty()) {
            data[0] = value;
            this.front = 0;
            this.back = 0;
        } else if (!isFull()) {
            back = (back + 1) % data.length;

            data[this.back] = value;
        } else {
            System.out.println("Queue is full!");
        }

    }

    @Override
    public int dequeue() { //more effcient
        int value;
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            value = -1;
        } else if (front == back) {
            value = data[front];
            makeEmpty();
        } else {
            value = data[front];
            front = (front + 1) % data.length;
        }
        return value;
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        if (front <= back) {
            return back - front + 1;
        } else {
            return (data.length) - front + back + 1;
        }
    }

    @Override
    public boolean isEmpty() {
        return (front == -1 && back == -1);
    }

    @Override
    public boolean isFull() {
        return (size() == data.length);
    }

    @Override
    public void makeEmpty() {

        this.front = -1;
        this.back = -1;

    }

    public void displayQueue() {
        for (int i = 0; i < data.length; i++) {
            if (this.front == i && this.back == i) {
                System.out.format("%4s", "FB");
            } else if (this.front == i) {
                System.out.format("%4s", "F-");
            } else if (this.back == i) {
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
        if (isEmpty()) {
            System.out.println("No front");
            return -1;
        } else {
                return data[front];    
        }

    }

    @Override
    public int back() {
        if (isEmpty()) {
            System.out.println("No back");
            return -1;
        } else {
                return data[front];    
        }
    }

    @Override
    public int capacity() {
        return data.length;
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);

        System.out.println("Adding to the queue...");
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        q.displayQueue();
        System.out.println(q.size());
        for (int i = 0; i < 5; i++) {
            System.out.println(q.dequeue());
        }
        q.dequeue();
        q.enqueue(5);
        q.enqueue(5);
        q.enqueue(5);
        q.dequeue();
        q.enqueue(5);
        q.dequeue();
        q.enqueue(5);
        q.dequeue();
        q.enqueue(5);
        q.dequeue();
        q.enqueue(5);
        q.enqueue(6);

        q.displayQueue();
        System.out.println(q.size());

    }

}
