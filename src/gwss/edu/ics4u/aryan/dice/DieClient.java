/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.dice;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 1GHAHREMANZA
 */
public class DieClient extends JFrame { //implements actionListener

    public static void main(String[] args) {
        JFrame window = new JFrame("Dice Game");
        window.add(new Die());
        window.setSize(300, 300);
        Die die = new Die(Color.CYAN, Color.WHITE, 1, 3);
        window.add(die);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
