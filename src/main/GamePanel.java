package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
//import object.SuperObject;
import tile.TileManager;

// GamePanel class. I mainly followed an online 
// tutorial on 2D game development to make this.
// YouTube Channel Ryisnow
// Title How to Make a 2D Game in Java
// It contians a very commonly used game engine 
// for java which is using a thread, paint component, 
// and a run method which will run our game at 60fps. 
// This loop is the exact same for every other java 2D game
// and I have seen it used in many online tutorials. This class
// will also have methods for playing music and sound effects, which
// I also give credit to the same 2D game tutorial for.
// However, I completely redesigned the player sprites, npc sprites, 
// and tile sprites as my own designs. I also made my own 
// map with my own tiles. 

// 13:00; #14

public class GamePanel extends JPanel implements Runnable {

	// Screen settings
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3;
	public final int tileSize = originalTileSize * scale; // 48x48 tile
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

	// world settings

	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	

	int FPS = 60;

	TileManager tileM = new TileManager(this);

	public KeyHandler keyH = new KeyHandler(this);
	
	Sound music = new Sound();
	Sound se = new Sound();



	public CollisionChecker cChecker = new CollisionChecker(this);

	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	public EventHandler eHandler = new EventHandler(this);
	Thread gameThread;
	
	//Entity and object
	public Player player = new Player(this, keyH);
	public Entity obj[] = new Entity[10]; // 10 slots for objects
	public Entity npc[] = new Entity[10];
	public Entity monster[] = new Entity[20];
	ArrayList<Entity> entityList = new ArrayList<>();
	
	// Game state (paused, etc)
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int dialogueState = 3;

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);

		this.addKeyListener(keyH);
		this.setFocusable(true);

	}

	public void setupGame() {

		aSetter.setObject();
		aSetter.setNPC();
		aSetter.setMonster();
		//playMusic(0);
		gameState = titleState;
	}

	public void startGameThread() {

		gameThread = new Thread(this);
		gameThread.start();

	}

	@Override
	public void run() {

		double drawInterval = 1000000000 / FPS; // 0.16667 secs per frame.. 60fps
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (gameThread != null) {

			update();

			repaint();

			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;

				if (remainingTime < 0) {
					remainingTime = 0;
				}

				Thread.sleep((long) remainingTime);

				nextDrawTime += drawInterval;

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void update() {
		
		if(gameState == playState) {
			// player
			player.update();
			// NPC
			for(int i = 0; i < npc.length; i++) {
				if(npc[i] != null) {
					npc[i].update();
				}
			}
			
			for(int i = 0; i < monster.length; i++) {
				if(monster[i] != null) {
					monster[i].update();
				}
			}
		}
		if(gameState == pauseState) {
			// none
		}

		player.update();

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
		// debug stuff
		long drawStart = 0;
		if(keyH.checkDrawTime == true) {
			drawStart = System.nanoTime();
		}
		
		// title screen
		if(gameState == titleState) {
			ui.draw(g2);
		}
		
		else {
			// tile layer
			tileM.draw(g2);
			
			// add entities to the list

			entityList.add(player);
			
			for(int i = 0; i < npc.length; i++) {
				if(npc[i] != null) {
					entityList.add(npc[i]);
				}
			}
			
			for(int i = 0; i < obj.length; i++) {
				if(obj[i] != null) {
					entityList.add(obj[i]);
				}
			}
			
			for(int i = 0; i < monster.length; i++) {
				if(monster[i] != null) {
					entityList.add(monster[i]);
				}
			}
			
			// sort
			Collections.sort(entityList, new Comparator<Entity>() {

				@Override
				public int compare(Entity e1, Entity e2) {
					
					int result = Integer.compare(e1.worldY, e2.worldY);
					
					return result;
				}
				
			});
			
			// draw entities
			for(int i = 0; i < entityList.size(); i++) {
				entityList.get(i).draw(g2);
			}
			
			// empty entity list
			for(int i = 0; i < entityList.size(); i++) {
				entityList.remove(i);
			}
			
			
			// UI
			ui.draw(g2);
			
		}
		
		
		// debug
		if(keyH.checkDrawTime == true) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setColor(Color.white);
			g2.drawString("Draw Time: " + passed, 10, 400);
			System.out.println("Draw Time: " + passed);
		
		}

		g2.dispose();

	}
	
	
	public void playMusic(int i) {
		
		music.setFile(i);
		music.play();
		music.loop();
		
	}
	
	public void stopMusic() {
		
		music.stop();
	}
	
	public void playSE(int i) {
		
		se.setFile(i);
		se.play();
		
	}
	
	
	
	
	

}
