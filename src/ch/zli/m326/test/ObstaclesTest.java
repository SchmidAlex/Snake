package ch.zli.m326.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ch.zli.m326.snakegame.Obstacles;
import ch.zli.m326.snakegame.util.Coord;

public class ObstaclesTest {
    private Obstacles obstacles = new Obstacles();

    @Test
    public void intersectsWithTest() {
        assertTrue(obstacles.intersectsWith(new Coord(0, 0)));
    }
}
