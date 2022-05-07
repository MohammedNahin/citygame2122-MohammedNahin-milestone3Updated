package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level1 extends GameLevel{

    //Fields
    /**
     * @param Enemy1 the first enemy in this level
     * @param Enemy2 the second enemy in this level
     * @param Enemy3 the third enemy in this level
     */
    Image background;
    private final Enemy1 enemy1;
    private final Enemy2 enemy2;
    private final Enemy3 enemy3;
    private final Game game;
    private SoundClip gameMusic;

    public Level1(Game game) {
        super(game);
        this.game = game;
        try {
            gameMusic = new SoundClip("data/DungeonSound.wav");   // Open an audio input stream
            gameMusic.play();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
        //The background image used for this level
        background = new ImageIcon("data/Dungeon.png" ).getImage();


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

        //Make the collectible orbs
        EnergyOrbs energyOrbs1 = new EnergyOrbs(this);
        energyOrbs1.setPosition(new Vec2(-12, -14));

        EnergyOrbs energyOrbs2 = new EnergyOrbs(this);
        energyOrbs2.setPosition(new Vec2(6, 3));


        enemy1 = new Enemy1(this);
        enemy1.setPosition(new Vec2(7,-7));

        enemy2 = new Enemy2(this);
        enemy2.setPosition(new Vec2(-6,-14));

        enemy3 = new Enemy3(this);
        enemy3.setPosition(new Vec2(-6,-2));

        //Gets knight and door from Gamelevel and adds it to current level
        getKnight().setPosition(new Vec2(7, -14));

        getDoor().setPosition(new Vec2(-9, 10));



    }
    // Can only go to next level if target energyorbs are obtained
    @Override
    public boolean isComplete() {
        return getKnight().getEnergyOrbsCount() >= 2;

    }

    @Override
    public Image getBackground() {
        return background;
    }
}
