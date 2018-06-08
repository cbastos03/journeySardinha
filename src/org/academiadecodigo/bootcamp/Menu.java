package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.keyboard.Keyboardable;
import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by codecadet on 08/06/2018.
 */
public class Menu implements Keyboardable {

    private Picture[] menuPictures;
    private Picture[] extraMenuPictures;
    private int currentMenu;
    private boolean extraMenuState = false;

    public Menu() {
        loadResources();
    }

    public void start() {
        System.out.println("---> start game <---");
    }

    private void loadResources() {
        /*
        * Loading Extra Menu Images
        * */
        extraMenuPictures = new Picture[2];
        for (int i = 0; i < extraMenuPictures.length; i++) {
            extraMenuPictures[i] = new Picture(10, 10, "resources/menu/extra_" + i + ".jpg");
        }
        /*
        * Loading Menu Images
        * */
        menuPictures = new Picture[3];
        for (int i = 0; i < menuPictures.length; i++) {
            menuPictures[i] = new Picture(10, 10, "resources/menu/menu_" + i + ".jpg");
        }
        menuPictures[0].draw();
        currentMenu = 0;
    }


    @Override
    public void keyDown() {
        if (currentMenu == 2) {
            return;
        }
        menuPictures[currentMenu].delete();
        currentMenu++;
        menuPictures[currentMenu].draw();
    }

    @Override
    public void keyUp() {
        if (currentMenu == 0) {
            return;
        }
        menuPictures[currentMenu].delete();
        currentMenu--;
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
            System.out.println("START GAME");
        }

        if (currentMenu == 1) {
            System.out.println("INSTRUCTIONS");
            extraMenuState = true;
            menuPictures[currentMenu].delete();
            extraMenuPictures[0].draw();
        }
        if (currentMenu == 2) {
            System.out.println("CREDITS");
            extraMenuState = true;
            menuPictures[currentMenu].delete();
            extraMenuPictures[1].draw();
        }
    }

    public void keySpaceRelease() {
        if (extraMenuState) {
            System.out.println("space released");
            extraMenuPictures[0].delete();
            extraMenuPictures[1].delete();
            menuPictures[currentMenu].draw();
            extraMenuState = false;
        }
    }

    @Override
    public void othersRelease() {

    }
}


