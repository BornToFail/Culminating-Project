package muzeyen.main;

import java.awt.image.BufferedImage;

public class Texture {
	
	public BufferedImage player, missile, enemy;
	private SpriteSheet ss;
	
	public Texture(Game game){
		ss = new SpriteSheet(game.getSpriteSheet());
		
		getTexture();
	}

	private void getTexture(){
		//**col, row, width, height
		player = ss.grabImage(1, 1, 32, 32); //grabs player sprite
		missile = ss.grabImage(2, 1, 32, 32); //grabs bullet sprite
		enemy = ss.grabImage(3, 1, 32, 32); //grabs enemy sprite
	}
}
