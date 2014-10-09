/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.isc4u.aryan.pacman;

import static gwss.edu.isc4u.aryan.pacman.PacmanCharacter.c;
import java.awt.Color;

/**
 *
 * @author 1GHAHREMANZA
 */
public class Ghost extends PacmanCharacter {
    
    protected static final int WIDTH = 50; 
    protected static final int HEIGHT = 110;

    // 
    public boolean eatable;
    public Color color;

    public Ghost(Color color) {
        this.color = color;
    }

    public Ghost(boolean alive, int xLoc, int yLoc, Color color) {
        super(alive, xLoc, yLoc);
        this.color = color;
        this.draw();
    }

    public boolean isEatable() {
        return eatable;
    }

    public void setEatable(boolean eatable) {
        this.eatable = eatable;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
   
    public void draw( ) {
       c.setColor( this.color );
       c.fillArc( this.xLoc, this.yLoc, WIDTH, HEIGHT , 0, 180 );
    }
    
       
    public void erase( ) {
       c.setColor(Color.white);
       c.fillArc(xLoc,yLoc, WIDTH, HEIGHT ,0,180);
    }
    
    public void eaten () {
        this.erase();
    }

}
