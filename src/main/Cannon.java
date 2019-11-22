package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
// a jatekos altal mozgathato agyu
public class Cannon implements Drawable {

	Dimension dimension = new Dimension(100, 40);
	int xPosition = -1;
	int yPosition = -1;

	public Cannon() {

		initPosition();
	}

	private void initPosition() {
		yPosition = Space.size.height-dimension.height;
		xPosition = (int) (Space.size.width / 2 - dimension.height );
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

		g.fillRect(xPosition, yPosition, dimension.width, dimension.height);
		g.setColor(Color.GREEN);
	}
}
