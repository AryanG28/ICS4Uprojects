/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.isc4u.aryan.pacman;

import hsa.Console;
import java.awt.Color;

/**
 */
public class PacmanTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        Console c = new Console();
        PacmanCharacter.setConsole(c);

        //Creates a valid pacman
        Pacman pacman = new Pacman();

        //Testing pacman moving down
        System.out.println("Test Case#1: Pacman moving down");
        Thread.sleep(1000);
        System.out.println("Previous Y Location: " + pacman.yLoc);
        for (int i = 0; i < 10; i++) {
            pacman.moveDown();
            Thread.sleep(100);
        }
        System.out.println("Current Y Location : " + pacman.yLoc);
        System.out.println("________________________________________");

        //Testing pacman moving right
        System.out.println("Test Case#3: Pacman moving right");
        Thread.sleep(1000);
        System.out.println("Previous X Location: " + pacman.xLoc);
        for (int i = 0; i < 10; i++) {
            pacman.moveRight();
            Thread.sleep(100);
        }
        System.out.println("Previous X Location: " + pacman.xLoc);
        System.out.println("________________________________________");

        //Testing pacman moving left
        System.out.println("Test Case#2: Pacman moving left");
        Thread.sleep(1000);
        System.out.println("Previous X Location: " + pacman.xLoc);
        for (int i = 0; i < 10; i++) {
            pacman.moveLeft();
            Thread.sleep(100);
        }
        System.out.println("Previous X Location: " + pacman.xLoc);
        System.out.println("________________________________________");

        //Testing pacman moving down
        System.out.println("Test Case#4: Pacman moving down");
        Thread.sleep(1000);
        System.out.println("Current Y Location : " + pacman.yLoc);
        for (int i = 0; i < 10; i++) {
            pacman.moveDown();
            Thread.sleep(100);
        }
        System.out.println("Current Y Location : " + pacman.yLoc);
        Thread.sleep(1000);
        System.out.println("________________________________________");

        //Testing to see if pacman can be erased
        System.out.println("Test Case#5: Pacman being erased");
        pacman.erase();

        //Creates 4 valid Ghosts
        Ghost ghost1 = new Ghost(true, 100, 200, Color.CYAN);
        Ghost ghost2 = new Ghost(true, 400, 200, Color.PINK);
        Ghost ghost3 = new Ghost(true, 300, 200, Color.MAGENTA);
        Ghost ghost4 = new Ghost(true, c.getWidth() - 55, c.getHeight() - 55, Color.RED);

        //Testing ghost moving down
        System.out.println("Test Case#6: Ghost moving down");
        Thread.sleep(1000);
        System.out.println("Previous Y Location: " + ghost1.yLoc);
         for (int i = 0; i < 10; i++) {
            ghost1.moveDown();
            Thread.sleep(100);
        }
        System.out.println("Current Y Location: " + ghost1.yLoc);
        System.out.println("________________________________________");
        
        //Testing ghost moving right
        System.out.println("Test Case#6: Ghost moving right");
        Thread.sleep(1000);
        System.out.println("Previous X Location: " + ghost2.xLoc);
         for (int i = 0; i < 10; i++) {
            ghost2.moveRight();
            Thread.sleep(100);
        }
        System.out.println("Current X Location: " + ghost2.xLoc);
        System.out.println("________________________________________");
        
        //Testing ghost moving up
        System.out.println("Test Case#7: Ghost moving up");
        Thread.sleep(1000);
        System.out.println("Previous Y Location: " + ghost3.yLoc);
         for (int i = 0; i < 10; i++) {
            ghost3.moveUp();
            Thread.sleep(100);
        }
        System.out.println("Current Y Location: " + ghost3.yLoc);
        System.out.println("________________________________________");
        
        //Testing ghost moving left
        System.out.println("Test Case#8: Ghost moving left");
        Thread.sleep(1000);
        System.out.println("Previous X Location: " + ghost4.xLoc);
         for (int i = 0; i < 10; i++) {
            ghost4.moveLeft();
            Thread.sleep(100);
        }
        System.out.println("Current X Location: " + ghost4.xLoc);
        System.out.println("________________________________________");
        
        //Testing move randomly and making sure it doesn't exit the console
        System.out.println("Test Case#7: Ghost moving right");
        Thread.sleep(1000);
        System.out.println("Previous Y Location: " + ghost2.xLoc);
         for (int i = 0; i < 10; i++) {
            ghost2.moveRight();
            Thread.sleep(100);
        }
        System.out.println("Current Y Location: " + ghost2.xLoc);
        System.out.println("________________________________________");



//        //Testing if a ghost can properly move left
//        System.out.println("TEST CASE 6 - MOVING GHOST LEFT");
//        Thread.sleep(1000);
//        System.out.println("Previous X Location: " + ghost.xLoc);
//        ghost.moveLeft();
//        System.out.println("Current X Location: " + ghost.xLoc);
//        System.out.println("________________________________________");
//
//        //Testing if a ghost can properly move right
//        System.out.println("TEST CASE 7 - MOVING GHOST RIGHT");
//        Thread.sleep(1000);
//        System.out.println("Previous X Location: " + ghost.xLoc);
//        ghost.moveRight();
//        System.out.println("Current X Location: " + ghost.xLoc);
//        System.out.println("________________________________________");
//
//        //Testing if a ghost can properly move up
//        System.out.println("TEST CASE 8 - MOVING GHOST UP");
//        Thread.sleep(1000);
//        System.out.println("Previous Y Location: " + ghost.yLoc);
//        ghost.moveUp();
//        System.out.println("Current Y Location: " + ghost.yLoc);
//        ghost.erase();
//        System.out.println("________________________________________");
        
        // Testing changing ghost from edible to none edible and back to edible
//        System.out.println("Test Case#1- Changes ghost from edible to none edible");
//        for (int i = 0; i < 10; i++) {
//            ghost1.moveRandomly();
//            ghost2.moveRandomly();
//            ghost3.moveRandomly();
//            ghost4.moveRandomly();
//            pacman.moveRandomly();
//
//            try {
//                Thread.sleep(100);
//            } catch (Exception e) {
//
//            }
//
//        }
//        ghost1.setEdible(true);
//        ghost2.setEdible(true);
//        ghost3.setEdible(true);
//        ghost4.setEdible(true);
//
//        for (int i = 0; i < 10; i++) {
//            ghost1.moveRandomly();
//            ghost2.moveRandomly();
//            ghost3.moveRandomly();
//            ghost4.moveRandomly();
//            pacman.moveRandomly();
//
//            Thread.sleep(100);
//
//        }
//        ghost1.setEdible(false);
//        ghost2.setEdible(false);
//        ghost3.setEdible(false);
//        ghost4.setEdible(false);
//
//        for (int i = 0; i < 10; i++) {
//            ghost1.moveRandomly();
//            ghost2.moveRandomly();
//            ghost3.moveRandomly();
//            ghost4.moveRandomly();
//            pacman.moveRandomly();
//
//            Thread.sleep(100);
//
//        }
//        for (int i = 0; i < 4; i++) {
//            ghost1.moveRandomly();
//            ghost2.moveRandomly();
//            ghost3.moveRandomly();
//            ghost4.moveRandomly();
//            pacman.moveRandomly();
//
//            try {
//                Thread.sleep(100);
//            } catch (Exception e) {
//
//            }
//
//        }
        //Test case 2:        

    }

}
