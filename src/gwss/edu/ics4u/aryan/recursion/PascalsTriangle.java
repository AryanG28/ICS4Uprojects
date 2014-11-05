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
        System.out.println(row(10));

    }

    public static int term(int row, int col) {
        if (col == 0) {
            return 1;
        }
        if (row == col) {
            return 1;
        }
        return term(row - 1, col - 1) + term(row - 1, col);
    }

    public static String row(int row) {

        if (row < 0) {
            return "";
       }
        for (int i = 0; i < row + 1; i++) {
            System.out.print(term(row, i) + " ");
        }
        System.out.println();
        return row(row - 1);

    }
}

//        int r=0;
//        while(row> 0) {
//            if (row==0) {
//                return 1;
//            }
//            if (row >0) {
//                for (int c= 0; c<= row ; c++) {
//                    System.out.format("%-5d", term(row,c));
//                    
//                }
//            }
//            System.out.println(" ");
//            row--;
//        }
//    return 1;
//   }
