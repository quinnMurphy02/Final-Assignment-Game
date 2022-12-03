package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

// the TileManager class. This is where things get complex.
// Again, I mainly followed RyiSnows tutorial for this one. 
// getTileImage(); allows us to set a tile to a number
// and then input the file name. Then say if collision is 
// true or false. setup(); just takes in the image file using
// a tile object, and setting it to the getResourceAsStream path. 

public class TileManager {

	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];

	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[20];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

		getTileImage();
		loadMap("/maps/map03.txt");
	}

	public void getTileImage() {

		setup(0, "cobblestone", false);
		setup(1, "dude_up_1", true);
		setup(2, "earth", false);
		setup(3, "grass00", false);
		setup(4, "lava", true);
		setup(5, "lava_corner_upright", true);
		setup(6, "lava_corner_upleft", true);
		setup(7, "lava_corner_botright", true);
		setup(8, "lava_corner_botleft", true);
		setup(9, "lava_ground_down", true);
		setup(10, "lava_ground_left", true);
		setup(11, "lava_ground_right", true);
		setup(12, "lava_ground_up", true);
		setup(13, "sand", false);
		setup(14, "newTree", true);
		setup(15, "bricks", true);
		setup(16, "water00", true);
	
		

	}

	public void setup(int index, String imageName, boolean collision) {
		UtilityTool uTool = new UtilityTool();

		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadMap(String filePath) {
		// loads map by for looping through the map.txt file
		// with the numbers in it. For each number, print a corresponding
		// tile. 
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0;
			int row = 0;

			while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

				String line = br.readLine();

				while (col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");

					int num = Integer.parseInt(numbers[col]);

					mapTileNum[col][row] = num;
					col++;
				}

				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}

			br.close();

		} catch (Exception e) {

		}
	}

	public void draw(Graphics2D g2) {

		int worldCol = 0;
		int worldRow = 0;

		while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

			int tileNum = mapTileNum[worldCol][worldRow];

			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;

			// draw tile where camera is
			if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
					&& worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
					&& worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
					&& worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, null);
			}

			worldCol++;

			if (worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;

			}

		}
	}

}
