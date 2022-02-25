package pong;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
* Handles playing, stoping, and looping of sounds for the game.
* @author Tyler Thomas
*
*/
public class Sound {
	
	private Clip clip;
	
	private FloatControl volume;
	public static final int sliderVolume[] = new int[] {-50, -40, -20, -15, -10, -5, -2, 0, 2, 4, 6};
	
	public static final Sound ballbeep0 = new Sound("res/Blip_Select0.wav");
	public static final Sound ballbeep1 = new Sound("res/Blip_Select1.wav");
	public static final Sound ballbeep2 = new Sound("res/Blip_Select2.wav");
	public static final Sound ballbeep3 = new Sound("res/Blip_Select3.wav");
	public static final Sound ballbeep4 = new Sound("res/Blip_Select4.wav");
	public static final Sound ballbeep5 = new Sound("res/Blip_Select5.wav");
	public static final Sound ballbeep6 = new Sound("res/Blip_Select6.wav");
	public static final Sound ballbeep7 = new Sound("res/Blip_Select7.wav");
	public static final Sound ballbeep8 = new Sound("res/Blip_Select8.wav");
	public static final Sound ballbeep9 = new Sound("res/Blip_Select9.wav");
	public static final Sound ballbeep10 = new Sound("res/Blip_Select10.wav");
	public static final Sound ballbeep11 = new Sound("res/Blip_Select11.wav");
	public static final Sound ballbeep12 = new Sound("res/Blip_Select12.wav");
	public static final Sound ballbeep13 = new Sound("res/Blip_Select13.wav");
	public static final Sound ballbeep14 = new Sound("res/Blip_Select14.wav");
	public static final Sound ballbeep15 = new Sound("res/Blip_Select15.wav");
	
	public static final Sound goalPlayer = new Sound("res/Powerup13.wav");
	public static final Sound goalComput = new Sound("res/Powerup4.wav");
	
	public static final Sound winPlayer = new Sound("res/Gameover_Player_win.wav");
	public static final Sound winComput = new Sound("res/Gameover_Comput_win.wav");
	
	//public static final Sound backgroundMusic = new Sound("res/463425__studioonebeatmakers__game-setup.wav");
	
	//public static int musicVolume = 4;
	public static int effectsVolume = 6;
	public static final int maxVolume = 9;
	
	public Sound(String fileName) {
   // specify the sound to play
   // (assuming the sound can be played by the audio system)
   // from a wave File
   try {
     File file = new File(fileName);
     if (file.exists()) {
       AudioInputStream sound = AudioSystem.getAudioInputStream(file);
      // load the sound into memory (a Clip)
       clip = AudioSystem.getClip();
       clip.open(sound);
       volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
     }
     else {
       throw new RuntimeException("Sound: file not found: " + fileName);
     }
   }
   catch (MalformedURLException e) {
     e.printStackTrace();
     throw new RuntimeException("Sound: Malformed URL: " + e);
   }
   catch (UnsupportedAudioFileException e) {
     e.printStackTrace();
     throw new RuntimeException("Sound: Unsupported Audio File: " + e);
   }
   catch (IOException e) {
     e.printStackTrace();
     throw new RuntimeException("Sound: Input/Output Error: " + e);
   }
   catch (LineUnavailableException e) {
     e.printStackTrace();
     throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
   }

 // play, stop, loop the sound clip
 }
 public void play(int setVolume){
	
	 volume.setValue(sliderVolume[setVolume]);
	 
	 clip.setFramePosition(0);  // Must always rewind!
     clip.start();
 }
 public void loop(int setVolume){
	 
	 volume.setValue(sliderVolume[setVolume]);
	 clip.loop(Clip.LOOP_CONTINUOUSLY);
/*     for(int i = 0; i < 16; i ++) {
    	 System.out.println("Volume: " + sliderVolume[i]);
    	 volume.setValue(sliderVolume[i]);
    	 try {
    		 Thread.sleep(1000);
    		 } catch (InterruptedException e){System.out.println(e);}
     } */
 }
 
 public void setVolume(int setVolume ) {
	 volume.setValue(sliderVolume[setVolume]);
 }
 public void stop(){
     clip.stop();
 }
 
 public void selectBeep(int atingido) {
 switch(atingido) {
	case 0: ballbeep0.play(effectsVolume); break;
	case -1:
	case 1: ballbeep1.play(effectsVolume); break;
	case -2:
	case 2: ballbeep2.play(effectsVolume); break;
	case -3:
	case 3: ballbeep3.play(effectsVolume); break;
	case -4:
	case 4: ballbeep4.play(effectsVolume); break;
	case -5:
	case 5: ballbeep5.play(effectsVolume); break;
	case -6:
	case 6: ballbeep6.play(effectsVolume); break;
	case -7:
	case 7: ballbeep7.play(effectsVolume); break;
	case -8:
	case 8: ballbeep8.play(effectsVolume); break;
	case -9:
	case 9: ballbeep9.play(effectsVolume); break;
	case -10:
	case 10: ballbeep10.play(effectsVolume); break;
	case -11:
	case 11: ballbeep11.play(effectsVolume); break;
	case -12:
	case 12: ballbeep12.play(effectsVolume); break;
	case -13:
	case 13: ballbeep13.play(effectsVolume); break;
	case -14:
	case 14: ballbeep14.play(effectsVolume); break;
	case -15:
	case 15: ballbeep15.play(effectsVolume);
	}
 }

}