package gwss.edu.ics4u.introduction;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1GHAHREMANZA
 */
public class Resistors {
    
    public static String string;
    public static String colour1;
    public static String colour2;
    public static String colour3;
    
    public static Scanner input = new Scanner(System.in);
        
    public static void main(String[] args) {
        
        int index1=0;
        int index2=0;
        int index3=0;
        
        String[] colour = new String [10];
        colour[0] = "black";
        colour[1] = "brown";
        colour[2] = "red";
        colour[3] = "orange";
        colour[4] = "yellow";
        colour[5] = "green";
        colour[6] = "blue";
        colour[7] = "violet";
        colour[8] = "grey";
        colour[9] = "white";
        
        getUserInput(); //gets user input
        seperateStrings();
        for (int i = 0; i < 10; i++) {
            
            if (colour1.equals(colour[i])) {
                index1 = i; 
            } 
            if (colour2.equals(colour[i])) {
                index2 = i; 
            } 
            if (colour3.equals(colour[i])) {
                index3 = i; 
            } 

        }
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
        


    
    }
    public static void getUserInput() {
        
        System.out.println("What is your resistors colour code? (Seperate each colour by hyphens): " );
        string = input.nextLine();
    }
    
    public static void seperateStrings() {
        
        String lowerCase = string.toLowerCase();
        int indexOfDash = lowerCase.indexOf('-');
        
        String firstColour = lowerCase.substring(0, indexOfDash);
        String secondColour = lowerCase.substring(indexOfDash + 1);
        
        indexOfDash = secondColour.indexOf('-');
        String thirdColour = secondColour.substring(indexOfDash + 1);
        secondColour = secondColour.substring(0, indexOfDash);

        
        colour1 = firstColour;
        colour2 = secondColour;
        colour3 = thirdColour;
    }
    
}
