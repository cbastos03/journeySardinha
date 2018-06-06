package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 04/06/2018.
 */
public class Player implements KeyboardHandler {

    private Grid grid;
    private Picture picture;
    private boolean isDead;
    private boolean spaceState;
    private int speed = 40;

    public Player(Grid grid, int width, int height) {
        picture = new Picture(width, height, "resources/fish-right.png");
        this.grid = grid;
        picture.draw();

        initKeyboard();
    }

    public boolean isIsdead() {
        return isDead;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setIsdead(boolean isdead) {
        this.isDead = isdead;
    }

    public void moveDown(int speed) {

        if (picture.getY() + speed + picture.getHeight() >= grid.getCanvas().getHeight()) {
            return;
        }
        picture.load("resources/fish-down.png");
        picture.translate(0, speed);
    }

    public void moveUp(int speed) {
        if (picture.getY() - speed <= grid.PADDING) {
            return;
        }
        picture.load("resources/fish-up.png");
        picture.translate(0, -speed);
    }

    public void moveLeft(int speed) {
        if (picture.getX() - speed <= grid.PADDING) {
            return;
        }
        picture.load("resources/fish-left.png");
        picture.translate(-speed, 0);
    }

    public void moveRight(int speed) {
        if (picture.getX() + speed + picture.getWidth() >= grid.getCanvas().getWidth()) {
            return;
        }
        picture.load("resources/fish-right.png");
        picture.translate(speed, 0);
    }

    private void initKeyboard() {

        Keyboard keyboard = new Keyboard(this);
        System.out.println(this);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);

        KeyboardEvent releasedSpace = new KeyboardEvent();
        releasedSpace.setKey(KeyboardEvent.KEY_SPACE);
        releasedSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(releasedSpace);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                moveDown(speed);
                break;
            case KeyboardEvent.KEY_UP:
                moveUp(speed);
                break;
            case KeyboardEvent.KEY_LEFT:
                moveLeft(speed);
                break;
            case KeyboardEvent.KEY_RIGHT:
                moveRight(speed);
                break;
            case KeyboardEvent.KEY_SPACE:
                speed = 80;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            speed = 40;

        }

    }
}
