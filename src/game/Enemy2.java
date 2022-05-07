package game;


import city.cs.engine.*;

public class Enemy2 extends Walker {
    private static final Shape enemy1Shape = new PolygonShape(-0.11f,2.08f,
            0.87f,1.68f,
            0.99f,0.49f,
            0.24f,-2.0f,
            -0.95f,-2.0f,
            -1.14f,1.41f);
//Gives a specific image to Enemy2
    private static final BodyImage image =
            new BodyImage("data/Enemy2.png", 3f);

    public Enemy2(World world) {
        super(world, enemy1Shape);
        addImage(image);
    }
}