package samples.catchtherain;

import javafx.scene.paint.Color;

/*
        The ground the bucket is standing (moving) on.
 */
public class Ground extends AbstractPositionable {

    public static final double GROUND_HEIGHT = 10;
    private final Color color;

    public Ground(double x, double y, double width, Color color) {
        super(x, y, width, GROUND_HEIGHT);
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
