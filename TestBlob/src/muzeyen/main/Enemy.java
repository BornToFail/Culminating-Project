package muzeyen.main;

import java.awt.Graphics;
import java.util.Random;

public class Enemy implements Entity {

	private double x, y;
	Random r = new Random();
	
	private Texture text;
	
	public Enemy(double x, double y, Texture text){
		this.x = x;
		this.y = y;
		this.text = text;
	}
	
	public void tick(){
		y+=5;
		
		if (y>(Game.HEIGHT*Game.SCALE)){
			y = 0;
			x = r.nextInt((Game.WIDTH*Game.SCALE));
		}
	}
	
	public void render(Graphics g){
		g.drawImage(text.enemy, (int)x, (int)y, null);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}


}
