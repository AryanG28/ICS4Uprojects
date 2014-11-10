/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u4;

import java.awt.Color;
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
    public static int FRAME_LENGTH;

    public SierpinskiTriangle() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(null);
        frame.setSize(800, 800);
        frame.setVisible(true);
        FRAME_LENGTH = frame.getWidth();
        frame.add(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFractal(g, FRAME_LENGTH / 2, 0, 200);

    }

    public void drawFractal(Graphics g, int x, int y, int length) {
        if (length <= 20) {
            drawTriangle(g, x, y, length * 2);
        } else {
            int height = length / 2;
            drawFractal(g, x, y, length / 2);
            drawFractal(g, x + length / 2, y + height, length / 2);
            drawFractal(g, x - length / 2, y + height, length / 2);

        }
    }

    public static void drawTriangle(Graphics g, int x, int y, int length) {
        g.setColor(Color.black);
        h = length / 2;
        g.drawLine(x, y, x - length / 2, y + h);
        g.drawLine(x, y, x + length / 2, y + h);
        g.drawLine(x + length / 2, y + h, x - length / 2, y + h);
        g.setColor(Color.red);
        drawCenteredCircle(g,x,y + h/2, 8);
        g.setColor(Color.green);
        drawCenteredCircle(g,x,y + h/2, 3);
    }

    public static void main(String[] args) {
        SierpinskiTriangle triangle = new SierpinskiTriangle();
        triangle.setVisible(true);

    }

    public static void drawCenteredCircle(Graphics g, int x, int y, int r) {
        x = x - (r / 2);
        y = y - (r / 2);
        g.fillOval(x, y, r, r);
    }
}
