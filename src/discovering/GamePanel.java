package discovering;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	Thread gameThread;  // This thread = the game clock
	private Sprite heroSprite;
	private Screen parentScreen;
	private int tileSize;
	public KeyInputHandler keyManager;
	final private int framesPerSecond;
	private int count;
	
	private Timer mainTimer;
	private Timer secondTimer;

	public GamePanel(Screen screen, Color bg) {
		// TODO Auto-generated constructor stub
		this.parentScreen = screen;
		count = 0;
		framesPerSecond = 60;
		
		mainTimer = new Timer(1 / framesPerSecond);
		secondTimer = new Timer(1);
		
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
		this.heroSprite.update(this.keyManager);
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
			
			// System.out.println(currentTime);
			
			if (this.mainTimer.isReached()) {
				count++;
				//this.update();
				//this.draw();
			}
			
			if (this.secondTimer.isReached()) {
				//System.out.println(count);
			}
		}
	}

	
}



