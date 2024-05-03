package model.metodoak;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ErreproduzioSpeed {
	
	
	
public static void erreproduzitu() {	
/*	Clip clip;
	String filepath = "src\\audioak\\" + abestiak.get(abestiAukera).getIzena() + ".wav";
	File f = new File(filepath);
	AudioInputStream aui;
	 

	try {
		aui = AudioSystem.getAudioInputStream(f);

		// Crear un nuevo formato de audio con velocidad x2
        AudioFormat format = aui.getFormat();
        
        float speed = 2.0f;
        
        AudioFormat newFormat = new AudioFormat(format.getEncoding(), format.getSampleRate() * speed,
                format.getSampleSizeInBits(), format.getChannels(), format.getFrameSize(),
                format.getFrameRate() * speed, format.isBigEndian());

        
        clip = AudioSystem.getClip();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = aui.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        byte[] audioData = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(audioData);

        // Convertir el ByteArrayInputStream a AudioInputStream
        AudioInputStream audioInputStream = new AudioInputStream(bais, newFormat, audioData.length / newFormat.getFrameSize());

        // Abrir el Clip con el AudioInputStream
        clip.open(audioInputStream);
	
		//clip = AudioSystem.getClip();
		//clip.open(aui);
	} catch (UnsupportedAudioFileException | IOException e) {
		e.printStackTrace();
	} catch (LineUnavailableException e1) {
		e1.printStackTrace();
	}
*/	
	 }

}
	 
