/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.dice;

import java.awt.Button;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
