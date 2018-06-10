package org.academiadecodigo.bootcamp.sound;

/**
 * Created by codecadet on 09/06/2018.
 */
public enum SoundClips {

    MENU("resources/menu.wav"),
    FUNDAO("resources/level_0.wav"),
    LISBOA("resources/level_1.wav"),
    MARROCOS("resources/level_2.wav"),
    DIES("resources/died.wav"),
    PUMA("resources/peafowl_sound.wav");

    String file;

    SoundClips(String file) {
        this.file = file;
    }

    public String getFile() {
        return this.file;
    }

}


