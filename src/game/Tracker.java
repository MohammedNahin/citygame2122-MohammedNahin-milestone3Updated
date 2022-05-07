package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import java.awt.geom.Point2D;

public class Tracker implements StepListener {
    private final GameView view;
    private final Knight knight;
    public Tracker(GameView view, Knight knight) {
        this.knight = knight;
        this.view = view;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(knight.getPosition());
    }
}