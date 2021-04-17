import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

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
    Timer timer;
    
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

        pointsLabel = new JLabel();
        pointsLabel.setIcon(new ImageIcon("/Users/alextanasescu/Desktop/Coding/CPSC 329/InfoSec-Locked-Room-Puzzle/InfoSec/src/score2.png"));
        pointsLabel.setFont(subtitleFont);
        pointsLabel.setForeground(Color.GREEN);
        statusPanel.add(pointsLabel);

        pointValueLabel = new JLabel();
        pointValueLabel.setFont(subtitleFont);
        pointValueLabel.setForeground(Color.GREEN);
        statusPanel.add(pointValueLabel);

        timeLabel = new JLabel();
        timeLabel.setIcon(new ImageIcon("/Users/alextanasescu/Desktop/Coding/CPSC 329/InfoSec-Locked-Room-Puzzle/InfoSec/src/timer2.png"));
        timeLabel.setFont(subtitleFont);
        timeLabel.setForeground(Color.GREEN);
        statusPanel.add(timeLabel);

        timeValueLabel = new JLabel();
        timeValueLabel.setFont(subtitleFont);
        timeValueLabel.setForeground(Color.GREEN);
        statusPanel.add(timeValueLabel);

        topicLabel = new JLabel();

        topicLabel.setIcon(new ImageIcon("/Users/alextanasescu/Desktop/Coding/CPSC 329/InfoSec-Locked-Room-Puzzle/InfoSec/src/heart.png"));
        topicLabel.setFont(subtitleFont);

       // topicLabel.setIcon(new ImageIcon("topic2.png"));
       // topicLabel.setFont(subtitleFont); 

        topicLabel.setForeground(Color.GREEN);
        topicLabel.setBackground(Color.WHITE);
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
        topic = Integer.toString(player.getLives());
        pointValueLabel.setText(Integer.toString(points)); 
        //timeValueLabel.setText(Integer.toString(time));
        topicValueLabel.setText(topic);
        countdownTimer();
        timer.start();
    
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
            
            Main.nextScreen(window);
            //new MultiChoice(window);

            }
        }
    
    public void countdownTimer()
    {
    	timer = new Timer(1000, new ActionListener()
    		{
    			public void actionPerformed(ActionEvent e)
    			{
    				time--;
    				timeLabel.setText(Integer.toString(time));
    				if(time == 0)
    				{
    					timer.stop();
    					new GameOver(window);
    				}
    			}
    		});
    }
    }

