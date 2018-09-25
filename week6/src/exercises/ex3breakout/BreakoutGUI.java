package exercises.ex3breakout;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static exercises.ex3breakout.Breakout.GAME_HEIGHT;
import static exercises.ex3breakout.Breakout.GAME_WIDTH;
import static exercises.ex3breakout.Brick.BRICK_WIDTH;
import static exercises.ex3breakout.Paddle.PADDLE_SPEED;

/*
 *    Basic Break Out Game
 *    See https://en.wikipedia.org/wiki/Breakout_(video_game)
 *
 *    This is the visible part of the game
 *
 *
 * See:
 * - catchtherain
 */
public class BreakoutGUI extends Application {

    private Breakout breakout;   // Reference to the whole OO model

    // ------- Keyboard handling ----------------------------------
    private void keyPressed(KeyEvent event) {
        KeyCode kc = event.getCode();
        switch (kc) {
            case LEFT:
                // TODO
                break;
            case RIGHT:
                // TODO
                break;
        }
    }

    private void keyReleased(KeyEvent event) {
        KeyCode kc = event.getCode();
        switch (kc) {
            case LEFT:
            case RIGHT:
                // TODO
        }
    }


    @Override
    public void init() {
        // Create the OO model here!
        // TODO Create parts of the model

        // Finally
        // TODO breakout = call contructor for Breakout with all parts

    }

    // ----- Nothing to do below, it's just JavaFX  -----------

    private GraphicsContext gc;
    private AnimationTimer timer;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        Canvas canvas = new Canvas(GAME_WIDTH, GAME_HEIGHT);
        gc = canvas.getGraphicsContext2D();

        root.getChildren().addAll(canvas);

        timer = new AnimationTimer() {
            // Param not used
            public void handle(long now) {
                breakout.update(now);
                render();

            }
        };

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(this::keyPressed);
        scene.setOnKeyReleased(this::keyReleased);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pong");
        primaryStage.show();

        timer.start();
    }

    private void render() {
        gc.clearRect(0, 0, GAME_WIDTH, GAME_HEIGHT);    // Clear everything
        gc.setFill(Color.RED);
        IPositionable ball = breakout.getBall();
        gc.fillOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        gc.setFill(Color.BLUE);
        IPositionable paddle = breakout.getPaddle();
        gc.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
        renderWall();
    }

    private void renderWall() {
        for (IPositionable p : breakout.getBricks()) {
            gc.setFill(Color.BLACK);
            gc.fillRect(p.getX(), p.getY(), p.getWidth(), p.getHeight());
            gc.setFill(Color.YELLOW);
            gc.fillRect(p.getX() + 3, p.getY() + 3, p.getWidth() - 6, p.getHeight() - 6);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }


}
