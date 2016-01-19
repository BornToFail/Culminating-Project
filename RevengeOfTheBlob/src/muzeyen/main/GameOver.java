package muzeyen.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameOver {
	private BufferedImage image = new BufferedImage(Game.WIDTH,Game.HEIGHT,BufferedImage.TYPE_INT_RGB); //buffers window
	private static BufferedImage menuButton = null;
	private static BufferedImage replayButton = null;
	private static BufferedImage quitButton = null;
	private static BufferedImage gameoverText = null;

	public static void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			//menuButton = loader.loadImage("/menuButton.png");// The play button
			//replayButton = loader.loadImage("/replayButton.png");
			quitButton = loader.loadImage("/quitButton.png");
			gameoverText = loader.loadImage("/gameoverTitle.png");

		}catch(IOException e){
			e.printStackTrace();	
			Game.State = Game.STATE.G_ERROR;
		}
		g.setColor(Color.WHITE);
		g.drawString("Game © Born To Fail 2016 ", 520, 475);
		g.drawImage(gameoverText, 30, 30, null);
		//g.drawImage(menuButton, 460, 200, null);
		//g.drawImage(replayButton, 460, 300, null);
		g.drawImage(quitButton, 460, 400, null);


		
	}
	
}
