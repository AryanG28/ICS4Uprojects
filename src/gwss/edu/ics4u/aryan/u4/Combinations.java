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
public class Combinations {

    public static void main(String[] args) {       
            System.out.println(combinations(10, 2));


    }

    public static int combinations(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        }
        if (n < 0 || r < 0 || r> n) {
            return -1;
        }
        return combinations(n - 1, r-1) + combinations(n - 1, r);

    }
}
