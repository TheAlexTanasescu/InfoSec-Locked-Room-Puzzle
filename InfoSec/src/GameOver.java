import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOver //Screen that's shown when player runs out of lives
{
	JPanel startPanel;
	JLabel endMessage;
	
	public GameOver(JFrame window)
	{
        startPanel = new JPanel();
        startPanel.setBounds(300, 250, 200, 200);
        startPanel.setBackground(Color.black);
        
        endMessage = new JLabel("GAME OVER");
        endMessage.setForeground(Color.RED);
        endMessage.setFont(new Font("Futura", Font.PLAIN, 28));
        
        startPanel.add(endMessage);
        window.add(startPanel);
        
	}

}
