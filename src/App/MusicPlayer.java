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
    private Clip clip;
    private String filePath;
    private FloatControl volumeControl;

    public MusicPlayer(String filePath, float defaultVolume) {
        this.filePath = filePath;
        loadMusic(filePath);
        setVolume(defaultVolume);
    }

    public void loadMusic(String filePath) {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
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
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the clip continuously
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
        }
    }

    public void close() {
        if (clip != null) {
            clip.close();
        }
    }

    public void setVolume(float volume) {
        if (volumeControl != null) {
            float min = volumeControl.getMinimum();
            float max = volumeControl.getMaximum();
            volumeControl.setValue(min + (max - min) * volume);
        }
    }

    public float getVolume() {
        if (volumeControl != null) {
            return volumeControl.getValue();
        }
        return -1.0f; // Indicates that volume control is not available
    }
    
    public String getFilePath(){
        return this.filePath;
    }
}
