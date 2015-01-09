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

    private NodeObject head;
    private NodeObject tail;

    public LinkList() { 
        this.head = null;
        this.tail = null;
    }

    @Override
    public int size() {
        int size = 0;
        if (head != null) {
            NodeObject n = head;
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
        NodeObject newHead = new NodeObject(str);
        if (size() == 0) {
            this.head = newHead;
            this.tail = newHead;
        } else {
            NodeObject temp = this.head;
            this.head = newHead;
            this.head.setNext(temp);
        }
    }

    @Override
    public void addAtEnd(String str) {
        NodeObject newTail = new NodeObject(str);
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
        if (this.head == null) {
            System.out.println("Link list is empty");
            return;
        } 
        NodeObject current = this.head;
        if (current.getData().equalsIgnoreCase(str)) {
            this.head = current.getNext();
            if (this.head == null) {
                this.tail = null;
            }
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
    }
    
        @Override
    public boolean isEmpty() {
        return (head==null && tail==null);
    }

    public String toString() {
        String s = "";

        if (head != null) {
            NodeObject n = head;
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
        LinkList l = new LinkList();
        l.addAtFront("first");
        System.out.println(l.size());
        l.addAtEnd("second");
        System.out.println(l.toString());
        System.out.println(l.size());
        l.addAtFront("3rd");
        System.out.println(l.toString());
        l.addAtFront("4th");
        System.out.println(l.toString());
        l.addAtEnd("5th");
        System.out.println(l.toString());
        l.remove("5th");
        l.addAtFront("6th");
        System.out.println(l.toString());
        l.remove("6th");
        System.out.println(l.toString());
        l.addAtEnd("seventh");
                System.out.println(l.toString());
        System.out.println(l.size());
        System.out.println(l.toString());
        l.remove("3rd");
        System.out.println(l.toString());
        l.remove("snaaaaaaaaaaaaaaake");
        l.remove("6th");
        System.out.println(l.toString());
        System.out.println(l.size());
        l.remove("swagagagag");
        System.out.println(l.size());
        l.remove("FIRST");
        System.out.println(l.size());
        l.makeEmpty();
        System.out.println(l.size());

        l.addAtEnd("end");
        System.out.println(l.size());
        l.remove("end");
        l.remove("end");
        l.remove("end");
        
        System.out.println(l.toString());

    }




}
