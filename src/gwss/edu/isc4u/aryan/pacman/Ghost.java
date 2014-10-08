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
    public boolean isAlive;
    public Color color;

    public Ghost(boolean alive, int xLoc, int yLoc, int direction, Color color) {
        super(alive, xLoc, yLoc, direction);
        this.color = color;
        this.draw();
    }
   
    public void draw( ) {
       c.setColor( this.color );
       c.fillArc( this.xLoc, this.yLoc, WIDTH, HEIGHT , 0, 180 );
    }
    
       
    public void erase( ) {
       c.setColor(Color.white);
       c.fillArc(xLoc,yLoc, WIDTH, HEIGHT ,0,180);
    }

}
