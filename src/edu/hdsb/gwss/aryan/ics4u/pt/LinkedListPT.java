package edu.hdsb.gwss.aryan.ics4u.pt;


/**
 * Linked List of Students
 *
 * @version v2014.S1
 */
public class LinkedListPT {

    private NodePT head;
    private NodePT tail;

    /**
     * Constructor: Empty Linked List
     */
    public LinkedListPT() {
        this.head = null;
        this.tail = null;
    }

    /**
     * @return returns the size (# of students) in the linked list.
     */
    public int size() {
        int size = 0;
        if (head != null) {
            NodePT n = head;
            do {
                size++;
                n = n.getNext();
            } while (n != null);
        }
        return size;
    }

    /**
     * This method makes the linked list empty.
     */
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    /**
     * This method returns true if the linked list is empty
     *
     * @return returns true if there are no student objects in the linked list
     */
    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    /**
     * This method adds a student object to the end of the linked list.
     *
     * @param student
     */
    public void addAtEnd(CSStudent student) {
        NodePT newTail = new NodePT(student);
        if (size() == 0) {
            this.head = newTail;
            this.tail = newTail;
        } else {
            this.tail.setNext(newTail);
            this.tail = newTail;
        }
    }

    /**
     * This method will get a student object from the linked list, given the
     * student number
     *
     * @param key student number (key)
     * @return returns the student object for the given key, or null if it
     * doesn't exist.
     */
    public CSStudent get(int key) {
        NodePT n = this.head;
        NodePT n1 = this.head;
        if (size() != 0) {
            if (key == n.getData().getStudentNumber()) {
                return n.getData();
            } else {
                while (n.getNext() != null) {
                    n1 = n;
                    n = n.getNext();
                    if (n.getData().getStudentNumber() == key) {
                        return n.getData();
                    }
                }
            }
        } else {
            System.out.println("Linked List is Empty");
        }
        return null;

    }

    /**
     * This method will remove a student object from the linked list, given the
     * student number.
     *
     * @param key student number (key)
     * @return returns the removed student object, or null if the key is not
     * found
     */
    public CSStudent remove(int key) {
        NodePT n = this.head;
        NodePT n1 = this.head;
        if (size() != 0) {
            if (key == n.getData().getStudentNumber()) {
                head = n.getNext();
            } else {
                while (n.getNext() != null) {
                    n1 = n;
                    n = n.getNext();
                    if (n.getData().getStudentNumber() == key) {
                        n1.setNext(n.getNext());
                    }
                }
            }
        } else {
            System.out.println("Linked List is Empty");
        }
        return null;
    }

    /**
     * DONE FOR YOU
     */
    @Override
    public String toString() {
        return "HEAD: " + toString(this.head);
    }

    /**
     * DONE FOR YOU
     */
    private String toString(NodePT n) {
        String s = "";
        if (n != null) {
            s = n.getData() + " --> " + this.toString(n.getNext());
        }
        return s;
    }

}
