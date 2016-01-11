package muzeyen.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends MovingObject {
	
	
	private static BufferedImage enemy;
	//static ArrayList<Enemy> spawner = new ArrayList<Enemy>();

	public Enemy (double x, double y, double xSpeed, double ySpeed) {
		super (x,y,xSpeed,ySpeed);

		
		
	}
	
	public static void setSprite(){
		SpriteSheet ss = new SpriteSheet(Game.getSpriteSheet());
		enemy = ss.grabImage(4, 1, 32, 32);

	}

	public void tick(){
		setX(getX() + getxSpeed());
		setY(getY() + getySpeed());
	}
	

	public void render(Graphics g) {
		g.drawImage(enemy, (int)getX(), (int)getY(), null);
	}

	@Override
	public void animateOneStep() {
	}

	@Override
	public void draw(Graphics g) {
	}
}
