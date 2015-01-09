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
public class Node {

    private Chair data;
    private Node next;
    private Node prev;

    public Node(Chair c) {
        //  super(newData);
        this.data = c;
        this.next = null;
    }

    //   @Override
    public Node getNext() {
        return this.next;
    }

    public void setNext(Node newNode) {
        this.next = newNode;
    }
    
    public void setPrev (Node newNode) {
        this.prev = newNode;
    }

    public Node getPrev() {
        return this.prev;
    }
    
    //   @Override
    public Chair getData() {
        return this.data;
    }

}
