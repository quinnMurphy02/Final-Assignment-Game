package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_Horse2 extends Entity{
	
	public NPC_Horse2(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		
		up1 = setup("/npc/horse_up_1");
		up2 = setup("/npc/horse_up_2");
		down1 = setup("/npc/horse_down_1");
		down2 = setup("/npc/horse_down_2");
		left1 = setup("/npc/horse_left_1");
		left2 = setup("/npc/horse_left_2");
		right1 = setup("/npc/horse_right_1");
		right2 = setup("/npc/horse_right_2");
		

	}

	public void setDialogue() {
		
		dialogues[0] = "Have you seen the damage??";
		dialogues[1] = "It seems most of the townsfolk \n have evacuated...";
		dialogues[2] = "Need a ride?";
		dialogues[3] = "How many others have you seen???";
		
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
