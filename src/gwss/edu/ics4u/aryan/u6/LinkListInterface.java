package gwss.edu.ics4u.aryan.u6;



/**
 * Lesson: 6.03 - Linked List
 */
public interface LinkListInterface {

    public int size();
    
    public void makeEmpty();
    
    /**
     * Adds a node to the front of the linked list .
     *
     * @param str
     */
    public void addAtFront( String str );
    
    /**
     * Adds a node to the end of the linked list.
     *
     * @param str
     */
    public void addAtEnd( String str );
    
    /**
     * Deletes a node in the linked list.
     *
     * @param str
     */
    public void remove( String str );

    /**
     * Creates a string that lists the nodes of the linked list.
     *
     * @param str
     */
    public String toString( );

}
