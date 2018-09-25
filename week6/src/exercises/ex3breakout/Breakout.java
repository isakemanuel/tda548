package exercises.ex3breakout;


import java.util.ArrayList;
import java.util.List;


/*
 * Logic for the Break Out Game (nothing visible here)
 *
 */
public class Breakout {
    // Global read only data
    public static final double GAME_WIDTH = 500;
    public static final double GAME_HEIGHT = 500;
    private static final long ONE_SEC = 1_000_000_000;

    // TODO
    //Instance variables for ball, bricks, walls, etc


    private long timeForLastHit;
    // -------- Game logic ----------------------------

    void update(long now) {
        // TODO The game loop , move check collisions etc.
    }




    // ------------ Use by GUI ---------------

    public void setPaddleSpeed(double paddleSpeed) {
        // TODO
    }

    public List<IPositionable> getBricks() {
        List<IPositionable> ps = new ArrayList<>();
        // TODO
        return ps;
    }

    public IPositionable getPaddle() {
        return null;   // TODO
    }

    public IPositionable getBall() {
        return null; // TODO
    }
}
