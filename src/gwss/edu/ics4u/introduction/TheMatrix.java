/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.introduction;

import java.util.Scanner;

/**
 *
 * @author 1GHAHREMANZA
 */
public class TheMatrix {
    
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        int userChoice = getUserInput();
        switch (userChoice) {
            case 1:
                int[][] matrixArray = generateMatrix();
                displayArray(matrixArray);
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            }
       }
        
    
     public static int getUserInput() {
         System.out.print(
            "----------Welcome to the Matrix Program!---------------\n" +
            "Please select one of the following options:\n" +
            "1: The Random Matrix\n" +
            "2: The Transpose Matrix\n" +
            "3: Multiplying a Matrix by a Constant\n" +
            "4: Multiplying Two Matrices\n" +
            "Your choice is:");
            int userChoice = input.nextInt();
         
         return userChoice;
                 
    }
     public static int[][] generateMatrix() {
        
        int numberOfRows;
        int numberOfCols;                
        int[][] matrixArray;
        
        System.out.print("State the number of rows: ");
        numberOfRows = input.nextInt();
        System.out.print("State the number of columns: ");
        numberOfCols = input.nextInt();
        matrixArray = new int[numberOfRows][numberOfCols];
        
        for (int row = 0; row < numberOfRows; row++) {            
            for (int col = 0; col < numberOfCols; col++) {
                matrixArray[row][col] = (int) (Math.random() * 9) + 1;  
            }
        }
        return matrixArray;
     }
     
     public static void displayArray(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + ", ");
            }
            System.out.println("");
        }
     }
}
