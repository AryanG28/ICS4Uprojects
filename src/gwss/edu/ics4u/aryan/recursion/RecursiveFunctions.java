/*
 * Name: Aryan Ghahremanzadeh 
 * Date: November 10, 2014 
 * Version: v0.1
 * Teacher: Mr.Muir
 * Description: This program shows the results of 2 different functions. One of them being 
 * Ackermanns Function .
 */
package gwss.edu.ics4u.aryan.recursion;

/**
 *
 * @author 1GHAHREMANZA
 */
public class RecursiveFunctions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Function 1: ");
        System.out.println("f(5,3): " + function1(5,3));
        System.out.println("f(2,2): " + function1(2,2));
        System.out.println("f(1,4): " + function1(1,4));
        System.out.println("f(-5,-2): " + function1(-5,-2));
        System.out.println("-----");
        System.out.println("Function 2 (Ackermann's Function): ");
        System.out.println("f(1,1): " + ackermannsFunction(1, 1));
        System.out.println("f(2,1): " + ackermannsFunction(2, 1));
        System.out.println("f(5,5): " + ackermannsFunction(5, 5));
    }
    
    public static int function1 (int x, int y) {
        // When x is less than y it returns the negative inverse of the function
        if (x < y)
            return -function1(y, x);
        // When x is equal to y it returns 0
        if (x==y)
            return 0;
        // Decreases x by 1 and calls the function again adding 1 to it
        return 1 + function1(x-1,y);
    }
       
    
    
    public static int ackermannsFunction  (int m, int n) {
        // when m is 0 it returns n value plus 1
        if (m == 0)
            return n+1;
        // when m is greater then 0 and n is equal to 0 it calls itself by m-1 and 1
        if (m>0 && n==0)
            return ackermannsFunction(m-1, 1);
        // If it does not meet any of the conditions above it does the following
        return ackermannsFunction(m-1, ackermannsFunction(m, n-1));
    }
    
}
