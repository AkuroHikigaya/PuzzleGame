package view;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundEffect {
	private Clip clip;
	
	public SoundEffect(String soundName) {
		try{
			File file = new File(soundName);
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);	
			clip = AudioSystem.getClip();
			clip.open(sound);
		}
		catch(Exception e){
		}
	}
	
	public void play(){
		clip.start();
	}
	
	public void stop() {
		clip.stop();
	}
}
