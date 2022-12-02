package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Door extends Entity{
	
	// Most of these OBJ classes are relatively the same.
		// We just initialize GamePanel, and then get the image
		// for the object (and scale it to size).
	
	
	
	public OBJ_Door(GamePanel gp) {
		super(gp);

		
		name = "Door";
		down1 = setup("/objects/door", gp.tileSize, gp.tileSize);
		
		collision = true;
		
		solidArea.x = 0;
		solidArea.y = 16;
		solidArea.width = 48;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		
	}	

}
