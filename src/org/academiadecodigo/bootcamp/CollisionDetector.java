package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.enemies.Enemies;
import org.academiadecodigo.bootcamp.player.Player;

/**
 * Created by codecadet on 04/06/2018.
 */
public class CollisionDetector {

    private Enemies[] enemies;
    private Player player;
    private boolean collision;

    public CollisionDetector(Enemies[] enemies, Player player) {
        this.enemies = enemies;
        this.player = player;
    }

    private double xmediumPlayer;
    private double ymediumPlayer;
    private double radiusxPlayer;
    private double radiusyPlayer;

    private double xmediumEnemy;
    private double ymediumEnemy;
    private double radiusxEnemy;
    private double radiusyEnemy;



    public boolean isCollision() {
        return collision;
    }


    public boolean check() {

        xmediumPlayer = player.getPicture().getX() + (player.getPicture().getWidth() / 2);
        ymediumPlayer = player.getPicture().getY() + (player.getPicture().getHeight() / 2);
        radiusxPlayer = player.getPicture().getWidth() / 2;
        radiusyPlayer = player.getPicture().getHeight() / 2;

        for (Enemies enemy : enemies) {

            xmediumEnemy = enemy.getPicture().getX() + (enemy.getPicture().getWidth() / 2);
            ymediumEnemy = enemy.getPicture().getY() + (enemy.getPicture().getHeight() / 2);
            radiusxEnemy = enemy.getPicture().getWidth() / 2;
            radiusyEnemy = enemy.getPicture().getHeight() / 2;



            if((xDistance(enemy) < (radiusxPlayer + radiusxEnemy)) && (yDistance(enemy) < (radiusyPlayer + radiusyEnemy))){
                collision = true;
                player.setIsdead(true);
                player.getPicture().load("resources/player/DeadFish-RIGHT.png");
                return true;
            }


        }

        return false;

    }


    public double xDistance(Enemies enemy) {
        return Math.abs(xmediumPlayer - xmediumEnemy);
    }

    public double yDistance(Enemies enemy) {
        return Math.abs(ymediumPlayer - ymediumEnemy);
    }



}
