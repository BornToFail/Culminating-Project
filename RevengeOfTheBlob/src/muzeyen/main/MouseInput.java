package muzeyen.main;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import muzeyen.main.Game.STATE;
public class MouseInput implements MouseListener {

	@Override
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		// TODO Auto-generated method stub
		
			
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		// TODO Auto-generated method stub
		/**
    public  Rectangle playButton = new Rectangle(500,200, 200, 50);
	public  Rectangle settingsButton = new Rectangle(500,300, 200, 50);
	public  Rectangle quitButton = new Rectangle(500,400, 200, 50);
		 */
		if (Game.State == STATE.MENU){
			if(mx >= 500 && mx <= 700){
				if(my >= 200 && my <= 250){
					//Pressed Play button
					Game.State = Game.STATE.SELECT;
				}
			}
		
			if(mx >= 500 && mx <= 700){
				if(my >= 300 && my <= 350){
					//Pressed settings button
					Game.State = Game.STATE.SETTINGS;
				}
			}
			if(mx >= 500 && mx <= 700){
				if(my >= 400 && my <= 450){
					//Pressed quit button
					System.exit(1);
				}
			}
		}
		if (Game.State == STATE.SELECT){

			if(mx >= 30 && mx <= 230){
				if(my >= 400 && my <= 450){
					//Pressed Back button
					Game.State = Game.STATE.MENU;
				}
			}
			if(mx >= 10 && mx <= 210){
				if(my >= 50 && my <= 350){
					Player.selectedCharacter = 1;
					Player.setSprite();
					Game.State = Game.STATE.GMSELECT;
				}
			}
			if(mx >= 225 && mx <= 425){//Tests if the user selects fennel
				if(my >= 50 && my <= 350){
					Player.selectedCharacter = 2;
					Player.setSprite();
					Game.State = Game.STATE.GMSELECT;
				}
			}
			if(mx >= 445 && mx <= 500){//Tests if the user selects Perditus 
				if(my >= 50 && my <= 350){
					Player.selectedCharacter = 3;
					Player.setSprite();
					Game.State = Game.STATE.GMSELECT;
				}
			}
		}
		if (Game.State == STATE.GMSELECT){
			if(mx >= 30 && mx <= 230){
				if(my >= 400 && my <= 450){
					//Pressed Back button
					System.out.println("Iwork");
					Game.State = Game.STATE.SELECT;
				}
			}
			if(mx >= 400 && mx <= 551){
				if(my >= 125 && my <= 146){
					//Pressed "MEDIUM SURVIVAL" button
					System.out.println("Iwork");
					Game.State = Game.STATE.GAME;
				}
			}
			if(mx >= 400 && mx <= 551){
				if(my >= 225 && my <= 246){
					//Pressed "HARD SURVIVAL" button
					Game.State = Game.STATE.GAME;
				}
			}
			if(mx >= 400 && mx <= 551){
				if(my >= 325 && my <= 346){
					//Pressed "HARD SURVIVAL" button
					Game.State = Game.STATE.GAME;
				}
			}
		}

		if (Game.State == STATE.SETTINGS){
			if(mx >= 30 && mx <= 230){
				if(my >= 400 && my <= 450){
					//Pressed Play button
					Game.State = Game.STATE.MENU;
				}
			}
		}
	
		if (Game.State == STATE.PAUSE){
				if(mx >= 250 && mx <= 400){
					if(my >= 300 && my <= 350){
						//Pressed Resume button button
						Game.paused = false;
						Game.State = Game.STATE.GAME;
					
					}
				}
				if(mx >= 250 && mx <= 400){
					if(my >= 400 && my <= 450){
						//Pressed Exit button
						System.exit(1);
					}
				}
			}
		}
		
	
	
		
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int mx = e.getX();
		int my = e.getY();

	}
	
}
