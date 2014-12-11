/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u6;

import java.util.Arrays;

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
        if (!this.isEmpty()) {
            int value = data[top];
            data[top] =0;
            top--;
            return value;
        } else {
            return -1;
        }
    }

    @Override
    public void push(int num) {
        if (!isFull()) {
            top++;
            data[top] = num;
            System.out.println("You pushed: " + data[top]);
        } else {
            System.out.println("Cannot push number");
        }
    }

    @Override
    public int size() {
        if (!isEmpty()) {

            int size = top + 1;
            return size;
        } else {
            return 0;
        }

    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
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
        for (int i = 0; i < data.length; i++) {
            data[i] = -1;
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Stack s = new Stack(5);
        // System.out.println(s.isEmpty());
        s.push(1);
        s.push(2);
        s.push(3);
        // System.out.println(s.isFull());
        //System.out.println(s.isEmpty());
        s.push(4);
        s.push(5);
        // System.out.println(s.isFull());
        System.out.println(Arrays.toString(s.data));
        System.out.println(s.top());
        s.pop();
        System.out.println(Arrays.toString(s.data));
        System.out.println(s.pop());
        System.out.println(Arrays.toString(s.data));

//        System.out.println(s.top);
//        s.makeEmpty();
//        System.out.println(s.isEmpty());
//         System.out.println(Arrays.toString(s.data));
//        
    }
}
