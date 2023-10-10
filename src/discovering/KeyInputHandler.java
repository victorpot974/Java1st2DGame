package discovering;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputHandler implements KeyListener {
	
	private boolean lPressed = false;
	private boolean rPressed = false;
	private boolean uPressed = false;
	private boolean dPressed = false;
	
	
	private boolean lTyped = false;
	private boolean rTyped = false;
	private boolean uTyped = false;
	private boolean dTyped = false;

	public KeyInputHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		
		lTyped = code == KeyEvent.VK_LEFT;

		rTyped = code == KeyEvent.VK_RIGHT;
			
		uTyped = code == KeyEvent.VK_UP;
		
		dTyped = code == KeyEvent.VK_DOWN;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_LEFT) {
			lPressed = true;
		}

		if (code == KeyEvent.VK_RIGHT) {
			rPressed = true;
		}
			
		if (code == KeyEvent.VK_UP) {
			uPressed = true;
		}
		
		if (code == KeyEvent.VK_DOWN) {
			dPressed = true;
		}
		
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_LEFT) {
			lPressed = false;
		}

		if (code == KeyEvent.VK_RIGHT) {
			rPressed = false;
		}
			
		if (code == KeyEvent.VK_UP) {
			uPressed = false;
		}
		
		if (code == KeyEvent.VK_DOWN) {
			dPressed = false;
		}
		
	}
	
	public boolean leftTyped() {
		return lTyped;
	}

	public boolean rightTyped() {
		return rTyped;
	}
	
	public boolean upTyped() {
		return uTyped;
	}
	
	public boolean downTyped() {
		return dTyped;
	}
	
	
	public boolean leftPressed() {
		return lPressed;
	}

	public boolean rightPressed() {
		return rPressed;
	}
	
	public boolean upPressed() {
		return uPressed;
	}
	
	public boolean downPressed() {
		return dPressed;
	}
	
	public boolean allArrowsReleased() {
		return !(dPressed || rPressed || uPressed|| lPressed);
	}

}
