/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.isc4u.aryan.pacman;

import hsa.Console;
import java.awt.Color;

/**
 *
 * @author Aryan
 */
public abstract class PacmanCharacter implements Movement {

    protected static final int DIRECTION_RIGHT = 0;
    protected static final int DIRECTION_LEFT = 1;
    protected static final int DIRECTION_UP = 2;
    protected static final int DIRECTION_DOWN = 3;

    // CLASS VARIABLES  
    protected static Console c;
    protected static int maxX;
    protected static int maxY;
    protected static int minX;
    protected static int minY;

    // OBJECT VARIABLES
    protected boolean isAlive;
    protected int xLoc;
    protected int yLoc;
    protected int direction;
    protected int stepSize = 10;

    public PacmanCharacter() {
        if (c == null) {
            System.out.println("WARN: HSA Console NOT set.");
        }
    }

    public PacmanCharacter(Console hsaConsole) {
        this();
        if (c == null) {
            c = hsaConsole;
            System.out.println("INFO: HSA Console set.");
        }
    }

    public PacmanCharacter(boolean isAlive, int xLoc, int yLoc) {
        this.isAlive = isAlive;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        if (direction < 0 || direction > 3) {
            System.out.println("Invalid direction");
        } else {
            this.direction = direction;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        if (xLoc > maxX) {
            this.xLoc = maxX;
        } else if (xLoc < minX) {
            this.xLoc = minX;
        } else {
            this.xLoc = xLoc;
        }

    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        if (yLoc > maxY) {
            this.yLoc = maxY;
        } else if (yLoc < minY) {
            this.yLoc = minY;
        } else {
            this.yLoc = yLoc;
        }
    }

    public void moveLeft() {
        if (minX < xLoc) {
            this.erase();
            this.direction = DIRECTION_LEFT;
            this.xLoc -= stepSize;
            this.draw();
        }

    }

    public void moveRight() {
        if (maxX > xLoc) {
            this.erase();
            this.direction = DIRECTION_RIGHT;
            this.xLoc += stepSize;
            this.draw();
        }

    }

    public void moveUp() {
        if (minY < yLoc) {
            this.erase();
            this.direction = DIRECTION_UP;
            this.yLoc -= stepSize;
            this.draw();
        }
    }

    public void moveDown() {
        if (maxY > yLoc) {
            this.erase();
            this.direction = DIRECTION_DOWN;
            this.yLoc += stepSize;
            this.draw();
        }
    }

    public void move() {
        switch (this.direction) {
            case DIRECTION_RIGHT:
                moveRight();
                break;
            case DIRECTION_LEFT:
                moveLeft();

                break;
            case DIRECTION_UP:
                moveUp();
                break;
            case DIRECTION_DOWN:
                moveDown();
                break;
        }

    }

    public void moveRandomly() {
        this.direction = (int) (Math.random() * 4);
        move();
    }

    public abstract void draw();

    public abstract void erase();

    public abstract void kill();

    public abstract void respawn();

    /**
     * The parent class, PacmanCharacter, must have reference to the HSA
     * Console. Set it ONCE.
     *
     * @param hsaConsole
     */
    public static void setConsole(Console hsaConsole) {
        c = hsaConsole;
        PacmanCharacter.maxX = c.getWidth() - 55;
        PacmanCharacter.minX = 0;
        PacmanCharacter.maxY = c.getHeight() - 55;
        PacmanCharacter.minY = 0;
    }

}
