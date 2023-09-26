package discovering;

public class Coordinate {
	
	private double x;
	private double y;

	public Coordinate(double xval, double yval) {
		// TODO Auto-generated constructor stub
		x = xval;
		y = yval;
	}
	
	public static Coordinate fromPolar(double angle, double distance) {
		double radAngle =  Math.toRadians(angle);
		return new Coordinate(distance * Math.cos(radAngle), distance * Math.sin(radAngle));
	}
	
	public static Coordinate fromCartesian(double xval, double yval) {
		return new Coordinate(xval, yval);
	}
	
	//final public double distance(Coordinate other) {
	//	return Math.sqrt( Math.pow( (this.x - other.x) , 2) +  Math.pow( (this.y - other.y) , 2) );
	//}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double value) {
		this.x = value;
	}
	
	public void setY(double value) {
		this.y = value;
	}
	
	public void increaseX(double value) {
		this.setX( this.getX() + value );
	}
	
	public void increaseY(double value) {
		this.setY( this.getY() + value );
	}

}
