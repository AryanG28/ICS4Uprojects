/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.u4;

import gwss.edu.ics4u.aryan.dice.ThePriceIsRight;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author 1GHAHREMANZA
 */
public class SierpinskiTriangle extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ThePriceIsRight().setVisible(true);
            }
        }
        );

    }
}
