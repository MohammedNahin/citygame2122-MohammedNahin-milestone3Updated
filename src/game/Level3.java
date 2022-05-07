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

public class Level3 extends GameLevel {
    //Fields
    Image background;
    private SoundClip gameMusic;
    private final Game game;

    public Level3(Game game){
        super(game);
        this.game = game;

        try {
            gameMusic = new SoundClip("data/CastleSound2.wav");   // Open an audio input stream
            gameMusic.play();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }

        //The background image for this level
        background = new ImageIcon("data/Castle1.png").getImage();

        //Make the collectible orbs
        EnergyOrbs energyOrbs1 = new EnergyOrbs(this);
        energyOrbs1.setPosition(new Vec2(0,4));


        // make a suspended platform
        Shape platformShape = new BoxShape(4, 0.5f);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-12, -10));

        StaticBody platform1 = new StaticBody(this,platformShape);
        platform1.setPosition(new Vec2(0,3));

        StaticBody platform2 = new StaticBody(this,platformShape);
        platform2.setPosition(new Vec2(-5,-5));

        //The lava added on this level
        LavaFloor lavaFloor = new LavaFloor(this);
        lavaFloor.setPosition(new Vec2(-12,-14));

        LavaFloor lavaFloor1 = new LavaFloor(this);
        lavaFloor1.setPosition(new Vec2(-8,-14));

        LavaFloor lavaFloor2 = new LavaFloor(this);
        lavaFloor2.setPosition(new Vec2(-5,-14));

        LavaFloor lavaFloor3 = new LavaFloor(this);
        lavaFloor3.setPosition(new Vec2(2,-14));

        LavaFloor lavaFloor4 = new LavaFloor(this);
        lavaFloor4.setPosition(new Vec2(6,-14));

        LavaFloor lavaFloor5 = new LavaFloor(this);
        lavaFloor5.setPosition(new Vec2(12,-14));

        LavaFloor lavaFloor6 = new LavaFloor(this);
        lavaFloor6.setPosition(new Vec2(11,4));









        //make walls
        Shape wallShape = new BoxShape(1, 20.5f);
        StaticBody wall = new StaticBody(this, wallShape);
        wall.setPosition(new Vec2(-15, -5));

        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(15, -5));

        getKnight().setPosition(new Vec2(-12, -9));

        getDoor().setPosition(new Vec2(11, 6));








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

