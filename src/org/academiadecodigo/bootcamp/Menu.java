package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.keyboard.Keyboardable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.IOException;


/**
 * Created by codecadet on 08/06/2018.
 */
public class Menu implements Keyboardable {

    private Picture[] menuPictures;
    private Picture[] extraMenuPictures;
    private int currentMenu;
    private boolean extraMenuState = false;
    private Game game;
    private boolean inMenu;

    public Menu(Game game) {
        this.game = game;
        loadResources();
        inMenu = true;
    }

    public boolean isInMenu() {
        return inMenu;
    }

    public void start() {

        deleteImages();
      inMenu = false;

    }


    public void deleteImages(){
        for(Picture pic : extraMenuPictures){
            System.out.println("delete2");
            pic.delete();
        }
        for(Picture pic: menuPictures){
            System.out.println("delete");
            pic.delete();
        }
        System.out.println("pictures deleted");
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
            System.out.println("2-"+i);
            menuPictures[i] = new Picture(0, 0, "resources/menu/menu_" + i + ".jpg");
        }
        System.out.println("AKI");
        menuPictures[0].draw();
        currentMenu = 0;
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


