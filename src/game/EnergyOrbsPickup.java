package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;


public class EnergyOrbsPickup implements CollisionListener {

    private Knight knight;
    public EnergyOrbsPickup(Knight s){
        this.knight = s;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof EnergyOrbs) {
            knight.setEnergyOrbs(knight.getEnergyOrbs()+1);
            e.getOtherBody().destroy();
        }
    }
}