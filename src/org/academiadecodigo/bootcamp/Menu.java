package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.keyboard.Keyboardable;
import org.academiadecodigo.bootcamp.sound.Sound;
import org.academiadecodigo.bootcamp.sound.SoundClips;
import org.academiadecodigo.simplegraphics.pictures.Picture;



/**
 * Created by codecadet on 08/06/2018.
 */
public class Menu implements Keyboardable {

    private Picture[] menuPictures;
    private Picture[] extraMenuPictures;
    private int currentMenu;
    private boolean extraMenuState = false;
    private boolean inMenu;

    public Menu() {
        loadResources();
        inMenu = true;
    }

    public boolean isInMenu() {
        return inMenu;
    }

    public void start() {
        Sound.stop();
        inMenu = false;

    }


    public void loadResources() {
        /*
        * Loading Extra Menu Images
        * */
        extraMenuPictures = new Picture[2];
        for (int i = 0; i < extraMenuPictures.length; i++) {
            System.out.println(i);
            extraMenuPictures[i] = new Picture(0, 0, "resources/menu/extra_" + i + ".jpg");
        }
        /*
        * Loading Menu Images
        * */
        menuPictures = new Picture[3];
        for (int i = 0; i < menuPictures.length; i++) {
            System.out.println("2-" + i);
            menuPictures[i] = new Picture(0, 0, "resources/menu/menu_" + i + ".jpg");
        }
        System.out.println("AKI");
        menuPictures[0].draw();
        currentMenu = 0;

        Sound.play(SoundClips.MENU.getFile(),1000000000);

    }


    @Override
    public void keyDown() {
        if (currentMenu == 2) {
            return;
        }
        System.out.println(currentMenu);
        menuPictures[currentMenu].delete();
        currentMenu = currentMenu + 1;
        System.out.println(currentMenu);
        menuPictures[currentMenu].draw();
    }

    @Override
    public void keyUp() {
        if (currentMenu == 0) {
            return;
        }
        menuPictures[currentMenu].delete();
        currentMenu = currentMenu - 1;
        menuPictures[currentMenu].draw();
    }

    @Override
    public void keyLeft() {

    }

    @Override
    public void keyRight() {

    }

    @Override
    public void keySpace() {
        if (currentMenu == 0) {
            menuPictures[currentMenu].delete();
            System.out.println("START GAME");
            start();

        }

        if (currentMenu == 1) {
            System.out.println("INSTRUCTIONS");
            extraMenuState = true;
            menuPictures[currentMenu].delete();
            extraMenuPictures[0].draw();
        }
        if (currentMenu == 2) {
            extraMenuState = true;
            menuPictures[currentMenu].delete();
            extraMenuPictures[1].draw();
        }
    }

    public void keySpaceRelease() {
        if (extraMenuState) {
            extraMenuPictures[0].delete();
            extraMenuPictures[1].delete();
            menuPictures[currentMenu].draw();
            extraMenuState = false;
        }
    }

    @Override
    public void keyDownRelease() {

    }

    @Override
    public void keyUpRelease() {

    }

    @Override
    public void keyLeftRelease() {

    }

    @Override
    public void keyRightRelease() {

    }


}


