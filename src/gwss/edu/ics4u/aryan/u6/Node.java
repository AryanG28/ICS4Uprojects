package gwss.edu.ics4u.aryan.u6;

/**
 * Lesson: 6.03 - a Node
 */
public class Node implements NodeInterface {
    //
    private String data;
    private Node next;

    public Node( String newData ) {
        this.data = newData;
        this.next = null;
    }

    @Override
    public Node getNext() {
        return this.next;
    }

    @Override
    public void setNext( Node newNode ) {
        this.next = newNode;
    }

    @Override
    public String getData() {
        return this.data;
    }       

}
