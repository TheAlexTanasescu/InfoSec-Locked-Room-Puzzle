import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MultiChoice 
{
	
    JPanel mainTextPanel, choicePanel, statusPanel;
    JLabel pointsLabel, timeLabel, topicLabel, pointValueLabel, timeValueLabel, topicValueLabel;
    Font titleFont = new Font("Futura", Font.PLAIN, 28), subtitleFont = new Font("Futura", Font.PLAIN, 21);
    JButton firstChoice, secondChoice, thirdChoice, fourthChoice;
    JTextArea mainTextArea;

    int points, time;
    String topic;
    
	public MultiChoice(JFrame window, Question question)
    {

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600,250);
        mainTextPanel.setBackground(Color.BLACK);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea(question.getAsk());
        mainTextArea.setBounds(100, 100, 600,250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.GREEN);
        mainTextArea.setFont(subtitleFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choicePanel = new JPanel();
        choicePanel.setBounds(0, 350, 800, 250);
        choicePanel.setBackground(Color.BLACK);
        window.add(choicePanel);

        firstChoice = new JButton(question.getChoices()[0]);
        firstChoice.setBackground(Color.BLACK);
        firstChoice.setForeground(Color.GREEN);
        firstChoice.setFont(subtitleFont);
        choicePanel.add(firstChoice);

        secondChoice = new JButton(question.getChoices()[1]);
        secondChoice.setBackground(Color.BLACK);
        secondChoice.setForeground(Color.GREEN);
        secondChoice.setFont(subtitleFont);
        choicePanel.add(secondChoice);

        thirdChoice = new JButton(question.getChoices()[2]);
        thirdChoice.setBackground(Color.BLACK);
        thirdChoice.setForeground(Color.GREEN);
        thirdChoice.setFont(subtitleFont);
        choicePanel.add(thirdChoice);

        fourthChoice = new JButton(question.getChoices()[3]);
        fourthChoice.setBackground(Color.BLACK);
        fourthChoice.setForeground(Color.GREEN);
        fourthChoice.setFont(subtitleFont);
        choicePanel.add(fourthChoice);

        statusPanel = new JPanel();
        statusPanel.setBounds(100, 15, 600, 50);
        statusPanel.setBackground(Color.BLACK);
        statusPanel.setLayout(new GridLayout(1,4));
        window.add(statusPanel);     

        pointsLabel = new JLabel("Points:");
        pointsLabel.setFont(subtitleFont);
        pointsLabel.setForeground(Color.GREEN);
        statusPanel.add(pointsLabel);

        pointValueLabel = new JLabel();
        pointValueLabel.setFont(subtitleFont);
        pointValueLabel.setForeground(Color.GREEN);
        statusPanel.add(pointValueLabel);


        timeLabel = new JLabel("Time:");
        timeLabel.setFont(subtitleFont);
        timeLabel.setForeground(Color.GREEN);
        statusPanel.add(timeLabel);

        timeValueLabel = new JLabel();
        timeValueLabel.setFont(subtitleFont);
        timeValueLabel.setForeground(Color.GREEN);
        statusPanel.add(timeValueLabel);

        topicLabel = new JLabel("Topic:");
        topicLabel.setFont(subtitleFont);
        topicLabel.setForeground(Color.GREEN);
        statusPanel.add(topicLabel);

        topicValueLabel = new JLabel();
        topicValueLabel.setFont(subtitleFont);
        topicValueLabel.setForeground(Color.GREEN);
        statusPanel.add(topicValueLabel);

        playerSetup();
    }

    public void playerSetup()
    {
    	Player user = new Player("name",0);
        points = user.getScore();
        time = 60;
        topic = "Security and Privacy";
        pointValueLabel.setText(Integer.toString(points)); 
        timeValueLabel.setText(Integer.toString(time));
        topicValueLabel.setText(topic);
    
    }
    
    

}
