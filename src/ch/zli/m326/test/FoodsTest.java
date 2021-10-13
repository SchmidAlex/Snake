package ch.zli.m326.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.zli.m326.snakegame.Food;
import ch.zli.m326.snakegame.Foods;
import ch.zli.m326.snakegame.util.Coord;

public class FoodsTest {
    private Foods foods = new Foods();
    private Food food = new Food(new Coord(9, 9));

    @BeforeEach
    public void init(){foods.addFood(food);}

    @Test
    public void intersectsWithAndAddTest() {
        assertTrue(foods.intersectsWith(new Coord(9, 9)));
    }

    @Test
    public void removeFoodTest(){
        foods.removeFood(new Coord(9, 9));
        assertFalse(foods.intersectsWith(new Coord(9, 9)));
    }
}
