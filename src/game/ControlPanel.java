package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {
    private JPanel mainPanel;
    private JButton pauseButton;
    private JButton resumeButton;
    private JButton restartButton;
    private Game game;

    public ControlPanel(Game game){
        this.game = game;
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game paused");
                game.pause();


            }
        });
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game resumed");
                game.resume();
            }
        });
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.restart();
            }
        });
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }
}
