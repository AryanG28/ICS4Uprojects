/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.dice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;


/**
 *
 * @author Aryan
 */
public class Die extends JPanel {

    /**
     * +
     */
    public static final int SIZE_FACTOR_CONSTANT = 100;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 6;
    public static final Color INITIAL_COLOUR = Color.BLACK;
    public static final Color INITIAL_DOT_COLOUR = Color.GREEN;
    public static final int MAX_X = JPanel.WIDTH;
    public static final int MAX_Y = JPanel.HEIGHT;
    private static final int CIRCLE_DIAMETER = 20;
    private static final int PIXEL_SIZE = 10;

//object Variables
    private Color colour;
    private Color dotColour;
    private int sizeFactor;
    private int size;
    private int topLeftX;
    private int topLeftY;
    private int value;
    private int pixel;

    public Die() {
        this(INITIAL_COLOUR, INITIAL_DOT_COLOUR, 1, 1);
    }

    public Die(Color colour, Color dotColour, int sizeFactor, int value) {
        this.colour = colour;
        this.dotColour = dotColour;
        this.sizeFactor = sizeFactor;
        this.size = sizeFactor * SIZE_FACTOR_CONSTANT;
        this.value = value;
        Dimension d = new Dimension(this.size, this.size);
        this.setPreferredSize(d);
        this.setSize(d);

    }

    public void setValue(int value) {
        if (value >= MIN_VALUE && value <= MAX_VALUE) {
            this.value = value;
            System.out.println("Value has been set to " + this.value);
        } else {
            System.out.println("Value is not valid!");

        }
    }

    public void setSizeFactor(int sizeFactor) {
        if (sizeFactor > 0) {
            this.sizeFactor = sizeFactor;
            System.out.println("Size factor set to: " + this.sizeFactor);
            this.size = sizeFactor * SIZE_FACTOR_CONSTANT;
            Dimension d = new Dimension(this.size, this.size);
            this.setPreferredSize(d);
            this.setSize(d);
            repaint();
        } else {
            System.out.println("Size Factor is not valid!");
        }
    }

    public void setTopLeftX(int topLeftX) {
        if (topLeftX >= 0 && topLeftX < MAX_X - sizeFactor) {
            this.topLeftX = topLeftX;
            System.out.println("X value set to: " + this.topLeftX);
        } else {
            System.out.println("X value is not valid!");
        }
    }

    public void setTopLeftY(int topLeftY) {
        if (topLeftY >= 0 && topLeftY < MAX_Y - sizeFactor) { // 
            this.topLeftY = topLeftY;
            System.out.println("Y value set to: " + this.topLeftY);
        } else {
            System.out.println("Y value is not valid!");
        }
    }

    public Color getColour() {
        return colour;
    }

    public int getSizeFactor() {
        return sizeFactor;
    }

    public int getTopLeftX() {
        return topLeftX;
    }

    public int getTopLeftY() {
        return topLeftY;
    }

    public int getValue() {
        return value;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public Color getDotColour() {
        return dotColour;
    }

    public void setDotColour(Color dotColour) {
        this.dotColour = dotColour;
    }

    public void roll() {
        this.value = (int) (Math.random() * 6) + 1;
        repaint();

    }

    public void setPosition(int topLeftX, int topLeftY) {
        setTopLeftX(topLeftX);
        setTopLeftY(topLeftY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawDie(g);
    }

    private void drawDie(Graphics g) {
        g.setColor(this.getColour());
        g.fillRect(this.topLeftX, this.topLeftY, this.size, this.size);
        drawDot(g);
    }

    private void dot(Graphics g, int row, int col) {
        this.pixel = this.size / PIXEL_SIZE;
        g.setColor(this.dotColour);
        int x = this.topLeftX + (row * 3 * this.pixel) - 2 * this.pixel;
        int y = this.topLeftY + (col * 3 * this.pixel) - 2 * this.pixel;
        g.fillOval(x, y, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
    }

    private void drawDot(Graphics g) {
        if (this.getValue() % 2 == 1) { // Draws middle dot for the numbers 1 3 5
            dot(g, 2, 2);
        }
        if (this.getValue() != 1) { // Draws top left and bottom right for numbers 2 3 4 5 6
            dot(g, 1, 1);
            dot(g, 3, 3);
        }
        if (this.getValue() > 3) { // Draws top left and top right for numbers 4 5 6
            dot(g, 1, 3);
            dot(g, 3, 1);
        }
        if (this.getValue() == 6) { // Draws middle left and middle right for number 6
            dot(g, 1, 2);
            dot(g, 3, 2);
        }

    }

}
