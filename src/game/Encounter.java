package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class Encounter implements CollisionListener {


    private final Knight knight;
    private static SoundClip gameMusic;
    public Encounter(Knight knight) {
        this.knight = knight;
    }

    @Override //knight dies upon contact with enemies
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Enemy1) {
            System.out.println("You died! Try again");
            e.getReportingBody().destroy();
            try {
                gameMusic = new SoundClip("data/Death Sound.wav");   // Open an audio input stream
                gameMusic.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException d) {
                //code in here will deal with any errors
                //that might occur while loading/playing sound
                System.out.println(d);
            }
            new Game();
        }
        else if (e.getOtherBody() instanceof Enemy2){
            System.out.println("You died! Try again");
            e.getReportingBody().destroy();
            try {
                gameMusic = new SoundClip("data/Death Sound.wav");   // Open an audio input stream
                gameMusic.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException d) {
                //code in here will deal with any errors
                //that might occur while loading/playing sound
                System.out.println(d);
            }
            new Game();

        }
        else if (e.getOtherBody() instanceof movingEnemy){
            System.out.println("You died! Try again");
            e.getReportingBody().destroy();
            try {
                gameMusic = new SoundClip("data/Death Sound.wav");   // Open an audio input stream
                gameMusic.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException d) {
                //code in here will deal with any errors
                //that might occur while loading/playing sound
                System.out.println(d);
            }
            new Game();
        }
        else if (e.getOtherBody() instanceof LavaFloor){
            System.out.println("You died to lava! Try again");
            e.getReportingBody().destroy();
            try {
                gameMusic = new SoundClip("data/Death Sound.wav");   // Open an audio input stream
                gameMusic.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException d) {
                //code in here will deal with any errors
                //that might occur while loading/playing sound
                System.out.println(d);
            }
            new Game();
        }
        else if (e.getOtherBody() instanceof Enemy3){
            System.out.println("You died! Try again");
            e.getReportingBody().destroy();
            try {
                gameMusic = new SoundClip("data/Death Sound.wav");   // Open an audio input stream
                gameMusic.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException d) {
                //code in here will deal with any errors
                //that might occur while loading/playing sound
                System.out.println(d);
            }
            new Game();
        }
        else if (e.getOtherBody()instanceof Door){


        }

    }
}