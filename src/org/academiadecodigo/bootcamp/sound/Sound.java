package org.academiadecodigo.bootcamp.sound;

import java.io.*;
import javax.sound.sampled.*;



/**
 * Created by codecadet on 08/06/2018.
 */
public class Sound {

    static Clip clip;





    public static void play(String pathname, int loop) {
        try {
            clip =  AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(pathname)));
            clip.start();
            clip.loop(loop);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void stop() {
        clip.stop();
    }


}
