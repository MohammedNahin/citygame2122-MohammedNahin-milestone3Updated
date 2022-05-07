package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level4 extends GameLevel {
    //Fields
    /**
     * @param movingEnemy the only type of enemy in this level
     */
    Image background;
    private final movingEnemy movingenemy;
    private final movingEnemy movingEnemy1;
    private final Game game;
    private SoundClip gameMusic;

    public Level4(Game game){
        super(game);
        this.game = game;

        try {
            gameMusic = new SoundClip("data/CastleSound3.wav");   // Open an audio input stream
            gameMusic.play();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }

        background = new ImageIcon("data/Castle2.png").getImage();

        //Make the collectible orbs
        EnergyOrbs energyOrbs1 = new EnergyOrbs(this);
        energyOrbs1.setPosition(new Vec2(2,1));


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

        //Add the moving enemies onto this level
        movingenemy = new movingEnemy(this);
        movingenemy.setPosition(new Vec2(-5,-14));

        movingEnemy1 = new movingEnemy(this);
        movingEnemy1.setPosition(new Vec2(5,-14));



        getKnight().setPosition(new Vec2(0, 11));

        getDoor().setPosition(new Vec2(0, 2));







    // Can only go to next level if target energyorbs are obtained
    }
    @Override
    public boolean isComplete() {
        return getKnight().getEnergyOrbsCount() >= 1;

    }
    @Override
    public Image getBackground() {
        return background;
    }
}

