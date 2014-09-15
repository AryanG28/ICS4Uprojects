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
        int[][] matrixArray = generateMatrix();
        switch (userChoice) {
            case 1:
                displayArray(matrixArray);
                break;
            case 2:
                matrixArray = transposeMatrix(matrixArray);
                displayArray(matrixArray);
                break;
            case 3:
                displayArray(matrixArray);
                matrixArray = multiplyMatrixByConstant(matrixArray);
                displayArray(matrixArray);
                break;
            case 4:
                int[][] matrixArray2 = generateMatrix();
                int[][] multipliedMatrices = multiplyMatrices(matrixArray, matrixArray2);
                displayArray(matrixArray);
                displayArray(matrixArray2);
                displayArray(multipliedMatrices);
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
     
     public static int[][] transposeMatrix(int[][] data) {
                     
        int[][] matrixArray= new int[data[0].length][data.length];
        
        for (int row = 0; row < data.length; row++) {            
            for (int col = 0; col < data[row].length; col++) {
                matrixArray[col][row] = data[row][col];  
            }
        }
        return matrixArray;
     }
     
     public static int[][] multiplyMatrixByConstant(int[][] data) {
        
        int[][] matrixArray= new int[data.length][data[0].length];
        
        System.out.print("Enter a constant you wish your matrix to be multiplied by: ");
        int constant = input.nextInt();
        for (int row = 0; row < data.length; row++) {            
            for (int col = 0; col < data[row].length; col++) {
                matrixArray[row][col] = data[row][col] * constant;
            }
        }
        return matrixArray;
     }
     
     public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
         int sum;
         int[][] matrix3 = new int[matrix1.length][matrix2[0].length];;
         if (matrix1[0].length == matrix2.length) {
            
            for (int i = 0; i < matrix1.length; i++) {            
                for (int j = 0; j < matrix2[0].length; j++) {
                    sum = 0;
                    for (int k = 0; k < matrix1[0].length; k++) {
                        sum+= matrix1[i][k] * matrix2[k][j];
                    }
                    matrix3[i][j] = sum; 
                    
                }
                        
            } 
         } else {
         System.out.println("Error");
             
     }
     return matrix3;
     }
     
     
}
