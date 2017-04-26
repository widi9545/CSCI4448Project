package dnm;

import java.awt.EventQueue;
import java.util.Scanner;
import java.util.ArrayList;


public class GameSystem {
	
	public static int NumberOfPlayers;
	public static int StartingCash;
	//Adding in a Player List for us to use - this will make it way easier for us to iterate down and perform operations on the players
	public static ArrayList<Player> ListOfPlayers = new ArrayList<Player>();
	
	public static int SetCash(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the starting amount of cash\n");
		StartingCash = input.nextInt();
		return StartingCash;
	}
	
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
		// an example of how retrieving through the ArrayList works. ListOfPlayers.get(0).setCash(5000);
		Runnable runnable = new Runnable(){
			public void run(){
				new GameBoard().displayGUI();
			}
			};
			EventQueue.invokeLater(runnable);
	}
	
	public static void main(String[] args){
		GameSystem.BeginGame();

	}
		

}
