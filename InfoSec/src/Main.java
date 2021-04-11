import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {

	static QuestionReader qList;
	static Player user = new Player("name",0);
	static int counter = 0;

	public static void main(String[] args) 
	{
		try {
			qList = new QuestionReader();
			new Game(qList,user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void nextQuestion(JFrame window)//Picks a question to show, then 
	{
		Question toShow;
		
		//If-elif-else statement to decide what difficulty of question to present.
		if(counter < 10)
		{
			int index = (int) (Math.random()*qList.getEasy().size());
			toShow = qList.getEasy().get(index);
		}
		else if(counter >= 10 & counter < 20)
		{
			int index = (int) (Math.random()*qList.getMedium().size());
			toShow = qList.getMedium().get(index);
		}
		else
		{
			int index = (int) (Math.random()*qList.getHard().size());
			toShow = qList.getHard().get(index);
		}
		
		//If the user has run out of lives, show the game over screen.
		if(user.getLives() == 0)
		{
			new GameOver(window);
		}
		else
		{
			counter++;
			//Check the type of the question to decide what class of question to show on screen
	        switch(toShow.getType())
	        {
	        case 2:
	        	try {
					new TrueFalse(window,toShow,user);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
	        	break;
	        case 4:
	        	try {
					new MultiChoice(window,toShow,user);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	break;
        }
	}

	}
}
