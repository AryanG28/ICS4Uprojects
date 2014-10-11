/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.pacman;

import java.awt.Color;

/**
 *
 *
 *
 * @author 1GHAHREMANZA
 */
public class Pacman extends PacmanCharacter {
    //object constants
    private static final int WIDTH = 70;
    private static final int HEIGHT = 70;
    private static final int ORIENTATION_RIGHT = 30;
    private static final int ORIENTATION_UP = 120;
    private static final int ORIENTATION_LEFT = 210;
    private static final int ORIENTATION_DOWN = 300;
    private static final int ANGLE_2 = 300;
    private static final int START_CIRCLE_DEGREES = 0;
    private static final int END_CIRCLE_DEGREES = 360;
    
    //Object variables
    private int numberOfLives;
    //constructor with no parameters
    public Pacman() {
        this.isAlive = true;
        this.numberOfLives = 3;
        this.draw();
        System.out.println("Number Of lives = " + numberOfLives);
    }
    //constructor with 4 parameters
    public Pacman(boolean alive, int xLoc, int yLoc, int direction) {
        super(alive, xLoc, yLoc);
        this.direction = direction;
        this.numberOfLives = 3;
        this.draw();
        System.out.println("Number Of lives = " + numberOfLives);
    }

    private int getNumberOfLives() {
        return numberOfLives;
    }
    //draws pacman according to the direction it moves
    public void draw() {
        if (isAlive == false) {
            System.out.println("Pacman is dead. Cannot draw");
        } else {
            c.setColor(Color.yellow);
            switch (this.direction) {
                case DIRECTION_RIGHT:
                    c.fillArc(xLoc, yLoc, WIDTH, HEIGHT, ORIENTATION_RIGHT, ANGLE_2);
                    break;
                case DIRECTION_LEFT:
                    c.fillArc(xLoc, yLoc, WIDTH, HEIGHT, ORIENTATION_LEFT, ANGLE_2);
                    break;
                case DIRECTION_UP:
                    c.fillArc(xLoc, yLoc, WIDTH, HEIGHT, ORIENTATION_UP, ANGLE_2);
                    break;
                case DIRECTION_DOWN:
                    c.fillArc(xLoc, yLoc, WIDTH, HEIGHT, ORIENTATION_DOWN, ANGLE_2);
            }
        }

    }
    //erases pacman
    public void erase() {
        c.setColor(Color.white);
        c.fillArc(xLoc, yLoc, WIDTH, HEIGHT, START_CIRCLE_DEGREES, END_CIRCLE_DEGREES);
    }
    //respawns pacman if he has lives left
    public void respawn() {
        if (isAlive == true) {
            System.out.println("Pacman is already alive");
        } else {
            if (numberOfLives > 0) {
                isAlive = true;
                this.xLoc = 0;
                this.yLoc = 0;
                draw();
                System.out.println("Pacman is now alive");
            } else {
                System.out.println("Cannot respawn. out of lives. ");
            }
        }

    }
    //kills pacman so number of lives go down and cannot be drawn
    public void kill() {
        if (isAlive == false) {
            System.out.println("Pacman is already dead");
        } else {
            if (numberOfLives > 0) {
                numberOfLives--;
                System.out.print("Pacman is dead. ");
            } else {
                System.out.print("Game over! ");
            }
            System.out.println("Number of lives = " + numberOfLives);
            isAlive = false;
            erase();
        }
    }
    //specific method for pacman which increases step size so it moves faster
    public void increaseSpeed() {
        if (stepSize > 29) {
            System.out.println("Speed cannot be increased more.");
        } else {
            System.out.println("Speed Increased.");
            stepSize = stepSize + 20;
        }
    }
    //specific method for pacman which decreases step size so it moves slower
    public void decreaseSpeed() {
        if (stepSize > 10) {
            System.out.println("Speed Decreased.");
            stepSize = stepSize - 20;
        } else {
            System.out.println("Speed cannot get slower.");
        }
    }

    @Override
    public String toString() {
        return "\n\t Is alive= " + isAlive
                + "\n\t X Location= " + xLoc
                + "\n\t Y Location=  " + yLoc
                + "\n\t Step size= " + stepSize
                + "\n\t Number of lives= " + numberOfLives;

    }

}
