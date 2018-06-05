package org.academiadecodigo.bootcamp;

/**
 * Created by codecadet on 04/06/2018.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Grid grid = new Grid(1024, 576, 110);

        //grid.init();

        Player player = new Player(grid, 500, 256);

        Enemies em1 = new EnemiesMoving(2, EnemiesType.MOVING, grid);
        EnemiesMoving em2 = new EnemiesMoving(3, EnemiesType.MOVING, grid);
        EnemiesMoving em3 = new EnemiesMoving(2, EnemiesType.MOVING, grid);
        EnemiesMoving em4 = new EnemiesMoving(2, EnemiesType.MOVING, grid);

        Enemies[] enemies = new Enemies[4];
        enemies[0] = em1;
        enemies[1] = em2;
        enemies[2] = em3;
        enemies[3] = em4;

        CollisionDetector collisionDetector = new CollisionDetector(enemies, player);

        grid.init();


        while (!collisionDetector.check()) {
            Thread.sleep(50);

            for (int i = 0; i < enemies.length; i++) {

                for (int j = 0; j < enemies[i].getSpeed(); j++) {
                    enemies[i].accelerate();
                    collisionDetector.check();

                }

            }

        }
    }
}
