/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.isc4u.aryan.pacman;

import java.awt.Color;

/**
 * 
 *
 *
 * @author 1GHAHREMANZA
 */
public class Pacman extends PacmanCharacter {

    protected static final int WIDTH = 70;
    protected static final int HEIGHT = 70;
    protected static final int ORIENTATION_RIGHT = 30;
    protected static final int ORIENTATION_UP = 120;
    protected static final int ORIENTATION_LEFT = 210;
    protected static final int ORIENTATION_DOWN = 300;
    protected static final int ANGLE_2 = 300;

    private int numberOfLives;
    private int pacmanSpeed;
    protected boolean poweredUp;

    public Pacman() {
        this.isAlive = true;
        this.numberOfLives = 3;
        this.draw();
        System.out.println("Number Of lives = " + numberOfLives);
    }

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

    public boolean isPoweredUp() {
        return poweredUp;
    }

    public void setPoweredUp(boolean poweredUp) {
        this.poweredUp = poweredUp;
    }

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

    public void erase() {
        c.setColor(Color.white);
        c.fillArc(xLoc, yLoc, WIDTH, HEIGHT, 0, 360);
    }

    public void respawn() {
        if (isAlive == true) {
            System.out.println("Pacman is already alive");
        } else {
            if (numberOfLives > 0) {
                isAlive = true;
                System.out.println("Pacman is now alive");
            } else {
                System.out.println("Cannot respawn. out of lives. ");
            }
        }

    }

    public void kill() {
        if (poweredUp == true) {
            System.out.println("Pacman cannot be killed. He is powered up. ");
        } else {
            if (numberOfLives > 0) {
                numberOfLives--;
                System.out.print("Pacman is dead ");
            } else {
                System.out.print("Game over! ");
            }
            System.out.println("Number of lives = " + numberOfLives);
            isAlive = false;
        }
    }

    public void increaseSpeed() {
        pacmanSpeed = STEP_SIZE + 10;
    }

}
