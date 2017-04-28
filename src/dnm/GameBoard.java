package dnm;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;


public class GameBoard extends JFrame {
	
	private MonopolyPanel newPane;
	JFrame frame = new JFrame("Gameboard");
	//permission bit for updating the gameboard!
	public Boolean refresh = false;
	
	public void displayGUI(int NumberOfPlayers){
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newPane = new MonopolyPanel(40,40,NumberOfPlayers);
		frame.setContentPane(newPane);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
	
	public void updateGUI(int x, int y){
		refresh = true;
		MonopolyPanel updatePane = new MonopolyPanel(x,y);
		frame.add(updatePane);
	}

	private class MonopolyPanel extends JPanel {
		private BufferedImage gameBoard;
		public Graphics2D g2;
		public int x;
		public int y;
		public int NumberOfPlayers;
		public ArrayList<Rectangle2D> PlayerPositions = new ArrayList<Rectangle2D>();
		public Color color = Color.blue;
		
		
		@SuppressWarnings("unused")
		//Initial formulation - we initialize the x and y coordinates of the players (have to mess with this) and
		//then initialize a list that we will use to keep track of positions - still messing with this! very beta stages!
		public MonopolyPanel(int _x, int _y, int NumberOfPlayers) {
			setCoordinates(_x, _y);
			setNumberOfPlayers(NumberOfPlayers);
			InitializePositions();
			try{ 
			gameBoard = ImageIO.read(MonopolyPanel.class.getResource("board.jpg"));
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
			
		}
		
		public MonopolyPanel(int _x, int _y) {
			setCoordinates(_x, _y);
			try{ 
			gameBoard = ImageIO.read(MonopolyPanel.class.getResource("board.jpg"));
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
			
		}
		
		
		public void setCoordinates(int _x, int _y){
			this.x = _x;
			this.y = _y;
		}
		public void setNumberOfPlayers(int _n){
			this.NumberOfPlayers = _n;
		}
		public void InitializePositions(){
			for(int i = 0; i < NumberOfPlayers; i ++){
				Rectangle2D position = new Rectangle2D.Double(x,y, 5, 5);
				PlayerPositions.add(position);
			}
		}
		
		
		@Override
		public Dimension getPreferredSize(){
			return gameBoard == null ? new Dimension(100, 100): new Dimension(800, 818);
		}

		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(gameBoard, 0, 0, this);
			if(refresh == true){
				g2 = (Graphics2D)g;
				Rectangle2D position = new Rectangle2D.Double(x,y,5,5);
				g2.setColor(color);
				g2.setStroke(new BasicStroke(20));
				g2.draw(position);
			}
			
		}


	}
	

}

		



