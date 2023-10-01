package discovering;

public class Map {
	
	private int width;
	private int height;
	private String abstractMap;

	public Map(String mapFile, int w, int h) {
		// TODO Auto-generated constructor stub
		width = w;
		height = h;
		abstractMap = FileManager.readFile(mapFile);
	}
	
	
	public static Map generateDefaultMap(String mapName, int w, int h) {
		String mapRepr = "";
		
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				mapRepr += "X";
			}
			mapRepr += "|";
		}
		
		FileManager.createFile(mapName);
		FileManager.writeFile(mapName, mapRepr);
		return new Map(mapName, w, h);
	}
	
	
	public  Sprite[][] readMap(int tileSize) {

		Sprite[][] spriteGroup = new Sprite[this.height][this.width];
		
		
		for (int i =0; i < this.height; i++) {
			
			
			for (int j =0; j < this.width; j++) {
				char mapElt = this.abstractMap.charAt(i * this.width + j);
				//System.out.println(mapElt);
				switch (mapElt) {
				
				case 'X':
					spriteGroup[i][j] = new Block(Coordinate.fromCartesian(j * tileSize, i * tileSize), tileSize, tileSize);
					break;
				case 'P':
					spriteGroup[i][j] = new Player(Coordinate.fromCartesian(j * tileSize, i * tileSize), tileSize, tileSize);
					break;
				case 'G':
					spriteGroup[i][j] = new Goal(Coordinate.fromCartesian(j * tileSize, i * tileSize), tileSize, tileSize);
					break;
				default:
					spriteGroup[i][j] = null;
				} 
			}
			
		}
		return spriteGroup;
	}
}
