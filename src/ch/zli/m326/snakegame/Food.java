package ch.zli.m326.snakegame;

import java.awt.Graphics2D;
import java.awt.Color;

import ch.zli.m326.snakegame.util.Coord;

public class Food {
    private Coord position;

    /**
     * Foodconstructor
     * @param pos as object Coord, is the position we place the food
     */
    public Food(Coord pos){
        this.position = pos;
    }

    /**
     * Draws the food as a red rectangel
     * @param g is the graphics2D to paint
     * @param square is the width of a square in the panel
     * @param offset is the amount of pixel we have left after all squares
     */
    public void draw(Graphics2D g, int square, int offset){
        g.setColor(Color.RED);
        g.fillRect(position.getX() * square + 2 + (offset / 2), position.getY() * square + 2 + (offset / 2), square - 4, square - 4);
    }

    /**
     * Checks if a position intesects with the food
     * @param pos the position we want to check, as object from the helpclass Coord
     * @return true or fals, true if pos intersects with the food
     */
    public boolean intersectsWith(Coord pos){
        return this.position.equals(pos);
    }

    /**
     * To get the position of the food
     * @return the position as Coord
     */
    public Coord getFoodPos(){
        return position;
    }
}
