package muzeyen.main;

import java.awt.Rectangle;

public class GameObject {
	
	
	public double x; //x-cord of player
	public double y; //y-cord of player
	
	public GameObject (double x, double y){
		this.x= x; 
		this.y = y;
	}
	
	public Rectangle getBounds(int width, int height){
		return new Rectangle ((int)x, (int)y, width, height);
	}

}
