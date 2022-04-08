package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public abstract class GameLevel extends World {


    private Knight knight;
    private EnergyOrbs energyOrbs;
    private Enemy1 enemy1;
    private Enemy2 enemy2;
    private Enemy3 enemy3;
    private Door door;



    public GameLevel(Game game) {
        super();


        // make the character
        knight = new Knight(this);
        enemy1 = new Enemy1(this);
        enemy2 = new Enemy2(this);
        enemy3 = new Enemy3(this);
        door = new Door(this);


        EnergyOrbsPickup pickup = new EnergyOrbsPickup(knight);
        Encounter contact = new Encounter(knight);
        doorEncounter nextLevel = new doorEncounter(this, game);
        this.door.addCollisionListener(nextLevel);
        knight.addCollisionListener(contact);
        knight.addCollisionListener(pickup);

        //Make the enemies




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

    public Enemy1 getEnemy1() {return enemy1;}

    public Enemy2 getEnemy2() {return enemy2;}

    public Enemy3 getEnemy3() {return enemy3;}

    public Door getDoor() {return door;}

    public abstract boolean isComplete();

    public abstract Image getBackground();



}