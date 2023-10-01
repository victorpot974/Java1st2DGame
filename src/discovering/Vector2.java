package discovering;

public class Vector2 {
	
	public Coordinate coord2;

	public Vector2(Coordinate coord) {
		// TODO Auto-generated constructor stub
		coord2  = coord;
	}
	
	public static Vector2 fromPolar(double angle, double length) {
		Vector2 vector = new Vector2(Coordinate.fromPolar(angle, length));
		return vector;
	}
	
	public static Vector2 fromCartesian(double xval, double yval) {
		return new Vector2(Coordinate.fromCartesian(xval, yval));
	}
	
	public  double x() {
		return this.coord2.getX();
	}
	
	public double y() {
		return this.coord2.getY();
	}
	
	public void setCoord(Coordinate newCoord) {
		this.coord2 = newCoord;
	}
	
	public void setAngle(double angle) {
		this.setCoord( Coordinate.fromPolar(angle, this.getLength()) );
	}
	
	public void rotateLeft(double angleChange) {
		this.setAngle(this.getAngle() + angleChange);
	}
	
	public void rotateRight(double angleChange) {
		this.setAngle(this.getAngle() - angleChange);
	}
	
	public double getLength() {
		return Math.sqrt( Math.pow(this.coord2.getX(), 2) + Math.pow(this.coord2.getY(), 2)  );
	}
	
	public double getAngle() {
		return Math.toDegrees(Math.acos(this.coord2.getX() / this.getLength()));
	}
	
	public void add(Vector2 other) {
		this.coord2.increaseX(other.coord2.getX());
		this.coord2.increaseY(other.coord2.getY());
	}

}
