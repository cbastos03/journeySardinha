package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.enemies.Enemies;
import org.academiadecodigo.bootcamp.keyboard.MyKeyboard;
import org.academiadecodigo.bootcamp.keyboard.Null;
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

        menu = new Menu();
        keyboard.setKeyboardable(menu);
        while (menu.isInMenu()) {
            System.out.println("");
        }
        try {
            Null empty = new Null();
            keyboard.setKeyboardable(empty);
            initGame();
            Sound.stop();
            Sound.play(SoundClips.PUMA.getFile(),10000);
            Thread.sleep(9000);
            System.exit(1);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void initGame() throws InterruptedException {


        grid = new Grid(1024, 576);
        factory = new Factory();

        Sound.play(SoundClips.FUNDAO.getFile(),1000000000);

        Levels levels = new Levels();
        grid.makeWin(currentLevel);
        Thread.sleep(5000);
        grid.removeWin(currentLevel);
        // 15 2500
        levels.level(15, 2500 );

        if (collisionDetector.isCollision()) {

            Sound.stop();
            Sound.play(SoundClips.DIES.getFile(),0);
            Thread.sleep(2003);
            grid.gameOver();

            return;
        }
        levels.levelClean(currentLevel);
        currentLevel++;
        Sound.stop();
        Sound.play(SoundClips.LISBOA.getFile(),1000000000);

        grid.makeWin(currentLevel);
        Thread.sleep(3000);
        grid.removeWin(currentLevel);

        //30 2500
        levels.level(30, 2500);
        if (collisionDetector.isCollision()) {
            Sound.stop();
            Sound.play(SoundClips.DIES.getFile(),0);
            Thread.sleep(2002);
            grid.gameOver();

            return;
        }

        levels.levelClean(2);
        currentLevel++;
        Sound.stop();
        Sound.play(SoundClips.MARROCOS.getFile(),1000000000);

        grid.makeWin(currentLevel);
        Thread.sleep(5000);
        grid.removeWin(currentLevel);

        levels.level(100, 15000);

        if (collisionDetector.isCollision()) {

            Sound.stop();
            Sound.play(SoundClips.DIES.getFile(),0);
            Thread.sleep(2001);
            grid.gameOver();

            return;
        }


    }
    private class AwakingEnemies {
        private int enemiesAwake = 0;
        public void awake(Enemies[] enemy) {
            enemy[enemiesAwake].setSleep();
            enemiesAwake++;
           // if (enemiesAwake > 3 && currentLevel != 3) {
             //   grid.removeBackground();
            //}
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
                    enemies[i] = factory.generateEnemies(grid,currentLevel);
                }

            grid.redrawOcean();
            //awakingEnemies.awake(enemies[0]);
        }
        public void levelClean(int level) {
            for (Enemies enemy : enemies) {
                enemy.getPicture().delete();
            }
            awakingEnemies.enemiesAwake = 0;
            player.getPicture().delete();
            grid.changeBackground(level + 1);
            grid.removeWin(currentLevel);
        }
        public void level(int numOfEnemies, int counterLimit) throws InterruptedException {
            reload(numOfEnemies);
            grid.redraw();
            while (!collisionDetector.check() && !isOver) {
                grid.moveAnimations();
                grid.moveGround();
                player.movePlayer();
                for (int i = 0; i < enemies.length; i++) {
                    if(numOfEnemies > 99 && awakingEnemies.enemiesAwake > 15){
                        counterLimit = 450;
                    }
                    if (counter > counterLimit) {
                        counter = 0;
                        if (awakingEnemies.enemiesAwake < enemies.length) {
                            awakingEnemies.awake(enemies);
                        }
                    }
                    for (int j = 0; j < enemies[i].getSpeed(); j++) {
                        enemies[i].accelerate();
                        collisionDetector.check();
                        counter++;
                    }
                }
                for (Enemies c : enemies) {
                    if (c.getPicture().getX() > -c.getPicture().getWidth()) {
                        isOver = false;
                        break;
                    } else {
                        isOver = true;
                    }
                }
                Thread.sleep(25);
            }
        }
    }

}
