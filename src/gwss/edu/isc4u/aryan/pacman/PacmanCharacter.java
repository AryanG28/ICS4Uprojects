/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.isc4u.aryan.pacman;

import hsa.Console;

/**
 *
 * @author Aryan
 */
public class PacmanCharacter {
    // CLASS VARIABLES
    private static Console c;
    
    // OBJECT VARIABLES
    private boolean alive;
    private int xLoc;
    private int yLoc;

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
        this.yLoc = yLoc;
    }
    
    public void moveLeft( ) {
        
    }
    
    public void moveRight( ) {
        
    }
    
    public void moveUp( ) {
        
    }
    
    public void moveDown( ) {
        
    }
    
    private void draw( ) {
        
    }
    
    private void erase( ) {
        
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

