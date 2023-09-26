package discovering;

import java.awt.Color;

public class Main {
	public static void main(String[] args) {
		System.out.println("Execution Started");
		Screen screen = new Screen("My Fav Game", 16, 3, 15, 10);
		GamePanel gamePanel = new GamePanel(screen, Color.LIGHT_GRAY);
		gamePanel.startThread();
		//screen.startThread();
		}
}