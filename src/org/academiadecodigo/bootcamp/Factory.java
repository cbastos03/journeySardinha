package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.enemies.*;
import org.academiadecodigo.bootcamp.player.Player;

/**
 * Created by codecadet on 04/06/2018.
 */
public class Factory {

    public Enemies generateEnemies(Grid grid, int level) {

    double random = Math.random();


        if (random > 0.7) {
        return getMovingEnemy(grid);
    }
        if(random > 0.4){
        return getStraightEnemy(grid);
    }

       return getCurvingEnemy(grid);
}


    public Enemies getMovingEnemy(Grid grid) {
        return new EnemiesMoving(2, grid);
    }

    public Enemies getStraightEnemy(Grid grid) {
        return new EnemiesStraight(3, grid);
    }

    public Enemies getCurvingEnemy(Grid grid) {
        return new EnemiesCurving(2, grid);

    }



    public Player getPlayer(Grid grid){
        return new Player(grid);
    }

    public Enemies getBoss(Grid grid){
        return new EnemiesBoss(1, grid);
    }


}
