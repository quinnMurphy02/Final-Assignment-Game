package tile;

import java.awt.image.BufferedImage;

// Here is the tile class. We need a tile object
// for our game, and all a tile will be is a 
// bufferedimage (aka png file in our case) and 
// a boolean if it is a collision tile. an example of
// a tile with collision true would be water, as we do not
// want our character to be able to walk on water.

public class Tile {
	
	public BufferedImage image;
	public boolean collision = false;

}
