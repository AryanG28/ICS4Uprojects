/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u4;

/**
 *
 * @author Aryan
 */
public class recursivePranctice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cq(21785);
    }

    public static void ct(int n) {
        System.out.println("Starting " + n);
        if (n > 0) {
            ct(n / 3);
            System.out.println("Middle " + n);
        }
    }
    
    public static void cp(int n) {
        System.out.println( n);
        if (n > 0) {
            if ( n% 2 ==1) {
                cp(n/3);
            } else {
                cp(n/2);
            }
        }
    }
    
    public static void cq(int n) {
        if (n > 0) {
            cq(n/10);
            System.out.println(n % 10);
        }
    }

}
