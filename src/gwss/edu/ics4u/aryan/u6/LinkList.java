/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose snakeeeTools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u6;

import edu.hdsb.gwss.muir.ics4u.u6.LinkListInterface;

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
        Node newHead = new Node(str);
        if (size() == 0) {
            this.head = newHead;
            this.tail = newHead;
        } else {
            Node temp = this.head;
            this.head = newHead;
            this.head.setNext(temp);
        }
    }

    @Override
    public void addAtEnd(String str) {
        Node newTail = new Node(str);
        if (size() == 0) {
            this.head = newTail;
            this.tail = newTail;
        } else {
            this.tail.setNext(newTail);
            this.tail = newTail;
        }
    }

    @Override
    public void remove(String str) {
        Node current = this.head;
        if (current.getData().equalsIgnoreCase(str)) {
            this.head = current.getNext();
        } else {

            while (current.getNext() != null && !current.getNext().getData().equalsIgnoreCase(str)) {
                current = current.getNext();
            }
            if (current.getNext() != null) {
                current.setNext(current.getNext().getNext());
            } else {
                System.out.println("Could not find");
            }

        }
//abstract data type is performance task
    }
    
        @Override
    public boolean isEmpty() {
        return (head==null && tail==null);
    }

    public String toString() {
        String s = "";

        if (head != null) {
            Node n = head;
            do {
                s += n.getData() + " ";
                n = n.getNext();
            } while (n != null);
        }
        return s;
    }

//    public static void main(String[] args) {
//        LinkList l = new LinkList();
//        l.addAtEnd("swag");
//        l.addAtFront("no future");
//        l.addAtEnd("snake");
//        System.out.println(l.toString());
//    }
    public static void main(String[] args) {
        // TODO code application logic here

        LinkList l = new LinkList();
        l.addAtFront("first");
        System.out.println(l.size());
        l.addAtEnd("first1");
         System.out.println(l.size());
        l.addAtFront("wedf");
        l.addAtFront("fjksdg");
        l.addAtEnd("end");
        l.addAtFront("sdgfsdg");
        l.addAtEnd("real");
        System.out.println(l.size());
        System.out.println(l.toString());
//        System.out.println(l.size());
      l.remove("swagagagag");
//        System.out.println(l.size());
//        l.remove("FIRST");

//        System.out.println(l.size());
//        l.makeEmpty();
//        System.out.println(l.size());

        // l.addAtEnd("end");
        System.out.println(l.size());
        System.out.println(l.toString());
    }


}
