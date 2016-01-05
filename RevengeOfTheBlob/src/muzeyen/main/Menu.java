package muzeyen.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
public  Rectangle playButton = new Rectangle(500,200, 200, 50);
public  Rectangle settingsButton = new Rectangle(500,300, 200, 50);
public  Rectangle quitButton = new Rectangle(500,400, 200, 50);

public void render(Graphics g){
	Graphics2D g2d = (Graphics2D) g;
	
	Font fnt0 = new Font("arial", Font.BOLD, 100);
	Font fntSub = new Font("arial",Font.ITALIC ,25);
	Font fntBTF = new Font("arial",Font.ITALIC ,10);

	g.setFont(fnt0);
	g.setColor(Color.WHITE);
	g.drawString("TEST", 375, 100);
	g.setFont(fntSub);
	g.drawString(">>Main Menu", 400, 150);
	g.setFont(fntBTF);
	g.drawString("Game © Born To Fail 2016 ", 520, 475);

	g.setFont(fntSub);
	g.drawString("Play", playButton.x+25,playButton.y+33);
	g.drawString("Settings", settingsButton.x+25,settingsButton.y+33);
	g.drawString("Quit", quitButton.x+25,quitButton.y+33);
	g2d.draw(playButton);
	g2d.draw(settingsButton);
	g2d.draw(quitButton);
	
	
}
}
