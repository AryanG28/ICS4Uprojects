package gwss.edu.ics4u.aryan.u6;

/**
 * Lesson: 6.02 - Queue
 */
public interface QueueInterface {
    
    public void enqueue( int value );

    public int dequeue();

    public int size();

    public boolean isEmpty();
    
    public boolean isFull();

    public void makeEmpty();

}
