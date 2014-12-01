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
// dont pass a node let link list handle it
    @Override
    public Node getNext() {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNext( Node newNode ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getData() {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }       

}
