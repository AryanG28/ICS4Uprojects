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
        Ghost ghost1 = new Ghost( true, 100, 200,  Color.CYAN);
        Ghost ghost2 = new Ghost( true, 300, 200, Color.MAGENTA );
        Ghost ghost3 = new Ghost( true, 400, 200,Color.PINK );
        Ghost ghost4 = new Ghost( true, c.getWidth() - 55, c.getHeight() - 55, Color.RED );

        for( int i = 0; i< 1000; i++) {
            ghost1.moveRandomly();
            ghost2.moveRandomly();
            ghost3.moveRandomly();
            ghost4.moveRandomly();
            pacman.moveRandomly();
            
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            
        }
        }
       
        //delay();
        
               
        
    }
    

}
    
