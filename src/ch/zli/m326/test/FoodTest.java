package ch.zli.m326.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ch.zli.m326.snakegame.Food;
import ch.zli.m326.snakegame.util.Coord;

public class FoodTest {
    private Food food = new Food(new Coord(9, 9));

    @Test
    public void intersectsWithTest() {
        assertTrue(food.intersectsWith(new Coord(9, 9)));
    }

    @Test
    public void getFoodPosTest(){
        assertEquals(new Coord(9, 9), food.getFoodPos());
    }
}
