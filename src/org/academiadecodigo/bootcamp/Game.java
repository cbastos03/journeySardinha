package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.enemies.Enemies;
import org.academiadecodigo.bootcamp.keyboard.MyKeyboard;
import org.academiadecodigo.bootcamp.player.Player;
import org.academiadecodigo.bootcamp.sound.Sound;
import org.academiadecodigo.bootcamp.sound.SoundClips;
import org.academiadecodigo.simplegraphics.graphics.Canvas;

/**
 * Created by codecadet on 04/06/2018.
 */
public class Game {

    private Player player;
    private Enemies[] enemies;
    private Grid grid;
    private CollisionDetector collisionDetector;
    private Factory factory;
    private AwakingEnemies awakingEnemies = new AwakingEnemies();
    private int currentLevel = 1;
    private MyKeyboard keyboard;
    private Menu menu;

    public Game() throws InterruptedException {
        keyboard = new MyKeyboard(this);

        initMenu();
    }


    public void initMenu() {
        menu = new Menu(this);
        keyboard.setKeyboardable(menu);

        while (menu.isInMenu()) {
            System.out.println("olaa");
        }
        try {
            initGame();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }


    public void initGame() throws InterruptedException {

        grid = new Grid(1024, 576);

        factory = new Factory();

        Levels levels = new Levels();


        levels.level(20, 1500);

        if (collisionDetector.isCollision()) {
            return;
        }
        grid.makeWin();
        Thread.sleep(5000);
        levels.levelClean(1);
        currentLevel++;
        levels.level(40, 300);

        if (collisionDetector.isCollision()) {
            return;
        }

        currentLevel++;
        grid.makeWin();
        Thread.sleep(5000);
        levels.levelClean(2);
        levels.level(500, 300);


    }


    private class AwakingEnemies {

        private int enemiesAwake = 0;

        public void awake(Enemies enemy) {

            enemy.setSleep();
            enemiesAwake++;

            if (enemiesAwake > 3 && currentLevel != 3) {
                grid.removeBackground();

            }

        }
    }

    private class Levels {

        private boolean isOver = false;
        private int counter = 0;

        public void reload(int numOfEnemies) {


            player = factory.getPlayer(grid);

            keyboard.setKeyboardable(player);

            enemies = new Enemies[numOfEnemies];
            isOver = false;
            collisionDetector = new CollisionDetector(enemies, player);
            counter = 0;
            for (int i = 0; i < enemies.length; i++) {
                enemies[i] = factory.generateEnemies(grid);
            }
            grid.redrawOcean();
            awakingEnemies.awake(enemies[0]);
        }

        public void levelClean(int level) {
            for (Enemies enemy : enemies) {
                enemy.getPicture().delete();
            }
            awakingEnemies.enemiesAwake = 0;
            player.getPicture().delete();
            grid.changeBackground(level + 1);
            grid.removeWin();

        }


        public void level(int numOfEnemies, int counterLimit) throws InterruptedException {

            reload(numOfEnemies);

            grid.redraw();

            while (!collisionDetector.check() && !isOver) {


                grid.moveAnimations();
                grid.moveGround();
                player.movePlayer();


                for (int i = 0; i < enemies.length; i++) {


                    if (counter > counterLimit) {

                        counter = 0;

                        if (awakingEnemies.enemiesAwake < enemies.length) {

                            awakingEnemies.awake(enemies[awakingEnemies.enemiesAwake]);
                        }
                    }

                    for (int j = 0; j < enemies[i].getSpeed(); j++) {

                        enemies[i].accelerate();
                        collisionDetector.check();
                        counter++;

                        //System.out.println(counter);

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

                Thread.sleep(50);
            }

        }

    }
}
