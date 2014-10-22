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
        DieGame dieGame = new DieGame();
        dieGame.setVisible(true);
        dieGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
