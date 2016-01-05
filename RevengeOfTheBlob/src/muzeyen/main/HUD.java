package muzeyen.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class HUD {
	public static  Rectangle hudFrame = new Rectangle(160,481, 500, 0);
	

	
	public static void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		Font fntL = new Font("arial", Font.BOLD, 15);
//		Font fntSub = new Font("arial",Font.ITALIC ,25);
		Font fntBTF = new Font("arial",Font.ITALIC ,10);
//
    	g.setFont(fntL);
		g.setColor(Color.WHITE);
		
		String livesLeft = "";
		if (Player.lives == 3){
			livesLeft = "* * *";
	
		}else if (Player.lives == 2){
			livesLeft ="* *";
	
		}else if (Player.lives == 1){
			livesLeft ="*";
		}
		g.drawString("Lives "+ livesLeft, 510, 175);
		g.drawString("Bombs "+ Player.bombs, 510, 225);
		g.drawString("Time "+ Game.hudTimer/100, 510, 275);
    	g.setFont(fntBTF);

	    g.drawString("Game © Born To Fail 2016 ", 520, 475);

//		g.setFont(fntSub);
		//g.drawString("Play", playButton.x+25,playButton.y+33);
		//g.drawString("Settings", settingsButton.x+25,settingsButton.y+33);
		//g.drawString("Quit", quitButton.x+25,quitButton.y+33);
		g2d.draw(hudFrame);
		
		
	}
}

