/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.account2;

import gwss.edu.ics4u.aryan.practice2.Student;

/**
 *
 * @author Aryan
 */
public class LinkList2 {
    
    private Node head;
    private Node tail;
    private Node prev;
    
    public LinkList2() {
        head = null;
        tail = null;
        prev = null;
    }

    //  @Override
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

    //  @Override
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    //   @Override
    public void addAtFront(Chair c) {
        Node newHead = new Node(c);
        if (size() == 0) {
            this.head = newHead;
            this.tail = newHead;
        } else {
            Node n = this.head;
            this.head = newHead;
            this.head.setNext(n);
            // while (n.getNext() != null) {
            this.head.getNext().setPrev(this.head);
            // }
        }
    }

    //  @Override
    public void addAtEnd(Chair c) {
        Node newTail = new Node(c);
        if (size() == 0) {
            this.head = newTail;
            this.tail = newTail;
        } else {
            Node n = this.tail;
            this.tail.setNext(newTail);
            this.tail = newTail;
            this.tail.setPrev(n);
        }
    }

    //  @Override
    public void remove(Chair c) {
        Node n = this.head;
        Node n1 = this.head;
        if (size() != 0) {
            if (c == n.getData()) {
                head = n.getNext();
            } else {
                while (n.getNext() != null) {
                    n1 = n;
                    n = n.getNext();
                    if (n.getData() == c) {
                        n1.setNext(n.getNext());
                    }
                }
            }
        } else {
            System.out.println("Linked List is Empty");
        }
    }

    //  @Override
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

    //  @Override
    public boolean isEmpty() {
        return (size() == 0);
    }
        public static void main(String[] args) {

        LinkList2 ll = new LinkList2();   
        Chair c = new Chair();
        Chair d = new Chair();
        Chair e = new Chair();


        // EMPTY
        assert ( ll.size() == 0 );
        assert ( ll.isEmpty() );

        // REMOVE: EMPTY
        System.out.println( "CASE 1: REMOVE NON EXISTING" );
        ll.remove( c );

        // ADD @ FRONT; SIZE 1
        System.out.println( "CASE 2: ADD AT FRONT / REMOVE ONLY ELEMENT" );
        ll.addAtFront( c );
        System.out.println( "DATA: " + ll.toString() );
        ll.remove( c );
        assert ( ll.size() == 0 );
        assert ( ll.isEmpty() );

        // ADD @ END; SIZE 1
        System.out.println( "CASE 3: ADD AT END / REMOVE ONLY ELEMENT" );
        ll.addAtEnd( c );
        System.out.println( "DATA: " + ll.toString() );
        ll.remove( c );
        assert ( ll.size() == 0 );
        assert ( ll.isEmpty() );

        // ADD @ FRONT; SIZE 2
        System.out.println( "CASE 4: ADD AT FRONT / REMOVE 2 ELEMENT" );
        ll.addAtFront( c );
        ll.addAtFront( d );
        System.out.println( "DATA: " + ll.toString() );
        assert ( ll.size() == 2 );
        ll.remove( d );
        System.out.println( "DATA: " + ll.toString() );
        assert ( ll.size() == 1 );
        ll.remove( c );
        System.out.println( "DATA: " + ll.toString() );

        // ADD @ BACK; SIZE 2
        System.out.println( "CASE 5: ADD AT END / REMOVE 2 ELEMENT" );
        ll.addAtEnd( c );
        ll.addAtEnd( d );
        System.out.println( "DATA: " + ll.toString() );
        assert ( ll.size() == 2 );
        ll.remove( d );
        System.out.println( "DATA: " + ll.toString() );
        assert ( ll.size() == 1 );
        ll.remove( c );
        System.out.println( "DATA: " + ll.toString() );

        // REMOVE; MIDDLE
        System.out.println( "CASE 6: REMOVE TWO ELEMENTS" );
        ll.addAtFront( c ); //0
        ll.addAtFront( e ); //2
        ll.addAtFront( d ); //1
        System.out.println( "DATA: " + ll.toString() );
        assert ( ll.size() == 3 );
        ll.remove( e );
        System.out.println( "DATA: " + ll.toString() );
        assert ( ll.size() == 2 );
        ll.remove( d );
        System.out.println( "DATA: " + ll.toString() );
        assert ( ll.size() == 1 );
        ll.remove( c );
        System.out.println( "DATA: " + ll.toString() );

    }
}
