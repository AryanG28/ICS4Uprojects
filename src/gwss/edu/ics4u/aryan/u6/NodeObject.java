package gwss.edu.ics4u.aryan.u6;



/**
 * Lesson: 6.03 - a Node
 */
public class NodeObject extends edu.hdsb.gwss.muir.ics4u.u6.Node {
    //
    private String data;
    private NodeObject next;

    public NodeObject( String newData ) {
        super(newData);
        this.data = newData;
        this.next = null;
    }

    @Override
    public NodeObject getNext() {
        return this.next;
    }

    public void setNext( NodeObject newNode ) {
        this.next = newNode;
    }

    @Override
    public String getData() {
        return this.data;
    }       


}
