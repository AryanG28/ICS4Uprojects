/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.thematrix;

import java.util.Scanner;

/**
 *
 * @author 1GHAHREMANZA
 */
public class TheMatrix {

    

    public static void main(String[] args) {
        
        // Variable list
        int[][] matrixArray;
        int keepGoing = 1;
        int userChoice;
        int[][] matrixArray2;
        int[][] multipliedMatrices;
        
        //Object list
        Scanner input = new Scanner(System.in);
        
        
        while (keepGoing == 1) { //loops until user chooses not to
            userChoice = getUserInput(); // method that returns user input               
            switch (userChoice) { // Selects different option based on user choice
                case 1:
                    matrixArray = generateMatrix(); // Calls method to generate random matrix
                    displayArray(matrixArray); // Displays random matrix
                    break;
                case 2: // Transposes matrix
                    matrixArray = generateMatrix(); // Calls method to generate random matrix
                    matrixArray = generateTranspose(matrixArray); //calls method to transpose array
                    displayArray(matrixArray);  //displays transposed array
                    break;
                case 3:
                    matrixArray = generateMatrix(); // Calls method to generate random matrix
                    displayArray(matrixArray); // Displays random matrix
                    matrixArray = multiplyMatrixByConstant(matrixArray); // Calls method to multiply values of matrix by a constant and returns multiplied matrix
                    displayArray(matrixArray); //Displays the matrix that was multiplied by constant
                    break;
                case 4:
                    matrixArray = generateMatrix(); // Calls method to generate random matrix
                    matrixArray2 = generateMatrix(); // Calls method to generate another random matrix
                    multipliedMatrices = multiplyMatrix(matrixArray, matrixArray2); // Multiplies the two matrices together and returns the new matrix
                    if (multipliedMatrices == null) // if product is not defined it bypasses next steps
                        break;          
                    System.out.println("This is the first array: "); 
                    displayArray(matrixArray); // displays the first matrix
                    System.out.println("This is the second array: "); 
                    displayArray(matrixArray2); // displays the second Matrix 
                    System.out.println("This is the product: "); 
                    displayArray(multipliedMatrices); //displays the multiplied matrice
                    break;
                default: // if user does not pick a valid choice it shows an error message
                    System.out.println("That is not a valid choice");
                    break;
            }
            //asks user if they would like to keep going
            System.out.println("Press 1 to continue or any number to quit");
            keepGoing = input.nextInt();
        }
        System.out.println("Thank you for using this program.");
    }

    public static int getUserInput() { //returns user input
        
        //Variable list
        int userChoice;
        //Object list
        Scanner input = new Scanner(System.in);
        
        System.out.print( // gives user the different options
                "----------Welcome to the Matrix Program!---------------\n"
                + "Please select one of the following options:\n"
                + "1: The Random Matrix\n"
                + "2: The Transpose Matrix\n"
                + "3: Multiplying a Matrix by a Constant\n"
                + "4: Multiplying Two Matrices\n"
                + "Your choice is:");
        userChoice = input.nextInt(); //gets userchoice

        return userChoice; // returns users choice

    }

    public static int[][] generateMatrix() { //method that returns a random matrix
        
        //variable list
        int numberOfRows;
        int numberOfCols;
        int[][] matrixArray;
        //Object list
        Scanner input = new Scanner(System.in);

        //Asks user for number of rows they want in there matrix
        System.out.print("State the number of rows: ");
        numberOfRows = Math.abs(input.nextInt());
        
        //Asks user for number of columns they want in there matrix
        System.out.print("State the number of columns: ");
        numberOfCols = Math.abs(input.nextInt());
        
        //makes array size that user wants
        matrixArray = new int[numberOfRows][numberOfCols];
        
        // goes through the rows and columns and fills array with random integers between 1 and 9
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfCols; col++) {
                matrixArray[row][col] = (int) (Math.random() * 10);
            }
        }
        return matrixArray; // returns array filled with random integers
    }

    public static void displayArray(int[][] matrix) { //displays matrix with proper format
        
        for (int row = 0; row < matrix.length; row++) { //iterates through rows
            for (int col = 0; col < matrix[row].length; col++) { //iterates through columns
                System.out.print(matrix[row][col] + "\t"); //prints value
            }
            System.out.println(""); 
        }
    }

    public static int[][] generateTranspose(int[][] matrix) { // returns transposed matrix
        //Variable list
        int[][] matrixArray = new int[matrix[0].length][matrix.length];// creates matrix with transposed size

        for (int row = 0; row < matrix.length; row++) { // iterates through rows
            for (int col = 0; col < matrix[row].length; col++) { //iterates through columns
                matrixArray[col][row] = matrix[row][col]; //sets transposed value
            }
        }
        return matrixArray; // returns transposed matrix
    }

    public static int[][] multiplyMatrixByConstant(int[][] matrix) {
        //variable list
        int[][] matrixArray = new int[matrix.length][matrix[0].length];
        int constant;
        
        //Object list
        Scanner input = new Scanner(System.in);
        
        // gets constant to multiply each value by
        System.out.print("Enter a constant you wish your matrix to be multiplied by: ");
        constant = input.nextInt();
        
        // itterates through rows and columns and multiplies each value of the array by the constant
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrixArray[row][col] = matrix[row][col] * constant;
            }
        }
        return matrixArray; // returns array that has been multiplied by constant
    }

    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        //variable list
        int sum;
        int[][] matrix3; 
        
        if (matrix1[0].length == matrix2.length) { // checks if product is defined
            matrix3 = new int[matrix1.length][matrix2[0].length]; //creates matrix with correct size
            
            for (int i = 0; i < matrix1.length; i++) { // iterates through matrix 1 rows
                for (int j = 0; j < matrix2[0].length; j++) { // iterates through matrix 2 columns
                    sum = 0;
                    for (int k = 0; k < matrix1[0].length; k++) { //calculates product of matrix 1 rows and matrix 2 columns
                        sum += matrix1[i][k] * matrix2[k][j];
                    }
                    matrix3[i][j] = sum;
                }
            }
        } else { // if product is not defined it lets user know and returns null
            System.out.println("Product is not defined");
            return null;
        }
        return matrix3;// returns multiplied matrices
    }

}
