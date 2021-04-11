
public class Question 
{
	int type;
	private String correct,ask;
	private String[] choices;
	private int points;
	
	public Question(String ask,String[] options, String right, int award, int type)
	{
		this.ask = ask;
		correct = right;
		choices = options;
		points = award;
		this.type = type;
	}
	
	public String getCorrect()
	{
		return correct;
	}
	
	public String[] getChoices()
	{
		return choices;
	}
	
	public int getPoints()
	{
		return points;
	}
	
	public int getType()
	{
		return type;
	}

	public String getAsk() {
		return ask;
	}
	
	public boolean isCorrect(String toCompare)
	{
		if(toCompare.equalsIgnoreCase(correct))
		{
			return true;
		}
		return false;
	}

}
