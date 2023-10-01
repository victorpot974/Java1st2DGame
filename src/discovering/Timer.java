package discovering;

public class Timer {
	
	private double nanoDuration;
	private long initialTime;
	private int loops;
	private double initDuration;
	
	public Timer(double duration, int repeats) {
		// TODO Auto-generated constructor stub
		this.nanoDuration = duration * Math.pow(10, 9);
		
		this.initDuration = nanoDuration;
		this.initialTime = System.nanoTime();
		this.loops = repeats;
		
	}
	
	public Timer(double duration) {
		// TODO Auto-generated constructor stub
		this.nanoDuration = (double) duration * Math.pow(10, 9);
		this.initDuration = nanoDuration;
		this.initialTime = System.nanoTime();
		this.loops = -1;
		System.out.println(this.initDuration);
	}
	
	public void reset() {
		// this.initialTime = System.nanoTime();
		this.nanoDuration += initDuration;
		this.loops--;
	}
	
	private double getCurrentTime() {
		return System.nanoTime() - this.initialTime;
	}
	
	public boolean isReached() {
		if (this.loops != 0 && this.getCurrentTime() >= this.nanoDuration) {
			this.reset();
			//System.out.println("Timer : " + this.nanoDuration + " reached!");
			return true;
		}
		return false;
	}

}
