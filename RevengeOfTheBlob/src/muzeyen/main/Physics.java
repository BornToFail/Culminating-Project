package muzeyen.main;

import java.util.ArrayList;

public class Physics {
	
	
	public static boolean Collision(EntityA entA, ArrayList<EntityB> entB){
		for (int i = 0; i< entB.size(); i++){
			if (entA.getBounds().intersects(entB.get(i).getBounds())){
				return true;
			}
		}
		return false;
	}

}
