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
//Start a counter when the boss level starts.
/*Timer T=new Timer();
T.scheduleAtFixedRate(new TimerTask() {         
                @Override
                public void run() {
                    runOnUiThread(new Runnable()
                    {

                        public void run()
                        {
                            countdown.setText(""+count);
                            count++;                
                        }
                    });
                }
            }, 1000, 1000);
*/

//T.cancel();

public class Boss implements Runnable {
	/**
	 * 
	 */
	private double x;
	private double y;
	
	private double XSpeed;
	private double YSpeed;
	
	private int left;
	private int right;
	private int top;
	private int bottom;
	
	private boolean bshooting = false;
	
	private boolean move;
	
	private BufferedImage boss;
	
	
	public Boss(double X, double Y, Game game) {
		this.x=x;
		this.y=y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		boss=ss.grabImage(5, 1, 32, 32);
	}
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void setX(double X){
		this.x = x;
	}
	public void setY(double Y){
		this.y = y;
	}
	
	public void setXSpeed(double XSpeed, double rate){
		this.XSpeed = XSpeed*rate;
	}
	public void setVelY(double YSpeed, double rate){
		this.YSpeed = YSpeed*rate;
	}
	
	
	private void Shooting(double speed){
		bshooting = true;
		
		//If boss shoots, player freezes for 2 seconds
		/*For shooting
		 * Loop that detects increasing angles of some
		 * kind and shoots bullets every x degrees.
		 * Bullets travel in straight lines.
		 */
	}
	
	public Boss(double x, double y, int left, int right, int top,
			int bottom) {
		this.XSpeed = 0;
		this.YSpeed = 0;
		this.x = x;
		this.y = y;
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
		startThread();
	}
	
	public void startThread() {
		move = true;
		Thread t = new Thread(this);
		t.start();
	}
	
	public void stopThread() {
		move = false;
	}
	
	public void run() {
		while (move) {
			x += XSpeed;
			y += YSpeed;
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
	
	//update method
		public void tick(){
			x+=XSpeed;
			y+=YSpeed;
			
			//prevents player from leaving the screen
			if(x <= 0){
				x=0;
			}
			if(x>=640-172){ //-20 was a result of trial and error
				x=640-172;
			}
			if(y <= 0){
				y=0;
			}
			if(y>=480-32){ //-32 was a result of trial and error
				y=480-32;
			}
		}
	
	

	

		

}


