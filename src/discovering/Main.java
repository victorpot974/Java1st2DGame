package discovering;

import java.awt.Color;

public class Main {
	public static void main(String[] args) {
		//System.out.println("Execution Started");
		Screen screen = new Screen("My Fav Game", 16, 3, 15, 10);
		Map gameMap = new Map("Maps/SimpleMap.txt", screen.getTileAmountX(), screen.getTileAmountY());
		GamePanel gamePanel = new GamePanel(screen, Color.YELLOW, gameMap.readMap(screen.getTileSize()));
		gamePanel.startThread();
	}
}