package gwss.edu.ics4u.aryan.practice2;

import gwss.edu.ics4u.aryan.practice.*;
import gwss.edu.ics4u.aryan.u6.*;



/**
 * Lesson: 6.03 - a Node
 */
public class Node2  {
    //
    private Student data;
    private Node2 next;

    public Node2( Student c) {
        this.data = c;
        this.next = null;
    }

   // @Override
    public Node2 getNext() {
        return this.next;
    }

    public void setNext( Node2 newNode ) {
        this.next = newNode;
    }

   // @Override
    public Student getData() {
        return this.data;
    }       


}
