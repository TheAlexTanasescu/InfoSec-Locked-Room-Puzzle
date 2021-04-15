import java.io.*;
import java.util.ArrayList;

public class QuestionReader 
{
	ArrayList<Question> easy = new ArrayList<Question>();
	ArrayList<Question> medium = new ArrayList<Question>();
	ArrayList<Question> hard = new ArrayList<Question>();
	
	public QuestionReader() throws IOException
	{
		//Create filereader and ArrayLists (create 3 for easy,med,hard)
		
		try(BufferedReader in = new BufferedReader(new FileReader("/Users/alextanasescu/Desktop/Coding/CPSC 329/InfoSec-Locked-Room-Puzzle/InfoSec/src/input.txt")))
		{
			//Set reader to the input file to be read, create variables that hold most recently read item
			
			char c;
			String line = "";
			
		
		//While loop that reads file and adds individual question to proper List
		/**
		 * Questions are in the format of:
		 * 000 (First number = type/numChoices, Second number = index of correct, Third = category)
		 * This is the question
		 * This is choice 1
		 * This is choice 2
		 * 
		 * And so on
		 */
		while(line != null)
		{
			//Get relevant info about question (type,correct choice, category)
			c = (char) in.read();
			int type = Character.getNumericValue(c);
			c = (char) in.read();
			int correct = Character.getNumericValue(c);
			c = (char) in.read();
			int category = Character.getNumericValue(c);
			
			//Get the actual question and store it
			line = in.readLine();
			line = in.readLine();
			String ask = line;
			String[] choices = new String[type];
			
			//Get all the possible choices and store them.
			for(int i = 0; i < type; i++)
			{
				line = in.readLine();
				choices[i] = line;
			}
			
			//Prepare to move on to next question
			line = in.readLine();
			
			//Create a question and add it to proper List
			//add switch statement so question is added to different ArrayList based on difficulty
			switch(category)
			{
			case 0:
				easy.add(new Question(ask, choices, choices[correct], (category+1)*500, type));
				break;
			case 1:
				medium.add(new Question(ask, choices, choices[correct], (category+1)*500, type));
				break;
			case 2:
				hard.add(new Question(ask, choices, choices[correct], (category+1)*500, type));
				break;
			}
			
		}
		//Test prints to check if question and answer are being properly stored
	/*		int index = (int) (Math.random()*easy.size());
			System.out.println(easy.get(index).getAsk());
			System.out.println(easy.get(index).getCorrect());
			
			System.out.println();
			
			index = (int) (Math.random()*medium.size());
			System.out.println(medium.get(index).getAsk());
			System.out.println(medium.get(index).getCorrect());
			
			System.out.println();
			
			index = (int) (Math.random()*hard.size());
			System.out.println(hard.get(index).getAsk());
			System.out.println(hard.get(index).getCorrect());
			*/
			in.close();
		} 
		/* finally //Close file as a common courtesy :) 
		{
			
		} */
	}
	
	public ArrayList<Question> getEasy()
	{
		return easy;
	}
	
	public ArrayList<Question> getMedium()
	{
		return medium;
	}
	
	public ArrayList<Question> getHard()
	{
		return hard;
	}
	
	public static void main(String[] args) throws IOException
	{
		new QuestionReader();
	}
	

}
