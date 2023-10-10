package discovering;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Sprite {
	
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
	
	public Vector2 getVelocity() {
		return this.velocity;
	}
	
	public double getVelocity(char coordinateInfo) {
		if (coordinateInfo == 'x' || coordinateInfo == 'X') {
			return this.getVelocity().x();
		}
		
		else if (coordinateInfo == 'y' || coordinateInfo == 'Y') {
			return this.getVelocity().y();
		}
		return 0;
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
	
	public void applyVelocity(int xVal, int yVal) {
		this.pos.increaseX(xVal);
		this.pos.increaseY(yVal);
	}
	
	public boolean isMoving() {
		return ( this.velocity.x() != 0 || this.velocity.y() != 0 );
	}
	
	public void applyAcceleration() {
		this.velocity.add(this.acceleration);
	}
	
	public void applyAcceleration(int xVal, int yVal) {
		this.velocity.add(new Vector2(Coordinate.fromCartesian(xVal, yVal)));
	}
	
	public void setColor(Color newColor) {
		this.color = newColor;
	}
	
	public void setPos(double x, double y) {
		this.pos.setX(x);
		this.pos.setY(y);
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public abstract void update();
	public abstract void update(KeyInputHandler inputChannel);
	public abstract String type();
	
	public void draw(Graphics2D g2) {
		g2.setColor(this.color);
		g2.fillRect(this.x(), this.y(), this.width, this.height);
		//g2.dispose();
	}
	
}
