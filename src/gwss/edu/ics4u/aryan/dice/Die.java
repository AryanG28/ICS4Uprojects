/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.dice;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Aryan
 */
public class Die extends JPanel {

    /**
     * +
     */
    public static final int SIZE_FACTOR = 100;
    public static final int VALUE_1 = 1;
    public static final int VALUE_2 = 2;
    public static final int VALUE_3 = 3;
    public static final int VALUE_4 = 4;
    public static final int VALUE_5 = 5;
    public static final int VALUE_6 = 6;
    
//object Variables
    private Color colour;
    private int sizeFactor;
    private int topleftX;
    private int topleftY;
    private int value;
    

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public int getSizeFactor() {
        return sizeFactor;
    }

    public void setSizeFactor(int sizeFactor) {
        this.sizeFactor = sizeFactor;
    }
    public void setPosition() {
        
    }

}
