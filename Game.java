import javax.swing.*;
import java.awt.Color;
import java.awt.Font;




public class Game
{
    JFrame window;
    JPanel titleScreen, startPanel;
    JLabel title, subtitle;
    Font titleFont = new Font("Futura", Font.PLAIN, 28), subtitleFont = new Font("Futura", Font.PLAIN, 21);
    JButton startButton;
    
    public static void main(String[] args) 
    {
        new Game();

    }

    public Game()
    {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setTitle("Encrypted Freedom");
   
        
        titleScreen = new JPanel();
        titleScreen.setBounds(100, 100, 600, 150);
        titleScreen.setBackground(Color.black);
        
        title = new JLabel("Encrypted Freedom");
        title.setForeground(Color.green);
        title.setFont(titleFont);
        
        subtitle = new JLabel("Can you decrypt your freedom before its too late...?");
        subtitle.setForeground(Color.green);
        subtitle.setFont(subtitleFont);

        startPanel = new JPanel();
        startPanel.setBounds(300, 400, 200, 100);
        startPanel.setBackground(Color.black);

        startButton = new JButton("Start");
        startButton.setContentAreaFilled(false);
        //startButton.setOpaque(true);
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.green);
        startButton.setFont(subtitleFont);
        
        titleScreen.add(title);
        titleScreen.add(subtitle);
        
        startPanel.add(startButton);

        window.add(titleScreen);
        window.add(startPanel);
        window.setVisible(true);

    }
}
