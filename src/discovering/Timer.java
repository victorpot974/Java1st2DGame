package discovering;

public class Timer {
	
	private double nanoDuration;
	private long initialTime;
	private int loops;

	public Timer(double duration, int repeats) {
		// TODO Auto-generated constructor stub
		nanoDuration = duration * Math.pow(10, 9);
		initialTime = System.nanoTime();
		loops = repeats;
	}
	
	public Timer(double duration) {
		// TODO Auto-generated constructor stub
		nanoDuration = duration * Math.pow(10, 9);
		initialTime = System.nanoTime();
		loops = -1;
	}
	
	public void reset() {
		this.initialTime = System.nanoTime();
		this.loops--;
	}
	
	private double getCurrentTime() {
		return System.nanoTime() - this.initialTime;
	}
	
	public boolean isReached() {
		if (this.loops != 0 && this.getCurrentTime() >= this.nanoDuration) {
			this.reset();
			System.out.println("Timer : " + nanoDuration + " reached!");
			return true;
		}
		return false;
	}

}
