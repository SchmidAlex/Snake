package ch.zli.m326.snakegame;

import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

import ch.zli.m326.game.snakegame.SnakeGame;
import ch.zli.m326.snakegame.util.Direction;

public class SnakeGameLogic {
    private SnakeGame game;
    private Timer timer;
    private Level level = new Level();
    private int points;
    private int levelHeight = 1;

    /**
     * Constructor for the gamelogic
     * @param game the game we need
     */
    public SnakeGameLogic(SnakeGame game){
        this.game = game;
        this.points = 0;
    }

    /**
     * We need that so it can delegate to the level to draw
     * @param panel is the panel to paint on
     * @param g is the graphics2D
     */
    public void draw(JPanel panel, Graphics2D g){
        level.draw(panel, g);
    }

    /**
     * The timer we need for the game
     */
    public void initAfterLevelChanged(){
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                processTick();
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 2, (430 - (levelHeight * 30)));
    }

    /**
     * The hole logic is here... this function does everything it needs to do in one tick
     */
    public void processTick(){
        // If the game is over or paused we wont do anything
        if (game.isGameOver() || game.isPaused()) {
            return;
        }

        // lets the snake move, gain points, change level, grow and eat if theres a food
        if(level.SnakemoveAndEat()){
            points++;
            if(points % 5 == 0 && points != 0){
                levelHeight++;
                levelUp();
            }
        }
        // checks if the snke colided with something that it would die
        if(level.checkDyingCollisions()){
            game.setGameOver();
        }

        // redraw the game so we can see changes
        game.gameNeedsRedraw();
    }

    /**
     * Function is called from keyboardlistener to call a change direction
     * @param dir the direction the user wants to go
     */
    public void changeDir(Direction dir){
        level.changeDir(dir);
    }

    /**
     * When we change the level we want a new speed, so we need to cancel the timer and set it new
     */
    public void cancelTimer(){
        timer.cancel();
    }

    /**
     * To get the amount of points the player haves
     * @return the points
     */
    public int getPoints(){
        return this.points;
    }

    /**
     * To get the level we are in
     * @return the levelnumber
     */
    public int getLevelHeight(){
        return this.levelHeight;
    }

    /**
     * if we have enough points, we get to the next level
     */
    private void levelUp(){
        game.pauseGame();
        cancelTimer();
        initAfterLevelChanged();
        this.level = new Level(levelHeight -1, levelHeight -1);
    }
}
