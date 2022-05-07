package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public abstract class GameLevel extends World {


    private final Knight knight;
    private final Door door;



    public GameLevel(Game game) {
        super();


        // make the character and door
        knight = new Knight(this);
        door = new Door(this);


        EnergyOrbsPickup pickup = new EnergyOrbsPickup(knight);
        Encounter contact = new Encounter(knight);
        doorEncounter nextLevel = new doorEncounter(this, game);
        this.door.addCollisionListener(nextLevel);
        knight.addCollisionListener(contact);
        knight.addCollisionListener(pickup);





        // make the ground and ceiling
        Shape shape = new BoxShape(22, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -15f));

        StaticBody ceiling = new StaticBody(this, shape);
        ceiling.setPosition(new Vec2(0,15));


        //make walls
        Shape wallShape = new BoxShape(1,20.5f);
        StaticBody wall = new StaticBody(this, wallShape);
        wall.setPosition(new Vec2(-15,-5));

        StaticBody wall1 = new StaticBody(this,wallShape);
        wall1.setPosition(new Vec2(15,-5));









    }
    public Knight getKnight(){
        return knight;
    }

    public Door getDoor() {return door;}

    public abstract boolean isComplete();

    public abstract Image getBackground();



}