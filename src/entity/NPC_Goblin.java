package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_Goblin extends Entity{
	
	public NPC_Goblin(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		
		getImage();
		setDialogue();
	}
	
public void getImage() {
		
		up1 = setup("/npc/goblin_up_1");
		up2 = setup("/npc/goblin_up_2");
		down1 = setup("/npc/goblin_down_1");
		down2 = setup("/npc/goblin_down_2");
		left1 = setup("/npc/goblin_left_1");
		left2 = setup("/npc/goblin_left_2");
		right1 = setup("/npc/goblin_right_1");
		right2 = setup("/npc/goblin_right_2");
		

	}

	public void setDialogue() {
		
		dialogues[0] = "Heh... Hello. I am a goblin";
		dialogues[1] = "You came at a pretty crazy time. \n There was just an explosion!!";
		dialogues[2] = "We have to do something!";
		
		
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
