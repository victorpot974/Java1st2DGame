package discovering;

import java.awt.Color;

public class Block extends Sprite {

	public Block(Coordinate position, int w, int h) {
		super(position, w, h);
		this.setColor(Color.green);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(KeyInputHandler inputChannel) {
		// TODO Auto-generated method stub

	}

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return "block";
	}

}
