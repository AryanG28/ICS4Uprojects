/**
 * Name: Aryan Ghahremanzadeh 
 * Date: November 10, 2014 
 * Version: v0.1
 * Teacher: Mr.Muir
 * Description: This program will calculate and display(nicely) the first 10 rows of Pascal's triangle.
 * It will also return the term value for a given row and column
 * 
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
        System.out.print("Term at (4,2): ");
        System.out.println(term(4,2));
        //displays the first 7 rows of pascals triangle
        System.out.println("First 7 rows of pascals traingle");
        System.out.println( row(7) );

    }
    //returns the term for the given row & col
    public static int term(int row, int col) {
        // when the column is 0 it returns 1
        if (col == 0) {
            return 1;
        }
        // when the row number is equal to column it returns 1
        if (row == col) {
            return 1;
        }
        //add term of (row -1, col -1) and row -1, col to get term value ( pascals formula) 
        return term(row - 1, col - 1) + term(row - 1, col);
    }
    //displays Pascal's Triangle properly formatted until given row
    public static String row(int row) {
        //var list
        String triangleFormat = "                                               ";
        String rowString = "";
        //if row is less than 0 it returns blank string
        if (row < 0) {
            return "";
       }
        // iterates through rows and adds the terms of that row to the rowString
        for (int i = 0; i < row + 1; i++) {
            rowString = rowString + (term(row, i) + " ");
        }
        // formats triangle
        rowString = triangleFormat.substring( 0, Math.abs(row - 10)) + rowString + "\n";
        //recursively displays the whole triangle
        return row(row - 1) + rowString;
    }
}


