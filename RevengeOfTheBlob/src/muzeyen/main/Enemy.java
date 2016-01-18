package muzeyen.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

//implements Entity
public class Enemy extends GameObject implements EntityB {

	Random r = new Random();
	
	private Texture text;
	
	public Enemy(double x, double y, Texture text){
		super(x,y);
		this.text = text;
	}
	
	public void tick(){
		y+=5;
		
		if (y>(Game.HEIGHT*Game.SCALE)){
			y = 0;
			x = r.nextInt(((Game.WIDTH*Game.SCALE))-192);
		}
	}
	
	public void render(Graphics g){
		g.drawImage(text.enemy, (int)x, (int)y, null);
	}
	
	public Rectangle getBounds(){
		return new Rectangle ((int)x, (int)y, 32, 32);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}


}
