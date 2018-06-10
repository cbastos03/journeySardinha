package org.academiadecodigo.bootcamp.enemies;

import org.academiadecodigo.bootcamp.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 10/06/2018.
 */
public class EnemiesBoss extends Enemies{

    public EnemiesBoss(int speed, Grid grid) {
        super(speed, EnemiesType.BOSS, grid);
        int positionY = (int) (Math.random() * (getGrid().getCanvas().getHeight() - 100));
        int positionX = getGrid().getCanvas().getWidth();
        super.setDirectionX(-1);                              // 1 pixel to the left
        super.setDirectionY(0);    //Random change in y pixels between -3 and 3
        super.setPicture(new Picture(positionX, positionY, "resources/enemies/catarina.png"));
        super.getPicture().draw();
    }


    @Override
    public void accelerate() {
        if (isSleep()){
            return;
        }

        for (int i = 0; i < super.getSpeed(); i++) {
            getPicture().translate(super.getDirectionX(), super.getDirectionY());
        }
    }
}
