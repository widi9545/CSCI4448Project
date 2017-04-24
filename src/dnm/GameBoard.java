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


public class GameBoard {
	
	private MonopolyPanel newPane;
	
	private void displayGUI(){
		JFrame frame = new JFrame("GameBoard");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newPane = new MonopolyPanel();
		frame.setContentPane(newPane);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
	
	

	private class MonopolyPanel extends JPanel {
		private BufferedImage gameBoard;
		public MonopolyPanel() {
			try{ 
			gameBoard = ImageIO.read(MonopolyPanel.class.getResource("board.jpg"));
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
		
	}
		@Override
		public Dimension getPreferredSize(){
			return gameBoard == null ? new Dimension(100, 100): new Dimension(800, 818);
		}
		
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(gameBoard, 0, 0, this);
		}
	}
	
	public static void main(String[] args){
		Runnable runnable = new Runnable(){
			public void run(){
				new GameBoard().displayGUI();
			}
			};
			EventQueue.invokeLater(runnable);
		
	}
	
}
		



