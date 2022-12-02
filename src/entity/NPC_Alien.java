package entity;

// 21:48

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class NPC_Alien extends Entity{
	// here is NPC_Alien. I made this class for the 
	// alien NPC. It first initializes the alien, and then
	// gets the image for his animations. As you can see he has
	// dialogue, which can be used in the game. We also have 
	// some simple AI. He moves every 2 seconds, and has a 25%
	// chance of moving in either direction.
	
	public NPC_Alien(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		
		getImage();
		setDialogue();
	}
	
public void getImage() {
		
		up1 = setup("/npc/alien_up_1", gp.tileSize, gp.tileSize);
		up2 = setup("/npc/alien_up_2", gp.tileSize, gp.tileSize);
		down1 = setup("/npc/alien_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/npc/alien_down_2", gp.tileSize, gp.tileSize);
		left1 = setup("/npc/alien_left_1", gp.tileSize, gp.tileSize);
		left2 = setup("/npc/alien_left_2", gp.tileSize, gp.tileSize);
		right1 = setup("/npc/alien_right_1", gp.tileSize, gp.tileSize);
		right2 = setup("/npc/alien_right_2", gp.tileSize, gp.tileSize);
		

	}

	public void setDialogue() {
		
		dialogues[0] = "The volcano just erupted!! \nDid you see it?";
		dialogues[1] = "Who are you anyway?";
		dialogues[2] = "Whatever, who cares!! We have \n to fight the volcanic monsters!";
		dialogues[3] = "Good luck on your journey!!";
		
	}

	public void setAction() {
		
		actionLockCounter++;
		
		if(actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100) + 1; // very simple AI for npc
											 // randomizes move based on randomizer
			
			if(i <= 25) {
				direction = "up";
				
			}
			if(i > 25 && i <= 50) {
				direction = "down";
			}
			if(i > 50 && i <= 75) {
				direction = "left";
			}
			if(i > 75 && i <= 100) {
				direction = "right";
			}
			
			actionLockCounter = 0;
		}
		}
	
	public void speak() {
		
		super.speak();
	}
		
	
}
