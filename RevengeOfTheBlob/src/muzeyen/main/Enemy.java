package muzeyen.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Enemy {
	
	private double X;
	private double Y;
	
	private double VELX;
	private double VELY;
	
	private BufferedImage enemy;

	public Enemy(double X, double Y, Game game) {
		this.X=X;
		this.Y=Y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		enemy=ss.grabImage(1, 5, 32, 32);
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
}
