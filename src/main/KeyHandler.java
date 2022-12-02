package main;

import java.awt.event.KeyEvent;


import java.awt.event.KeyListener;


// key handler class. This mainly just contains the 
// key type methods that you need for any program that is using
// keyListener. We will use WASD for the movement of the character,
// and these will be attached to booleans that change to true
// if the key is pressed. I have used this exact method
// on several previous programs I have made.
public class KeyHandler implements KeyListener {
	
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
	
	// debug
	boolean checkDrawTime;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		// title state
		
		if(gp.gameState == gp.titleState) {
			if (code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}

			}
			if (code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}

			}
			
		if(code == KeyEvent.VK_ENTER) {
			if(gp.ui.commandNum == 0) {
				gp.gameState = gp.playState;
				gp.playMusic(0);
			}
			if(gp.ui.commandNum == 1) {
				// add later
				
			}
			if(gp.ui.commandNum == 2) {
				System.exit(0);
			}
		}
		}
		
		
		
		// play state
		else if(gp.gameState == gp.playState) {
			if (code == KeyEvent.VK_W) {
				upPressed = true;

			}
			if (code == KeyEvent.VK_S) {
				downPressed = true;

			}
			if (code == KeyEvent.VK_A) {
				leftPressed = true;
			}
			if (code == KeyEvent.VK_D) {
				rightPressed = true;
			}
			if (code == KeyEvent.VK_P) {
				gp.gameState = gp.pauseState;
				
			}
			if (code == KeyEvent.VK_ENTER) {
				enterPressed = true;
				
			}
			
			// debug
			if (code == KeyEvent.VK_T) {
				if(checkDrawTime == false) {
					checkDrawTime = true;
				}
				else if(checkDrawTime  == true) {
					checkDrawTime = false;
				}
			}
		}
		
		// pause state
		else if(gp.gameState == gp.pauseState) {
			if (code == KeyEvent.VK_P) {
				gp.gameState = gp.playState;
			}
		}
		// dialogue state
		else if(gp.gameState == gp.dialogueState) {
			if(code == KeyEvent.VK_ENTER) {
				gp.gameState = gp.playState;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			upPressed = false;

		}
		if (code == KeyEvent.VK_S) {
			downPressed = false;

		}
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
		}

	}

}
