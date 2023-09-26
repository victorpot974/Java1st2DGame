package discovering;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	Thread gameThread;
	private Sprite heroSprite;
	private Screen parentScreen;
	private int tileSize;
	public KeyInputHandler keyManager;

	public GamePanel(Screen screen, Color bg) {
		// TODO Auto-generated constructor stub
		this.parentScreen = screen;
		
		this.setDoubleBuffered(true);
		
		this.setBackground(bg);
		this.parentScreen.add(this);
		this.setPreferredSize(this.parentScreen.getDimensions());
		this.parentScreen.load();
		
		this.tileSize = this.parentScreen.getTileSize();
		this.heroSprite = new Sprite(new Coordinate(0, 0), this.tileSize, this.tileSize);
		
		this.loadInputManager();
		// this.heroSprite.setXVelocity(1);
	}
	
	public void startThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void loadInputManager() {
		this.keyManager = new KeyInputHandler();
		this.addKeyListener(keyManager);
		this.setFocusable(true);
	}
	
	public void setParentScreen(Screen screen) {
		this.parentScreen = screen;
	}
	
	
	private void update() {
		this.heroSprite.update();
	}
	
	private void draw() {
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		this.heroSprite.draw(g2);
		// System.out.println("OK");
	}
	
	public void run() {
		while (gameThread != null) {
			this.update();
			this.draw();
		}
	}

	
}



