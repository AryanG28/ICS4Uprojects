/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u4;

import static gwss.edu.ics4u.introduction.Resistors.input;
import java.util.Scanner;

/**
 *
 * @author Aryan
 */
public class recursivePranctice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        oddInReverse(9);
    }

    public static void ct(int n) {
        System.out.println("Starting " + n);
        if (n > 0) {
            ct(n / 3);
            System.out.println("Middle " + n);
        }
    }

    public static void cp(int n) {
        System.out.println(n);
        if (n > 0) {
            if (n % 2 == 1) {
                cp(n / 3);
            } else {
                cp(n / 2);
            }
        }
    }

    public static void cq(int n) {
        if (n > 0) {
            cq(n / 10);
            System.out.println(n % 10);
        }
    }

    public static void whatItDo() {
        Scanner input = new Scanner(System.in);
        String letter = input.next();

        if (!letter.equals(
                ".")) {
            whatItDo();
            System.out.println(letter);
        }

    }

    public static int countingOddNumbers(int n) {
        int sum;
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 1) {
            sum = n + countingOddNumbers(n - 2);
        } else {
            sum = countingOddNumbers(n - 1);
        }

        return sum;

    }

    public static void oddInReverse(int n) {
        if (n == 1) {
            System.out.print(n + " ");
        }
        if ((n % 2 != 0) && n > 1) {
            oddInReverse(n - 2);
        }
        if ((n % 2 == 0)) {
            oddInReverse(n - 1);
            
        } 
        System.out.print(n + " ");
    }

}
