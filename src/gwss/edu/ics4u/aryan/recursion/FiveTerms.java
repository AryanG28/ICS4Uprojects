/**
 * Name: Aryan Ghahremanzadeh 
 * Date: November 10, 2014 
 * Version: v0.1
 * Teacher: Mr.Muir
 * Description: This program displays the first 5 terms of two different sequences
 * (both are called recursively)
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
        //Displays first 5 terms of sequence one
        System.out.println("Sequence One: ");
        for (int i = 1; i < 6; i++) {
            System.out.println(sequenceOne(i));
        }
        //Displays first 5 terms of sequence 2
        System.out.println("Sequence Two: ");
        for (int i = 1; i < 6; i++) {
            System.out.println(String.format("%.2f",sequenceTwo(i)));
        }

    }

    public static int sequenceOne(int n) {
        // If n is 1 it returns 1
        if (n == 1) {
            return 1;
        }
        // If n is 2 it returns 3
        if (n == 2) {
            return 3;
        }
        // If n is less than 1 it returns -1 because thats an invalid number
        if (n < 1) {
            return -1;
        }
        //recursively adds the 2 terms before together
        return sequenceOne(n - 1) + sequenceOne(n - 2);

    }

    public static double sequenceTwo(int n) {
        // if n is 1 it returns 2
        if (n == 1) {
            return 2;
        }
        // If n is less than 1 it returns -1 because thats an invalid number
        if (n < 1) {
            return -1;
        }
        // Multiplies the term before by 3 and add 4. Square roots the whole thing. The term before is recursively called. 
        return Math.sqrt(3 * (sequenceTwo(n - 1)) + 4);

    }

}
