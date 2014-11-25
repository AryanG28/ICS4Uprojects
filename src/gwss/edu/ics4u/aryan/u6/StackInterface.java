package gwss.edu.ics4u.aryan.u6;

/**
 * Lesson: 6.01 - Stacks
 */
public interface StackInterface {

    public int top();

    public int pop();

    public void push( int num );

    public int size();

    public boolean isEmpty();
    
    public boolean isFull();

    public void makeEmpty();

}
