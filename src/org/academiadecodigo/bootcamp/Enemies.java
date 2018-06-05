package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 04/06/2018.
 */
public abstract class Enemies {

    private Picture picture;
    private Grid grid;

    public abstract void move();

    public Picture getPicture() {
        return picture;
    }


}
