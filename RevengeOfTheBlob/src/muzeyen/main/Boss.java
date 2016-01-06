package muzeyen.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


/**
 * 
 */

/**
 * @author 342643103
 *
 */
public class Boss {
	/**
	 * 
	 */
	private double X;
	private double Y;
	
	private BufferedImage boss;
	
	private void Moves(){
	//Boss' movement method	
		
	
		
		
	}
	
	public Boss(double X, double Y, Game game) {
		this.X=X;
		this.Y=Y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		//boss=ss.grabImage(1, 5, 32, 32);
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
	

}








