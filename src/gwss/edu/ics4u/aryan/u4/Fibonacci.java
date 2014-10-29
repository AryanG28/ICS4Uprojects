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
public class Fibonacci {
    
    public static void main(String[] args) {
        for (int i = 1; i <25; i++ ) {
            System.out.println(fibonacci(i));
        }

    } 

    public static int fibonacci(int n) {
        if (n==1 || n==2) {
            return 1;
        }
        if (n< 1) {
            return -1;
        }
        return fibonacci (n-1) + fibonacci(n-2) ;
        

    }
}
