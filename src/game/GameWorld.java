package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {


    private Knight knight;
    private Enemy1 enemy1;
    private Enemy2 enemy2;
    private Enemy3 enemy3;
    private EnergyOrbs energyOrbs;



    public GameWorld() {
        super();


        // make the character
        knight = new Knight(this);
        knight.setPosition(new Vec2(7, -14));
        EnergyOrbsPickup pickup = new EnergyOrbsPickup(knight);
        Encounter contact = new Encounter(knight);
        knight.addCollisionListener(contact);
        knight.addCollisionListener(pickup);

        //Make the enemies
        enemy1 = new Enemy1(this);
        enemy1.setPosition(new Vec2(6, -7));

        enemy2 = new Enemy2(this);
        enemy2.setPosition(new Vec2(-6, -14));

        enemy3 = new Enemy3(this);
        enemy3.setPosition(new Vec2(-6, -2));

        //Make the collectible orbs
        energyOrbs = new EnergyOrbs(this);
        energyOrbs.setPosition(new Vec2(-12,-14));

        energyOrbs = new EnergyOrbs(this);
        energyOrbs.setPosition(new Vec2(6,3));


        // make the ground and ceiling
        Shape shape = new BoxShape(22, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -15f));

        StaticBody ceiling = new StaticBody(this, shape);
        ceiling.setPosition(new Vec2(0,15));


        // make a suspended platform
        Shape platformShape = new BoxShape(4, 0.5f);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(6, -7));

        Shape platformShape1 = new BoxShape(3,0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape1);
        platform1.setPosition(new Vec2(-6,-9));

        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(-6,-2));

        StaticBody platform3 = new StaticBody(this,platformShape1);
        platform3.setPosition(new Vec2(6,2));

        Shape platformShape3 = new BoxShape(8,0.5f);
        StaticBody platform4 = new StaticBody(this,platformShape3);
        platform4.setPosition(new Vec2(-9,7));

        //make walls
        Shape wallShape = new BoxShape(1,20.5f);
        StaticBody wall = new StaticBody(this, wallShape);
        wall.setPosition(new Vec2(-15,-5));

        StaticBody wall1 = new StaticBody(this,wallShape);
        wall1.setPosition(new Vec2(15,-5));

        //Door to next level
        Shape doorShape = new PolygonShape(-0.11f,2.08f,
                0.87f,1.68f,
                0.99f,0.49f,
                0.24f,-2.0f,
                -0.95f,-2.0f,
                -1.14f,1.41f);
        StaticBody door = new StaticBody(this,doorShape);
        door.addImage(new BodyImage("data/Dungeondoor.png",7f));
        door.setPosition(new Vec2(-9,10));







    }
    public Knight getKnight(){
        return knight;
    }



}