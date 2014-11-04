/*
 * To change this license header, choose License Headers in Project Properties.
 * chooooke, 
 */
package gwss.edu.ics4u.aryan.recursion;

/**
 *
 * @author 1GHAHREMANZA
 */
public class PascalsTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static int term(int n) {
        
    }
    
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n < 1) {
            return -1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);

    }

}
