package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class doorEncounter implements CollisionListener {
    private final Game game;


    GameLevel currentlevel;


    public doorEncounter(GameLevel level, Game game) {
        this.currentlevel = level;
        this.game = game;

    }
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Knight && this.currentlevel.isComplete()) {
            this.game.goToNextLevel();
            System.out.println("You've reached the next level!");




        }

    }


}


