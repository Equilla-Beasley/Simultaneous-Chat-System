package EquillaBeasley.T_Assessment;

/**
 * This Class contains the main function 
 * to run our simulation.
 * 
 * This program creates any number of players
 * and allows them to send messages to one another.
 * 
 * When the player that started the simulation,
 * the Initiator, sends and receives 10 messages,
 * the program ends.
 * 
 * @author Equilla Beasley Jr.
 */
public class Assessment {
  public static void main(String[] args) {
	//Constants
	int NUMBER_OF_PLAYERS = 2;
	int NUMBER_OF_ROUNDS = 10;
	
	//Creates a message to be shared between the players
	Message message = new Message(NUMBER_OF_PLAYERS, NUMBER_OF_ROUNDS);
	
	//Creates two Players 
	Player player1 = new Player("Player 1", message, 0);
	Player player2 = new Player("Player 2", message, 1);
	
	//Creates threads and then runs them
	Thread thread1 = new Thread(player1);
	Thread thread2 = new Thread(player2);
	
	//Runs Test and threads
    System.out.println("Running Players on the same Process");
    thread1.start();
    thread2.start();
    
  }
}
