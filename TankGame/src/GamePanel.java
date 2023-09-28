import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class GamePanel extends JPanel implements KeyListener, MouseListener, ActionListener, Runnable {

	private ArrayList<Bullet> bullets;



	public int currentblock;
	public GamePanel() {
		setBackground( Color.BLACK );
		EnemiesCreator.start();
	}
	Player b = new Player();
	Bullet bullet = new Bullet();

	Particle p1 = new Particle();
	Particle p2 = new Particle();
	Particle p3 = new Particle();
	Particle p4 = new Particle();
	Particle p5 = new Particle();
	Particle p6 = new Particle();
	Particle p7 = new Particle();
	Particle p8 = new Particle();

	private AnimationV2 rainbow_tank= new AnimationV2(new String[]{"enemy_gr.png", "enemy_pr.png", "enemy_r.png", "enemy_sr.png", "player_l.png"}, new TextureRegion(), 100, 100, 100);
//	private AnimationV2 turtle= new AnimationV2(new String[]{"turtle/turtle-1.png", "turtle/turtle-2.png", "turtle/turtle-3.png", "turtle/turtle-4.png", "turtle/turtle-5.png", "turtle/turtle-6.png"}, new TextureRegion(), 30, 60, 140);
//	private AnimationV2 mouse= new AnimationV2(new String[]{"mouse/mouse.png", "mouse/mouse0.png", "mouse/mouse1.png", "mouse/mouse2.png", "mouse/mouse3.png"}, new TextureRegion(), 100, 60, 300);
//	private AnimationV2 mouse1= new AnimationV2(new String[]{"mouse/mouse.png", "mouse/mouse0.png", "mouse/mouse1.png", "mouse/mouse2.png", "mouse/mouse3.png"}, new TextureRegion(), 100, 60, 360);
//	private AnimationV2 mouse2= new AnimationV2(new String[]{"mouse/mouse.png", "mouse/mouse0.png", "mouse/mouse1.png", "mouse/mouse2.png", "mouse/mouse3.png"}, new TextureRegion(), 100, 60, 360);

	Random rand = new Random();

	int eventCount1;
	int eventCount2;
	int eventCount3;
	int eventCount4;
	int eventCount5;
	int eventCount6;
	int eventCount7;
	int eventCount8;

	int eventCount1Max;
	int eventCount2Max;
	int eventCount3Max;
	int eventCount4Max;
	int eventCount5Max;
	int eventCount6Max;
	int eventCount7Max;
	int eventCount8Max;

	Thread EnemiesCreator = new Thread(this);
	java.util.List<Enemy> meteorites = new ArrayList<>();

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);


		Camera.setH(getHeight());
		Camera.setW(getWidth());

		Map.paint(g);

		rainbow_tank.update(1, AnimationV2.REVERSED);
		rainbow_tank.paint(g);

	//	turtle.update(1, AnimationV2.STRAIGHT);
	//	turtle.paint(g);

	//	mouse.update(1, AnimationV2.STRAIGHT); mouse.paint(g);
	//	mouse1.update(1, AnimationV2.STRAIGHT); mouse1.paint(g);
	//	mouse2.update(1, AnimationV2.STRAIGHT); mouse2.paint(g);

		g.drawImage(b.bird, b.x, b.y, null);

		System.out.println(eventCount1 + " " + eventCount1Max);

		if (bullet.up) {
			eventCount1++;eventCount2++;eventCount3++;eventCount4++;
			eventCount5++;eventCount6++;eventCount7++;eventCount8++;

			if (eventCount1 < eventCount1Max) { p1.update_downLeft();g.drawImage(p1.particle, p1.x, p1.y, null); }
			if (eventCount2 < eventCount2Max) { p2.update_downRight();g.drawImage(p2.particle, p2.x, p2.y, null); }
			if (eventCount3 < eventCount3Max) { p3.update_upLeft();g.drawImage(p3.particle, p3.x, p3.y, null); }
			if (eventCount4 < eventCount4Max) { p4.update_upRight();g.drawImage(p4.particle, p4.x, p4.y, null); }
			if (eventCount5 < eventCount5Max) { p5.update_up();g.drawImage(p5.particle, p5.x, p5.y, null); }
			if (eventCount6 < eventCount6Max) { p6.update_down();g.drawImage(p6.particle, p6.x, p6.y, null); }
			if (eventCount7 < eventCount7Max) { p7.update_right();g.drawImage(p7.particle, p7.x, p7.y, null); }
			if (eventCount8 < eventCount8Max) { p8.update_left();g.drawImage(p8.particle, p8.x, p8.y, null); }

			bullet.update_up();
			g.drawImage(bullet.bullet, bullet.x, bullet.y, null);

			for (int i = 0; i < Map.matrix.length; i++) {
				for (int j = 0; j < Map.matrix.length; j++) {

					if (Map.matrix[i][j] == Map.WALL || Map.matrix[i][j] == Map.PURPLE || Map.matrix[i][j] == Map.LIGHTPURPLE || Map.matrix[i][j] == Map.HIGHWALL) {
						if (bullet.y - 32 == i * 32 & (bullet.x > (j - 1) * 32 & bullet.x < (j + 1) * 32)) {
							eventCount1 = 0; eventCount2 = 0; eventCount3 = 0; eventCount4 = 0;
							eventCount5 = 0; eventCount6 = 0; eventCount7 = 0; eventCount8 = 0;
							eventCount1Max = rand.nextInt(60)+50; eventCount2Max = rand.nextInt(60)+50;eventCount3Max = rand.nextInt(60)+50; eventCount4Max = rand.nextInt(60)+50;
							eventCount5Max = rand.nextInt(60)+50; eventCount6Max = rand.nextInt(60)+50;eventCount7Max = rand.nextInt(60)+50; eventCount8Max = rand.nextInt(60)+50;
							p1.move(bullet.x, bullet.y);p2.move(bullet.x, bullet.y);p3.move(bullet.x, bullet.y);p4.move(bullet.x, bullet.y);
							p5.move(bullet.x, bullet.y);p6.move(bullet.x, bullet.y);p7.move(bullet.x, bullet.y);p8.move(bullet.x, bullet.y);
							bullet.y = -100;bullet.x = -100;
						}
					}
					if (Map.matrix[i][j] == Map.BRICK) {
						if (bullet.y - 32 == i * 32 & (bullet.x > (j - 1) * 32 & bullet.x < (j + 1) * 32)) {
							Map.matrix[i][j] = Map.GROUND;
							Map.matrix_layer2[i][j] = Map.BROKEN_BRICK;
						}
					}
				}
			}
		} else if (bullet.down) {
			bullet.update_down();
			g.drawImage(bullet.bullet, bullet.x, bullet.y, null);

			eventCount1++;eventCount2++;eventCount3++;eventCount4++;
			eventCount5++;eventCount6++;eventCount7++;eventCount8++;

			if (eventCount1 < eventCount1Max) { p1.update_downLeft();g.drawImage(p1.particle, p1.x, p1.y, null); }
			if (eventCount2 < eventCount2Max) { p2.update_downRight();g.drawImage(p2.particle, p2.x, p2.y, null); }
			if (eventCount3 < eventCount3Max) { p3.update_upLeft();g.drawImage(p3.particle, p3.x, p3.y, null); }
			if (eventCount4 < eventCount4Max) { p4.update_upRight();g.drawImage(p4.particle, p4.x, p4.y, null); }
			if (eventCount5 < eventCount5Max) { p5.update_up();g.drawImage(p5.particle, p5.x, p5.y, null); }
			if (eventCount6 < eventCount6Max) { p6.update_down();g.drawImage(p6.particle, p6.x, p6.y, null); }
			if (eventCount7 < eventCount7Max) { p7.update_right();g.drawImage(p7.particle, p7.x, p7.y, null); }
			if (eventCount8 < eventCount8Max) { p8.update_left();g.drawImage(p8.particle, p8.x, p8.y, null); }

			for(int i = 0; i < Map.matrix.length; i++) {
				for(int j = 0; j < Map.matrix.length; j++) {
					if (Map.matrix[i][j] == Map.WALL || Map.matrix[i][j] == Map.PURPLE || Map.matrix[i][j] == Map.LIGHTPURPLE || Map.matrix[i][j] == Map.HIGHWALL){
						if(bullet.y+32 == i*32 & (bullet.x > (j-1) * 32 & bullet.x < (j+1)*32)) {
							eventCount1 = 0; eventCount2 = 0; eventCount3 = 0; eventCount4 = 0;
							eventCount5 = 0; eventCount6 = 0; eventCount7 = 0; eventCount8 = 0;
							eventCount1Max = rand.nextInt(60)+50; eventCount2Max = rand.nextInt(60)+50;eventCount3Max = rand.nextInt(60)+50; eventCount4Max = rand.nextInt(60)+50;
							eventCount5Max = rand.nextInt(60)+50; eventCount6Max = rand.nextInt(60)+50;eventCount7Max = rand.nextInt(60)+50; eventCount8Max = rand.nextInt(60)+50;
							p1.move(bullet.x, bullet.y);p2.move(bullet.x, bullet.y);p3.move(bullet.x, bullet.y);p4.move(bullet.x, bullet.y);
							p5.move(bullet.x, bullet.y);p6.move(bullet.x, bullet.y);p7.move(bullet.x, bullet.y);p8.move(bullet.x, bullet.y);
							bullet.y = -100;bullet.x = -100;
						}
					}
					if (Map.matrix[i][j] == Map.BRICK){
						if(bullet.y+32 == i*32 & (bullet.x > (j-1) * 32 & bullet.x < (j+1)*32)) {
							Map.matrix[i][j] = Map.GROUND;
							Map.matrix_layer2[i][j] = Map.BROKEN_BRICK;
						}
					}
				}
			}
		} else if(bullet.left) {
			bullet.update_left();
			g.drawImage(bullet.bullet, bullet.x, bullet.y, null);

			eventCount1++;eventCount2++;eventCount3++;eventCount4++;
			eventCount5++;eventCount6++;eventCount7++;eventCount8++;

			if (eventCount1 < eventCount1Max) { p1.update_downLeft();g.drawImage(p1.particle, p1.x, p1.y, null); }
			if (eventCount2 < eventCount2Max) { p2.update_downRight();g.drawImage(p2.particle, p2.x, p2.y, null); }
			if (eventCount3 < eventCount3Max) { p3.update_upLeft();g.drawImage(p3.particle, p3.x, p3.y, null); }
			if (eventCount4 < eventCount4Max) { p4.update_upRight();g.drawImage(p4.particle, p4.x, p4.y, null); }
			if (eventCount5 < eventCount5Max) { p5.update_up();g.drawImage(p5.particle, p5.x, p5.y, null); }
			if (eventCount6 < eventCount6Max) { p6.update_down();g.drawImage(p6.particle, p6.x, p6.y, null); }
			if (eventCount7 < eventCount7Max) { p7.update_right();g.drawImage(p7.particle, p7.x, p7.y, null); }
			if (eventCount8 < eventCount8Max) { p8.update_left();g.drawImage(p8.particle, p8.x, p8.y, null); }

			for (int i = 0; i < Map.matrix.length; i++) {
				for (int j = 0; j < Map.matrix.length; j++) {
					if (Map.matrix[i][j] == Map.WALL || Map.matrix[i][j] == Map.PURPLE || Map.matrix[i][j] == Map.LIGHTPURPLE || Map.matrix[i][j] == Map.HIGHWALL) {
						if (bullet.x - 32 == j * 32 & (bullet.y > (i - 1) * 32 & bullet.y < (i + 1) * 32)) {
							eventCount1 = 0; eventCount2 = 0; eventCount3 = 0; eventCount4 = 0;
							eventCount5 = 0; eventCount6 = 0; eventCount7 = 0; eventCount8 = 0;
							eventCount1Max = rand.nextInt(60)+50; eventCount2Max = rand.nextInt(60)+50;eventCount3Max = rand.nextInt(60)+50; eventCount4Max = rand.nextInt(60)+50;
							eventCount5Max = rand.nextInt(60)+50; eventCount6Max = rand.nextInt(60)+50;eventCount7Max = rand.nextInt(60)+50; eventCount8Max = rand.nextInt(60)+50;
							p1.move(bullet.x, bullet.y);p2.move(bullet.x, bullet.y);p3.move(bullet.x, bullet.y);p4.move(bullet.x, bullet.y);
							p5.move(bullet.x, bullet.y);p6.move(bullet.x, bullet.y);p7.move(bullet.x, bullet.y);p8.move(bullet.x, bullet.y);
							bullet.y = -100;bullet.x = -100;
						}
					}
					if (Map.matrix[i][j] == Map.BRICK) {
						if (bullet.x - 32 == j * 32 & (bullet.y > (i - 1) * 32 & bullet.y < (i + 1) * 32)) {
							Map.matrix[i][j] = Map.GROUND;
							Map.matrix_layer2[i][j] = Map.BROKEN_BRICK;
						}
					}
				}
			}
		} else if(bullet.right) {
			bullet.update_right();
			g.drawImage(bullet.bullet, bullet.x, bullet.y, null);

			eventCount1++;eventCount2++;eventCount3++;eventCount4++;
			eventCount5++;eventCount6++;eventCount7++;eventCount8++;

			if (eventCount1 < eventCount1Max) { p1.update_downLeft();g.drawImage(p1.particle, p1.x, p1.y, null); }
			if (eventCount2 < eventCount2Max) { p2.update_downRight();g.drawImage(p2.particle, p2.x, p2.y, null); }
			if (eventCount3 < eventCount3Max) { p3.update_upLeft();g.drawImage(p3.particle, p3.x, p3.y, null); }
			if (eventCount4 < eventCount4Max) { p4.update_upRight();g.drawImage(p4.particle, p4.x, p4.y, null); }
			if (eventCount5 < eventCount5Max) { p5.update_up();g.drawImage(p5.particle, p5.x, p5.y, null); }
			if (eventCount6 < eventCount6Max) { p6.update_down();g.drawImage(p6.particle, p6.x, p6.y, null); }
			if (eventCount7 < eventCount7Max) { p7.update_right();g.drawImage(p7.particle, p7.x, p7.y, null); }
			if (eventCount8 < eventCount8Max) { p8.update_left();g.drawImage(p8.particle, p8.x, p8.y, null); }

			for(int i = 0; i < Map.matrix.length; i++) {
				for(int j = 0; j < Map.matrix.length; j++) {
					if (Map.matrix[i][j] == Map.WALL || Map.matrix[i][j] == Map.PURPLE || Map.matrix[i][j] == Map.LIGHTPURPLE || Map.matrix[i][j] == Map.HIGHWALL){
						if(bullet.x+32 == j*32 & (bullet.y > (i-1) * 32 & bullet.y < (i+1)*32)) {
							eventCount1 = 0; eventCount2 = 0; eventCount3 = 0; eventCount4 = 0;
							eventCount5 = 0; eventCount6 = 0; eventCount7 = 0; eventCount8 = 0;
							eventCount1Max = rand.nextInt(60)+50; eventCount2Max = rand.nextInt(60)+50;eventCount3Max = rand.nextInt(60)+50; eventCount4Max = rand.nextInt(60)+50;
							eventCount5Max = rand.nextInt(60)+50; eventCount6Max = rand.nextInt(60)+50;eventCount7Max = rand.nextInt(60)+50; eventCount8Max = rand.nextInt(60)+50;
							p1.move(bullet.x, bullet.y);p2.move(bullet.x, bullet.y);p3.move(bullet.x, bullet.y);p4.move(bullet.x, bullet.y);
							p5.move(bullet.x, bullet.y);p6.move(bullet.x, bullet.y);p7.move(bullet.x, bullet.y);p8.move(bullet.x, bullet.y);
							bullet.y = -100;bullet.x = -100;
						}
					}
					if (Map.matrix[i][j] == Map.BRICK){
						if(bullet.x+32 == j*32 & (bullet.y > (i-1) * 32 & bullet.y < (i+1)*32)) {
							Map.matrix[i][j] = Map.GROUND;
							Map.matrix_layer2[i][j] = Map.BROKEN_BRICK;
						}
					}
				}
			}
		}



//		Iterator<Enemy> i = meteorites.iterator();
//		while(i.hasNext()) {
//			Enemy m = i.next();
//			if(b.r().intersects(m.r())) {
//				if(b.x >= m.x) m.x -=40;
//				else if (b.x <= m.x) m.x +=40;
//				else if (b.y < m.y) m.y +=40;
//				else if (b.y >= m.y) m.y -=40;
//
//				if(m.x <= Camera.getX()) { m.x -= 32; }
//			}
//			else {
//				g.drawImage(m.red, m.x, m.y, null);
//			}
//		}

		Rectangle f = new Rectangle(1632,0,200,1032);
		g.setColor(Color.GRAY);
		g.fillRect(1632,0,200,1032);

		//g.drawString("select block", 1000, 1);
		//Camera.move(0.15,0.2);
		Image brick = new ImageIcon("brick.png").getImage();
		g.drawImage(brick, 1712,30, this);
		Image wall = new ImageIcon("wall.png").getImage();
		g.drawImage(wall, 1712,90, this);
		Image water = new ImageIcon("water.png").getImage();
		g.drawImage(water, 1712,150, this);
		Image grass = new ImageIcon("grass.png").getImage();
		g.drawImage(grass, 1712,210, this);
		Image ograss = new ImageIcon("oground.png").getImage();
		g.drawImage(ograss, 1712,270, this);
		Image ggrass = new ImageIcon("gground.png").getImage();
		g.drawImage(ggrass, 1712,330, this);
		Image hwall = new ImageIcon("highwall.png").getImage();
		g.drawImage(hwall, 1712,390, this);
		Image purple = new ImageIcon("purple.png").getImage();
		g.drawImage(purple, 1712,450, this);
		Image lpurple = new ImageIcon("lightpurple.png").getImage();
		g.drawImage(lpurple, 1712,510, this);
		Image sbullet = new ImageIcon("superbullet.png").getImage();
		g.drawImage(sbullet, 1712,570, this);
		Image tbbullet = new ImageIcon("manybullets.png").getImage();
		g.drawImage(tbbullet, 1712,630, this);
		Image grassclear = new ImageIcon("grassclear.png").getImage();
		g.drawImage(grassclear, 1632,800, this);
		Image waterclear = new ImageIcon("waterclear.png").getImage();
		g.drawImage(waterclear, 1632,900, this);
		Image generate = new ImageIcon("generate.png").getImage();
		g.drawImage(generate, 1632,700, this);

		Image tablo1 = new ImageIcon("tablo1.png").getImage();
		g.drawImage(tablo1, 1776,30, this);
		Image tablo2 = new ImageIcon("tablo2.png").getImage();
		g.drawImage(tablo2, 1776,90, this);
		Image tablo3 = new ImageIcon("tablo3.png").getImage();
		g.drawImage(tablo3, 1776,150, this);
		Image tablo4 = new ImageIcon("tablo4.png").getImage();
		g.drawImage(tablo4, 1776,210, this);
		Image tree = new ImageIcon("tree.png").getImage();
		g.drawImage(tree, 1776,270, this);
		Image broken = new ImageIcon("broken.png").getImage();
		g.drawImage(broken, 1776,330, this);

		repaint();

		g.setColor(Color.WHITE);
		Font fnt2 = new Font("progresspixel-bold", Font.BOLD,23);
		g.setFont(fnt2);
		g.drawString("SELECT BLOCK", 1640, 23);

//		bullets = new ArrayList<Bullet>();
//		for(int i = 0; i < bullets.size(); i++) {
//			g.drawImage(bullets.get(i).bullet, bullets.get(i).x, bullets.get(i).y, null);
//		}

	}

	private void Intersects() {
		for (Enemy en : meteorites) {
			if (b.r().intersects(en.r())) {
				b.x -= 4;
				b.y -= 4;
			}

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if (mx >= 1720 && mx <= 1752) {
			if (my >= 60 && my <= 92){
				currentblock = 2;
			} else if (my >= 120 && my <= 152){
				currentblock = 1;
			} else if (my >= 180 && my <= 212){
				currentblock = 3;
			} else if (my >= 240 && my <= 272){
				currentblock = 0;
			} else if (my >= 300 && my <= 332){
				currentblock = 8;
			} else if (my >= 360 && my <= 392){
				currentblock = 9;
			} else if (my >= 420 && my <= 452){
				currentblock = 7;
			} else if (my >= 480 && my <= 512){
				currentblock = 5;
			} else if (my >= 540 && my <= 572){
				currentblock = 6;
			} else if (my >= 600 && my <= 632){
				currentblock = 10;
			} else if (my >= 660 && my <= 692){
				currentblock = 11;
			}
		}

		if (mx >= 1784 && mx <= 1816) {
			if (my >= 60 && my <= 92){
				currentblock = 13;
			} else if (my >= 120 && my <= 152) {
				currentblock = 14;
			} else if (my >= 180 && my <= 212){
				currentblock = 15;
			} else if (my >= 240 && my <= 272){
				currentblock = 16;
			} else if (my >= 300 && my <= 332){
				currentblock = 17;
			} else if (my >= 360 && my <= 392){
				currentblock = 12;
			}
			else if (my >= 420 && my <= 452){
			//	currentblock = 12;
			}
		}

		if (mx >= 1632 && mx <= 1837){
			if (my >= 830 && my <= 930){
				for(int i = 0; i < Map.matrix.length; i++ ) {
					for(int j = 0; j < Map.matrix.length; j++ ) {
						Map.matrix[i][j] = Map.GROUND;
					}
				}
			} else if (my >= 930 && my <= 1030) {
				for (int i = 0; i < Map.matrix.length; i++) {
					for (int j = 0; j < Map.matrix.length; j++) {
						Map.matrix[i][j] = Map.WATER;
					}
				}
			} else if (my >= 730 && my <= 830) {
				Map.generate(100, 100);
			}
		}
		if (mx >= 1632 && mx <= 1832) { }
		else {
			if (currentblock == 2) { Map.matrix[my / 32 + (int) (Camera.getY() / 32) - 1][mx / 32 + (int) (Camera.getX() / 32)] = Map.BRICK;
			} else if (currentblock == 1) { Map.matrix[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.WALL;
			} else if (currentblock == 3) { Map.matrix[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.WATER;
			} else if (currentblock == 0) { Map.matrix[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.GROUND;
			} else if (currentblock == 5) { Map.matrix[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.PURPLE;
			} else if (currentblock == 6) { Map.matrix[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.LIGHTPURPLE;
			} else if (currentblock == 7) { Map.matrix[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.HIGHWALL;
			} else if (currentblock == 8) { Map.matrix[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.ORANGEGROUND;
			} else if (currentblock == 9) { Map.matrix[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.GRAYGROUND;
			} else if (currentblock == 10) { Map.matrix[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.SUPERBULLET;
			} else if (currentblock == 13) {
				Map.matrix[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.GROUND;
				Map.matrix_layer2[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.TABLO1;
			} else if (currentblock == 14) {
				Map.matrix[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.GROUND;
				Map.matrix_layer2[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.TABLO2;
			} else if (currentblock == 15) {
				Map.matrix[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.GROUND;
				Map.matrix_layer2[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.TABLO3;
			} else if (currentblock == 16) {
				Map.matrix[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.GROUND;
				Map.matrix_layer2[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.TABLO4;
			} else if (currentblock == 17) {
				Map.matrix[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.GROUND;
				Map.matrix_layer2[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.TREE;
			} else if (currentblock == 12) {
				Map.matrix[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.GROUND;
				Map.matrix_layer2[my / 32 - 1 + (int) (Camera.getY() / 32)][mx / 32 + (int) (Camera.getX() / 32)] = Map.BROKEN_BRICK;
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

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
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		//System.out.print(bullets.size());

		if (key == KeyEvent.VK_RIGHT) {
			Camera.moveright(32,32);
		} else if (key == KeyEvent.VK_DOWN) {
			Camera.movedown(32,32);
		} else if (key == KeyEvent.VK_LEFT) {
			Camera.moveleft(32,32);
		} else if (key == KeyEvent.VK_UP) {
			Camera.moveup(32,32);
		}
		if (key == KeyEvent.VK_W ) { b.move_up(); b.CheckCoords();}
		if (key == KeyEvent.VK_S ) { b.move_down(); b.CheckCoords();}
		if (key == KeyEvent.VK_A ) { b.move_left(); b.CheckCoords();}
		if (key == KeyEvent.VK_D ) { b.move_right(); b.CheckCoords();}
		if (key == KeyEvent.VK_R ) {
			if (b.right) {
				bullet.move_right(b.x, b.y);
				eventCount1 = 0; eventCount2 = 0; eventCount3 = 0; eventCount4 = 0;
				eventCount5 = 0; eventCount6 = 0; eventCount7 = 0; eventCount8 = 0;
				eventCount1Max = rand.nextInt(60)+30; eventCount2Max = rand.nextInt(60)+30; eventCount3Max = rand.nextInt(60)+30; eventCount4Max = rand.nextInt(60)+30;
				eventCount5Max = rand.nextInt(60)+30; eventCount6Max = rand.nextInt(60)+30; eventCount7Max = rand.nextInt(60)+30; eventCount8Max = rand.nextInt(60)+30;
				p1.move(b.x, b.y);
				p2.move(b.x, b.y);
				p3.move(b.x, b.y);
				p4.move(b.x, b.y);
				p5.move(b.x, b.y);
				p6.move(b.x, b.y);
				p7.move(b.x, b.y);
				p8.move(b.x, b.y);
			} else if (b.left) {
				bullet.move_left(b.x, b.y);
				eventCount1 = 0; eventCount2 = 0; eventCount3 = 0; eventCount4 = 0;
				eventCount5 = 0; eventCount6 = 0; eventCount7 = 0; eventCount8 = 0;
				eventCount1Max = rand.nextInt(60)+30; eventCount2Max = rand.nextInt(60)+30; eventCount3Max = rand.nextInt(60)+30; eventCount4Max = rand.nextInt(60)+30;
				eventCount5Max = rand.nextInt(60)+30; eventCount6Max = rand.nextInt(60)+30; eventCount7Max = rand.nextInt(60)+30; eventCount8Max = rand.nextInt(60)+30;
				p1.move(b.x, b.y);
				p2.move(b.x, b.y);
				p3.move(b.x, b.y);
				p4.move(b.x, b.y);
				p5.move(b.x, b.y);
				p6.move(b.x, b.y);
				p7.move(b.x, b.y);
				p8.move(b.x, b.y);
			} else if (b.up) {
				bullet.move_up(b.x, b.y);
				eventCount1 = 0; eventCount2 = 0; eventCount3 = 0; eventCount4 = 0;
				eventCount5 = 0; eventCount6 = 0; eventCount7 = 0; eventCount8 = 0;
				eventCount1Max = rand.nextInt(60)+30; eventCount2Max = rand.nextInt(60)+30; eventCount3Max = rand.nextInt(60)+30; eventCount4Max = rand.nextInt(60)+30;
				eventCount5Max = rand.nextInt(60)+30; eventCount6Max = rand.nextInt(60)+30; eventCount7Max = rand.nextInt(60)+30; eventCount8Max = rand.nextInt(60)+30;
				p1.move(b.x, b.y);
				p2.move(b.x, b.y);
				p3.move(b.x, b.y);
				p4.move(b.x, b.y);
				p5.move(b.x, b.y);
				p6.move(b.x, b.y);
				p7.move(b.x, b.y);
				p8.move(b.x, b.y);
			} else if (b.down) {
				bullet.move_down(b.x, b.y);
				eventCount1 = 0; eventCount2 = 0; eventCount3 = 0; eventCount4 = 0;
				eventCount5 = 0; eventCount6 = 0; eventCount7 = 0; eventCount8 = 0;
				eventCount1Max = rand.nextInt(60)+30; eventCount2Max = rand.nextInt(60)+30; eventCount3Max = rand.nextInt(60)+30; eventCount4Max = rand.nextInt(60)+30;
				eventCount5Max = rand.nextInt(60)+30; eventCount6Max = rand.nextInt(60)+30; eventCount7Max = rand.nextInt(60)+30; eventCount8Max = rand.nextInt(60)+30;
				p1.move(b.x, b.y);
				p2.move(b.x, b.y);
				p3.move(b.x, b.y);
				p4.move(b.x, b.y);
				p5.move(b.x, b.y);
				p6.move(b.x, b.y);
				p7.move(b.x, b.y);
				p8.move(b.x, b.y);
			}
		}
	}

//	p1.update_downLeft();
//	g.drawImage(p1.particle, p1.x, p1.y, null);
//	p1.update_downRight();
//	g.drawImage(p2.particle, p2.x, p2.y, null);
//	p1.update_upLeft();
//	g.drawImage(p3.particle, p3.x, p3.y, null);
//	p1.update_upRight();
//	g.drawImage(p4.particle, p4.x, p4.y, null);


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	int spawned_count = 0;

	@Override
	public void run() {
		while (spawned_count <= 50) {
			Random random = new Random();
			try {
				Thread.sleep(random.nextInt(1));
				meteorites.add(new Enemy(random.nextInt(Map.matrix.length*32), random.nextInt(Map.matrix.length*32), this));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			spawned_count++;
		}
	}
}
