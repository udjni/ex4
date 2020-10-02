package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatchResult extends JFrame {
    public MatchResult() {
        setLayout(new FlowLayout());
        //add JButtons and Listeners for them to the frame
        b1.addActionListener(al);
        b2.addActionListener(al);
        add(b1);
        add(b2);
        //set actual text for our labels
        resultLabel.setText(getResultLabelText());
        lastScoreLabel.setText(getLastScoreTeam());
        winnerLabel.setText(getWinnerTeam());
        //add JTextFields to the frame
        add(resultLabel);
        add(lastScoreLabel);
        add(winnerLabel);
    }

    public static void main(String[] args) {
        SwingConsole.run(new MatchResult(), 400, 200);
    }
    //variables
    private String lastScoreTeam = "N/A";
    private long team1Score = 0;
    private long team2Score = 0;
    private final JTextField resultLabel = new JTextField(20);
    private final JTextField lastScoreLabel = new JTextField(20);
    private final JTextField winnerLabel = new JTextField(20);
    private final JButton b1 = new JButton("AC Milan");
    private final JButton b2 = new JButton("Real Madrid");
    //create listener for our buttons
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonName = ((JButton) e.getSource()).getText(); //get button name which was pressed
            //add score for distinct team
            if (buttonName.equalsIgnoreCase("AC Milan"))
                team1Score++;
            else
                team2Score++;
            //set actual lastScoreTeam
            lastScoreTeam = buttonName;
            //add refresh our labels to the event queue
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    resultLabel.setText(getResultLabelText());
                    lastScoreLabel.setText(getLastScoreTeam());
                    winnerLabel.setText(getWinnerTeam());
                }
            });
        }
    };
    //methods for getting actual text of labels
    private String getResultLabelText() {
        return "Result: " + team1Score + " X " + team2Score;
    }
    private String getLastScoreTeam() {
        return "Last Scorer: " + lastScoreTeam;
    }
    private String getWinnerTeam() {
        String winnerTeam;
        if (team1Score == team2Score)
            winnerTeam = "DRAW";
        else if (team1Score > team2Score)
            winnerTeam = "AC Milan";
        else winnerTeam = "Real Madrid";
        return "Winner: " + winnerTeam;
    }
}