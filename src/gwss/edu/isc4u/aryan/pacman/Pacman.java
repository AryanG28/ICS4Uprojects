/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.isc4u.aryan.pacman;

import java.awt.Color;

/**
 *    private boolean isAlive;
    private int pacmanLives; 
    
 * @author 1GHAHREMANZA
 */
public class Pacman extends PacmanCharacter {
    
    
    protected static final int WIDTH = 70; 
    protected static final int HEIGHT = 70; 
    
    public int numberOfLives;

    public Pacman() {
        this.draw( );
    }
    
    public Pacman(boolean alive, int xLoc, int yLoc, int direction) {
        super(alive, xLoc, yLoc);
        this.direction = direction;
        this.draw();
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    
    public void draw( ) {
       c.setColor(Color.yellow);
       c.fillArc(xLoc,yLoc, WIDTH, HEIGHT ,30,300);
    }
    
       
    public void erase( ) {
       c.setColor(Color.white);
       c.fillArc(xLoc,yLoc, WIDTH, HEIGHT ,30,300); 
    }

}
