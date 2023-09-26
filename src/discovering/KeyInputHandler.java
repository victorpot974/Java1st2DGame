package discovering;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputHandler implements KeyListener {
	
	private boolean lPressed = false;
	private boolean rPressed = false;
	private boolean uPressed = false;
	private boolean dPressed = false;

	public KeyInputHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		System.out.println(code);
		
		lPressed = code == KeyEvent.VK_LEFT;

		rPressed = code == KeyEvent.VK_RIGHT;
			
		uPressed = code == KeyEvent.VK_UP;
		
		dPressed = code == KeyEvent.VK_DOWN;
		
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
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
