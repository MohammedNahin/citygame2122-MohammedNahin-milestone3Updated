package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level4 extends GameLevel {

    Image background;
    private movingEnemy movingenemy;
    private movingEnemy movingEnemy1;

    public Level4(Game game){
        super(game);

        background = new ImageIcon("data/Dungeon.png").getImage();

        //Make the collectible orbs
        EnergyOrbs energyOrbs1 = new EnergyOrbs(this);
        energyOrbs1.setPosition(new Vec2(0,4));


        // make a suspended platform
        Shape platformShape = new BoxShape(4, 0.5f);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(0, 0));

        StaticBody platform1 = new StaticBody(this,platformShape);
        platform.setPosition(new Vec2(0,10));

        //make walls
        Shape wallShape = new BoxShape(1, 20.5f);
        StaticBody wall = new StaticBody(this, wallShape);
        wall.setPosition(new Vec2(-15, -5));

        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(15, -5));

        movingenemy = new movingEnemy(this);
        movingenemy.setPosition(new Vec2(-5,-14));

        movingEnemy1 = new movingEnemy(this);
        movingEnemy1.setPosition(new Vec2(-));



        getKnight().setPosition(new Vec2(0, 11));

        getDoor().setPosition(new Vec2(0, 1));








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

