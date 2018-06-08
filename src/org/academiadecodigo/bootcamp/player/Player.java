package org.academiadecodigo.bootcamp.player;

import org.academiadecodigo.bootcamp.Grid;
import org.academiadecodigo.bootcamp.keyboard.Keyboardable;
import org.academiadecodigo.bootcamp.player.Directions;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 04/06/2018.
 */
public class Player implements Keyboardable {

    private Grid grid;
    private Picture picture;
    private boolean isDead;
    private boolean spaceState;
    private int speed = 20;
    private Directions directions;

    public Player(Grid grid) {
        picture = new Picture(200, grid.getCanvas().getHeight() / 2, "resources/player/fish-right.png");
        this.grid = grid;
        picture.draw();
        directions = Directions.NODIRECTION;
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
        picture.load("resources/player/fish-down.png");
        picture.translate(0, speed);
    }

    public void moveUp(int speed) {
        if (picture.getY() - speed <= grid.PADDING) {
            return;
        }
        picture.load("resources/player/fish-up.png");
        picture.translate(0, -speed);
    }

    public void moveLeft(int speed) {
        if (picture.getX() - speed <= grid.PADDING) {
            return;
        }
        picture.load("resources/player/fish-left.png");
        picture.translate(-speed, 0);
    }

    public void moveRight(int speed) {
        if (picture.getX() + speed + picture.getWidth() >= grid.getCanvas().getWidth()) {
            return;
        }
        picture.load("resources/player/fish-right.png");
        picture.translate(speed, 0);
    }


    public void movePlayer() {
        switch (directions) {
            case LEFT:
                moveLeft(speed);
                break;
            case RIGHT:
                moveRight(speed);
                break;
            case UP:
                moveUp(speed);
                break;
            case DOWN:
                moveDown(speed);
                break;
            case NODIRECTION:
                return;
        }
    }

    @Override
    public void keyDown() {
        directions = Directions.DOWN;

    }

    @Override
    public void keyUp() {
        directions = Directions.UP;

    }

    @Override
    public void keyLeft() {
        directions = Directions.LEFT;

    }

    @Override
    public void keyRight() {
        directions = Directions.RIGHT;

    }

    @Override
    public void keySpace() {
        speed = 40;
    }

    @Override
    public void keySpaceRelease() {
        speed = 20;
    }

    @Override
    public void othersRelease() {
        directions = Directions.NODIRECTION;
    }
}

