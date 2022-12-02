package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Key extends Entity{
	
	// Most of these OBJ classes are relatively the same.
		// We just initialize GamePanel, and then get the image
		// for the object (and scale it to size).
	
	
	
	public OBJ_Key(GamePanel gp) {
		
		super(gp);
		name = "Key";
		down1 = setup("/objects/key");
		
	}
	
	

}
