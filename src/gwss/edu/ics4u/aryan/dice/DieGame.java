/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.dice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    public int numberOfWins;
    public int numberOfLoses;

    Die die1;
    Die die2;
    JButton roll;
    JLabel numberOfRollsLabel;
    JLabel numberOfWinsLabel;
    JLabel numberOfLosesLabel;
    JLabel actionLabel;
    JPanel panel1;

    public DieGame() {
        
        this.numberOfRolls = 0;
        die1 = new Die(Color.CYAN, Color.WHITE, 1, 5);
        die2 = new Die(Color.ORANGE, Color.WHITE, 1, 3);
        roll = new JButton("ROLL");
        
        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // MESSAGE
        numberOfRollsLabel = new JLabel("Number of Games = 0");
        numberOfWinsLabel = new JLabel("Number of Wins = 0");
        numberOfLosesLabel = new JLabel("Number of Loses = 0");
        actionLabel = new JLabel("");
        panel1.setSize( 200, 100);
        panel1.setPreferredSize( new Dimension(200, 100 ) );
        panel1.add(numberOfRollsLabel);
        panel1.add(numberOfWinsLabel);
        panel1.add(numberOfLosesLabel);
        panel1.add(actionLabel);
        
        
        this.setLayout( new GridBagLayout() );
        //JPanel pane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
       // JButton button;
       // this.setLayout(new GridBagLayout());
     //   if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.BOTH;
     //   }

        //button = new JButton("Button 1");
      //  if (shouldWeightX) {
       // }
        c.fill = GridBagConstraints.BOTH;
      //  c.ipady = 100;
      //  c.ipadx = 100;

        c.gridx = 0;
        c.gridy = 0;
        this.add(die1, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        this.add(die2, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 0;
        
        this.add(panel1, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        this.add(roll, c);

//        this.add(die1);
//        this.add(die2);
//        this.add(numberOfRollsLabel);
//        this.add(roll);
        roll.addActionListener(this);
        this.pack();
      //  this.setSize(400, 400);
 

    }

    /*
    numberOfWins
    numberOfLoses
    */
    public void diceRoll() {
        if (die1.getValue() + die2.getValue() == 7) {
            actionLabel.setText("You lose, you rolled a 7!");
            numberOfLoses++;
        } else if (die1.getValue() == die2.getValue()) {                       
            actionLabel.setText("You win, you rolled doubles!");
            numberOfWins++;
        } else {
            actionLabel.setText("It's a draw!                  ");
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == roll) {
            this.die1.roll();//Change die
            this.die2.roll();
            diceRoll();
            numberOfRolls++;
            numberOfRollsLabel.setText("Number of Games = " + String.valueOf(numberOfRolls));
            numberOfWinsLabel.setText("Number of wins: "+ numberOfWins);
            numberOfLosesLabel.setText("Number of losses: "+ numberOfLoses);
        }
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    public static void main(String[] args) {
        DieGame dieGame = new DieGame();
        dieGame.setVisible(true);
        dieGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
