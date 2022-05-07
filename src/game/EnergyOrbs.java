package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
// The collectible available in game
public class EnergyOrbs extends DynamicBody {
    private static SoundClip EnergyOrbsSound;
// The sound played when an energy orb is picked up
    static {
        try {
            EnergyOrbsSound = new SoundClip("data/EnergyOrbsSound.wav");
            System.out.println("Loading energy orbs sound");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final Shape energyOrbsShape = new CircleShape(1);
// The specific image used for energyorbs
    private static final BodyImage image =
            new BodyImage("data/EnergyOrb.png", 2f);

    public EnergyOrbs(World w) {
        super(w,energyOrbsShape);
        addImage(image);
    }

    @Override
    public void destroy()
    {
        EnergyOrbsSound.play();
        super.destroy();
    }


}