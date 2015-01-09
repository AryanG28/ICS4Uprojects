/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose snakeeeTools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.practice;

import gwss.edu.ics4u.aryan.u6.*;
import edu.hdsb.gwss.muir.ics4u.u6.LinkListInterface;

/**
 *
 * @author Aryan
 */
public class LinkListObject {

    private NodeObject head;
    private NodeObject tail;

    public LinkListObject() { 
        this.head = null;
        this.tail = null;
    }

    //@Override
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

  //  @Override
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

  //  @Override
    public void addAtFront(Student c) {
        NodeObject newHead = new NodeObject(c);
        if (size() == 0) {
            this.head = newHead;
            this.tail = newHead;
        } else {
            NodeObject temp = this.head;
            this.head = newHead;
            this.head.setNext(temp);
        }
    }

  //  @Override
    public void addAtEnd(Student c) {
        NodeObject newTail = new NodeObject(c);
        if (size() == 0) {
            this.head = newTail;
            this.tail = newTail;
        } else {
            this.tail.setNext(newTail);
            this.tail = newTail;
        }
    }

   // @Override
    public void remove(Student c) {
        if (this.head == null) {
            System.out.println("Link list is empty");
            return;
        } 
        NodeObject current = this.head;
        if (current.getData().equals(c)) {
            this.head = current.getNext();
            if (this.head == null) {
                this.tail = null;
            }
        } else {

            while (current.getNext() != null && !current.getNext().getData().equals(c)) {
                current = current.getNext();
            }
            if (current.getNext() != null) {
                current.setNext(current.getNext().getNext());
            } else {
                System.out.println("Could not find");
            }

        }
    }
    
    //    @Override
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

        LinkListObject ll = new LinkListObject();   
        Student c = new Student();
        Student d = new Student();
        Student e = new Student();
        d.setWeight(2);
        e.setWeight(100);

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
        ll.addAtFront( c );
        ll.addAtFront( e );
        ll.addAtFront( d );
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
