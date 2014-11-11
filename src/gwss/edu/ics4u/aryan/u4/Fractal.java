/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u4;

/**
 *
 * @author 1GHAHREMANZA
 */
public class Fractal {


    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {

        int[] data = { 0, 2, 8, 12, 18, 24, 30, 70, 122, 140 };
        
        for( int i = 0; i < data.length; i++ ) {
            System.out.println( search( data, data[i] ) );
        }
        System.out.println( search( data, -100 ) );
        System.out.println( search( data, 200 ) );
        System.out.println( search( data, 1 ) );
        System.out.println( search( data, 17 ) );
        System.out.println( search( data, 139 ) );

    }

    public static int search( int[] data, int value ) {
        return binarySearch( data, value, 0, data.length - 1 );
    }
    
    public static int binarySearch( int[] data, int value, int left, int right ) {
        if( left > right )
            return -1;
        int mid = ( left + right ) / 2;
        if( data[mid] == value )
            return mid;
        if( data[mid] > value )
            return binarySearch( data, value, left, mid - 1);
        else
            return binarySearch( data, value, mid + 1, right );
    }

    public static long factorial( int n ) {
        if ( n < 0 ) {
            return -1;
        }
        if ( n == 0 || n == 1 ) {
            return 1;
        }
        return n * factorial( n - 1 );

    }

}