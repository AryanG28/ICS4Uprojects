/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u6;

import java.util.Arrays;

/**
 *
 * @author 1GHAHREMANZA
 */
public class Queue implements QueueInterface {

    int size;
    int[] data = new int[5];

    public Queue(int size) {
        this.data = new int[size];
    }

    @Override
    public void enqueue(int value) {
        if (isEmpty()) {
            data[0] = value;
            size++;
        } else if (!isFull()) {
            for (int i = 0; i < size; i++) {
                int temp = data[i];
                data[i + 1] = temp;
            }
            data[0] = value;
            size++;
        }
    }

    @Override
    public int dequeue() {
        int i;
        if (isEmpty()) {
            i = -1;
        } else {
            i = data[0];
            size--;
            for (int j = size; j > 0; j--) {
                int temp = data[j];
                data[j - 1] = temp;
                data[j] = 0;
            }
        }
        return i;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean isFull() {
        return (size == data.length);
    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < size; i++) {
            data[i] = 0;
        }
        size = 0;

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Queue q = new Queue(5);
        // q.data = new int [5];
        q.enqueue(5);
        q.enqueue(7);
        System.out.println(Arrays.toString(q.data));
        System.out.println(q.size());
        q.dequeue();
        System.out.println(Arrays.toString(q.data));
        System.out.println(q.size());
        q.makeEmpty();
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        System.out.println(Arrays.toString(q.data));
        q.enqueue(5);
        q.enqueue(5);
        q.enqueue(5);
        q.enqueue(5);
        q.enqueue(5);
        System.out.println(Arrays.toString(q.data));
        System.out.println(q.isEmpty());
        System.out.println(q.isFull());
        q.enqueue(8);
    }

}
