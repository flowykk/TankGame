import javax.swing.*;
import java.awt.*;

public class Particle {

    int x = 0;
    int y = 0;

    boolean upRight = false;
    boolean downLeft = false;
    boolean upLeft = false;
    boolean downRight = false;

    Image particle = new ImageIcon("particle.png").getImage();

    public Rectangle r() {
        return new Rectangle(x, y, 32, 32);
    }

    public void update_upRight() { y -= 1;x += 1; }
    public void update_downRight() { y += 1;x += 1; }
    public void update_upLeft() { y -= 1;x -= 1; }
    public void update_downLeft() { y += 1;x -= 1; }

    public void update_up() { y -= 1; }
    public void update_down() { y += 1; }
    public void update_left() { x -= 1; }
    public void update_right() { x += 1; }

    public void move(int dx, int dy) {
        x = dx;
        y = dy;
    }
}
