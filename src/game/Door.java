package game;


import city.cs.engine.*;

//Static body for Door so that door doesn't make any movements
public class Door extends StaticBody {
    private static final Shape doorShape = new PolygonShape(-0.11f,2.08f,
            0.87f,1.68f,
            0.99f,0.49f,
            0.24f,-2.0f,
            -0.95f,-2.0f,
            -1.14f,1.41f);
//Door is given an image
    private static final BodyImage image =
            new BodyImage("data/Dungeondoor.png", 4f);

    public Door(World world) {
        super(world,doorShape);
        this.addImage(image);
    }
}