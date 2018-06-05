package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 05/06/2018.
 */
public class EnemiesMoving extends Enemies {


    public EnemiesMoving(int speed, EnemiesType enemiesType, Grid grid) {
        super(speed, enemiesType, grid);
        int positionY = (int) (Math.random() * getGrid().getCanvas().getHeight());
        int positionX = getGrid().getCanvas().getWidth();
        super.setPicture(new Picture(positionX, positionY, "resources/catarina.png"));
        super.getPicture().draw();
    }

    @Override
    public void move() {

    }


    @Override
    public void changeDirection() {
        super.changeDirection();
    }

    @Override
    public void accelerate() {

        if(getPicture().getX() < 2*getGrid().PADDING){
            return;
        }

        for (int i = 0; i < super.getSpeed(); i++) {


            if (getPicture().getY() <= getGrid().PADDING || getPicture().getY() >= getGrid().getCanvas().getHeight()-getPicture().getHeight()) {
                this.changeDirection();
            }
            getPicture().translate(super.getDirectionX(), super.getDirectionY());
        }
    }

}


