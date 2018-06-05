package org.academiadecodigo.bootcamp;

/**
 * Created by codecadet on 04/06/2018.
 */
public class Main {

    public static void main(String[] args) {

        Grid grid = new Grid(1024,576,110);

        grid.init();

        Player player = new Player(grid, 500, 256);

    }
}