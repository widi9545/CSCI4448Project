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


public class GameBoard extends JFrame {
	
	private MonopolyPanel newPane;
	JFrame frame = new JFrame("Gameboard");
	public Boolean refresh = false;
	
	public void displayGUI(){
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newPane = new MonopolyPanel(40,40,40,40);
		frame.setContentPane(newPane);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
	
	public void updateGUI(int x, int y,int h, int z){
		refresh = true;
		MonopolyPanel updatePane = new MonopolyPanel(x,y,h,z);
		frame.add(updatePane);
	}

	private class MonopolyPanel extends JPanel {
		private BufferedImage gameBoard;
		public Graphics2D g2;
		public int x;
		public int y;
		public int h;
		public int z;
		public Color color = Color.blue;
		
		
		@SuppressWarnings("unused")
		public MonopolyPanel(int _x, int _y, int _h, int _z) {
			setCoordinates(_x, _y, _h, _z);
			try{ 
			gameBoard = ImageIO.read(MonopolyPanel.class.getResource("board.jpg"));
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
		}
		public void setCoordinates(int _x, int _y, int _h, int _z){
			this.x = _x;
			this.y = _y;
			this.h = _h;
			this.z = _z;
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
				Line2D line = new Line2D.Double(x,y,h,z);
				g2.setColor(color);
				g2.setStroke(new BasicStroke(10));
				g2.draw(line);
			}
			
		}


	}
	

}

		



