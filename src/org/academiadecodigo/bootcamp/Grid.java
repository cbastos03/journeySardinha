package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 04/06/2018.
 */
public class Grid {

    public final int PADDING = 0;

    private Rectangle canvas;





    public Grid(int width, int height, int widthFrame) {
        this.canvas = new Rectangle(PADDING,PADDING,width,height);

        Picture lisboa = new Picture(PADDING,PADDING,"resources/lisboa.jpg");
        lisboa.draw();

        Picture oceano = new Picture(PADDING,PADDING,"resources/ocean.png");
        oceano.draw();


    }


    public void init(){
        canvas.draw();


    }


    public Rectangle getCanvas() {
        return canvas;
    }


}
