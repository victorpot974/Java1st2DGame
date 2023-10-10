package discovering;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	Thread gameThread;  // This thread = the game clock
	//private Player heroSprite;
	private Screen parentScreen;
	private int tileSize;
	public KeyInputHandler keyManager;
	final private int framesPerSecond;
	private double frameRate;
	private Sprite[][] allSprites;
	private Player player;
	//private int count;
	
	private Timer mainTimer;
	// private Timer secondTimer;

	public GamePanel(Screen screen, Color bg, Sprite[][] sprites, Player playerSprite) {
		// TODO Auto-generated constructor stub
		this.parentScreen = screen;
		//count = 0;
		framesPerSecond = 60;
		frameRate  = (double) 1 / framesPerSecond;
		mainTimer = new Timer(frameRate);
		allSprites = sprites;
		//secondTimer = new Timer(1);
		
		this.setDoubleBuffered(true);
		
		this.setBackground(bg);
		this.parentScreen.add(this);
		this.setPreferredSize(this.parentScreen.getDimensions());
		this.parentScreen.load();
		
		this.tileSize = this.parentScreen.getTileSize();
		//this.heroSprite = new Player(new Coordinate(0, 0), this.tileSize, this.tileSize);
		
		this.loadInputManager();
		this.player = playerSprite;
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
		for (Sprite[] sList: allSprites) {
			for (Sprite s : sList) {
				if (s != null) {
					s.update(keyManager);
				}
			}
		}
		this.player.update(keyManager);
	}
	
	private void draw() {
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (Sprite[] sList: allSprites) {
			for (Sprite s : sList) {
					if (s != null) {
						s.draw(g2);
					}
			}
		}
		this.player.draw(g2);
		// System.out.println("OK");
		g2.dispose();
	}
	
	
	public void run() {
		while (gameThread != null) {
			
			// System.out.println(currentTime);
			
			if (this.mainTimer.isReached()) {
				this.update();
				this.draw();
			}

		}
	}

	
}



