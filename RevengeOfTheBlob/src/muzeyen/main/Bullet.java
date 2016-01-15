package muzeyen.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet implements Entity {
	
	private double x;
	private double y;
	
	private Texture text;
	
	public Bullet(double x, double y, Texture text){
		this.x = x;
		this.y = y;	
		this.text = text;

	}
	
	public void tick(){
		y-=10;
	}
	public void render(Graphics g){
		g.drawImage(text.missile, (int)x, (int)y, null);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	

}
