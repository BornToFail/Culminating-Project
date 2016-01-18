package muzeyen.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Controller {

	ArrayList<EntityA> eA = new ArrayList<EntityA>();
	ArrayList<EntityB> eB = new ArrayList<EntityB>();

	EntityA entA;
	EntityB entB;
	private Texture text;
	

	public Controller(Game game, Texture text) {
		this.text = text;
		addEntity(new Enemy(100, 100, text));
	}

	public void tick(){
		//A class
		for(int i = 0; i < eA.size(); i++){
			entA = eA.get(i);

			entA.tick();
		}
		
		//B class
		for(int i = 0; i < eB.size(); i++){
			entB = eB.get(i);

			entB.tick();
		}
	}

	public void render (Graphics g){

		//A class
		for(int i = 0; i < eA.size(); i++){
			entA = eA.get(i);

			entA.render(g);
		}
		
		//B class
				for(int i = 0; i < eB.size(); i++){
					entB = eB.get(i);

					entB.render(g);
				}
	}

	public void addEntity(EntityA param){
		eA.add(param);
	}
	public void removeEntity(EntityA param){
		eA.remove(param);
	}
	
	public void addEntity(EntityB param){
		eB.add(param);
	}
	public void removeEntity(EntityB param){
		eB.remove(param);
	}


	public ArrayList<EntityA> getEntityA(){
		return eA;
	}
	
	public ArrayList<EntityB> getEntityB(){
		return eB;
	}


}
