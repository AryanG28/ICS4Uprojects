/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.dice;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Aryan
 */
public class DieGame extends JFrame implements ActionListener {

    public int numberOfRolls;

    Die die1;
    Die die2;
    JButton roll;
    JLabel numberOfRollsLabel;
    JPanel numberOfWinsLabel;

    public DieGame() {
        this.numberOfRolls = 0;
        die1 = new Die(Color.CYAN, Color.WHITE, 1, 5);
        die2 = new Die(Color.ORANGE, Color.WHITE, 1, 3);
        roll = new JButton("ROLL");
        numberOfRollsLabel = new JLabel("0");
        this.setLayout(new GridBagLayout());
        //JPanel pane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

       // JButton button;
       // this.setLayout(new GridBagLayout());
     //   if (shouldFill) {
            //natural height, maximum width
            c.ipadx = 0;
            c.ipady =0;
            c.fill= GridBagConstraints.BOTH;
     //   }

        //button = new JButton("Button 1");
      //  if (shouldWeightX) {
       // }
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        this.add(die1, c);

      //  button = new JButton("Button 2");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        this.add(die2, c);

    //    button = new JButton("Button 3");
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 0;
        this.add(numberOfRollsLabel, c);

       // button = new JButton("Long-Named Button 4");
        c.fill = GridBagConstraints.BOTH;
      //  c.ipady = 40;      //make this component tall
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        this.add(roll, c);

//        button = new JButton("5");
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.ipady = 0;       //reset to default
//        c.weighty = 1.0;   //request any extra vertical space
//        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
//        c.insets = new Insets(10, 0, 0, 0);  //top padding
//        c.gridx = 1;       //aligned with button 2
//        c.gridwidth = 2;   //2 columns wide
//        c.gridy = 2;       //third row
//        pane.add(button, c);
//        this.add(die1);
//        this.add(die2);
//        this.add(numberOfRollsLabel);
//        this.add(roll);

        this.pack();
        this.setSize(400, 400);
        roll.addActionListener(this);

    }

//    public void ActionListener(ActionEvent ae) {
////        if (ae.getSource() == roll) {
////            this.die1.roll();//Change die
////            this.die2.roll();
////            die1.repaint();
////
////        }
//    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == roll) {
            this.die1.roll();//Change die
            this.die2.roll();
            numberOfRolls++;
            numberOfRollsLabel.setText(String.valueOf(numberOfRolls));
        }
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
