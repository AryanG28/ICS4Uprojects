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
        System.out.println("_____________________________________");

        //Testing pacman moving right
        System.out.println("Test Case#2: Pacman moving right");
        Thread.sleep(1000);
        System.out.println("Previous X Location: " + pacman.xLoc);
        for (int i = 0; i < 10; i++) {
            pacman.moveRight();
            Thread.sleep(100);
        }
        System.out.println("Previous X Location: " + pacman.xLoc);
        System.out.println("_____________________________________");

        //Testing pacman moving left
        System.out.println("Test Case#3: Pacman moving left");
        Thread.sleep(1000);
        System.out.println("Previous X Location: " + pacman.xLoc);
        for (int i = 0; i < 10; i++) {
            pacman.moveLeft();
            Thread.sleep(100);
        }
        System.out.println("Previous X Location: " + pacman.xLoc);
        System.out.println("_____________________________________");

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
        System.out.println("____________________________________");

        //Testing to see if pacman can be erased
        System.out.println("Test Case#5: Pacman being erased");
        Thread.sleep(1000);
        pacman.erase();
        Thread.sleep(1000);
        System.out.println("____________________________________");

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
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing ghost moving right
        System.out.println("Test Case#7: Ghost moving right");
        Thread.sleep(1000);
        System.out.println("Previous X Location: " + ghost2.xLoc);
        for (int i = 0; i < 10; i++) {
            ghost2.moveRight();
            Thread.sleep(100);
        }
        System.out.println("Current X Location: " + ghost2.xLoc);
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing ghost moving up
        System.out.println("Test Case#8: Ghost moving up");
        Thread.sleep(1000);
        System.out.println("Previous Y Location: " + ghost3.yLoc);
        for (int i = 0; i < 10; i++) {
            ghost3.moveUp();
            Thread.sleep(100);
        }
        System.out.println("Current Y Location: " + ghost3.yLoc);
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing ghost moving left
        System.out.println("Test Case#9: Ghost moving left");
        Thread.sleep(1000);
        System.out.println("Previous X Location: " + ghost4.xLoc);
        for (int i = 0; i < 10; i++) {
            ghost4.moveLeft();
            Thread.sleep(100);
        }
        System.out.println("Current X Location: " + ghost4.xLoc);
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing move randomly and making sure it doesn't exit the console
        System.out.println("Test Case#10: Ghost and pacman moving randomly, pacman and ghost cannot exit the console");
        Thread.sleep(1000);
        for (int i = 0; i < 100; i++) {
            ghost1.moveRandomly();
            ghost2.moveRandomly();
            ghost3.moveRandomly();
            ghost4.moveRandomly();
            pacman.moveRandomly();
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        System.out.println("Test Case#11: Killing pacman");
        Thread.sleep(1000);
        pacman.kill();
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing if ghost can be killed when not edible
        System.out.println("Test Case#12: Killing ghost when not edible");
        Thread.sleep(1000);
        ghost1.kill();
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing if ghost changes colour when edible
        System.out.println("Test Case#13: Ghost changing colour when edible");
        Thread.sleep(1000);
        ghost1.setEdible(true);
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing if ghost can be killed when edible
        System.out.println("Test Case#14: Killing ghost when edible");
        Thread.sleep(1000);
        ghost1.kill();
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing if pacman can be drawn when killed
        System.out.println("Test Case#15: Checking if pacman can be drawn when killed");
        Thread.sleep(1000);
        pacman.draw();
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing if ghost can be drawn when killed
        System.out.println("Test Case#16: Checking if ghost can be drawn when killed");
        Thread.sleep(1000);
        ghost1.draw();
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing if pacman can be respawned
        System.out.println("Test Case#17: Checking if pacman can be respawned");
        Thread.sleep(1000);
        pacman.respawn();
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing if ghost can be respawned
        System.out.println("Test Case#18: Checking if ghost can be respawned");
        Thread.sleep(1000);
        ghost1.respawn();
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing if ghost can be respawned when already alive
        System.out.println("Test Case#19: Checking if ghost can be respawned when already alive");
        Thread.sleep(1000);
        ghost1.respawn();
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing if pacman can be respawned when already alive
        System.out.println("Test Case#20: Checking if pacman can be respawned when already alive");
        Thread.sleep(1000);
        pacman.respawn();
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing speed increase
        System.out.println("Test Case#21: Testing pacman speed increase");
        Thread.sleep(1000);
        for (int i = 0; i < 10; i++) {
            pacman.moveRight();
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        pacman.increaseSpeed();
        for (int i = 0; i < 5; i++) {
            pacman.moveLeft();
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing speed increase when it cannot get faster
        System.out.println("Test Case#22: Testing pacman speed increase when cannot get faster");
        Thread.sleep(1000);
        for (int i = 0; i < 5; i++) {
            pacman.moveRight();
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        pacman.increaseSpeed();
        for (int i = 0; i < 5; i++) {
            pacman.moveLeft();
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing speed decrease
        System.out.println("Test Case#23: Testing pacman speed decrease");
        Thread.sleep(1000);
        for (int i = 0; i < 5; i++) {
            pacman.moveRight();
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        pacman.decreaseSpeed();
        for (int i = 0; i < 10; i++) {
            pacman.moveLeft();
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        //Testing speed decrease when it cannot get slower
        System.out.println("Test Case#24: Testing pacman speed decrease when it cannot get slower");
        Thread.sleep(1000);
        for (int i = 0; i < 10; i++) {
            pacman.moveRight();
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        pacman.decreaseSpeed();
        for (int i = 0; i < 10; i++) {
            pacman.moveLeft();
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        System.out.println("_____________________________________");

        System.out.println("Test Case#25: Testing pacman and ghost move given a direction");
        Thread.sleep(1000);
        pacman.setDirection(0);
        ghost1.setDirection(1);
        ghost2.setDirection(2);
        ghost3.setDirection(3);
        ghost4.setDirection(2);
        for (int i = 0; i < 10; i++) {
            ghost1.move();
            ghost2.move();
            ghost3.move();
            ghost4.move();
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        System.out.println("_____________________________________");
    }

}
