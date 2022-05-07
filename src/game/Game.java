package game;

import city.cs.engine.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * Your main game entry point
 */
public class Game {

    GameLevel currentLevel;
    GameView  view;
    KnightController controller;




    private SoundClip gameMusic;


    /** Initialise a new Game. */
    public Game() {




        //make an empty game world
        currentLevel = new Level1(this);




        // make a view to look into the game world
        view = new GameView(currentLevel, 600, 600);
        view.setZoom(20);

        // create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("Dungeon Game");
        frame.add(view);

        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel.getMainPanel(), BorderLayout.WEST);






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
        controller = new KnightController(currentLevel.getKnight());
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));

        System.out.println("Collect the orbs and evade the enemies");









    }
    public void goToNextLevel(){

        if (currentLevel instanceof Level1) {
            currentLevel.stop();
            currentLevel = new Level2(this);
            controller.updateKnight(currentLevel.getKnight());
            view.setWorld(currentLevel);
            currentLevel.start();


        }
        else if (currentLevel instanceof Level2){
            currentLevel.stop();
            currentLevel = new Level3(this);
            controller.updateKnight(currentLevel.getKnight());
            view.setWorld(currentLevel);
            currentLevel.start();
        }
        else if (currentLevel instanceof Level3){
            currentLevel.stop();
            currentLevel = new Level4(this);
            controller.updateKnight(currentLevel.getKnight());
            view.setWorld(currentLevel);
            currentLevel.start();
        }
        else if (currentLevel instanceof Level4){
            System.out.println("Congratulations! You've beat the game!");
        }

    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
    //Pauses game when button pressed
    public void pause() {currentLevel.stop();
    }

    public void resume() {currentLevel.start();
    }

    public void quit()  {System.exit(0);

    }

}
