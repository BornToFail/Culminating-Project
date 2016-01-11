package muzeyen.main;

import java.awt.Graphics;

/**
 * 
 * @author 322211632
 *Adapted from Christina Kemp
 */

public abstract class MovingObject implements Runnable {
	
	private double x;
	private double y;
	
	private double xSpeed;
	private double ySpeed;
	
	private int PauseDuration;
	
	private boolean moving;

	public MovingObject(double x, double y, double xSpeed, double ySpeed) {
		this.PauseDuration = 40;
		
		this.setxSpeed(0);
		this.setySpeed(0);
		
		this.x=x;
		this.y=y;
		StartThread();
		
	}
	
	
	public void StartThread(){
		moving=true;
		Thread t = new Thread(this);
		t.start();
	}
	
	public void StopThread(){
		moving=false;
	}
	
	public void run() {
		while (moving) {
			animateOneStep();
			x += getxSpeed();
			y += getySpeed();
			//if (x >= right | x <= left)
				//xSpeed *= -1;
			//if (y >= bottom | y <= top)
				//ySpeed *= -1;
			try {
				Thread.sleep(PauseDuration);
			} catch (InterruptedException e) {
			}
		}
	}

	abstract public void animateOneStep();
	
	abstract public void draw(Graphics g);
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y){
		this.y=y;
	}
	
	public double getxSpeed() {
		return xSpeed;
	}


	public void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}


	public double getySpeed() {
		return ySpeed;
	}


	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	
	
	
}
