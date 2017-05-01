package dnm;

import java.awt.Color;

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
	
	public static int rollDice(){
		int random = (int)(Math.random() * 12 + 1);
		return random;	
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
			player.setPlayerPosition(675, 650);
			ListOfPlayers.add(player);
		}
			gameBoard.displayGUI(NumberOfPlayers);
			
	}
	//an example of how retrieving through the ArrayList works. ListOfPlayers.get(0).setCash(5000);
	//Here is where we will update the board according to the player position
	public static void updateBoard(){
		//175 - 225
		int xCoord = ListOfPlayers.get(0).getPlayerXCoord();
		int yCoord = ListOfPlayers.get(0).getPlayerYCoord();
		gameBoard.updateGUI(5, 5);
	}
	
	public void GameManger(Boolean GameInProgress){
		GameExecution(GameInProgress);
		updateBoard();
		return;
		
	}
	
	public static void GameExecution(boolean GameInProgress){
		int diceRoll;
		Scanner input = new Scanner(System.in);
		
		
		while(GameInProgress == true){
			for(int i = 0; i < ListOfPlayers.size(); i++){
				System.out.println("Greetings: " + ListOfPlayers.get(i).getName() + "\n");
				System.out.println("What would you like to do?\n");
				System.out.println("Would you like to (1) Roll the Dice?\n");
				System.out.println("Would you like to (2) see your properties?\n");
				System.out.println("Would you like to (3) purchase this property if available?\n");
				System.out.println("Would you like to (4) trade a property?\n");
				System.out.println("Would you like to (5) end your turn?\n");
				int PlayerChoice = input.nextInt();
				
				switch(PlayerChoice){
				case 1: 
					diceRoll = rollDice();
					System.out.println("You rolled: " + diceRoll);
					break;
				case 2:
					GameInProgress = false;
					break;
			
				}		
			}
		}
		return; 		
	}
	
	
	public static void main(String[] args){
		boolean GameInProgress = false;
		
		GameSystem MonopolyGame = new GameSystem();
		
		if(GameInProgress == false){
			MonopolyGame.BeginGame();
			GameInProgress = true;
		}
		while(true){
		MonopolyGame.GameManger(GameInProgress);
		}
		
	}
		

}
