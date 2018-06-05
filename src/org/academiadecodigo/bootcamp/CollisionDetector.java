package org.academiadecodigo.bootcamp;

/**
 * Created by codecadet on 04/06/2018.
 */
public class CollisionDetector {

    private Enemies[] enemies;
    private Player player;

    public CollisionDetector(Enemies[] enemies, Player player) {
        this.enemies = enemies;
        this.player = player;
    }

    private double xmediumPlayer;
    private double ymediumPlayer;
    private double radiusPlayer;

    private double xmediumEnemy;
    private double ymediumEnemy;
    private double radiusEnemy;

    private double centersDistance;




    public boolean check() {

        xmediumPlayer = player.getPicture().getX() + (player.getPicture().getWidth() / 2);
        ymediumPlayer = player.getPicture().getY() + (player.getPicture().getHeight() / 2);
        radiusPlayer = player.getPicture().getWidth() / 2;

        for (Enemies enemy : enemies) {

            xmediumEnemy = enemy.getPicture().getX() + (enemy.getPicture().getWidth() / 2);
            ymediumEnemy = enemy.getPicture().getY() +(enemy.getPicture().getHeight() / 2);
            radiusEnemy = enemy.getPicture().getWidth() / 2;

            centersDistance = centerDistance(enemy);

            if(centersDistance < (radiusPlayer + radiusEnemy)){
                return true;
            }

        }

        return false;

    }

    public double centerDistance(Enemies enemy) {

        double cateto1 = xmediumPlayer - xmediumEnemy;

        double cateto2 = ymediumPlayer - ymediumEnemy;

        double hipotenusa = Math.sqrt(Math.pow(cateto1,2) + Math.pow(cateto2,2));

        return hipotenusa;

    }


}
