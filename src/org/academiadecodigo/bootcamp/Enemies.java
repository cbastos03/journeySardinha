package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 04/06/2018.
 */
public abstract class Enemies {

    private Picture picture;

    private Grid grid;

    private int speed;
    private EnemiesType enemiesType;
    private int directionX;
    private int directionY;

    public Enemies(int speed, EnemiesType enemiesType, Grid grid) {
        this.speed = speed;
        this.enemiesType = enemiesType;
        this.grid = grid;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }

    public abstract void move();

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public void changeDirection(){        //TODO check if this has to return anything
        directionY = -directionY;
    }



    public Grid getGrid() {
        return grid;
    }

    public int getSpeed() {
        return speed;
    }

    public EnemiesType getEnemiesType() {
        return enemiesType;
    }

    public int getDirectionX() {
        return directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

    public abstract void accelerate();

}
