package game;

import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;

public class LavaFloor extends StaticBody {
//sets width and height of the lavafloor
    private static final Shape floorShape = new BoxShape(4,0.5f);

    public LavaFloor(World w) {
        super(w, floorShape);
        this.setFillColor(Color.red);

    }

}
