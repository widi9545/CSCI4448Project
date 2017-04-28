package dnm;

import java.awt.EventQueue;
import java.util.Scanner;
import java.util.ArrayList;


public class GameSystem {
	
	public static int NumberOfPlayers;
	public static int StartingCash;
	public static GameBoard gameBoard = new GameBoard();
	//Adding in a Player List for us to use - this will make it way easier for us to iterate down and perform operations on the players
	public static ArrayList<Player> ListOfPlayers = new ArrayList<Player>();
	//set our cash 
	public static int SetCash(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the starting amount of cash\n");
		StartingCash = input.nextInt();
		return StartingCash;
	}
	//start the game! these are the default settings, the GameSystem class is going to become massive as move along
	public static void BeginGame(){
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Monopoly!\n");
		System.out.println("How many players are playing?\n");
		
		NumberOfPlayers = input.nextInt();
		
		for(int i = 0; i < NumberOfPlayers; i++){
			System.out.println("Enter in a player name!\n");
			String playerName = input.next();
			System.out.println("Enter in a player color\n");
			String playerColor = input.next();
			Player player = new Player(playerName, playerColor);	
			player.setCash(StartingCash);
			ListOfPlayers.add(player);
		}
		
			gameBoard.displayGUI(NumberOfPlayers);
			
	}

	//Here is where we will update the board according to the player position
	public static void updateBoard(){
		//175 - 225
		gameBoard.updateGUI(175,650);
		return;
	}
	
	
	
	
	public static void main(String[] args){
		boolean StartOfGame = false;
		GameSystem MonopolyGame = new GameSystem();
		if(StartOfGame == false){
			MonopolyGame.BeginGame();
			StartOfGame = true;
		}
		MonopolyGame.updateBoard();

	}
		

}
