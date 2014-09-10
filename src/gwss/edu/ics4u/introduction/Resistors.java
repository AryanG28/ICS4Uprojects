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
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        String[] colour = new String [10];
        colour[0] = "black";
        colour[1] = "brown";
        colour[2] = "red";
        colour[3] = "white";
        colour[4] = "orange";
        colour[5] = "yellow";
        colour[6] = "green";
        colour[7] = "blue";
        colour[8] = "violet";
        colour[9] = "grey";
        
        
        System.out.println("What is your resistors colour code? (Seperate each colour by hyphens): " );
        String string = input.nextLine();
        
        
        String lowerCase = string.toLowerCase();
        
        int indexOfDash = lowerCase.indexOf('-');
        
        String before = lowerCase.substring(0, indexOfDash);
        String after = lowerCase.substring(indexOfDash + 1);
        
        System.out.println(before);
        System.out.println(after);


    
    }
}
