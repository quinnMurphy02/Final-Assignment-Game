package main;

import javax.swing.JFrame;

// main class
// CONTROLS
// USE ENTER AND WASD KEYS TO NAVIGATE
// MAIN MENU AND GAME. 
// W = UP
// S = DOWN
// A = LEFT
// D = RIGHT
// TO TALK TO NPC, PRESS ENTER WHILE FACING THEM
// SOUND CREDITS IN "SOUND" CLASS.

// Here is the last assignment. I have always
// wanted to make a retro style game, and I figured
// it would be a good challenge for my final assignment. 
// I mainly followed a tutorial series on youtube to 
// help me make this game. It is called 
// "How to Make a 2D Game in Java" by RyiSnow.
// Despite using most of his code for things like
// the game loop and key handler, I wanted to make my
// own version of the game. 
// This game features my own map design, title screen,
// player sprites, npc sprites, tile sprites and more. 
// This is by far the biggest project I have ever taken on in java
// and has taken me about a week and a half of consistent work to 
// get this far. It is not completely finished yet, but is more of 
// a work in progress. But I think it meets the criteria of 
// something we have put a lot of time into for the assignment
// requirements. 

public class Main {
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("2D RPG Game");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel); // add gameaPanel to window settings
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.setupGame();
		
		gamePanel.startGameThread();
	}
	

}
