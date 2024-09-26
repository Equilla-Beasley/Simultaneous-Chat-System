package EquillaBeasley.T_Assessment;

/**
 * The Player Class contains the information for
 * each instance of this class, and when it is run,
 * it calls the Message class to run the Assessment.
 * 
 * @author Equilla Beasley Jr.
 *
 */
public class Player implements Runnable{
	private final String playerName;
	private final int playerID; 
	Message message;
	
	/**
	 * Constructor for Player Class
	 * @param playerName name of the Player
	 * @param message a message that is shared between players and added to
	 * @param playerID ID number for each player (starting at 0)
	 */
	public Player(String playerName, Message message, int playerID)
	{
		this.playerName = playerName;
		this.playerID = playerID;
		this.message = message;
	}
	
	//Runs code to send messages between players.
	@Override
	public void run()
	{	
		message.sendMessage(playerName, playerID);
	}
}
