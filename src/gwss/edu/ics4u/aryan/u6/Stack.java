/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u6;

/**
 *
 * @author 1GHAHREMANZA
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void push(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        if (top== -1)
            return true;
        else {
            return false;
        }
    }

    @Override
    public boolean isFull() {
       if (top== data.length -1 )
            return true;
        else {
            return false;
        }
    }

    @Override
    public void makeEmpty() {
        top = -1;
    }
    
}
