package Example;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayMp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String pathname = "F:/Listerning/level1/2010";
		File file = new File(pathname);
		File newpath = null;
		if(file.isDirectory()){
			String[] directoryContents = file.list();
			for(int i = 0; i < directoryContents.length; i++){
				newpath = new File(pathname + "/"+ directoryContents[i]);
				System.out.println(newpath);
			}
		}
		try{
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(newpath);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
