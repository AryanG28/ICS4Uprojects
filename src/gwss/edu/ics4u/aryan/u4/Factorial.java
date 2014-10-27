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
public class Factorial {
    public static void main(String args[]) {
//        int n= 21;
//        long factorial = 1; 
//        for (int i = n; i > 0; i--) {
//            factorial = factorial * i;
//        }
//                System.out.println(factorial);
        for (int i= 0; i < 100; i++) {
            System.out.println(i+"! = " + factorial(i));
        }

        
    }
    public static long factorial (int n) {
        if(n<0) 
            return-1;
        if (n==0) 
            return 1;
        return n* factorial(n-1);
        
                    
    }
}
