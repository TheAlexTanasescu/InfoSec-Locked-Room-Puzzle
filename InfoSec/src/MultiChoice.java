import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MultiChoice extends QuestionWindow //Class responsible for four choice questions
{

    JButton firstChoice, secondChoice, thirdChoice, fourthChoice;
    
	public MultiChoice(JFrame window, Question question, Player player) throws IOException
    {
		super(window,question,player);

        firstChoice = new JButton(question.getChoices()[0]);
        firstChoice.setBackground(Color.BLACK);
        firstChoice.setForeground(Color.GREEN);
        firstChoice.setFont(subtitleFont);
        firstChoice.addActionListener(qHandler);
        choicePanel.add(firstChoice);
        

        secondChoice = new JButton(question.getChoices()[1]);
        secondChoice.setBackground(Color.BLACK);
        secondChoice.setForeground(Color.GREEN);
        secondChoice.setFont(subtitleFont);
        secondChoice.addActionListener(qHandler);
        choicePanel.add(secondChoice);
       

        thirdChoice = new JButton(question.getChoices()[2]);
        thirdChoice.setBackground(Color.BLACK);
        thirdChoice.setForeground(Color.GREEN);
        thirdChoice.setFont(subtitleFont);
        thirdChoice.addActionListener(qHandler);
        choicePanel.add(thirdChoice);
        

        fourthChoice = new JButton(question.getChoices()[3]);
        fourthChoice.setBackground(Color.BLACK);
        fourthChoice.setForeground(Color.GREEN);
        fourthChoice.setFont(subtitleFont);
        fourthChoice.addActionListener(qHandler);
        choicePanel.add(fourthChoice);

    }
   
}
