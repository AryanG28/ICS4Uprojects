/*
 * Name: Aryan Ghahremanzadeh 
 * Date: October 22, 2014 
 * Version: v0.1
 * Teacher: Mr.Muir
 * Description: This class is for the dieGame. It sets the properties and layout
 of it.
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
    public int numberOfLosses;

    Die die1;
    Die die2;
    JButton roll;
    JButton restart;
    JLabel numberOfRollsLabel;
    JLabel numberOfWinsLabel;
    JLabel numberOfLosesLabel;
    JLabel actionLabel;
    JPanel labelPanel;

    public DieGame() {

        die1 = new Die(Color.CYAN, Color.WHITE, 1, -1);
        die2 = new Die(Color.ORANGE, Color.WHITE, 1, -1);
        roll = new JButton("ROLL");
        restart = new JButton("RESTART");
        numberOfRollsLabel = new JLabel("Number of Games: 0");
        numberOfWinsLabel = new JLabel("Number of Wins: 0");
        numberOfLosesLabel = new JLabel("Number of Losses: 0");
        actionLabel = new JLabel("");
        
        createScorePanel();
        createGridBagLayout();
        roll.addActionListener(this);
        restart.addActionListener(this);
        
        this.pack();
        this.setResizable(false);

    }

    public void createScorePanel() {
        labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.numberOfRolls = 0;
        labelPanel.setSize(200, 100);
        labelPanel.setPreferredSize(new Dimension(200, 100));
        labelPanel.add(numberOfRollsLabel);
        labelPanel.add(numberOfWinsLabel);
        labelPanel.add(numberOfLosesLabel);
        labelPanel.add(actionLabel);
    }

    public void createGridBagLayout() {

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
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

        this.add(labelPanel, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        this.add(roll, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 2;
        this.add(restart, c);
    }

    public void diceRoll() {
        if (die1.getValue() + die2.getValue() == 7) {
            actionLabel.setText("You lose, you rolled a 7!");
            numberOfLosses++;
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
            setText();
        } else if (ae.getSource() == restart) {
            numberOfRolls = 0;
            numberOfWins = 0;
            numberOfLosses = 0;
            setText();
            actionLabel.setText("");
        }
    }

    public void setText() {
        numberOfRollsLabel.setText("Number of Games: " + String.valueOf(numberOfRolls));
        numberOfWinsLabel.setText("Number of Wins: " + numberOfWins);
        numberOfLosesLabel.setText("Number of Losses: " + numberOfLosses);
    }


}
