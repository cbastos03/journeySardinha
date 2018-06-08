package org.academiadecodigo.bootcamp;
import java.io.*;
import javax.sound.sampled.*;

/**
 * Created by codecadet on 08/06/2018.
 */
public class Sound {

        public static void play(String pathname) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File("resources/sounds/" + pathname)));
                clip.start();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

