/*
 * Name: Aryan Ghahremanzadeh 
 * Date: November 10, 2014 
 * Version: v0.1
 * Teacher: Mr.Muir
 * Description: This program creates a very cool looking fractal( a traingle with a circle in the middle)
 */
package gwss.edu.ics4u.aryan.recursion;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 1GHAHREMANZA
 */
public class TriangleFractal extends JPanel {

    public static int height;
    public static int frameLength;
    public static final int START_POSITION_Y = 20;
    public static final int FRACTAL_LENGTH = 400;

    // Constructs a frame to display the fractal
    public TriangleFractal() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(null);
        frame.setSize((FRACTAL_LENGTH * 2) + 50, (FRACTAL_LENGTH * 2) + 50);
        frame.setVisible(true);
        frameLength = frame.getWidth();
        frame.add(this);
        frame.setResizable(false);
    }

    // Overides paint component to draw Fractal
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFractal(g, frameLength / 2, START_POSITION_Y, FRACTAL_LENGTH);

    }

    // Finds where to draw the Fractal
    private void drawFractal(Graphics g, int x, int y, int length) {
        // if length is less than 20 it calls drawTriangle
        if (length <= 10) {
            drawTriangle(g, x, y, length * 2);
        } else { // try to find a smaller triangle

            int triangleHeight = length / 2;
            // Recursively calls until top smallest triangle is found that has not been drawn
            drawFractal(g, x, y, length / 2);

            // Draws circle in center every size of triangle but smallest
            drawCenteredCircle(g, x, y + length / 2, length / 2);

            // Recursively calls to find lower right vertex of the top smallest triangle 
            drawFractal(g, x + length / 2, y + triangleHeight, length / 2);

            // Recursively calls to find lower left vertex of the top smallest triangle 
            drawFractal(g, x - length / 2, y + triangleHeight, length / 2);

        }
    }

    //Draws Triangle with circle inside

    private static void drawTriangle(Graphics g, int x, int y, int length) {
        g.setColor(Color.black);
        height = length / 2;
        // Draws left line of triangle
        g.drawLine(x, y, x - length / 2, y + height);
        // Draws right line of triangle
        g.drawLine(x, y, x + length / 2, y + height);
        // Draws bottom line of triangle
        g.drawLine(x + length / 2, y + height, x - length / 2, y + height);

        //Draws circle in center of smallest size of triangle       
        drawCenteredCircle(g, x, y + length / 4, length / 4);
    }

    // Draws a centered circle 
    private static void drawCenteredCircle(Graphics g, int x, int y, int r) {
        g.setColor(Color.red);
        x = x - (r / 2);
        y = y - (r / 2);
        g.drawOval(x, y, r, r);
    }

    public static void main(String[] args) {
        TriangleFractal triangle = new TriangleFractal();
        triangle.setVisible(true);

    }

}
