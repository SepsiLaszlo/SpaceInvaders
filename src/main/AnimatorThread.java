package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;



public class AnimatorThread extends Thread {

	Space space;
	

	public AnimatorThread(Space space) {
		// TODO Auto-generated constructor stub
		this.space = space;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			space.invasion.move();

			space.repaint();
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
