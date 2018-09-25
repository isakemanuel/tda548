package samples.catchtherain;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static samples.catchtherain.Bucket.BUCKET_HEIGHT;
import static samples.catchtherain.Bucket.BUCKET_SPEED;
import static samples.catchtherain.Ground.GROUND_HEIGHT;


/**
 *   A game for catching raindrops in a bucket
 *
 *   This is both the OO model and the GUI (just fo now, not like this in labs)
 *
 *   To run the game run this
 */
public class CatchTheRainGUI extends Application {

    // Global read only data
    public static final double GAME_WIDTH = 500;
    public static final double GAME_HEIGHT = 500;
    public static final long HALF_SEC = 500_000_000;

    // This is the OO model (RainDrops come and go)
    private final List<IPositionable> drops = new ArrayList<>();
    private Bucket bucket = new Bucket(GAME_WIDTH / 2, GAME_HEIGHT - GROUND_HEIGHT - BUCKET_HEIGHT
            , Color.BLUE);
    private Ground ground = new Ground(0, GAME_HEIGHT - GROUND_HEIGHT, GAME_WIDTH, Color.BROWN);
    private int points = 0;

    // Administration
    private long timeForLastDrop;  // Use time supplied by JavaFX
    private List<IPositionable> toRemove = new ArrayList<>();

    // The main "game loop" that makes everything happens
    // Called by timer approx. 1/60 sec.
    void update(long now) {
        bucket.move();   // No check for hitting left/right margin

        for (IPositionable d : drops) {
            RainDrop r = (RainDrop) d;
            r.move();
            if (r.intersects(ground) || r.intersects(bucket)) {
                toRemove.add(d);
                if( r.intersects(bucket)){
                    points += r.getDy();
                }
            }
        }
        drops.removeAll(toRemove);
        toRemove.clear();

        if (now - timeForLastDrop > HALF_SEC) {
            drops.add(createRainDrop());
            timeForLastDrop = now;
        }

    }

    // -- Handle keyboard -----------------------

    void handleKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT:
                bucket.setDx(-BUCKET_SPEED);
                break;
            case RIGHT:
                bucket.setDx(BUCKET_SPEED);
                break;
            default:
                ;
        }
    }

    void handleKeyReleased(KeyEvent event) {
        bucket.setDx(0);
    }

    // --- Utility --------------------

    private final Random rand = new Random();

    // Create Raindrop with random size, speed, color
    private RainDrop createRainDrop() {
        double x = 50 + rand.nextInt((int) GAME_WIDTH - 100);
        double y = 0 - rand.nextInt(20);
        double width = 5 + rand.nextInt(20);
        double height = width;
        double dy = 1 + rand.nextInt((int)(60 / width));//1 / (int) width);
        Color color = Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
        return new RainDrop(x, y, width, height, dy, color);
    }

   // ------------ JavaFX don't need to understand -----------------------------

    private GraphicsContext fg;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();
        Canvas canvas = new Canvas(GAME_WIDTH, GAME_HEIGHT);
        fg = canvas.getGraphicsContext2D();

        root.getChildren().addAll(canvas);

        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                update(now);
                render();

            }
        };
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(this::handleKeyPressed);
        scene.setOnKeyReleased(this::handleKeyReleased);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Catch the Rain");
        primaryStage.show();

        timer.start();
    }

    void render() {
        fg.clearRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        fg.setFill(Color.BLACK);
        fg.fillText("Points: " + points, 10, 20);
        fg.setFill(ground.getColor());
        fg.fillRect(ground.getX(), ground.getY(), ground.getWidth(), ground.getHeight());
        fg.setFill(bucket.getColor());
        fg.fillRect(bucket.getX(), bucket.getY(), bucket.getWidth(), bucket.getHeight());
        for (IPositionable d : drops) {
            fg.setFill(d.getColor());
            fg.fillOval(d.getX(), d.getY(), d.getWidth(), d.getHeight());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
