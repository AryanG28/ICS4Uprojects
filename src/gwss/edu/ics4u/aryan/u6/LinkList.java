/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u6;

/**
 *
 * @author Aryan
 */
public class LinkList implements LinkListInterface {

    private Node head;
    private Node tail;

    @Override
    public int size() {
        int size = 0;
        if (head != null) {
            Node n = head;
            do {
                size++;
                n = n.getNext();
            } while (n != null);
        }
        return size;
    }

    @Override
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void addAtFront(String str) {
        Node newTail = new Node(str);
        this.tail.setNext(newTail);
        this.tail = newTail;
        if (size() == 0) {
            this.head = newTail;
        }
    }

    @Override
    public void addAtEnd(String str) {
        Node newTail = new Node(str);
        if (size() == 0) {
            this.head = newTail;
            this.tail =newTail;
        }else  {
            this.tail.setNext(newTail);
        }
    }

    @Override
    public void remove(String str) {

        Node current = this.head;
        boolean removed = false;

        if (current.getData().equalsIgnoreCase(str)) {
            this.head = current.getNext();
            current.setNext(null);
        } else {

            while (!current.getNext().getData().equalsIgnoreCase(str)) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            removed = true;

        }
//abstract data type is performance task
    }
    
    public String toString( ) {
        return "---------------------------------"
                + "\n\t Head = " + head.getData()
                + "\n\t Tail = " + tail.getData();
              //  + "\n\t School= " + School;
    }
    
    public static void main(String[]args) {
        LinkList l = new LinkList();
        l.addAtEnd("swag");
        l.addAtEnd("no future");
        l.addAtFront("snake");
        System.out.println(l.toString());
    }
}