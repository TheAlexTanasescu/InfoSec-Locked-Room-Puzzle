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

//Master class that creates all features that are common amongst question classes
public class QuestionWindow
{
	
	JFrame window;
    JPanel mainTextPanel, choicePanel, statusPanel;
    JLabel pointsLabel, timeLabel, topicLabel, pointValueLabel, timeValueLabel, topicValueLabel;
    Font titleFont = new Font("Futura", Font.PLAIN, 28), subtitleFont = new Font("Futura", Font.PLAIN, 21);
    JTextArea mainTextArea;

    int points, time;
    String topic;
    Question question;
    Player player;
    
    QuestionScreenHandler qHandler = new QuestionScreenHandler();
    
	public QuestionWindow(JFrame window, Question question, Player player) throws IOException
    {
		this.window = window;
		this.question = question;
		this.player = player;

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
        points = player.getScore();
        time = 60;
        topic = "Security and Privacy";
        pointValueLabel.setText(Integer.toString(points)); 
        timeValueLabel.setText(Integer.toString(time));
        topicValueLabel.setText(topic);
    
    }
    
    public class QuestionScreenHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	mainTextPanel.setVisible(false);
            mainTextArea.setVisible(false); 
            choicePanel.setVisible(false);
            statusPanel.setVisible(false);
            JButton button = (JButton) e.getSource();
            
            if(question.isCorrect(button.getText()))
            {
            	player.addScore(question.getPoints());
            }
            else
            {
            	player.reduceLives();
            }
            
            Main.nextQuestion(window);
            //new MultiChoice(window);

            }
        }
    }

