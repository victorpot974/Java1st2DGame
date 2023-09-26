package discovering;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Screen extends JFrame {
	private static final long serialVersionUID = 1L;
	private final int defaultTileSize;
	private final int scaling;
	private final int tileSize;
	private final int tileAmountX;
	private final int tileAmountY;
	private final int width;
	private final int height;
	
	

	public Screen(String title, int originalTileSize, int tileScale, int tileWidthAmount, int tileHeightAmount) {
		defaultTileSize = originalTileSize;
		scaling = tileScale;
		tileSize = defaultTileSize * scaling;
		tileAmountX = tileWidthAmount;
		tileAmountY= tileHeightAmount;
		width = tileSize * tileAmountX;
		height = tileSize * tileAmountY;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setResizable(false);
		this.setTitle(title);
	}
	
	public void load() {
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public int getTileSize() {
		return tileSize;
	}
	
	public int getTileAmountX() {
		return tileAmountX;
	}
	
	public int getTileAmountY() {
		return tileAmountY;
	}
	
	public Dimension getDimensions() {
		return new Dimension(this.width, this.height);
	}
	
	
}