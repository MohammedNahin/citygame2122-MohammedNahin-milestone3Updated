package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level2 extends GameLevel {

    Image background;

    public Level2(Game game){
        super(game);

        background = new ImageIcon("data/Dungeon.png").getImage();

        //Make the collectible orbs
        EnergyOrbs energyOrbs1 = new EnergyOrbs(this);
        energyOrbs1.setPosition(new Vec2(-12,-14));

        EnergyOrbs energyOrbs2 = new EnergyOrbs(this);
        energyOrbs2.setPosition(new Vec2(6,3));

        // make a suspended platform
        Shape platformShape = new BoxShape(4, 0.5f);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(6, -7));

        Shape platformShape1 = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape1);
        platform1.setPosition(new Vec2(-6, -9));

        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(-6, -2));

        StaticBody platform3 = new StaticBody(this, platformShape1);
        platform3.setPosition(new Vec2(6, 2));

        Shape platformShape3 = new BoxShape(8, 0.5f);
        StaticBody platform4 = new StaticBody(this, platformShape3);
        platform4.setPosition(new Vec2(-9, 7));

        //make walls
        Shape wallShape = new BoxShape(1, 20.5f);
        StaticBody wall = new StaticBody(this, wallShape);
        wall.setPosition(new Vec2(-15, -5));

        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(15, -5));

        getKnight().setPosition(new Vec2(7, -14));


        getDoor().setPosition(new Vec2(-9, 10));








    }
    @Override
    public boolean isComplete() {
        if (getKnight().getEnergyOrbsCount() >=2)
            return true;
        else
            return false;

    }
    @Override
    public Image getBackground() {
        return background;
    }
}
