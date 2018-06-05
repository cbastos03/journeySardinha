package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 04/06/2018.
 */
public class Player {

    private Grid grid;
    private Picture picture;

    public Player(Grid grid, int width, int height) {
        picture = new Picture(width,height,"resources/sardinha.png");
        this.grid = grid;
        picture.draw();
    }


    private boolean isdead;

    public boolean isIsdead() {
        return isdead;
    }

    public void setIsdead(boolean isdead) {
        this.isdead = isdead;
    }

    public void move() {

    }

    public Picture getPicture() {
        return picture;
    }


}
