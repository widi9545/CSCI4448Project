import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameBoard {
	public static void main(String[] args) throws IOException {
		JFrame frame = buildFrame();
		final BufferedImage image = ImageIO.read(new File("board.jpg"));
		
		JPanel pane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g.drawImage(image, 0, 0, null);			
			}
		};
		frame.add(pane);
		
	}
	
	private static JFrame buildFrame(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(true);
		return frame;
	}
	

}
