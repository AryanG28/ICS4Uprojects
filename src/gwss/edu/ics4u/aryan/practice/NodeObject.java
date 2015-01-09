package gwss.edu.ics4u.aryan.practice;

import gwss.edu.ics4u.aryan.u6.*;



/**
 * Lesson: 6.03 - a Node
 */
public class NodeObject  {
    //
    private Student data;
    private NodeObject next;

    public NodeObject( Student c) {
        this.data = c;
        this.next = null;
    }

   // @Override
    public NodeObject getNext() {
        return this.next;
    }

    public void setNext( NodeObject newNode ) {
        this.next = newNode;
    }

   // @Override
    public Student getData() {
        return this.data;
    }       


}
