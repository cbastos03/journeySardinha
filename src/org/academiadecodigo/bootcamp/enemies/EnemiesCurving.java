package org.academiadecodigo.bootcamp.enemies;

import org.academiadecodigo.bootcamp.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 10/06/2018.
 */
public class EnemiesCurving extends Enemies{

    boolean goingDown;

    public EnemiesCurving(int speed, Grid grid) {
        super(speed, EnemiesType.CURVING, grid);
        int positionY = (int) (Math.random() * (getGrid().getCanvas().getHeight() - 100));
        int positionX = getGrid().getCanvas().getWidth();
        super.setDirectionX(-1);                                // 1 pixel to the left
        super.setDirectionY(5);    //Random change in y pixels between -3 and 3
        super.setPicture(new Picture(positionX, positionY, "resources/enemies/enemy" + getEnemyIndexPic() + ".png"));
        super.getPicture().draw();
        this.goingDown = true;
    }

    @Override
    public void changeDirection() {
        super.changeDirection();
    }

    @Override
    public void accelerate() {

        if (isSleep()) {
            return;
        }

        for (int i = 0; i < super.getSpeed(); i++) {

            if (getPicture().getY() <= 0 ||
                    getPicture().getY() >= getGrid().getCanvas().getHeight() - getPicture().getHeight()) {
                this.changeDirection();
            }

            curve();

            getPicture().translate(super.getDirectionX(), super.getDirectionY());
        }
    }

    public void curve(){
        if(super.getDirectionY() == -5){
            goingDown = false;
        }
        if(super.getDirectionY() == 5){
            goingDown = true;
        }

        if(goingDown){
            super.setDirectionY(super.getDirectionY()-1);
        }else{
            super.setDirectionY(super.getDirectionY()+1);
        }

    }
}
