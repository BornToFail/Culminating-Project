package muzeyen.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends MovingObject {
	
	private static BufferedImage enemy;
	private static BufferedImage enemy2;

	public Enemy (double x, double y, double xSpeed, double ySpeed, int right, int top) {
		super (x,y,xSpeed,ySpeed,right,top);
	}
	
	public static void setSprite(){
		SpriteSheet ss = new SpriteSheet(Game.getSpriteSheet());
		enemy = ss.grabImage(4, 1, 32, 32);
		enemy2= ss.grabImage(4, 2, 32, 32);
	}

	public void tick(){
				setX(getX() + getxSpeed());
				setY(getY() + getySpeed());

		}
		
	public static void testBorders(){
		for(int i = 0; i < Game.spawner.size(); i++){
			if(Game.spawner.get(i).getX() >= 480){
				Game.spawner.get(i).setxSpeed(-2);
			}
			else{
				Game.spawner.get(i).setxSpeed(2);
			}
			
			if(Game.spawner.get(i).getY() >= 300){
				Game.spawner.remove(i);
			}
		}
	}
	
	public static void collisionTest(){
		//Game.spawner.remove(i);
	}
		
	public void render(Graphics g) {
		g.drawImage(enemy, (int)getX(), (int)getY(), null);
		g.drawImage(enemy2, (int)getX(), (int)getY(), null);
	}

	@Override
	public void animateOneStep() {
	}

	@Override
	public void draw(Graphics g) {
	}
}
