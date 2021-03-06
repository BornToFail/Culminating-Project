package muzeyen.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	//standard JFrame dimensions
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH/12*9;
	public static final int SCALE = 2;
	public final String TITLE = "Revenge of the Blob"; //title
	public static int hudTimer = 0;
	private boolean running = false;
	private Thread thread;
	private Menu menu;
	static boolean paused = false;
	public static int FPS;
	public static boolean sounds = true;
	public static boolean music = true;
	static Random generator = new Random();
	static int randSpawn = generator.nextInt(200)+ 1;
	public static enum STATE{
		MENU,
		SELECT, //Character Selection menu
		GMSELECT,//Game Mode Selection menu
		CUTSCENE_1,
		SETTINGS,
		GAME,
		PAUSE, 
		HIGHSCORE,
		GAMEOVER,
		G_ERROR
	}
	
	public static STATE State = STATE.MENU;

	private static BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB); //buffers window
	private static BufferedImage spriteSheet = null;
	private static BufferedImage spriteSheetK = null;
	private static BufferedImage background = null;
	private static BufferedImage menuBG_1 = null;
	private static BufferedImage fennelSplash = null;
	private static BufferedImage pauseOverlay = null;
	private static BufferedImage selectionBG = null;
	

	private BufferedImage hudRight = null;
	boolean shooting = false;
	public static boolean konami = false;
	int[] sequence = {38, 38, 40, 40, 37, 39, 37, 39, 66, 65};
	int currentButton = 0;
	public static Player p;
	public static Boss b;
	static Controller c;

	private Controller testC;

	static ArrayList<Enemy> spawner = new ArrayList<Enemy>();
	
	
	//initialize
	public void init(){
		requestFocus(); //makes it so user doesn't have to press game to begin playing when it launces
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			spriteSheet = loader.loadImage("/sprite_sheet_new.png");
			spriteSheetK = loader.loadImage("/sprite_sheet.png");
			background = loader.loadImage("/background.png");
			menuBG_1 = loader.loadImage("/menuBackground_1.png");
			selectionBG = loader.loadImage("/selectionBackground_1.png");
			fennelSplash = loader.loadImage("/fennel.png");
			pauseOverlay = loader.loadImage("/pauseOverlay.png");

			hudRight = loader.loadImage("/HUD_Side_Display.png");

		}catch(IOException e){
			Game.State = Game.STATE.G_ERROR;
			e.printStackTrace();	
		}

		addKeyListener(new KeyInput(this));
		
		p = new Player(300,400, 1 ,this); //initializes player with x-cord and y-cord 200 and the state of the player sprite\
		c = new Controller(this);
		//b = new Boss();
		testC = new Controller(this);
		menu = new Menu();
		
		fennelSplash.getScaledInstance(fennelSplash.getWidth()/3, fennelSplash.getHeight()/3, Image.SCALE_DEFAULT);

		this.addMouseListener(new MouseInput());
	}


	//starts up initialized thread
	private synchronized void start(){
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}
                
	private synchronized void stop(){  //sync deals with threads
		if(!running)
			return;

		running = false;
		try {
			thread.join(); //joins all threads together and waits for them to terminate
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	
	public static void EnemyBehaviour(){
		if(State == STATE.GAME ){
			for (int i=0;i<8;i++){	
				spawner.add(new Enemy(randSpawn,0,0,0,400,0));
				spawner.get(i).setxSpeed(2);
				spawner.get(i).setySpeed(2);
			}

		}

	}
	
	public static void BossBehaviour(){
		if(State == STATE.GAME){
			
		}
	}


	//whenever a thread is called, runnable will call run
	public void run(){
		//game loop - handles updates until game is exited 
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0; //updates 60 times every time it goes through
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();	

		while (running){
			long now = System.nanoTime();
			delta+= (now - lastTime) / ns;
			lastTime = now;
			if (delta >=1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (State == STATE.GAME){
				//Enemy.testBorders();
				//Enemy.playercollisionTest();
				EnemyBehaviour();
			}
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + " Ticks, FPS " + frames);
			    FPS = frames;
				updates = 0;
				frames = 0;
			}
//			for (int i=0;i<8;i++){
//				if (spawner.get(i).getX()-5<=p.getX()&&spawner.get(i).getX()+5>=p.getX()&&spawner.get(i).getY()-32<=p.getY()&&spawner.get(i).getY()+32>=p.getY()){
//					Player.lives--;
//				}
//			}
		}
		stop();
	}

	//everything that updates
	private void tick(){
		if (State == STATE.GAME){
		p.tick();
		c.tick();
		hudTimer++;
	
		if ((hudTimer % 200)==0){
			if (spawner.size() < 10){
				EnemyBehaviour();
			}
		}
		
		}else if(State == STATE.PAUSE){
			//paused
		}
	}

	//everything that renders
	private void render (){

		BufferStrategy bs = this.getBufferStrategy(); //handles buffering behind the scenes, this refers to canvas
		if (bs == null){
			createBufferStrategy(3); //3 means triple buffering (loads 2 images in "stock/supply"), increases performance
			return;
		}

		Graphics g = bs.getDrawGraphics(); //draws out buffers
		//////////////////////////////
		if (State == STATE.GAME){

		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(background, 0, 0, null);
		g.drawImage(hudRight, 500, 0, null);
		HUD.render(g);
	
		p.render(g);
		c.render(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(background, 0, 0, null);
		g.drawImage(hudRight, 500, 0, null);
		HUD.render(g);
		for (int i = 0; i < spawner.size(); i++){
			spawner.get(i).render(g);
		}
	
			p.render(g);
			c.render(g);
			testC.render(g);

		}else if (State == STATE.CUTSCENE_1){
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			g.drawImage(background, 0, 0, null);
			g.drawImage(hudRight, 500, 0, null);
			HUD.render(g);
			cutScenes.render(g);

			p.render(g);
			c.render(g);

		}else if (State == STATE.MENU){//If it's the MENU state, it will display the menu
			g.drawImage(menuBG_1, 0, 0, null);
			g.drawImage(fennelSplash, 50, 100, null);
			menu.render(g);
		}else if (State == STATE.SELECT){//If it's the MENU state, it will display the menu
			if (konami == true){
				Game.State = Game.STATE.GAME;
			}
			else{
				g.drawImage(selectionBG, 0, 0, null);
				try {
					characterSelection.render(g);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}else if (State == STATE.GMSELECT){//If it's the MENU state, it will display the menu
			if (konami == true){
				Game.State = Game.STATE.GAME;
			}
			else{
				g.drawImage(selectionBG, 0, 0, null);
				try {
					gamemodeSelection.render(g);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			}else if (State == STATE.SETTINGS){//If it's the MENU state, it will display the menu
			g.drawImage(selectionBG, 0, 0, null);
			Settings.preLoad();
			Settings.render(g);

		}else if (State == STATE.PAUSE){//If it's the MENU state, it will display the pause screen
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			g.drawImage(background, 0, 0, null);
			g.drawImage(pauseOverlay, 0, 0, null);
			pause.render(g);
		}else if (State == STATE.GAMEOVER){
			GameOver.render(g);
		}else if (State == STATE.G_ERROR){
			ErrorScreen.render(g);
		}

		/////////////////////////////

		g.dispose();
		bs.show();
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
	
		
		if (State == STATE.GAME){
			if (key == KeyEvent.VK_RIGHT){
				p.setVelX(5);
				Player.tiltRight();
			}
			else if (key == KeyEvent.VK_LEFT){
				p.setVelX(-5);
				Player.tiltLeft();
			}
			else if (key == KeyEvent.VK_DOWN){
				p.setVelY(5);
			}
			else if (key == KeyEvent.VK_UP){
				p.setVelY(-5);
			}	
			else if (key == KeyEvent.VK_SPACE && !shooting){
				shooting = true;
				if (Player.selectedCharacter == 1){
					c.addBullet(new Bullet(p.getX()+3, p.getY(), this));
					c.addBullet(new Bullet(p.getX()-3, p.getY(), this));
				}
				else if (Player.selectedCharacter == 2){
					c.addBullet(new Bullet(p.getX(), p.getY(), this));
					c.addBullet(new Bullet(p.getX(), p.getY(), this));

				}
				else{ //if (Player.selectedCharacter == 3)
					c.addBullet(new Bullet(p.getX(), p.getY(), this));
					c.addBullet(new Bullet(p.getX(), p.getY(), this));

				}


			}	
			else if (key == KeyEvent.VK_Z && !shooting){
				shooting = true;
				if (Player.selectedCharacter == 1){
					testC.addBullet(new Bullet(p.getX()+3, p.getY(), this));
				}
				else if (Player.selectedCharacter == 2){
					testC.addBullet(new Bullet(p.getX(), p.getY(), this));

				}
				else{ //if (Player.selectedCharacter == 3)
					testC.addBullet(new Bullet(p.getX(), p.getY(), this));
				}


			}	
			else if (key == KeyEvent.VK_BACK_SPACE&&paused == false){
				Game.State = Game.STATE.PAUSE;
				paused = true;
			}
		}	
		if (State == STATE.MENU){
			System.out.println(key);

			if (key == sequence[currentButton]){
				currentButton++;
				if(currentButton == sequence.length){
					System.out.print("ACCESS GRANTED");
					this.konami = true;
					Player.setSprite();
					currentButton = 0; 
						
				}
			}
			else{
				currentButton = 0;
			}
			
		}

	}
	
	

	public void keyReleased(KeyEvent e){
		
		
		int key = e.getKeyCode();
		
		 if (State == STATE.GAME){


			if (key == KeyEvent.VK_RIGHT){
				p.setVelX(0);
				Player.setSprite();

			}
			else if (key == KeyEvent.VK_LEFT){
				p.setVelX(0);
				Player.setSprite();
			}
			else if (key == KeyEvent.VK_DOWN){
				p.setVelY(0);
			}
			else if (key == KeyEvent.VK_UP){
				p.setVelY(0);
			}
			else if (key == KeyEvent.VK_SPACE){
				shooting = false;
			}
		}
		 else if (State == STATE.CUTSCENE_1){
			 cutScenes.cutscene_F ++;
		 }
	}

	public static void main(String args[]){
		Game game = new Game();

		//initializes a new dimension with a specified width and height
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		game.start();


	}

	//method that passes spriteSheet to player class
	public static BufferedImage getSpriteSheet(){
		return spriteSheet;
	}
	public static BufferedImage getSpriteSheetK(){
		return spriteSheetK;
	}

}