package discovering;

import java.awt.Color;

public class Player extends Sprite {
	
	private int playerSpeed;
	private int slidingMoveDivision;
	private int slidingMoveCount;
	private int slidingMoveRemain;
	private boolean moveKeyWasReleased;
	private Map gameMap;
	private double initPosX;
	private double initPosY;
	private int currentTileRowIndex;
	private int currentTileColIndex;
	
	public Player(Coordinate position, int w, int h, Map parentMap) {
		super(position,w, h);
		initPosX = position.getX();
		initPosY = position.getY();
;		slidingMoveCount = 0;
		slidingMoveDivision = 7;
		gameMap = parentMap;
		moveKeyWasReleased = true;
		playerSpeed = (int) w / slidingMoveDivision;
		slidingMoveRemain = w % slidingMoveDivision;
		this.setColor(Color.red);
		currentTileRowIndex = gameMap.getTileRowIndex(this.y());
		currentTileColIndex = gameMap.getTileColIndex(this.x());
		System.out.println(this.currentTileRowIndex);
		System.out.println(this.currentTileColIndex);
	}
	
	public void detectArrowControls(KeyInputHandler inputChannel) {
		int xVel = 0;
		int yVel = 0;
		
		int colIndexBonus = 0;
		int rowIndexBonus = 0;
		
		if (inputChannel.leftPressed()) {
			xVel = -playerSpeed;
			colIndexBonus = -1;
		}
		
		else if (inputChannel.rightPressed()) {
			xVel = playerSpeed;
			colIndexBonus = 1;
		}
		
		
		else if (inputChannel.upPressed()) {
			yVel = -playerSpeed;
			rowIndexBonus = -1;
		}
		
		else if (inputChannel.downPressed()) {
			yVel = playerSpeed;
			rowIndexBonus = 1;
		}
	
		
		
		if ( (colIndexBonus != 0 || rowIndexBonus != 0) && this.headingToValidTile(this.currentTileRowIndex + rowIndexBonus, this.currentTileColIndex + colIndexBonus)) {
			slidingMoveCount = slidingMoveDivision;
			this.setVelocity(xVel, yVel);
			this.currentTileColIndex += colIndexBonus;
			this.currentTileRowIndex += rowIndexBonus;
		}
	}
	
	
	public boolean headingToValidTile(int rowIndex, int colIndex) {
		Sprite nextTile = this.gameMap.getTile(rowIndex, colIndex);
		if (nextTile != null)	
			System.out.println(nextTile.type());
		return nextTile == null || nextTile.type() == "goal";
	}
	
	public void stopMoving() {
		this.setVelocity(0, 0);
	}
	
	
	@Override
	public void update(KeyInputHandler inputChannel) {
		// Saves initial position to cancel potential invalid moves
		
		if (slidingMoveCount == 0 && moveKeyWasReleased) {
			this.detectArrowControls(inputChannel);
		}
		
		else {
			moveKeyWasReleased = inputChannel.allArrowsReleased();
		}
		
		if (this.isMoving()) {
			// moveKeyWasReleased = inputChannel.allArrowsReleased();
			this.applyVelocity();
			this.slidingMoveCount--;
			
			if (slidingMoveCount == 0) {
				
				if (this.getVelocity('x') > 0) {
					this.setXVelocity(slidingMoveRemain);
				}
				
				else if (this.getVelocity('x') < 0) {
					this.setXVelocity(-slidingMoveRemain);
				}
				
				else if (this.getVelocity('y') > 0) {
					this.setYVelocity(slidingMoveRemain);
				}
				
				if (this.getVelocity('y') < 0) {
					this.setYVelocity(-slidingMoveRemain);
				}
				
				this.applyVelocity();
				this.stopMoving();
				
			}
		}
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.applyAcceleration();
		this.applyVelocity();
	}

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return "player";
	}

	
	
	
}
