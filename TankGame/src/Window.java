import javax.swing.JFrame;

public class Window extends JFrame {

	public Window () {
		
		setUndecorated(false);
		setSize(1847, 1040);
		setVisible(true);
		setDefaultCloseOperation( EXIT_ON_CLOSE );

		
		GamePanel panel = new GamePanel();

		leveleditor le = new leveleditor();

		add(le);

		add(panel);
		addKeyListener(panel );
		addMouseListener(panel );
	
		revalidate();
		
		
	}
	
	
}
