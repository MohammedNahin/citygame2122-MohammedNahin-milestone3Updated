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

public class Level2 extends GameLevel {


    //Fields
    /**
     * @param movingEnemy the only type of enemy in this level
     *
     */
    Image background;
    private final movingEnemy movingenemy;
    private final Game game;
    private SoundClip gameMusic;

    public Level2(Game game){
        super(game);
        this.game = game;

        try {
            gameMusic = new SoundClip("data/CastleSound1.wav");   // Open an audio input stream
            gameMusic.play();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }

        background = new ImageIcon("data/Dungeon2.png").getImage();

        //Make the collectible orbs
        EnergyOrbs energyOrbs1 = new EnergyOrbs(this);
        energyOrbs1.setPosition(new Vec2(-12,-14));

        EnergyOrbs energyOrbs2 = new EnergyOrbs(this);
        energyOrbs2.setPosition(new Vec2(0,1));

        // make a suspended platform
        Shape platformShape = new BoxShape(4, 0.5f);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(0, 0));

        StaticBody platform1 = new StaticBody(this,platformShape);
        platform1.setPosition(new Vec2(12,6));

        StaticBody platform2 = new StaticBody(this,platformShape);
        platform2.setPosition(new Vec2(0,-9));

        StaticBody platform3 = new StaticBody(this,platformShape);
        platform3.setPosition(new Vec2(-12,-5));


        //make walls
        Shape wallShape = new BoxShape(1, 20.5f);
        StaticBody wall = new StaticBody(this, wallShape);
        wall.setPosition(new Vec2(-15, -5));

        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(15, -5));

        //Add the moving enemy to the level
        movingenemy = new movingEnemy(this);
        movingenemy.setPosition(new Vec2(-5,-14));



        getKnight().setPosition(new Vec2(7, -14));

        getDoor().setPosition(new Vec2(11, 8));








    }
    @Override
    public boolean isComplete() {
        return getKnight().getEnergyOrbsCount() >= 2;

    }
    @Override
    public Image getBackground() {
        return background;
    }
}
