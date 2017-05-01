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
	public static ArrayList<TradeRequest> TradeQueue = new ArrayList<TradeRequest>();
	
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
			player.setPlayerPosition(650, 650);
			ListOfPlayers.add(player);
		}
			gameBoard.displayGUI(NumberOfPlayers);
			
	}
	//an example of how retrieving through the ArrayList works. ListOfPlayers.get(0).setCash(5000);
	//Here is where we will graphically update the board according to the player position
	//we use the move() method in the Player class to actually increment the tile counter however
	public static void updateBoard(int currentPlayer, int DiceRoll){
		//175 - 225
		
		int xCoord = ListOfPlayers.get(currentPlayer).getPlayerXCoord();
		int yCoord = ListOfPlayers.get(currentPlayer).getPlayerYCoord();
		
		int newYCoord = 0;
		int newXCoord = 0;
		if(yCoord >= 650){
			newXCoord = xCoord - (DiceRoll*50);
			newYCoord = yCoord;
			
		}
		if(xCoord <= 125){
			newYCoord = yCoord - (DiceRoll*50);
			newXCoord = xCoord;
		}
		gameBoard.updateGUI(newXCoord, newYCoord);
	}
	
	public void GameManger(Boolean GameInProgress, int CurrentPlayer, int DiceRoll){
		updateBoard(CurrentPlayer, DiceRoll);
		GameExecution(GameInProgress, CurrentPlayer);
		updateBoard(CurrentPlayer, DiceRoll);
		return;
		
	}
	
	public static void GameExecution(boolean GameInProgress, int CurrentPlayer){
		int diceRoll;
		Scanner input = new Scanner(System.in);
		while(GameInProgress == true){
			System.out.println("What would you like to do now?\n");
			System.out.println("Would you like to (1) see your properties?\n");
			System.out.println("Would you like to (2) purchase this property if available?\n");
			System.out.println("Would you like to (3) trade a property?\n");
			System.out.println("Would you like to (4) end your turn?\n");
			int PlayerChoice = input.nextInt();
				switch(PlayerChoice){
				case 1: 
					ListOfPlayers.get(CurrentPlayer).getPropertyList();
				case 2:
					break;
				case 3:
					break;
				case 4:
					GameInProgress = false;
					break;
				}		
			
		}
		return; 		
	}
	

	public static void main(String[] args){
		boolean GameInProgress = false;
		int DiceRoll;
		
		GameSystem MonopolyGame = new GameSystem();
		
		if(GameInProgress == false){
			MonopolyGame.BeginGame();
			GameInProgress = true;
		}
		while(true){
			
		for(int i = 0; i < ListOfPlayers.size(); i ++){
			System.out.println("Greetings: " + ListOfPlayers.get(i).getName());
			System.out.println("We are rolling the dice now!");
			DiceRoll = rollDice();
			System.out.println("You received: "+ DiceRoll);
			//Leaving this out for now until we get DataBase going for certain 
			//ListOfPlayers.get(i).move(DiceRoll);
			int CurrentPlayer = i;
			
			MonopolyGame.GameManger(GameInProgress, CurrentPlayer, DiceRoll);
		
		}
		
		}
		
	}
}
		


