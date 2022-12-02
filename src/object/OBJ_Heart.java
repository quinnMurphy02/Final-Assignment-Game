package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity{
	

	
	public OBJ_Heart(GamePanel gp) {
		
		super(gp);
		name = "Key";
		image = setup("/objects/heart_full");
		image2 = setup("/objects/heart_half2");
		image3 = setup("/objects/heart_blank2");
		
	}

}
