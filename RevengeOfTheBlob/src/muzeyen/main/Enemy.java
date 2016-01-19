package muzeyen.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends MovingObject {
	
	
	private static BufferedImage enemy;
	//static ArrayList<Enemy> spawner = new ArrayList<Enemy>();

	public Enemy (double x, double y, double xSpeed, double ySpeed, int right, int top) {
		super (x,y,xSpeed,ySpeed,right,top);
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

	//	public static void testBorders(){
//		for(int i = 0; i < Game.spawner.size(); i++){
//			if(Game.spawner.get(i).getX() >= 480){
//				Game.spawner.get(i).setxSpeed(-2);
//			}
//			else{
//				Game.spawner.get(i).setxSpeed(2);
//			}
//
//			if(Game.spawner.get(i).getY() >= 300){
//				Game.spawner.remove(i);
//			}
//		}
//	}

//	public static void playercollisionTest(){
//
//		if (cooldown == false){
//			System.out.print("cooldown not in effect");
//			for (int i = 0; i<Game.spawner.size() && cooldown == false; i++){
//				double distance = Math.sqrt((Game.p.getX()-Game.spawner.get(i).getX())*(Game.p.getX()-Game.spawner.get(i).getX())-((Game.p.getY()-Game.spawner.get(i).getY()*(Game.p.getY()-Game.spawner.get(i).getY()))));
//				if (distance < 32){
//					Player.lives --;
//					Game.spawner.remove(i);
//					System.out.println("Collided");
//					cooldown = true;
//				}
//			}
//
//		}
//		else{
//			if(System.currentTimeMillis() - timer > 10000){
//				System.out.println("cooldown in effect");
//				cooldown = false;
//			}
//		}
//	}
	public void animateOneStep() {
	}

	@Override
	public void draw(Graphics g) {
	}
}