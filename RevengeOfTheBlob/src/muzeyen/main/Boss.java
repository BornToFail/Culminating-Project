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

public class Boss {
	/**
	 * 
	 */
	private double X;
	private double Y;
	
	private double XSpeed;
	private double YSpeed;
	
	private BufferedImage boss;
	
	
	public Boss(double X, double Y, Game game) {
		this.X=X;
		this.Y=Y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		boss=ss.grabImage(5, 1, 32, 32);
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
	
	public void setXSpeed(double XSpeed){
		this.XSpeed = XSpeed;
	}
	public void setVelY(double YSpeed){
		this.YSpeed = YSpeed;
	}
	
	private void Moves(){
		//Boss' movement method	
			//If boss speed is fast
				//Boss is visible
		
			//If boss speed is slow
				//Boss is only invisible when user shoots
		
				
		
			
			
		}
	
	private void Shooting(){
		//If boss shoots, player freezes for 2 seconds
	}
		

}








