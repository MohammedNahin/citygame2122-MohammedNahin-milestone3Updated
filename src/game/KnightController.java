package game;

import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KnightController implements KeyListener {

    private static final float WALKING_SPEED = 4;
    private static final float JUMPING_SPEED = 10;

    private Knight knight;

    public KnightController(Knight k) {
        knight = k;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        // allows knight to move
        if (code == KeyEvent.VK_LEFT) {
            knight.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_RIGHT) {
            knight.startWalking(WALKING_SPEED);
        } else if (code == KeyEvent.VK_Q) {
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) {
            Vec2 v = knight.getLinearVelocity();
            if (Math.abs(v.y) < 0.01f) {
                knight.jump(JUMPING_SPEED);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            knight.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            knight.stopWalking();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void updateKnight(Knight newKnight){
        knight = newKnight;
    }
}
