import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EnterName 
{
	JTextField userName;
	JPanel field;
	Player user;
	JFrame window;
	JLabel prompt;
	Font titleFont = new Font("Futura", Font.PLAIN, 12);
	
	public EnterName(JFrame window,Player player)
	{
		this.window = window;
		user = player;
		
        field = new JPanel();
        field.setBounds(300, 250, 200, 200);
        field.setBackground(Color.black);
        
        userName = new JTextField(20);
        userName.addActionListener(new TextFieldListener());
        userName.setBackground(Color.WHITE);
        
        prompt = new JLabel("Please enter your name");
        prompt.setForeground(Color.green);
        prompt.setFont(titleFont);
        
        field.add(userName);
        field.add(prompt);
        
        window.add(field);
        
	}
	
	public class TextFieldListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			user.setName(userName.getText());
			field.setVisible(false);
			new StoryScreen(window,"The year is 2031. After the eruption of constant warfare, both psychological and psychical, resources have become scarce. This led major governments around the world to become dystopian, due to the lack of better terms of not knowing when new threats will arise. In turn however, privacy and freedoms have been stripped from almost every civilian except for those who hold positions of power. Now anonymity online and private data have become a relic of the past.\r\n" + 
					"\nYou, and a few others within society saw this as unjust and have created a resistance group that has grown rampant in size, with a single objective in mind: Restoring privacy and freedoms back into the hands of the people. In order to do this your group has decided to spread out and infiltrate these centralized data centers that monitor an individual's activities each on a solo mission. You start in your current province/state as double agents in order to steal and destroy all the information they have currently. After months of preparation, your final mission begins now.\r\n" + 
					"");
			
		}
		
	}

}
