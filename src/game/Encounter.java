package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class Encounter implements CollisionListener {


    private Knight knight;
    public Encounter(Knight knight) {
        this.knight = knight;
    }


    @Override //knight dies upon contact with enemies
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Enemy1) {
            System.out.println("You died! Try again");
            e.getReportingBody().destroy();
            new Game();
        }
        else if (e.getOtherBody() instanceof Enemy2){
            System.out.println("You died! Try again");
            e.getReportingBody().destroy();
            new Game();
        }
        else if (e.getOtherBody() instanceof movingEnemy){
            System.out.println("You died! Try again");
            e.getReportingBody().destroy();
            new Game();
        }
        else if (e.getOtherBody() instanceof Enemy3){
            System.out.println("You died! Try again");
            e.getReportingBody().destroy();
            new Game();
        }
        else if (e.getOtherBody() instanceof Door){


        }

    }
}