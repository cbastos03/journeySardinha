package org.academiadecodigo.bootcamp.sound;

/**
 * Created by codecadet on 09/06/2018.
 */
public enum SoundClips {

    MENU("menu"),
    FUNDAO("level_0"),
    LISBOA("level_1"),
    MARROCOS("level_2");

    String file;

    SoundClips(String file) {
        this.file = file;
    }

    public String getFile() {
        return this.file;
    }

}


