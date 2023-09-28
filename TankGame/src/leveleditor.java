import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class leveleditor extends JPanel implements MouseListener {

    public leveleditor() {
        addMouseListener(this);
        Map.matrix[10][2] = Map.WALL;

    }

    public void draw(Graphics2D g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawRect(300,0,300,400);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click");
        Map.matrix[10][2] = Map.WATER;
        System.out.println("STADE");
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // System.out.println("click");
       // Map.matrix[10][2] = Map.WALL;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
