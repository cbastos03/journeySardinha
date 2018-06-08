package org.academiadecodigo.bootcamp;

/**
 * Created by codecadet on 04/06/2018.
 */
public class Game {

    private Player player;
    private Enemies[] enemies;
    private Grid grid;
    private CollisionDetector collisionDetector;


    public void init() throws InterruptedException {

        grid = new Grid(1024, 576, 110);

        Factory factory = new Factory();
        player = factory.getPlayer(grid);
        enemies = new Enemies[6];

        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = factory.generateEnemies(grid);
        }

        collisionDetector = new CollisionDetector(enemies, player);

        grid.init();


        Thread.sleep(1000);
        grid.makeWin();
        Thread.sleep(1000);
        grid.removeWin();
        grid.changeBackground(2);

        while(true){
            Thread.sleep(80);
            grid.redrawOcean();
            grid.moveAnimations();
            grid.moveGround();
            //grid.moveOcean();
        }


        /*while (!collisionDetector.check()) {
            Thread.sleep(50);

            player.movePlayer();

            for (int i = 0; i < enemies.length; i++) {

                for (int j = 0; j < enemies[i].getSpeed(); j++) {
                    enemies[i].accelerate();
                    collisionDetector.check();

                }

            }

        }*/
    }


}
