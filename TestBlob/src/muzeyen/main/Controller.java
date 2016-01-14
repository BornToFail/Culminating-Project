package muzeyen.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Controller {

	ArrayList<Entity> e = new ArrayList<Entity>();

	Entity ent;
	private Texture text;
	

	public Controller(Game game, Texture text) {
		this.text = text;
		addEntity(new Enemy(100, 100, text));
	}

	public void tick(){
		for(int i = 0; i < e.size(); i++){
			ent = e.get(i);

			ent.tick();
		}
	}

	public void render (Graphics g){

		for(int i = 0; i < e.size(); i++){
			ent = e.get(i);

			ent.render(g);
		}
	}

	public void addEntity(Entity param){
		e.add(param);
	}
	public void removeEntity(Entity param){
		e.remove(param);
	}



}
