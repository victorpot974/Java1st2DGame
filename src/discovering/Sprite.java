package discovering;

import java.awt.Color;
import java.awt.Graphics2D;

public class Sprite {
	
	private int width;
	private int height;
	private Coordinate pos;
	private Color color;
	private Vector2 velocity;
	private Vector2 acceleration;
	// private int count;

	public Sprite(Coordinate position, int w, int h) {
		width = w;
		// count = 0;
		height = h;
		pos = position;
		color = Color.white;
		velocity = new Vector2(Coordinate.fromCartesian(0, 0));
		acceleration = new Vector2(Coordinate.fromCartesian(0, 0));
	}
	
	public int x() {
		return (int) this.pos.getX();
	}
	
	public int y() {
		return (int) this.pos.getY();
	}
	
	public void setXVelocity(double newVal) {
		this.velocity.coord2.setX(newVal);
	}
	
	public void setYVelocity(double newVal) {
		this.velocity.coord2.setY(newVal);
	}
	
	public void setVelocity(double xVal, double yVal) {
		this.velocity.setCoord(Coordinate.fromCartesian(xVal, yVal));
	}
	
	
	public void applyVelocity() {
		this.pos.increaseX(this.velocity.coord2.getX());
		this.pos.increaseY(this.velocity.coord2.getY());
	}
	
	public void applyAcceleration() {
		this.velocity.add(this.acceleration);
	}
	
	public void detectArrowControls(KeyInputHandler inputChannel) {
		int xVel = inputChannel.leftPressed() ? -1 : inputChannel.rightPressed() ? 1 : 0;;
		int yVel = inputChannel.upPressed() ? -1 : inputChannel.downPressed() ? 1 : 0;
		this.setVelocity(xVel, yVel);
	}
	
	public void update(KeyInputHandler inputChannel) {
		// this.count++;
		// System.out.println(this.count);
		this.detectArrowControls(inputChannel);
		this.applyAcceleration();
		this.applyVelocity();
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(this.color);
		g2.fillRect(this.x(), this.y(), this.width, this.height);
		g2.dispose();
		//System.out.println(this.x());
		// System.out.println(this.y());
	}
	
}
