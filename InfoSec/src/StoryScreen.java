import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class StoryScreen 
{
	JPanel field;
	JPanel continueField;
	JButton cont;
	JTextArea text;
	JFrame window;
	Font titleFont = new Font("Futura", Font.PLAIN, 18);
	
	public StoryScreen(JFrame window,String toDisplay)
	{
		this.window = window;
		
        field = new JPanel();
        field.setBounds(0, 0, 800, 400);
        field.setBackground(Color.black);
        
        text = new JTextArea(toDisplay,5,5);
        text.setWrapStyleWord(true);
        text.setLineWrap(true);
        text.setBounds(0, 0, 700, 400);
        text.setBackground(Color.black);
        text.setForeground(Color.green);
        text.setFont(titleFont);
        
        field.add(text);
        
        continueField = new JPanel();
        continueField.setBounds(500, 400, 150, 200);
        continueField.setBackground(Color.black);
        
        cont = new JButton("Continue");
        cont.setBackground(Color.BLACK);
        cont.setForeground(Color.green);
        cont.setFont(titleFont);
        cont.addActionListener(new ContinueListener());
        
        
        continueField.add(cont);
        
        window.add(field);
        window.add(continueField);
		
	}
	
	public class ContinueListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			field.setVisible(false);
			continueField.setVisible(false);
			Main.nextScreen(window);
			
			
		}
		
	}

}
