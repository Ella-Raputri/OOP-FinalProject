/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author Asus
 */
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    //attributes
    private Clip clip;
    private String filePath;
    private FloatControl volumeControl;

    //constructor
    public MusicPlayer(String filePath, float defaultVolume) {
        this.filePath = filePath;
        loadMusic(filePath);
        setVolume(defaultVolume);
    }

    public void loadMusic(String filePath) {
        //stop the clip if the clip is not null and still running
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
        //close the clip if the clip is not null
        if (clip != null) {
            clip.close();
        }
        try {
            // Open an audio input stream.
            File soundFile = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

            // Get a sound clip resource.
            clip = AudioSystem.getClip();

            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);

            // Get the volume control from the clip
            volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Volume control not supported.");
        }
    }

    public void play() {
        //if the clip is not null, play the clip from the beginning
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the clip continuously
        }
    }

    public void stop() {
        //stop the clip if it is not null
        if (clip != null) {
            clip.stop();
        }
    }

    public void close() {
        //close the clip if it is not null
        if (clip != null) {
            clip.close();
        }
    }

    public void setVolume(float volume) {
        //if the volumeControl is not null
        if (volumeControl != null) {
            //get the min and max of the volume control
            float min = volumeControl.getMinimum();
            float max = volumeControl.getMaximum();
            //set the volume
            volumeControl.setValue(min + (max - min) * volume);
        }
    }

    public float getVolume() {
        //get the volume control if is not null
        if (volumeControl != null) {
            return volumeControl.getValue();
        }
        return -1.0f; // Indicates that volume control is not available
    }
    
    public String getFilePath(){
        //get audio filepath
        return this.filePath;
    }
}
