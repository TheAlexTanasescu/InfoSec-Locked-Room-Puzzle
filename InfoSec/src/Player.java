
public class Player 
{
	private String name;
	private int score, lives;
	
	public Player(String name, int score)
	{
		this.name = name;
		this.score = score;
		lives = 3;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addScore(int toAdd)
	{
		score += toAdd;
	}

	public int getLives() {
		return lives;
	}

	public void reduceLives()
	{
		lives -= 1;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

}
