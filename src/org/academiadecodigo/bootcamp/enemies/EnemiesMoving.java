package org.academiadecodigo.bootcamp.enemies;

import org.academiadecodigo.bootcamp.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 05/06/2018.
 */
public class EnemiesMoving extends Enemies {


    public EnemiesMoving(int speed, Grid grid) {
        super(speed, EnemiesType.MOVING, grid);
        int positionY = (int) (Math.random() * getGrid().getCanvas().getHeight());
        int positionX = getGrid().getCanvas().getWidth();
        super.setDirectionX(-1);                              // 1 pixel to the left
        super.setDirectionY((int)(Math.random() * 10 - 5));    //Random change in y pixels between -3 and 3
        super.setPicture(new Picture(positionX, positionY, "resources/enemies/faustino-2.png"));
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

       // if(getPicture().getX() < 2*getGrid().PADDING){
         //   return;
       // }

        for (int i = 0; i < super.getSpeed(); i++) {


            if (getPicture().getY() <= getGrid().PADDING || getPicture().getY() >= getGrid().getCanvas().getHeight()-getPicture().getHeight()) {
                this.changeDirection();
            }
            getPicture().translate(super.getDirectionX(), super.getDirectionY());
        }
    }

}


