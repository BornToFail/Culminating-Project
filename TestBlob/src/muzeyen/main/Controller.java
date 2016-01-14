package muzeyen.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Controller {
	
	ArrayList<Bullet> b = new ArrayList<Bullet>();
	ArrayList<Enemy> e = new ArrayList<Enemy>();
	
	Random r = new Random();
	
	Bullet tempBullet;
	Enemy tempEnemy;
	
	Game game;
	Texture text;
	
	public Controller(Game game, Texture text){
		this.game = game;
		this.text = text;
		
		addEnemy (new Enemy(r.nextInt(Game.WIDTH*Game.SCALE),0,text));
	}
	
	public void tick(){
		for (int i = 0; i<b.size(); i++){
			tempBullet = b.get(i);

			//destroys bullet once its off the screen
			if(tempBullet.getY() <0){
				removeBullet(tempBullet);
			}

			tempBullet.tick();
		}
		
		for (int i = 0; i<e.size(); i++){
			tempEnemy = e.get(i);

			tempEnemy.tick();
		}
	}

	public void render (Graphics g){
		for (int i = 0; i<b.size(); i++){
			tempBullet = b.get(i);
			
			tempBullet.render(g);
		}
		for (int i = 0; i<e.size(); i++){
			tempEnemy = e.get(i);
			
			tempEnemy.render(g);
		}
	}
	
	public void addBullet (Bullet block){
		b.add(block);
	}
	public void removeBullet(Bullet block){
		b.remove(block);
	}
	
	public void addEnemy (Enemy block){
		e.add(block);
	}
	public void removeEnemy(Enemy block){
		e.remove(block);
	}
	
	
}
