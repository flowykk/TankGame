import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Bullet {

    Player p = new Player();

    int x = 0;
    int y = 0;

    public boolean shooting = false;

    public void setRight(boolean right) { this.right = right; }
    public void setLeft(boolean left) { this.left = left; }
    public void setUp(boolean up) { this.up = up; }
    public void setDown(boolean down) { this.down = down; }

    boolean right = false;
    boolean left = false;
    boolean up = false;
    boolean down = false;

    private int betweenTime;
    private int elapsedTime;

    int canmove = 0;

    Image bullet = new ImageIcon("bullet.png").getImage();

    public Rectangle r() {
        return new Rectangle(x, y, 32, 32);
    }

    public void update_up() { y -= 2; }
    public void update_down() { y += 2; }
    public void update_left() { x -= 2; }
    public void update_right() { x += 2; }

    public void move_up(int dx, int dy) {
        bullet = new ImageIcon("bullet.png").getImage();
        x = dx;
        y = dy;
        up = true; right = false; left = false; down = false;
    }

    public void move_down(int dx, int dy) {
        bullet = new ImageIcon("bullet_d.png").getImage();
        x = dx;
        y = dy;
        up = false; right = false; left = false; down = true;
    }

    public void move_left(int dx, int dy) {
        bullet = new ImageIcon("bullet_l.png").getImage();
        x = dx;
        y = dy;
        up = false; right = false; left = true; down = false;
    }
    public void move_right(int dx, int dy) {
        bullet = new ImageIcon("bullet_r.png").getImage();
        x = dx;
        y = dy;
        up = false; right = true; left = false; down = false;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
    }
}
