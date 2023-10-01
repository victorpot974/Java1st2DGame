package discovering;

import java.awt.Color;

public class Player extends Sprite {
	
	private int playerSpeed;
	private int slidingMoveDivision;
	private int slidingMoveCount;
	private int slidingMoveRemain;
	
	public Player(Coordinate position, int w, int h) {
		super(position,w, h);
		slidingMoveCount = 0;
		slidingMoveDivision = 5;
		playerSpeed = (int) w / slidingMoveDivision;
		slidingMoveRemain = w % slidingMoveDivision;
		this.setColor(Color.red);
	}
	
	public void detectArrowControls(KeyInputHandler inputChannel) {
		int xVel = inputChannel.leftPressed() ? -playerSpeed : inputChannel.rightPressed() ? playerSpeed : 0;;
		int yVel = inputChannel.upPressed() ? -playerSpeed : inputChannel.downPressed() ? playerSpeed : 0;
		
		if (xVel != 0 || yVel != 0) {
			slidingMoveCount = slidingMoveDivision;
			this.setVelocity(xVel, yVel);
		}
	}
	
	public void stopMoving() {
		this.setVelocity(0, 0);
	}
	
	@Override
	public void update(KeyInputHandler inputChannel) {
		// this.count++;
		// System.out.println(this.count);
		if (slidingMoveCount == 0) {
			this.detectArrowControls(inputChannel);
		}
		
		if (this.isMoving()) {
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
