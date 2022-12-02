package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	// The sound class. This contains the paths to the sound files. 
	// Here are the credits for the sounds I got from youtube.
	// ALL OF THESE ARE NON COPYRIGHT, AND ARE FREE!! I DO 
	// NOT TAKE CREDIT FOR MAKING ANY OF THESE SOUND EFFECTS
	
	//	music.wav = "Stand my Ground" by Cody O'Quinn
	//  YouTube Link = https://www.youtube.com/watch?v=xw4Gpm4b7zk&list=PLtkjJsGOW8yPVOauP48WCyeq7KARWxD7r&index=6
	
	// coin.wav = https://www.youtube.com/watch?v=XZJ4Izyr2f0
	// fanfare.wav = https://www.youtube.com/shorts/RgU-84NjIZ8
	// powerup.wav = https://www.youtube.com/watch?v=vZemqbWsXso
	// unlock.wav = https://www.youtube.com/watch?v=657R-eJCs-I
	
	Clip clip;
	URL soundURL[] = new URL[30];
	
	public Sound() {
		
		soundURL[0] = getClass().getResource("/sound/music.WAV");
		soundURL[1] = getClass().getResource("/sound/coin.wav");
		soundURL[2] = getClass().getResource("/sound/powerup.wav");
		soundURL[3] = getClass().getResource("/sound/unlock.wav");
		soundURL[4] = getClass().getResource("/sound/fanfare.wav");
			
		
	}
	
	public void setFile(int i) {
		// format to open audio file in java.
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		}catch(Exception e) {
			
		}
		
	}
	
	public void play() {
		
		clip.start();
		
	}
	
	public void loop() {
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		
	}
	
	public void stop() {
		
		clip.stop();
		
	}

}
