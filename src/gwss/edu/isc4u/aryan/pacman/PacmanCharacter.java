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
public class PacmanCharacter implements Movement{
    
    protected static final int STEP_SIZE = 10; 
    protected static final int WIDTH = 70; 
    protected static final int HEIGHT = 70; 
    protected static final int DIRECTION_LEFT = 1;
    protected static final int DIRECTION_RIGHT = 2;
    protected static final int DIRECTION_DOWN = 3;
    protected static final int DIRECTION_UP = 4;
    
    
    
    // CLASS VARIABLES
    protected static Console c;
    
    // OBJECT VARIABLES
    private boolean alive;
    protected int xLoc;
    protected int yLoc;

    public PacmanCharacter() {
        if( c == null ) {
            System.out.println( "WARN: HSA Console NOT set." );
        }
    }
    
    public PacmanCharacter( Console hsaConsole ) {
        this();
        if( c == null ) {
            c = hsaConsole;
            System.out.println( "INFO: HSA Console set." );
        }
    }

    public PacmanCharacter( boolean alive, int xLoc, int yLoc ) {
        this.alive = alive;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }        
    
    public boolean isIsAlive() {
        return alive;
    }

    public void setIsAlive( boolean isAlive ) {
        this.alive = isAlive;
    }

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc( int xLoc ) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc( int yLoc ) {
        this.yLoc+= yLoc;
    }
    
    public void moveLeft( ) {
        this.erase();
        this.xLoc-= STEP_SIZE;
        this.draw();
        
    }
 
    public void moveRight( ) {
        this.erase();
        this.xLoc+= STEP_SIZE;
        this.draw();
        
    }
    
    public void moveUp( ) {
        this.erase();
        this.yLoc+= STEP_SIZE;
        this.draw();
    }
    
    public void moveDown( ) {
        this.erase();
        this.yLoc-= STEP_SIZE;
        this.draw();
    }
    
    public void draw( ) {
        
    }
    
       
    public void erase( ) {
        
    }
   
    /**
     * The parent class, PacmanCharacter, must have reference to the HSA Console.
     * Set it ONCE.
     * @param hsaConsole 
     */
    public static void setConsole( Console hsaConsole ) {
        c = hsaConsole;
    }
    
}

