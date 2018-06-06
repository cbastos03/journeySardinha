package org.academiadecodigo.bootcamp;

/**
 * Created by codecadet on 04/06/2018.
 */
public class Factory {


    public Enemies generateEnemies(Grid grid) {
        double random = Math.random();

        if (random > 0.3) {
            return getMovingEnemy(grid);
        } else {
            return getStraightEnemy(grid);
        }
    }


    public Enemies getMovingEnemy(Grid grid) {
        return new EnemiesMoving((int) (Math.random() * 5), grid);
    }

    public Enemies getStraightEnemy(Grid grid) {
        return new EnemiesStraight((int) (Math.random() * 5), grid);
    }

    public Player getPlayer(Grid grid){
        return new Player(grid);
    }


}
