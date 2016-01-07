package muzeyen.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy {
	
	private double X;
	private double Y;
	
	private double VELX;
	private double VELY;
	
	private static BufferedImage enemy;
	//static ArrayList<Enemy> spawner = new ArrayList<Enemy>();

	public Enemy(double X, double Y, Game game) {
		this.X=X;
		this.Y=Y;
		
		
	}
	
	public static void setSprite(){
		SpriteSheet ss = new SpriteSheet(Game.getSpriteSheet());
		enemy = ss.grabImage(5, 1, 32, 32);

	}

	public void tick(){
		X+=VELX;
		Y+=VELY;
	}
	
	public double getX(){
		return X;
	}
	public double getY(){
		return Y;
	}
	public void setX(double X){
		this.X = X;
	}
	public void setY(double Y){
		this.Y = Y;
	}
	
	public void setVelX(double VELX){
		this.VELX = VELX;
	}
	public void setVelY(double VELY){
		this.VELY = VELY;
	}

	public void render(Graphics g) {
		g.drawImage(enemy, (int)X, (int)Y, null);
	}
}
