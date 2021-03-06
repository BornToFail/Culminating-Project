package muzeyen.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player {
	
	private static double x; //x-cord of player
	private static double y; //y-cord of player
	private int s; //Sprite position of player
	
	//used to make movement smother 
	private double velX = 0;
	private double velY = 0;
	public static int lives = 3;
	public static int bombs = 3;
	public static int selectedCharacter = 1;
	private static BufferedImage player;
	static SpriteSheet ss = new SpriteSheet(Game.getSpriteSheet());
	static SpriteSheet ssk = new SpriteSheet(Game.getSpriteSheetK());
	
	public Player(double x, double y, int s, Game game){
		
		//initialize player and sets x and y c-cord
		this.x = x;
		this.y = y;
		this.s = s;

		//received from getter method in Game class
		
	}
	

	
	public static void setSprite(){


		
		if (Game.konami == true){
			player = ssk.grabImage(1, 1, 32, 32);
		}
		else{
			player = ss.grabImage(1, selectedCharacter, 32, 32);
		}
		
	}
	public static void tiltRight(){
		player = ss.grabImage(3,selectedCharacter,32,32);
	}
	public static void tiltLeft(){
		player = ss.grabImage(2,selectedCharacter,32,32);
	}
	
	//update method
	public void tick(){
		x+=velX;
		y+=velY;
		
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
	
	//draw image method
	public void render(Graphics g){
		
		g.drawImage(player, (int)x, (int)y, null);
		
	}
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public int getS(){
		return s;
	}
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	public void setS(int s){
		this.s = s;
	}
	
	public void setVelX(double velX){
		this.velX = velX;
	}
	public void setVelY(double velY){
		this.velY = velY;
	}

}
