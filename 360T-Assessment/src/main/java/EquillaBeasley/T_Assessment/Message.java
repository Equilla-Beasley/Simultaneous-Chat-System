package EquillaBeasley.T_Assessment;
import java.util.Scanner;

/**
 * Message Class contains the message shared
 * between players and also handles the transfer
 * of messages between players.
 * 
 * It stops once the total number of rounds is met 
 * (specifically when Player 1, the Initiator, has 
 * sent and received 10 messages).
 * 
 * @author Equilla Beasley Jr.
 */
public class Message {
	private StringBuilder message = new StringBuilder();
	private Scanner scanner = new Scanner(System.in);
	private int numberOfPlayers;
	private int numberOfRounds;
	private int currentTurn = 0;
	
	/**
	 * Constructor for Message Class
	 * @param numberOfPlayers Total number of Players
	 * @param numberOfRounds Total number of Rounds
	 */
	public Message(int numberOfPlayers, int numberOfRounds)
	{
		this.numberOfPlayers = numberOfPlayers;
		this.numberOfRounds = numberOfRounds;
	}
	
	/*
	 * Creates prompt for player to fill out.
	 * Also prints the previous message and
	 * number of messages sent by current player.
	 */
	private synchronized void createMessage(String playerName, int totalMessagesSent)
	{
		System.out.println("\n" + playerName + " is at Round" + totalMessagesSent);
		System.out.print("\nWhat do you want to say? " + playerName);
		if(message.length() == 0)
		{
			message.append(playerName + ": '" + scanner.nextLine() + "'");
		}
		else
		{
			message.append("\n" + playerName + ": '" + scanner.nextLine() + "'");
		}		
		System.out.println("\nPrevious Messages: \n" + message.toString());
		System.out.println("\nTotal Messages Sent by " + playerName + ": " + totalMessagesSent);
	}
	
	//Handles the transfer of messages between Players
	public synchronized void sendMessage(String playerName, int playerID) 
	{
		for(int round = 0; round < numberOfRounds; round++)
		{
			//if not the current player, wait for turn
			while(playerID != currentTurn)
			{
					try {
						wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
			}		
			
			/*
			 * Current player takes turn and then ends it,
			 * giving priority to next player.
			 */
			createMessage(playerName, round + 1);
			currentTurn = (currentTurn + 1) % numberOfPlayers;
			notifyAll();
		}
		
		/*
		 * After all players have sent and received the
		 * intended number of message (numberOfRounds),
		 * the simulation ends.
		 */
		System.out.println("End Simulation");
	}
}