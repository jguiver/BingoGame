package sound;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlaySound {
	
	public static void main(String [] args){
		
		File Clap = new File("mario2.wav");
		PlayMusic(Clap);
		
	}
	
	static void PlayMusic(File Sound){
		
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength()/1000);
			
			
		}catch(Exception e){
			
			
		}
		
	}
}
