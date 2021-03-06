package ch.zli.m326.snakegame;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import ch.zli.m326.snakegame.util.Coord;

public class Foods {
    private List<Food> foodList = new ArrayList<>();

    /**
     * Adds a food
     * @param food is the food we want to add
     */
    public void addFood(Food food){
        foodList.add(food);
    }

    /**
     * This function checks every food in it, if its intersects with a position we give
     * @param pos is the position we want to check
     * @return true if it intersects, otherwise false
     */
    public boolean intersectsWith(Coord pos) {
        for (Food food : foodList) {
            if(food.getFoodPos().equals(pos)) return true;
        }
        return false;
    }

     /**
      * Draws every single food
      * @param g is the graphics2D to paint
      * @param square is the width of a square in the panel
      * @param offset is the amount of pixel we have left after all squares
      */
    public void draw(Graphics2D g, int square, int offset) {
        for (Food food : foodList) {
            food.draw(g, square, offset);
        }
    }

    /**
     * Removes a food of the list if the position we give
     * @param pos the position we want to remove the food
     */
    public void removeFood(Coord pos){
        for (Food food : foodList) {
            if (food.getFoodPos().equals(pos)) {
                foodList.remove(food);
                return;
            }
        }
    }
}
