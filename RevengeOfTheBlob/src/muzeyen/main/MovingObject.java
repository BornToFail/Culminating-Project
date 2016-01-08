package muzeyen.main;

import java.awt.Graphics;

/**
 * 
 * @author 322211632
 *Adapted from Christina Kemp
 */

public abstract class MovingObject implements Runnable {
	
	protected double x;
	protected double y;
	
	protected double xSpeed;
	protected double ySpeed;
	
	private int PauseDuration;
	
	private boolean moving;

	public MovingObject(double x, double y, double xSpeed, double ySpeed) {
		this.PauseDuration = 40;
		
		this.xSpeed=0;
		this.ySpeed=0;
		
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
			x += xSpeed;
			y += ySpeed;
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
	
	
}
