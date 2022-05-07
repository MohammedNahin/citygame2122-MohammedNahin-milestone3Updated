package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;


public class EnergyOrbsPickup implements CollisionListener {

    private final Knight knight;
    public EnergyOrbsPickup(Knight s){
        this.knight = s;
    }

    // Collision between knight and energyorbs
    // Results in knight picking up energyorb
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof EnergyOrbs) {
            knight.setEnergyOrbs(knight.getEnergyOrbsCount()+1);
            e.getOtherBody().destroy();
        }
    }
}