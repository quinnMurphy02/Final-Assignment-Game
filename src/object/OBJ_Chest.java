package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Chest extends Entity{
	
	// Most of these OBJ classes are relatively the same.
		// We just initialize GamePanel, and then get the image
		// for the object (and scale it to size).
	
	
	
public OBJ_Chest(GamePanel gp) {
	
		super(gp);
		name = "Chest";
		down1 = setup("/objects/treasureChest", gp.tileSize, gp.tileSize);
		
	}

}
