package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.enemies.Enemies;
import org.academiadecodigo.bootcamp.keyboard.MyKeyboard;
import org.academiadecodigo.bootcamp.player.Player;
import org.academiadecodigo.bootcamp.sound.Sound;
import org.academiadecodigo.bootcamp.sound.SoundClips;

/**
 * Created by codecadet on 04/06/2018.
 */
public class Game {

    private Player player;
    private Enemies[] enemies;
    private Grid grid;
    private CollisionDetector collisionDetector;
    private MyKeyboard myKeyboard;

    public Game() {
        myKeyboard = new MyKeyboard(this);
        myKeyboard.keyboardInit();
    }



    public void init() throws InterruptedException {



        grid = new Grid(1024, 576, 110);

        //grid.init();
        grid.redraw();
        Factory factory = new Factory();
        player = factory.getPlayer(grid);
        enemies = new Enemies[400];
        boolean isOver = false;

        myKeyboard.setKeyboardable(player);

        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = factory.generateEnemies(grid);
        }
        collisionDetector = new CollisionDetector(enemies, player);
        grid.redrawOcean();

        AwakingEnemies awakingEnemies = new AwakingEnemies();
        awakingEnemies.awake(enemies[0]);
        int counter = 0;

        Sound.play(SoundClips.FUNDAO.getFile(),10);

        while (!collisionDetector.check() && isOver == false) {

            Thread.sleep(50);

            grid.moveAnimations();
            grid.moveGround();
            player.movePlayer();


            for (int i = 0; i < enemies.length; i++) {


                if (counter > 400) {

                    counter = 0;

                    if (awakingEnemies.enemiesAwake < enemies.length) {
                        System.out.println("Enemy " + awakingEnemies.enemiesAwake + " acordou");
                        System.out.println("Enemy " + awakingEnemies.enemiesAwake + " acordou");
                        awakingEnemies.awake(enemies[awakingEnemies.enemiesAwake]);
                    }
                }

                for (int j = 0; j < enemies[i].getSpeed(); j++) {

                    enemies[i].accelerate();
                    collisionDetector.check();
                    counter++;

                    System.out.println(counter);


                }

            }
            for (Enemies c : enemies) {
                if (c.getPicture().getX() > 0) {
                    isOver = false;
                    break;
                } else {
                    isOver = true;
                }
            }


        }
    }

    private class AwakingEnemies {

        private int enemiesAwake = 0;

        public void awake(Enemies enemy) {

            enemy.setSleep();
            enemiesAwake++;

            if (enemiesAwake > 3) {
                grid.removeBackground();
            }

        }
    }
}


