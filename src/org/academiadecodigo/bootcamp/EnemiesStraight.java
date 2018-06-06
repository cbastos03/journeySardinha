package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 06/06/2018.
 */
public class EnemiesStraight extends Enemies {

    public EnemiesStraight(int speed, Grid grid) {
        super(speed, EnemiesType.STRAIGHT, grid);
        int positionY = (int) (Math.random() * getGrid().getCanvas().getHeight());
        int positionX = getGrid().getCanvas().getWidth();
        super.setDirectionX(-1);                              // 1 pixel to the left
        super.setDirectionY(0);    //Random change in y pixels between -3 and 3
        super.setPicture(new Picture(positionX, positionY, "resources/catarina.png"));
        super.getPicture().draw();
    }


    @Override
    public void move() {

    }

    @Override
    public void accelerate() {


        for (int i = 0; i < super.getSpeed(); i++) {
            getPicture().translate(super.getDirectionX(), super.getDirectionY());
        }
    }
}
