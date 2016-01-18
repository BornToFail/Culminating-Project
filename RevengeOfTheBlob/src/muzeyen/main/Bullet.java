package muzeyen.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Bullet extends GameObject implements EntityA {
	

	private Texture text;
	private Game game;
	
	public Bullet(double x, double y, Texture text, Game game){
		super(x,y);
		this.text = text;
		this.game = game;

	}
	
	public void tick(){
		y-=10;
		
		if(Physics.Collision(this, game.eB)){
			System.out.println("COLLISION");
		}
	}
	
	
	public Rectangle getBounds(){
		return new Rectangle ((int)x, (int)y, 32, 32);
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
