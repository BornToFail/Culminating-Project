package muzeyen.main;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class KonamiMusic {
	static Clip clip; 
	static AudioInputStream ais; 
	public static void playMusic(){
		try{
		    ais = AudioSystem.getAudioInputStream(new File("/thesongofmypeople.wav"));
			clip = AudioSystem.getClip();
			clip.open(ais);
		}
		catch(Exception e){
			System.out.println(e);
		}
		clip.start();
	}
}
