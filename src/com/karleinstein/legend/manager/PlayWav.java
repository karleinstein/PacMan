package com.karleinstein.legend.manager;
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class PlayWav {
    private Clip clip;

    public PlayWav(String filename) {
        try {
            URL url = getClass().getResource("/res/raw/" + filename + ".wav");
            AudioInputStream input = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(input);
        } catch (LineUnavailableException
                | UnsupportedAudioFileException
                | IOException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip.isOpen() && !clip.isRunning()) {
            clip.start();
        }
    }

    public void stop() {
        clip.stop();
    }

    public void loop(int count) {
        //Clip.LOOP_CONTINUOUSLY la -1 lap vo so lan
        clip.loop(count);
    }


}
