package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 04/06/2018.
 */
public class Grid {

    public final int PADDING = 0;

    private Rectangle canvas;
    private Picture[] backgrounds = new Picture[3];
    private Picture[] ground = new Picture[1];
    private Picture[] animations = new Picture[1];
    private Picture gameOver;
    private int animationIndex = 0;
    private int groundIndex = 0;
    private Picture ocean;
    private Picture win[] = new Picture[3];



    public Grid(int width, int height) {

        this.canvas = new Rectangle(PADDING, PADDING, width, height);
        //canvas.delete();


        for (int i = 0; i < backgrounds.length; i++) {

            backgrounds[i] = new Picture(PADDING, canvas.getHeight() / 7, "resources/grid/backgrounds/background" + i + ".png");

        }

        gameOver = new Picture(0, 0, "resources/menu/GAME-OVER.jpg");


        backgrounds[0].draw();

        ocean = new Picture(PADDING, 0, "resources/grid/backgrounds/ocean.png");

        for (int i = 0; i < win.length; i++) {

            win[i] = new Picture(canvas.getWidth() / 2, canvas.getHeight() / 2, "resources/grid/levels/win" + i + ".png");

        }


        int distance = 0;
        for (int i = 0; i < animations.length; i++) {

            animations[i] = new Picture(100 + distance, canvas.getHeight(), "resources/grid/animations/bubbles" + i + ".png");
            distance = distance + 100;
            animations[i].draw();
        }

        for (int i = 0; i < ground.length; i++) {

            ground[i] = new Picture(canvas.getWidth(), 400, "resources/grid/ground/seaweed" + i + ".png");
            ground[i].draw();

        }
        //canvas.draw();
        ocean.draw();
    }


    public void redraw() {
        int counter = 0;
        int distance = 0;
        for (Picture c : animations) {
            c.delete();
            animations[counter] = new Picture(100 + distance, canvas.getHeight(), "resources/grid/animations/bubbles" + counter + ".png");
            distance = distance + 100;
            animations[counter].draw();
            counter++;
            redrawOcean();
        }

        counter = 0;
        for (Picture c : ground) {
            c.delete();
            ground[counter] = new Picture(canvas.getWidth() + PADDING, canvas.getHeight() - ground[counter].getHeight(), "resources/grid/ground/seaweed" + counter + ".png");
            ground[counter].draw();
            counter++;
        }
        redrawOcean();
    }

    public void changeAnimations() {

        animationIndex++;
        if (animationIndex >= animations.length) {
            animationIndex = 0;
        }
    }

    public void changeGround() {

        groundIndex++;

        if (groundIndex >= ground.length) {
            groundIndex = 0;
        }
    }

    public void redrawOcean() {
        ocean.delete();
        ocean.draw();
    }


    public void changeBackground(int level) {

        if (level < 0) {
            return;
        }

        backgrounds[level - 1].draw();
        // backgrounds[level-1].translate(canvas.getWidth()+PADDING,PADDING);
        backgrounds[level - 2].delete();
        redraw();
    }

    public void makeWin(int level) {

        win[level - 1].draw();
    }

    public void removeWin(int level) {

        win[level - 1].delete();
    }


    public void moveGround() {

        ground[groundIndex].translate(-10, 0);

        if (ground[groundIndex].getX() < -ground[groundIndex].getWidth()) {


            ground[groundIndex].translate(canvas.getWidth() + ground[groundIndex].getWidth(), 0);

            changeGround();
        }

    }


    public void removeBackground() {

        for (Picture c : backgrounds) {
            c.delete();
        }
    }


    public void moveAnimations() {

        int position = animations[animationIndex].getX();

        animations[animationIndex].translate(-5, -10);

        if (animations[animationIndex].getY() <= -animations[animationIndex].getHeight()) {

            animations[animationIndex].translate(canvas.getWidth() / 2 - position, canvas.getHeight() + animations[animationIndex].getHeight());
            changeAnimations();
        }
    }


    public void gameOver() {

        gameOver.draw();

    }

    public Rectangle getCanvas() {
        return canvas;
    }


}
