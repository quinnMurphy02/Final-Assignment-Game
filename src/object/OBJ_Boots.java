package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Boots extends Entity{
	
	// Most of these OBJ classes are relatively the same.
	// We just initialize GamePanel, and then get the image
	// for the object (and scale it to size).
	

	
public OBJ_Boots(GamePanel gp) {
	super(gp);
	
		
		name = "Boots";
		down1 = setup("/objects/boots", gp.tileSize, gp.tileSize);
	}

}
