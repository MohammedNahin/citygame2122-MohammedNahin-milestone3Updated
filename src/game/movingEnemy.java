package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class movingEnemy extends Walker implements StepListener{
    private static final Shape patrollingEnemyShape = new PolygonShape(-0.11f,2.08f,
            0.87f,1.68f,
            0.99f,0.49f,
            0.24f,-2.0f,
            -0.95f,-2.0f,
            -1.14f,1.41f);

    private String direction;
    private static final BodyImage leftImage =
            new BodyImage("data/movingEnemy.png", 4f);

    private static final BodyImage rightImage =
            new BodyImage("data/movingEnemy.png", 4f);

    private final int SPEED = 3;
    private float left, right;
    private final int RANGE = 5;


    public movingEnemy(World world) {
        super(world, patrollingEnemyShape);
        addImage(rightImage);
        world.addStepListener(this);
        direction = "left";
        //setAlwaysOutline(true); - used to see outline of body
        startWalking(SPEED);

    }


    @Override
    public void setPosition(Vec2 position){
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;
    }

    @Override
    public void preStep(StepEvent stepEvent){
        if(getPosition().x > right){
            startWalking(-SPEED);
            this.removeAllImages();
            this.addImage(leftImage);
        }
        if(getPosition().x < left){
            startWalking(SPEED);
            this.removeAllImages();
            this.addImage(rightImage);
        }

    }

    @Override
    public void postStep(StepEvent stepEvent){

    }

}
