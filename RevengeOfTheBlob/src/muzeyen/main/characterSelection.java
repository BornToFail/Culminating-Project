package muzeyen.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class characterSelection {
private BufferedImage image = new BufferedImage(Game.WIDTH,Game.HEIGHT,BufferedImage.TYPE_INT_RGB); //buffers window
private static BufferedImage titleText = null;
private static BufferedImage selectionF = null;
private static BufferedImage selectionO = null;
private static BufferedImage selectionP = null;	
public static  Rectangle backButton = new Rectangle(30,400, 200, 50);
public static Rectangle ottoButton = new Rectangle(10,50, 200, 300);
public static Rectangle fennelButton = new Rectangle(225,50, 200, 300);
public static Rectangle perditusButton = new Rectangle(440,50, 200, 300);



public static void render(Graphics g) throws IOException{

	Graphics2D g2d = (Graphics2D) g;
	
	BufferedImageLoader loader = new BufferedImageLoader();
	try{
		titleText = loader.loadImage("/characterSelectText.png");
		selectionF = loader.loadImage("/selectionF.png");
		selectionO = loader.loadImage("/selectionO.png");
		selectionP = loader.loadImage("/selectionP.png");

	}catch(IOException e){
		e.printStackTrace();	
	}

	
	Font fnt0 = new Font("arial", Font.BOLD, 40);
	Font fntSub = new Font("arial",Font.ITALIC ,25);
	Font fntBTF = new Font("arial",Font.ITALIC ,10);

	g.setFont(fnt0);
	g.setColor(Color.WHITE);	
	g.drawImage(titleText, 55, 3, null);

	g.setFont(fntBTF);
	g.drawString("Game © Born To Fail 2016 ", 520, 475);
	
	g.setFont(fntSub);
	g.drawString("Back", backButton.x+25,backButton.y+33);
	//g.drawString("Settings", settingsButton.x+25,settingsButton.y+33);
	//g.drawString("Quit", quitButton.x+25,quitButton.y+33);
	g.drawImage(selectionO, 10, 50, null);
	g.drawImage(selectionF, 225, 50, null);
	g.drawImage(selectionP, 440, 50, null);
}
public static void ottoOverlay(Graphics g){
	Font fnt = new Font("arial", Font.BOLD, 40);
	g.setFont(fnt);
	g.setColor(Color.WHITE);
	g.drawString("OTTO", 150, 325);

}
}
