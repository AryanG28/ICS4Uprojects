/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u6;

/**
 *
 * @author snake
 */
public class Stack implements StackInterface {

    int top;
    int data[];

    public Stack(int size) {
        this.top = -1;
        this.data = new int[size];
    }

    @Override
    public int top() {
        return data[top];
    }

    @Override
    public int pop() {
        return data[top--];
    }

    @Override
    public void push(int num) {
        if (!isFull()) {
            top++;
            data[top] = num;
            System.out.println("You pushed: " + data[top]);

        } else {
            System.out.println("stack is full");
        }
    }

    @Override
    public int size() {
        int size = top + 1;
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFull() {
        if (top == data.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void makeEmpty() {
        top = -1;
    }

    public static void main(String[] args) {

    }
}
