/*
 * Name: Aryan Ghahremanzadeh 
 * Date: October 22, 2014 
 * Version: v0.1
 * Teacher: Mr.Muir
 * Description: This client creates a dieGame. 
 */
package gwss.edu.ics4u.aryan.dice;

import javax.swing.JFrame;



/*
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
