import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class Player {


    public boolean right;
    public boolean left;
    public boolean up;
    public boolean down;
    int x;
    int y;


    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public int getX() { return x; }
    public int getY() { return y; }

    int canmove = 0;

    Image bird = new ImageIcon("player_r.png").getImage();

    public Rectangle r() {
        return new Rectangle(x, y, 32, 32);

    }

    public void move_up() {
        bird = new ImageIcon("player_u.png").getImage();

        right = false;
        left = false;
        up = true;
        down = false;

        for(int i = 0; i < Map.matrix.length; i++) {
            for(int j = 0; j < Map.matrix.length; j++) {
                if (Map.matrix[i][j] == Map.WATER || Map.matrix[i][j] == Map.WALL || Map.matrix[i][j] == Map.PURPLE || Map.matrix[i][j] == Map.LIGHTPURPLE || Map.matrix[i][j] == Map.HIGHWALL){
                    if(y-32 == i*32 & (x > (j-1) * 32 & x < (j+1)*32)) {
                        canmove = 1;

                    }
                }
                if (Map.matrix[i][j] == Map.BRICK){
                    if(y-32 == i*32 & (x > (j-1) * 32 & x < (j+1)*32)) {
                        System.out.println("brick!");

                        Map.matrix[i][j] = Map.GROUND;
                        Map.matrix_layer2[i][j] = Map.BROKEN_BRICK;
                    }
                }
            }
        }
        if (canmove == 0) {
            if(y <= 0) {
                y = 0;
            } else {
                y -= 4;
            }

        }
        canmove = 0;
    }

    public void move_down() {
        bird = new ImageIcon("player_d.png").getImage();

        right = false;
        left = false;
        up = false;
        down = true;

        for(int i = 0; i < Map.matrix.length; i++) {
            for(int j = 0; j < Map.matrix.length; j++) {
                if (Map.matrix[i][j] == Map.WATER || Map.matrix[i][j] == Map.WALL || Map.matrix[i][j] == Map.PURPLE || Map.matrix[i][j] == Map.LIGHTPURPLE || Map.matrix[i][j] == Map.HIGHWALL){
                    if(y+32 == i*32 & (x > (j-1) * 32 & x < (j+1)*32)) {
                        canmove = 1;
                    }
                }
                if (Map.matrix[i][j] == Map.BRICK){
                    if(y+32 == i*32 & (x > (j-1) * 32 & x < (j+1)*32)) {
                        System.out.println("brick!");

                        Map.matrix[i][j] = Map.GROUND;
                        Map.matrix_layer2[i][j] = Map.BROKEN_BRICK;
                    }
                }
            }
        }
        if (canmove == 0) { y += 4;}
        canmove = 0;
    }
    public void move_left() {

        right = false;
        left = true;
        up = false;
        down = false;

        bird = new ImageIcon("player_l.png").getImage();
        for(int i = 0; i < Map.matrix.length; i++) {
            for(int j = 0; j < Map.matrix.length; j++) {
                if (Map.matrix[i][j] == Map.WATER || Map.matrix[i][j] == Map.WALL || Map.matrix[i][j] == Map.PURPLE || Map.matrix[i][j] == Map.LIGHTPURPLE || Map.matrix[i][j] == Map.HIGHWALL){
                    if(x-32 == j*32 & (y > (i-1) * 32 & y < (i+1)*32)) {
                        canmove = 1;
                    }
                }
                if (Map.matrix[i][j] == Map.BRICK){
                    if(x-32 == j*32 & (y > (i-1) * 32 & y < (i+1)*32)) {

                        Map.matrix[i][j] = Map.GROUND;
                        Map.matrix_layer2[i][j] = Map.BROKEN_BRICK;
                    }
                }
            }
        }



        if (canmove == 0) {
            if(x <= 0) {
                x = 0;
            } else {
                x -= 4;
            }
            /*if (x >= Camera.getX()) {
                Camera.setPosition(Camera.getX()-4, Camera.getY());
            }*/
        }
        canmove = 0;
    }
    public void move_right() {
        bird = new ImageIcon("player_r.png").getImage();

        right = true;
        left = false;
        up = false;
        down = false;

        for(int i = 0; i < Map.matrix.length; i++) {
            for(int j = 0; j < Map.matrix.length; j++) {
                if (Map.matrix[i][j] == Map.WATER || Map.matrix[i][j] == Map.WALL || Map.matrix[i][j] == Map.PURPLE || Map.matrix[i][j] == Map.LIGHTPURPLE || Map.matrix[i][j] == Map.HIGHWALL){
                    if(x+32 == j*32 & (y > (i-1) * 32 & y < (i+1)*32)) {
                        canmove = 1;
                    }
                }
                if (Map.matrix[i][j] == Map.BRICK){
                    if(x+32 == j*32 & (y > (i-1) * 32 & y < (i+1)*32)) {

                        Map.matrix[i][j] = Map.GROUND;
                        Map.matrix_layer2[i][j] = Map.BROKEN_BRICK;
                    }
                }
            }
        }



        if (canmove == 0) {

            x += 4;
        }
        canmove = 0;
    }

    public void CheckCoords() {
        /*if (x >= Camera.getX() + 51*32) {
            x -=4;
            Camera.setPosition(Camera.getX()+32*4, Camera.getY());
        }*/
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
    }


}
