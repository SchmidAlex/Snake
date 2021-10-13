package ch.zli.m326.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ch.zli.m326.snakegame.Desert;
import ch.zli.m326.snakegame.util.Coord;
import ch.zli.m326.snakegame.util.Direction;

public class DesertTest {
    private Desert desert = new Desert();

    @Test
    public void nextPosTest() {
        assertEquals(new Coord(6, 5), desert.nextPos(new Coord(5, 5), Direction.right));
    }
}
