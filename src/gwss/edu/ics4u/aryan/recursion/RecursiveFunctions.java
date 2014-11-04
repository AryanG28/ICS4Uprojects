/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        // TODO code application logic here
        System.out.println(function1(5,3));
        System.out.println(function1(2,2));
        System.out.println(function1(1,4));
        System.out.println(function1(-5,-2));
        System.out.println("");
        System.out.println(function2(1, 1));
        System.out.println(function2(2, 1));
        System.out.println(function2(5, 5));
    }
    public static int function1 (int x, int y) {
        if (x < y)
            return -function1(y, x);
        
        if (x==y)
            return 0;

        return 1 + function1(x-1,y);
    }
       
    
    
    public static int function2 (int m, int n) {
        if (m == 0)
            return n+1;
        
        if (m>0 && n==0)
            return function2(m-1, 1);
        
        return function2(m-1, function2(m, n-1));
    }
    
}
