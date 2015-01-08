/*
 */
package gwss.edu.ics4u.aryan.u6;

/**
 */
public class LinkListTester {

    /**
     */
    public static void main( String[] args ) {

        LinkList ll = new LinkList();        

        // EMPTY
        assert ( ll.size() == 0 );
        assert ( ll.isEmpty() );

        // REMOVE: EMPTY
        System.out.println( "CASE 1: REMOVE NON EXISTING" );
        ll.remove( "ABC" );

        // ADD @ FRONT; SIZE 1
        System.out.println( "CASE 2: ADD AT FRONT / REMOVE ONLY ELEMENT" );
        ll.addAtFront( "ABC" );
        System.out.println( "DATA: " + ll.toString() );
        ll.remove( "ABC" );
        assert ( ll.size() == 0 );
        assert ( ll.isEmpty() );

        // ADD @ END; SIZE 1
        System.out.println( "CASE 3: ADD AT END / REMOVE ONLY ELEMENT" );
        ll.addAtEnd( "ABC" );
        System.out.println( "DATA: " + ll.toString() );
        ll.remove( "ABC" );
        assert ( ll.size() == 0 );
        assert ( ll.isEmpty() );

        // ADD @ FRONT; SIZE 2
        System.out.println( "CASE 4: ADD AT FRONT / REMOVE 2 ELEMENT" );
        ll.addAtFront( "ABC" );
        ll.addAtFront( "XYZ" );
        System.out.println( "DATA: " + ll.toString() );
        assert ( ll.size() == 2 );
        ll.remove( "XYZ" );
        System.out.println( "DATA: " + ll.toString() );
        assert ( ll.size() == 1 );
        ll.remove( "ABC" );
        System.out.println( "DATA: " + ll.toString() );

        // ADD @ BACK; SIZE 2
        System.out.println( "CASE 5: ADD AT END / REMOVE 2 ELEMENT" );
        ll.addAtEnd( "ABC" );
        ll.addAtEnd( "XYZ" );
        System.out.println( "DATA: " + ll.toString() );
        assert ( ll.size() == 2 );
        ll.remove( "XYZ" );
        System.out.println( "DATA: " + ll.toString() );
        assert ( ll.size() == 1 );
        ll.remove( "ABC" );
        System.out.println( "DATA: " + ll.toString() );

        // REMOVE; MIDDLE
        System.out.println( "CASE 6: REMOVE TWO ELEMENTS" );
        ll.addAtFront( "ABC" );
        ll.addAtFront( "123" );
        ll.addAtFront( "XYZ" );
        System.out.println( "DATA: " + ll.toString() );
        assert ( ll.size() == 3 );
        ll.remove( "123" );
        System.out.println( "DATA: " + ll.toString() );
        assert ( ll.size() == 2 );
        ll.remove( "XYZ" );
        System.out.println( "DATA: " + ll.toString() );
        assert ( ll.size() == 1 );
        ll.remove( "ABC" );
        System.out.println( "DATA: " + ll.toString() );

    }

}
