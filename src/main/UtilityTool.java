package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UtilityTool {
	
	// utility tool. This just receives an 
	// image and scales it to whatever size we want.
	// It then returns the image.
	
	public BufferedImage scaleImage(BufferedImage original, int width, int height) {
		
		BufferedImage scaledImage = new BufferedImage(width, height, original.getType());
		Graphics2D g2 = scaledImage.createGraphics();
		g2.drawImage(original, 0, 0, width, height, null);
		g2.dispose();
		
		return scaledImage;
	}

}
