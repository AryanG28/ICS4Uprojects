package gwss.edu.ics4u.aryan.u6;

/**
 * Lesson: 6.02 - Queue
 */
public interface QueueInterface {
    
    public int enqueue();

    public int dequeue();

    public int size();

    public boolean isEmpty();
    
    public boolean isFull();

    public void makeEmpty();

}
