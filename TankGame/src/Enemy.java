import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemy {
    GamePanel bg;
    int x = 0 ;
    int y = 0;
    Random rand = new Random();


    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public int getX() { return x; }
    public int getY() { return y; }

    int canmove = 0;
    Image red = new ImageIcon("enemy_r.png").getImage();
    Image salat = new ImageIcon("enemy_sr.png").getImage();
    Image green = new ImageIcon("enemy_gr.png").getImage();
    Image purple = new ImageIcon("enemy_pr.png").getImage();

    public Rectangle r() {
        return new Rectangle(x, y, 32, 32);

    }

    public Enemy(int x, int y, GamePanel bg) {
        this.x = x;
        this.y = y;
        this.bg = bg;
    }
    public void move_up() {
        y -= 0.001;
    }
}
