package muzeyen.main;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.image.BufferedImage;


/**
 * 
 */

/**
 * @author 342643103
 *
 */


public class Boss implements Runnable {
	/**
	 * 
	 */
	private double x;
	private double y;
	
	private double xSpeed;
	private double ySpeed;
	
	private int left;
	private int right;
	private int top;
	private int bottom;
	
	private boolean move;
	
	private static BufferedImage boss;
	
	
	public Boss (double x, double y, double xSpeed, double ySpeed, int right, int top) {
		
	}
	
	public static void setSprite(){
		SpriteSheet ss = new SpriteSheet(Game.getSpriteSheet());
		boss = ss.grabImage(4, 1, 32, 32);
	}
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	
	public void setXSpeed(double xSpeed, double rate){
		this.xSpeed = xSpeed*rate;
	}
	public void setVelY(double ySpeed, double rate){
		this.ySpeed = ySpeed*rate;
	}
	
	
	private void Shooting(double speed){
		//If boss shoots, player freezes for 2 seconds
		/*For shooting
		 * Loop that detects increasing angles of some
		 * kind and shoots bullets every x degrees.
		 * Bullets travel in straight lines.
		 */
	}
	
	public void run() {
		while (move) {
			x += xSpeed;
			y += ySpeed;
			if (x >= right | x <= left){
				//XSpeed *= -1;
				x = left;
			}
			if (x >= left | x <= right){
				x = right;
			}
			if (y >= bottom | y <= top){
				//YSpeed *= -1;
				y = top;
			}
			if (y >= top | y <= bottom){
				y = bottom;
			}			
		}
	}
}
