package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    private Image background;
    private Knight knight;

    public GameView(GameLevel world, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/Dungeon.png").getImage();
        knight = world.getKnight();

    }
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }


    protected void paintForeground(Graphics2D g){
        Font myFont = new Font("Calibre",Font.BOLD,15);
        g.setFont(myFont);
        g.setColor(Color.red);
        g.drawString("EnergyOrbs collected: " + knight.getEnergyOrbsCount(),0,12);

    }
}

