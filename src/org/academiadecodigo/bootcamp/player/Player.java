package org.academiadecodigo.bootcamp.player;

import org.academiadecodigo.bootcamp.Grid;
import org.academiadecodigo.bootcamp.keyboard.Keyboardable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 04/06/2018.
 */
public class Player implements Keyboardable {

    private Grid grid;
    private Picture picture;
    private boolean isDead;
    private boolean spaceState;
    private double speedStandard;
    private double speedX = 0;
    private double speedY = 0;
    private boolean[] directions;

    public Player(Grid grid) {
        picture = new Picture(200, grid.getCanvas().getHeight() / 2, "resources/player/fish-right.png");
        this.grid = grid;
        picture.draw();

        directions = new boolean[4];
        speedStandard = 10;
        for (boolean status : directions) {
            status = false;
        }

    }


    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
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

    public boolean borderDown(double speed) {
        return (picture.getY() + speed + picture.getHeight() >= grid.getCanvas().getHeight());
    }

    public boolean borderUp(double speed) {
        return (picture.getY() - speed <= (grid.PADDING + 50));

    }

    public boolean borderLeft(double speed) {
        return (picture.getX() - speed <= (grid.PADDING + 50));
    }


    public boolean borderRight(double speed) {
        return (picture.getX() + speed + picture.getWidth() >= grid.getCanvas().getWidth());

    }


    public void movePlayer() {

        if(isIsdead()){
            return;
        }

        if ((borderUp(speedY) && speedY < 0) || (borderDown(speedY) && speedY > 0)) {
            setSpeedY(0);
        }

        if ((borderRight(speedX) && speedX > 0) || (borderLeft(speedX) && speedX < 0)) {
            setSpeedX(0);
        }

        picture.translate(speedX, speedY);

    }

    @Override
    public void keyDown() {
        setSpeedY(speedStandard);
        directions[0] = true;

        if (isIsdead()) {
            picture.load("resources/player/DeadFish-DOWN.png");
        } else {
            picture.load("resources/player/fish-down.png");
        }
    }

    @Override
    public void keyUp() {
        setSpeedY(-speedStandard);
        directions[1] = true;

        if (isIsdead()) {
            picture.load("resources/player/DeadFish-UP.png");
        } else {
            picture.load("resources/player/fish-up.png");
        }
    }

    @Override
    public void keyLeft() {
        setSpeedX(-speedStandard);
        directions[2] = true;

        if (isIsdead()) {
            picture.load("resources/player/DeadFish-LEFT.png");
        } else {
            picture.load("resources/player/fish-left.png");
        }
    }

    @Override
    public void keyRight() {
        setSpeedX(speedStandard);
        directions[3] = true;
        if (isIsdead()) {
            picture.load("resources/player/DeadFish-RIGHT.png");
        } else {
            picture.load("resources/player/fish-right.png");
        }
    }

    @Override
    public void keySpace() {
        speedStandard = 20;
    }

    @Override
    public void keySpaceRelease() {
        speedStandard = 10;
    }

    @Override
    public void keyDownRelease() {
        directions[0] = false;
        if (directions[1]) {
            keyUp();
        } else {
            setSpeedY(0);
        }
    }

    @Override
    public void keyUpRelease() {
        directions[1] = false;
        if (directions[0]) {
            keyDown();
        } else {
            setSpeedY(0);
        }
    }


    @Override
    public void keyLeftRelease() {
        directions[2] = false;
        if (directions[3]) {
            keyRight();
        } else {
            setSpeedX(0);
        }
    }

    @Override
    public void keyRightRelease() {
        directions[3] = false;
        if (directions[2]) {
            keyLeft();
        } else {
            setSpeedX(0);
        }
    }

}

