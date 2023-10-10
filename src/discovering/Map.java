package discovering;

public class Map {
	
	private int width;
	private int height;
	private String abstractMap;
	private Sprite[][] spriteGroup;
	private int tileSize;
	private Player mazePlayer;

	public Map(String mapFile, int w, int h, int tSize) {
		// TODO Auto-generated constructor stub
		width = w;
		height = h;
		tileSize = tSize;
		abstractMap = FileManager.readFile(mapFile);
		this.readMap();
	}
	
	
	
	public static Map generateDefaultMap(String mapName, int w, int h, int tSize) {
		String mapRepr = "";
		
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				mapRepr += "X";
			}
			mapRepr += "|";
		}
		
		FileManager.createFile(mapName);
		FileManager.writeFile(mapName, mapRepr);
		return new Map(mapName, w, h, tSize);
	}
	
	
	public Sprite[][] getSprites(){
		return this.spriteGroup;
	}
	
	public Sprite getTileFromPos(int x, int y) {
		return this.spriteGroup[(int) y / tileSize][(int) x / tileSize];
	}
	
	public Sprite getTile(int row, int col) {
		return this.spriteGroup[row][col];
	}
	
	public int getTileRowIndex(int y) {
		return (int) y / tileSize;
	}
	
	
	public int getTileColIndex(int x) {
		return (int) x / tileSize;
	}
	
	public Player getPlayer() {
		return this.mazePlayer;
	}
	
	
	private void readMap() {
		
		this.spriteGroup = new Sprite[this.height][this.width];
		for (int i =0; i < this.height; i++) {
			
			
			for (int j =0; j < this.width; j++) {
				char mapElt = this.abstractMap.charAt(i * this.width + j);
				//System.out.println(mapElt);
				switch (mapElt) {
				
				case 'X':
					this.spriteGroup[i][j] = new Block(Coordinate.fromCartesian(j * tileSize, i * tileSize), tileSize, tileSize);
					break;
				case 'P':
					this.spriteGroup[i][j] = null;
					this.mazePlayer = new Player(Coordinate.fromCartesian(j * tileSize, i * tileSize), tileSize, tileSize, this);
					break;
				case 'G':
					this.spriteGroup[i][j] = new Goal(Coordinate.fromCartesian(j * tileSize, i * tileSize), tileSize, tileSize);
					break;
				default:
					this.spriteGroup[i][j] = null;
				} 
			}
			
		}
	}
}
