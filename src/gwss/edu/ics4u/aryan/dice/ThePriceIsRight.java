/*
 *
 */
package gwss.edu.ics4u.aryan.dice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 */
public class ThePriceIsRight extends JFrame implements ActionListener, MouseListener {

    private JPanel middlePanel;
    private JPanel topDicePanel;
    private JPanel midDicePanel;
    private JPanel botDicePanel;
    private Die[][] dice;
    private JFrame[][] diceFrame;
    private JButton roll;
    private JButton showAnswer;
    private int turn;
    private int[] digit;
    private JLabel firstDigit;

    public ThePriceIsRight() {
        init();
    }

    public void init() {
        generateCarPrice();
        // MAIN WINDOW; The Price is Righta
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("The Price is Right!");

        // WINDOW; Border Layout
        this.setLayout(new BorderLayout());
        this.setSize(800, 400);

        // PARENT PANEL
        this.middlePanel = new JPanel();
        this.middlePanel.setLayout(new BoxLayout(this.middlePanel, BoxLayout.PAGE_AXIS));
        this.middlePanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

        // TOP DICE; HIGH
        this.topDicePanel = new JPanel();
        this.topDicePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        // BOT DICE; ROLLed
        Font font1 = new Font("Arial", Font.BOLD, 45);

        this.midDicePanel = new JPanel();
        this.firstDigit = new JLabel();
        firstDigit.setText(Integer.toString(digit[0]));
        firstDigit.setFont(font1);
        this.midDicePanel.add(firstDigit);
        this.midDicePanel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));

        // BOT DICE; LOW
        this.botDicePanel = new JPanel();
        this.botDicePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        // GENERATE DIE, put them in TOP/BOT Dice Panel
        this.dice = new Die[3][4];
        initDice();

        // TOP / BOT Dice Panel
        this.middlePanel.add(topDicePanel);
        this.middlePanel.add(midDicePanel);
        this.middlePanel.add(botDicePanel);

        // ADD ITEMS TO middlePanel
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(new JLabel("PAGE_START"), BorderLayout.PAGE_START);
        this.add(this.roll = new JButton("ROLL"), BorderLayout.LINE_START);
        this.add(this.showAnswer = new JButton("SHOW ANSWER"), BorderLayout.LINE_END);
        showAnswer.setEnabled(false);
        this.add(new JLabel("PAGE_END"), BorderLayout.PAGE_END);
        //this.pack();
        roll.addActionListener(this);

    }

    private void initDice() {
        Die die;
        Dimension d = new Dimension(100, 100);
        for (int row = 0; row < dice.length; row++) {
            for (int col = 0; col < dice[row].length; col++) {

                die = new Die();
                die.setPreferredSize(d);
                die.setSize(d);
                die.setName(row + "-" + col);
                die.addMouseListener(this);

                if ((row + col) % 2 == 0) {
                    die.setBorder(BorderFactory.createLineBorder(Color.RED));
                    die.setBackground(Color.GREEN);
                } else {
                    die.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                    die.setBackground(Color.RED);
                }

                this.dice[row][col] = die;
                if (row == 0) {
                    this.topDicePanel.add(this.dice[row][col]);
                } else if (row == 1) {
                    this.midDicePanel.add(this.dice[row][col]);
                } else {
                    this.botDicePanel.add(this.dice[row][col]);
                }
            }
        }
    }

    public void generateCarPrice() {
        this.digit = new int[5];
        for (int index = 0; index < 5; index++) {
            this.digit[index] = (int) (Math.random() * 6) + 1;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int row = 1;
        if (turn - 1 < 0 || dice[0][turn - 1].isSelected || dice[2][turn - 1].isSelected) {
            if (e.getSource() == roll) {
                if (turn < 4) {
                    dice[row][turn].roll();
                    turn++;
                    roll.setEnabled(false);
                } else {
                    if (roll.getText() == "DONE") {
                        roll.setEnabled(false);
                        showAnswer.setEnabled(true);
                    }

                }
            }
        } else {
            System.out.println("Must select higher or lower");
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked on " + e.getComponent().getName());
        String name = e.getComponent().getName();
        int dieRow = Integer.parseInt(name.substring(0, 1));
        int dieCol = Integer.parseInt(name.substring(2, 3));
        if (dieCol == (turn - 1) && dieRow != 1) {
            dice[dieRow][dieCol].setIsSelected(true);
            if (dieRow == 0) {
                dice[2][dieCol].setIsSelected(false);
            } else {
                dice[0][dieCol].setIsSelected(false);
            }
            roll.setEnabled(true);
        } else {
            System.out.println("Invalid Click");
        }
        if (dieCol == 3) {
            roll.setText("DONE");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // DO NOTHING
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // DO NOTHING
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // DO NOTHING
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // DO NOTHING
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ThePriceIsRight().setVisible(true);
            }
        }
        );

    }

}
