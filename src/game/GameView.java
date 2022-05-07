package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    private Image background;
    private final Knight knight;
    GameLevel currentLevel;

    public GameView(GameLevel world, int width, int height) {
        super(world, width, height);
        knight = world.getKnight();
        currentLevel = world;

    }

    @Override
    public void setWorld(World world){
        super.setWorld(world);
        currentLevel = (GameLevel) world;
    }
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(currentLevel.getBackground(), 0, 0, this);
    }

//Text on top left corner about energy orbs
    protected void paintForeground(Graphics2D g){
        Font myFont = new Font("Calibre",Font.BOLD,15);
        g.setFont(myFont);
        g.setColor(Color.red);
        g.drawString("EnergyOrbs collected: " + knight.getEnergyOrbsCount(),0,12);

    }
}

