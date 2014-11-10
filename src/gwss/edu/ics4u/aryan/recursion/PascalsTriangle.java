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
        //tests term at 4,2
        System.out.println(term(4,2));
        //displays the first 10 rows of pascals triangle
        System.out.println( row(7) );

    }
    //calculates term value of pascals triangle
    public static int term(int row, int col) {
        if (col == 0) {
            return 1;
        }
        if (row == col) {
            return 1;
        }
        return term(row - 1, col - 1) + term(row - 1, col);
    }
    //
    public static String row(int row) {
        String triangleFormat = "                                               ";
        String s = "";
        //if row is less than 0 it recursively returns blank string
        if (row < 0) {
            return "";
       }
        for (int i = 0; i < row + 1; i++) {
            s = s + (term(row, i) + " ");
        }
        // formats triangle
        s = triangleFormat.substring( 0, Math.abs(row - 10)) + s + "\n";
        //recursively displays the whole triangle
        return row(row - 1) + s;
    }
}


