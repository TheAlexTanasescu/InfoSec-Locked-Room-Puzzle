import java.io.IOException;

public class Tester 
{
	public static void main(String[] args) throws IOException
	{
		QuestionReader qList = new QuestionReader();
		Player user = new Player("name",0);
		new Game(qList, user);
	}

}
