package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_Worm extends Entity{
	
	public NPC_Worm(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		
		getImage();
		setDialogue();
	}
	
public void getImage() {
		
		up1 = setup("/npc/worm_up_1");
		up2 = setup("/npc/worm_up_2");
		down1 = setup("/npc/worm_down_1");
		down2 = setup("/npc/worm_down_2");
		left1 = setup("/npc/worm_left_1");
		left2 = setup("/npc/worm_left_2");
		right1 = setup("/npc/worm_right_1");
		right2 = setup("/npc/worm_right_2");
		

	}

	public void setDialogue() {
		
		dialogues[0] = "I dug out of the ground to see \n what happened.";
		dialogues[1] = "I hope there aren't any predators around...";
		dialogues[2] = "Woah!";
		
		
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
