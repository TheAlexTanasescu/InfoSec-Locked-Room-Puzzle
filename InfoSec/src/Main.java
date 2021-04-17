import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {

	static QuestionReader qList;
	static Player user = new Player("name",0);
	static int counter = 1;
	static int storyCounter = 0;

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
	
	public static int getDifficulty()
	{
		if(counter > 8)
		{
			return 2;
		}
		else if(counter > 3)
		{
			return 1;
		}
		return 0;
		
	}
	
	public static Question createQuestion(int difficulty)
	{
		switch(difficulty)
		{
		case 0:
			int index = (int) (Math.random()*qList.getEasy().size());
			return qList.getEasy().get(index);
		case 1:
			index = (int) (Math.random()*qList.getMedium().size());
			return qList.getMedium().get(index);
		case 2:
			index = (int) (Math.random()*qList.getHard().size());
			return qList.getHard().get(index);
		}
		return null;
	}
	
	public static void nextScreen(JFrame window)//Picks a question to show, then 
	{
		int difficulty = getDifficulty();
		Question toShow = createQuestion(difficulty);
		
		if(user.getLives() == 0)
		{
			new GameOver(window);
		}
		else if(counter % 2 == 0)
		{
			counter++;
			new StoryScreen(window,story[storyCounter++]);
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
	
	public static String[] story = {"Your resistance group has created a hacking device called Yggdrasil that allows you to hack into any security, and computer system as long as it has an electronic signal. And it has multiple functions such as rewriting security camera footage, and stealing data. However for each hack, one must give the correct response to security questions, as this device just reformats machine language/code into an understandable format. Either that or the creator is a troll and locked the device’s functionality behind this wall so it doesn’t fall into the wrong hands(or not).\r\n" + 
			"Once you arrive and wait for the allotted time for the gas to effectively take over the building, you make your way towards the front door of the building. Instead of using your employee keycard for fear of being tracked and revealing your identity, you pull out the Yggdrasil in order to hack the door open. “Hopefully this works properly, not like the incidents during ‘training’ with these things…” you think to yourself as you connect the device and see the screen booting up with the following question being displayed \r\n" + 
			"", 
			"Here I was hoping this functionality was removed, I sighed. Oh well, can’t muddle around here for too long, I only have about an hour before the gas wears off.\r\n" + 
					"You put away the device. Alright, first I need to get rid of any video evidence that I was here by replacing it with a loop of footage of the past hour before I got here.\r\n" + 
					"",
					"As you walk through the now unlocked front entrance, you stop to let your eyes adjust to the blindingly bright lights. The greyscale interior is just as depressing as you remembered it from all the time you’ve spent inside this dreary building. You tactfully maneuver between the unconscious bodies of your so-called coworkers and dart into one of the many connecting hallways and make your way towards the security footage room. Standing before the locked door, you pull out Yggdrasil again to begin the process of forcing open another door.",
					"The door slides open silently and you make your way inside. You push the head security guard out of the chair and he lands on the ground with a thump. That gas is really doing its job well, not even a grunt from this guy. You take his spot and turn your attention to the screen. What you see renders you speechless. On the screen, the browser is pulled up with a series of tabs open. Instead of properly doing his job, the man is out here chatting and  catfishing people on a dating website. Revolted, you quickly sweep through all the cameras checking for any movements and making sure everyone is knocked out. Once satisfied, you hook up Yggdrasil to the monitoring system to begin the process of overwriting the security footage. ",
					"“Alright now time to reforge the footage of this place.” As you navigate and hit the rewrite option on the device’s screen.",
					"With the last few clicks of the keys on the keyboard, you successfully rewrote the security footage and disconnected Yggdrasil. Now with that out of the way, it’s finally time for me to check out the upper floors and see what these rotten higher ups are spending all the company money on. Guys couldn’t even spare a small amount to fixup the break room down here. You think to yourself with an eye roll as you navigate around and pull up the employee registry. You filter the list and narrow down the list of people to a handful and pinpoint Haesi Lock, the CEO’s name. Upon clicking his name, you scan through the useless background information until you come across his office location. Floor 25, here I come. \r\n" + 
					"As you get up, your foot bumps against the security guard’s leg. Why not take care of this guy’s catfishing habits as well. You crouch down in front of the unconscious security guard and search for his mobile phone. After checking his back pockets, you successfully pull out the phone. Turning it on, you’re prompted to enter the pin. You retrieve Yggdrasil and plug it into the phone. \r\n" + 
					"",
					"After completing the last answer, the phone unlocks. Let’s delete all his social media accounts why don’t we. You navigate through the options on Yggdrasil and with a grin, tap on the option to “delete all accounts associated with the device owner”.",
					"With a smirk, you unplug Yggdrasil and get up to make your way back to the main entrance in order to access the elevators.\r\n" + 
					"Your footsteps echo through the barren walls as you walk up to the elevators and press the “up” button and a soft orange glow immediately radiates off the arrow. You hear a ding and one of the doors slide open. You walk in and press the “25” button. The doors close and a robotic voice breaks the silence. \r\n" + 
					"“Please state your full name.” Says the AI.\r\n" + 
					"You raise an eyebrow and look straight at the service panel and locate some small screws. Tsk. What a pain. You rummage through your tools bag and pull out a screwdriver and snap on the matching magnetic screw head. You make quick work of the screws and they each hit the ground with a sharp ting. You move the small panel and you’re greeted by a series of wires and microchips. \r\n" + 
					"“I’m sorry, I didn’t pick up on a valid response. Please state your full name.” Repeats the AI.\r\n" + 
					"Your brows furrow with slight annoyance as you locate the Voice Recognition label and jab the corresponding connector from Yggdrasil into the USB port.\r\n" + 
					"",
					"“Identification verified. Thank you, Mr. Haesi Lock.” You hear the AI say. \r\n" + 
					"Once the voice fades, you feel the elevator begin its ascend. Putting all your tools back, you lean back against the walls and sigh. Looking at your wristwatch, you see that 12 minutes have gone by. Making good time I suppose. The elevator stops with a ding and the doors open, revealing polished marble floors and a nice red carpet. You eye the red carpet and scoff. Of course...classic red carpet. You slightly stick your head out to assess the unfamiliar floor. Your eyes follow the red carpet past the leather armchairs and glass table, all the way to the far back middle of the room where you see an elegant wood desk with an expensive looking curved monitor situated to the side. You look at the leather office chair half expecting to see someone knocked out but it’s just an empty chair. Pft, of course he won’t be here. It’s half past midnight after all. You think with a sneer as you make your way up to the desk.\r\n" + 
					"Turning on the desktop, you’re prompted with the password screen. The CEO’s birthdate flashes in your mind and you type the numbers in trying your luck. A welcome message is plastered across the screen and you stare at the desktop screen perplexed. Who in their right mind would store important documents within a device that is protected with just your birthday?... You shake your head in disappointment and start searching through the folders. Finding what you need, you click on the folder and another password prompt opens up. You try the birthdate again and it fails. Well, at least he isn’t that stupid I suppose. Taking out Yggdrasil again, you plug the device into the computer.\r\n" + 
					"",
					"The prompt disappears, and the content of the window opens up, pulling out one of the USB drives you have in your bag. You insert it into the port of the computer, and copy and paste all the files over in that folder. While i'm here, might as well check out this dude’s emails, and copy them over. As you proceed to click on the Mail application, half expectantly thinking you would need to hack the password again you begin to plug in Yggdrasil, only to look back on the screen and see that you are already logged into the email. “Wow, something actually went easier than expected? That is definitely a first.” you thought to yourself. As you check to see if the corresponding email matches the one to the CEO’s, verifying and realizing that it is, you move to hit copy and export to USB drive on Yggdrasil and another question pops up. “Do you want to filter out malicious/spam emails?” To which you hit Yes, happy that you don't have to do it yourself later at base, now another question pops up used as the security measure for the copy and extort feature of Yggdrasil. “Well, guess I spoke too soon on it getting easier… at least I won’t have to do the filtering. Bless this device.”:",
					"Upon the completion of copying the files, you check to see if the web browser contained any other possible email entries that were saved, to which there were none. Now checking again on the application version after logging out, you find nothing besides the previously logged in email. “Well, no other trails, so far… Guess we have to wait and see if the backdoor that Yggdrasil created will reveal anything later on.” You thought to yourself. “Now to leave” with a tired sigh. Once the doors slide open, you quickly enter and reconnect Yggdrasil again and enter in the command for the AI to take you down to floor B1. \r\n" + 
					"“Authorization cleared, thank you Mr. Haesi Lock. Now heading down to level B1.” Announces the AI. \r\n" + 
					"The elevator stops with a ding and the doors slide open. Stepping out, you see a large open computer lab with a few unconscious bodies littered here and there. There was a complicated looking machine located in the middle of the room. Above it were numerous screen projections of footage of individuals. Some people were sleeping, others were seen on computers, watching television, eating... there were even toddlers and elderly being shown. It was like these people were locked up in cells and monitored like criminals. Seeing the projections fill you with rage. Get a hold of yourself. You need to finish this mission. With clenched fists, you walk down the few stairs and move towards the machine. This has got to be the centralized data storage unit. All I have to do now is get the data and get out. You inspect the elaborate machine and plug Yggdrasil into an output slot. Suddenly, the screen starts glitching out and a set of words are displayed: \r\n" + 
					"“Unrecognized device plugged in. Intruder detected.”\r\n" + 
					"Oh boy… another AI to deal with.\r\n" + 
					"",
					"Upon defending the attack, the device has created a fake compromised access point after the successful defense, which allows you time to hack the AI back. The next question rapidly appears:",
					"“Thank god that is over with.” As you see the message AI has successfully been hacked on the device, you breathe out a sigh of relief. “Now that it is dealt with I still have to access the data to steal and delete it. Here I was hoping I would have gained access after hacking the AI, but it seems as if they were smart and made it separate from the data itself…” you thought about while navigating to hack the access was Backstreet boys tell me why, as a single tear rolls down your cheek reminded of the good times, as the next question pops up:",
					"Alright now that could have gone better... You thought to yourself, as you rub the sweat off your forehead with your sleeve. That AI is pretty powerful, we might find a use for it in the hands of the resistance. And might as well cripple allow the resistance to have easier access to this on site server too. While rummaging through your bag, you glance at your watch seeing you have 13 minutes left. You pull out a SSD and plug it into the server. You hook up Yggdrasil to it and allow it to begin downloading the AI data  while simultaneously navigating to the option on Yggdrasil to create a backdoor. You are prompted with the next question:",
					"As the device shows the message of the completed backdoor, you unplug the SSD from the server that contains the AI, and use Yggdrasil to delete all traces of the AI and replace the original files on the server with random junk files. As the operation completes, you put the SSD carefully back in your bag, and proceed back towards the elevator to get back to the main floor. On the way up, you look at your wrist and see you have about 8 minutes left before everyone starts waking up. With the doors opening, you hastily step out and make your way towards the entrance. Once outside, you run towards your vehicle parked a few meters away and floor it back towards the town. As you park the car in an empty parking lot, and grab Yggdrasil and hit the reset button, “one more time.” as the next question appears:"};
}
