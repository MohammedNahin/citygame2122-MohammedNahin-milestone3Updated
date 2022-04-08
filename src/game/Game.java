package game;

import city.cs.engine.*;

import javax.swing.JFrame;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Your main game entry point
 */
public class Game {


    private game.GameView view;
    private SoundClip gameMusic;


    /** Initialise a new Game. */
    public Game() {




        //make an empty game world
        GameLevel currentLevel = new Level1(this);

        try {
            gameMusic = new SoundClip("data/DungeonSound.wav");   // Open an audio input stream
            gameMusic.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }






        // make a view to look into the game world
        view = new GameView(currentLevel, 600, 600);
        view.setZoom(20);

        // create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("Dungeon Game");
        frame.add(view);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 600, 600);

        // start our game world simulation!
        currentLevel.start();

        //Allow the knight to move when buttons on keyboard are pressed
        KnightController controller = new KnightController(currentLevel.getKnight());
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));

        System.out.println("Collect the orbs and evade the enemies");









    }
    public void goToNextLevel(){
        System.out.println("Transition to next level");
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
