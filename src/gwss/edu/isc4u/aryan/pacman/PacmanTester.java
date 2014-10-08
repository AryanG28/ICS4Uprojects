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
public class PacmanTester  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Console c = new Console();
        PacmanCharacter.setConsole( c );
        
        // New Pacman
        Pacman pacman = new Pacman();
        Ghost ghost1 = new Ghost( true, 100, 200, PacmanCharacter.DIRECTION_DOWN, Color.CYAN);
        Ghost ghost2 = new Ghost( true, 300, 200, PacmanCharacter.DIRECTION_RIGHT,Color.MAGENTA );
        Ghost ghost3 = new Ghost( true, 400, 200, PacmanCharacter.DIRECTION_LEFT,Color.PINK );
        Ghost ghost4 = new Ghost( true, 100, 400, PacmanCharacter.DIRECTION_UP,Color.RED );

        for( int i = 0; i< 100; i++) {
            ghost1.move();
            ghost2.move();
            ghost3.move();
            ghost4.move();
            
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            
        }
        }
        
        //delay();
        
               
        
        
    }

}
    
