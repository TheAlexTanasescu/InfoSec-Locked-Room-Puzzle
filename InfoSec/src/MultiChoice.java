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
    
	public MultiChoice(JFrame window)
    {

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600,250);
        mainTextPanel.setBackground(Color.BLACK);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea("This is where the question goes");
        mainTextArea.setBounds(100, 100, 600,250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.GREEN);
        mainTextArea.setFont(subtitleFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choicePanel = new JPanel();
        choicePanel.setBounds(250, 350, 300, 150);
        choicePanel.setBackground(Color.BLACK);
        window.add(choicePanel);

        firstChoice = new JButton("Choice 1");
        firstChoice.setBackground(Color.BLACK);
        firstChoice.setForeground(Color.GREEN);
        firstChoice.setFont(subtitleFont);
        choicePanel.add(firstChoice);

        secondChoice = new JButton("Choice 2");
        secondChoice.setBackground(Color.BLACK);
        secondChoice.setForeground(Color.GREEN);
        secondChoice.setFont(subtitleFont);
        choicePanel.add(secondChoice);

        thirdChoice = new JButton("Choice 3");
        thirdChoice.setBackground(Color.BLACK);
        thirdChoice.setForeground(Color.GREEN);
        thirdChoice.setFont(subtitleFont);
        choicePanel.add(thirdChoice);

        fourthChoice = new JButton("Choice 4");
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
