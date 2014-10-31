/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u4;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 1GHAHREMANZA
 */
public class SierpinskiTriangle extends JPanel {

    public static int w;
    public static int h;
    
    public SierpinskiTriangle() {
        init();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); 
        
        drawTriangle(w,h, 10);
        
        
    }
    
    public static void drawTriangle(int w, int h, int lineLength) {
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(null);
        frame.setSize(800, 800);
        w = frame.getWidth();
        h = frame.getHeight();
    }

    public void init() {
        

    }

}
