/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.pacman;

import static gwss.edu.ics4u.aryan.pacman.PacmanCharacter.c;
import java.awt.Color;

/**
 *
 * @author 1GHAHREMANZA
 */
public class Ghost extends PacmanCharacter {
    //object constants
    private static final int WIDTH = 50;
    private static final int HEIGHT = 110;
    private static final Color EDIBLE = Color.BLUE;
    private static final int ANGLE_1 = 0;
    private static final int ANGLE_2 = 180;
    
    //object variables
    private boolean isEdible;
    private Color color;
    private Color originalColor;
    //constructs ghost
    public Ghost(Color color) {
        this.color = color;
    }
    //constructs ghost and calls super
    public Ghost(boolean alive, int xLoc, int yLoc, Color color) {
        super(alive, xLoc, yLoc);
        this.color = color;
        this.draw();
    }

    public boolean isEdible() {
        return isEdible;
    }
    //sets edible and calls the method
    public void setEdible(boolean isEdible) {
        this.isEdible = isEdible;
        edible();
    }

    public Color getColor() {
        return color;
    }
    //sets the color
    public void setColor(Color color) {
        this.color = color;
    }
    //draws the ghost
    public void draw() {
        if (isAlive == true) {
            c.setColor(this.color);
            c.fillArc(this.xLoc, this.yLoc, WIDTH, HEIGHT, ANGLE_1, ANGLE_2);
        } else {
            System.out.println("Ghost is dead. Cannot draw. ");
        }
    }
    //erases the ghost
    public void erase() {
        c.setColor(Color.white);
        c.fillArc(xLoc, yLoc, WIDTH, HEIGHT, ANGLE_1, ANGLE_2);
    }
    
    //changes colour if ghost is edible
    public void edible() {
        if (isEdible == true) {
            System.out.println("Ghost is now edible");
            originalColor = this.color;
            this.color = EDIBLE;
            this.draw();
        } else if (isEdible == false) {
            //sets to default colour 
            this.color = originalColor;
            System.out.println("Ghost is not edible");
        }

    }
    //kills the ghost
    public void kill() {
        if (isEdible == true) {
            isAlive = false;
            erase();
            System.out.println("Ghost has been killed.");
        } else {
            System.out.println("Ghost is not edible cannot be killed.");
        }

    }
    //respawns the ghost(brings it back to life) 
    public void respawn() {
        if (isAlive == true) {
            System.out.println("Ghost is already alive");
        } else {
            System.out.println("Ghost is now alive.");
            isAlive = true;
            this.xLoc = c.getWidth() / 2;
            this.yLoc = c.getWidth() / 2;
            this.isEdible = false;
            this.color = originalColor;
            this.draw();
        }

    }

    @Override
    public String toString() {
        return    "\n\t Is alive= " + isAlive
                + "\n\t X Location= " + xLoc
                + "\n\t Y Location=  " + yLoc
                + "\n\t Step size= " + stepSize
                + "\n\t Is edible= " + isEdible 
                + "\n\t Current color= " + color 
                + "\n\t Original color= " + originalColor ;

    }

}
