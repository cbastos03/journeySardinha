package org.academiadecodigo.bootcamp;

/**
 * Created by codecadet on 04/06/2018.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Grid grid = new Grid(1024,576,110);

        grid.init();

        Player player = new Player(grid, 500, 256);

        EnemiesMoving em1 = new EnemiesMoving(10,EnemiesType.MOVING, grid);
        EnemiesMoving em2 = new EnemiesMoving(15,EnemiesType.MOVING, grid);
        EnemiesMoving em3 = new EnemiesMoving(5,EnemiesType.MOVING, grid);
        EnemiesMoving em4 = new EnemiesMoving(20,EnemiesType.MOVING, grid);

        for (int i = 0; i < 500; i++) {
            Thread.sleep(50);
            em1.accelerate(em1.getSpeed());
            em2.accelerate(em2.getSpeed());
            em3.accelerate(em3.getSpeed());
            em4.accelerate(em4.getSpeed());
        }

    }
}