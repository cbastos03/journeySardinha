package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 05/06/2018.
 */
public class EnemiesMoving extends Enemies{
    private Picture picture;

    public EnemiesMoving(int speed, EnemiesType enemiesType, Grid grid) {
        super(speed, enemiesType, grid);
        int positionY = (int)(Math.random() * getGrid().getCanvas().getHeight());
        int positionX = getGrid().getCanvas().getWidth();
        picture = new Picture(positionX, positionY, "resources/MovingEnemy.png");
        picture.draw();
    }

    @Override
    public void move() {

    }

    @Override
    public Picture getPicture() {
        return super.getPicture();
    }

    @Override
    public void changeDirection() {
        super.changeDirection();
    }

    @Override
    public void accelerate(int speed) {

        for (int i = 0; i < speed; i++) {
            if(picture.getY() <= 0 || picture.getY() >= getGrid().getCanvas().getHeight()){
                this.changeDirection();
            }
            picture.translate(super.getDirectionX(), super.getDirectionY());
        }

    }

}
