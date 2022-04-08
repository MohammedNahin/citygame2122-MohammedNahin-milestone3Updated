package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

public class Level2 extends GameLevel {

    public Level2(Game game){
        super(game);

        //Make the collectible orbs
        EnergyOrbs energyOrbs1 = new EnergyOrbs(this);
        energyOrbs1.setPosition(new Vec2(-12,-14));

        EnergyOrbs energyOrbs2 = new EnergyOrbs(this);
        energyOrbs2.setPosition(new Vec2(6,3));

        getKnight().setPosition(new Vec2(7, -14));

        getEnemy1().setPosition(new Vec2(6, -7));

        getEnemy2().setPosition(new Vec2(-6, -14));

        getEnemy3().setPosition(new Vec2(-6, -2));





    }
    @Override
    public boolean isComplete() {
        if (getKnight().getEnergyOrbsCount() >=2)
            return true;
        else
            return false;

    }
}
