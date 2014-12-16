/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u6;

import java.util.Arrays;
import edu.hdsb.gwss.muir.ics4u.u6.StackInterface;
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
        if (isEmpty()) {
            System.out.println("Cannot return top");
            return -1;
        }
        return data[top];
    }

    @Override
    public int pop() {
        if (!this.isEmpty()) {
            int value = data[top];
            top--;
            return value;
        } else {
            System.out.println("Cannot pop");
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
            return (top + 1);
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
    }
    
    
    @Override
    public int capacity() {
        return data.length;
    }

    public static void main(String[] args) {
 Stack s = new Stack(10);

        assert (s.top() == -1);
        assert (s.size() == 0);
        assert (s.isEmpty() == true);
        assert (s.isFull() == false);
        assert (s.pop() == -1);

        for (int i = 0; i < s.capacity(); i++) {
            assert (s.isFull() == false);
            s.push(i);
            assert (s.isEmpty() == false);
            assert (s.top() == 1);
            assert (s.size() == i + 1);
        }

        assert (s.isFull() == true);

        int value;

        for (int i = s.capacity() - 1; i >= 0; i--) {
            assert (s.top() == 1);
            value = s.pop();
            assert (value == i);
            if (i != 0) {
                assert (s.top() == i - 1);
            }
        }

        assert (s.top() == -1);
        assert (s.pop() == -1);
        assert (s.size() == 0);
        assert (s.isEmpty() == true);
        assert (s.isFull() == false);

        for (int i = 0; i < s.capacity(); i++) {
            s.push((int) (Math.random() * 100));
        }

        assert (s.isFull() == true);
        s.makeEmpty();
        assert (s.isEmpty() == true);
        assert (s.size() == 0);
        assert (s.top() == -1);

//        
    }

}
