package main;

import entity.NPC_Alien;
import entity.NPC_Goblin;
import entity.NPC_Horse;
import entity.NPC_Horse2;
import entity.NPC_Worm;
import monster.MON_RedGuy;
import object.OBJ_Boots;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

// The asset setter class. Thankfully this one is pretty simple.
// All we need to do is set a tile array num as a object, and place 
// it on the map. If you go into the map text file containing the 
// tile map, you will see it is just a grid of numbers. We use
// our world x and world y variables to simply set a location for 
// the object. It is literally an x,y coordinate on the grid.

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
		
	}
	
	public void setObject() {
		

	}
	
	public void setNPC() {
		
		gp.npc[0] = new NPC_Alien(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*21;
		
		gp.npc[1] = new NPC_Horse(gp);
		gp.npc[1].worldX = gp.tileSize*22;
		gp.npc[1].worldY = gp.tileSize*22;
		
		gp.npc[2] = new NPC_Goblin(gp);
		gp.npc[2].worldX = gp.tileSize*27;
		gp.npc[2].worldY = gp.tileSize*22;
		
		gp.npc[3] = new NPC_Horse2(gp);
		gp.npc[3].worldX = gp.tileSize*20;
		gp.npc[3].worldY = gp.tileSize*20;
		
		gp.npc[4] = new NPC_Worm(gp);
		gp.npc[4].worldX = gp.tileSize*34;
		gp.npc[4].worldY = gp.tileSize*17;
		
		
		
	}
	
	public void setMonster() {
		
		gp.monster[0] = new MON_RedGuy(gp);
		gp.monster[0].worldX = gp.tileSize*21;
		gp.monster[0].worldY = gp.tileSize*18;
		
		gp.monster[1] = new MON_RedGuy(gp);
		gp.monster[1].worldX = gp.tileSize*21;
		gp.monster[1].worldY = gp.tileSize*15;
		
		gp.monster[2] = new MON_RedGuy(gp);
		gp.monster[2].worldX = gp.tileSize*5;
		gp.monster[2].worldY = gp.tileSize*30;
		
		gp.monster[3] = new MON_RedGuy(gp);
		gp.monster[3].worldX = gp.tileSize*5;
		gp.monster[3].worldY = gp.tileSize*32;
		
		gp.monster[4] = new MON_RedGuy(gp);
		gp.monster[4].worldX = gp.tileSize*5;
		gp.monster[4].worldY = gp.tileSize*34;
		
		gp.monster[5] = new MON_RedGuy(gp);
		gp.monster[5].worldX = gp.tileSize*5;
		gp.monster[5].worldY = gp.tileSize*33;
	}
	
	

}
