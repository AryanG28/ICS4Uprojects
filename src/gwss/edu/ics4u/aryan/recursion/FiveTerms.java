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
public class FiveTerms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Sequence One: ");
        for (int i = 1; i < 6; i++) {
            System.out.println(sequenceOne(i));
        }
        System.out.println("Sequence Two: ");
        for (int i = 1; i < 6; i++) {
            System.out.println(String.format("%.2f",sequenceTwo(i)));
        }

    }

    public static int sequenceOne(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 3;
        }
        if (n < 1) {
            return -1;
        }
        return sequenceOne(n - 1) + sequenceOne(n - 2);

    }

    public static double sequenceTwo(int n) {
        if (n == 1) {
            return 2;
        }
        if (n < 1) {
            return -1;
        }
        return Math.sqrt(3 * (sequenceTwo(n - 1)) + 4);

    }

}
