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

//The base of this code was cited from two StackOverflow forum questions, as neither of us had real experience dealing
//with graphics in Java before - the url for the forum post is here, and is also in a file called
//ResourcesUsedInProject.txt on the GitHub repo
// http://stackoverflow.com/questions/21970879/java-cant-draw-an-image-from-file
// http://stackoverflow.com/questions/17865465/how-do-i-draw-an-image-to-a-jpanel-or-jframe

public class GameBoard extends JFrame {
	
	private MonopolyPanel newPane;
	JFrame frame = new JFrame("Gameboard");
	
	
	public void displayGUI(int NumberOfPlayers){
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newPane = new MonopolyPanel(675,625,NumberOfPlayers);
		frame.setContentPane(newPane);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
	
	public void updateGUI(int x, int y){
		MonopolyPanel updatePane = new MonopolyPanel(x,y);
		frame.add(updatePane);
		frame.revalidate();
		frame.repaint();
	}

	private class MonopolyPanel extends JPanel {
		private BufferedImage gameBoard;
		public Graphics2D g2;
		public int x;
		public int y;
		public int NumberOfPlayers;
		public boolean refresh = false;
		public ArrayList<Rectangle2D> PlayerPositions = new ArrayList<Rectangle2D>();
		public Color color = Color.blue;
		
		
		@SuppressWarnings("unused")
		//Initial formulation - we initialize the x and y coordinates of the players (have to mess with this) and
		//then initialize a list that we will use to keep track of positions - still messing with this! very beta stages!
		public MonopolyPanel(int _x, int _y, int NumberOfPlayers) {
			setCoordinates(_x, _y);
			setNumberOfPlayers(NumberOfPlayers);
			try{ 
			gameBoard = ImageIO.read(MonopolyPanel.class.getResource("board.jpg"));
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
			
		}
		
		
		public MonopolyPanel(int _x, int _y) {
			setCoordinates(_x, _y);
			this.refresh = true;
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
		
		@Override
		public Dimension getPreferredSize(){
			return gameBoard == null ? new Dimension(100, 100): new Dimension(800, 818);
		}

		public void paintComponent(Graphics g){
			g2 = (Graphics2D)g;
			Rectangle2D position;
			
			super.paintComponent(g);
			g.drawImage(gameBoard, 0, 0, this);
			
			if(refresh == false){
				position = new Rectangle2D.Double(650, 650, 5, 5);
				g2.setColor(color);
				g2.setStroke(new BasicStroke(20));
				g2.draw(position);
			}
			if(refresh == true){
				position = new Rectangle2D.Double(x, y, 5, 5);
				g2.setColor(color);
				g2.setStroke(new BasicStroke(20));
				g2.draw(position);
			}
			
		}


	}
	

}

		



