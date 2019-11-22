package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

//a jatekelemek tartalmazo panel
public class Space extends JPanel {
	// eredeti jatek felbontasanak a tobbszorose
	public static Dimension size = new Dimension(224 * 3, 256 * 3);

	Invasion invasion = new Invasion();
	Cannon cannon = new Cannon();

	public Space() {
		setPreferredSize(size);
	}
//egy kirajzolja a jatekelemeket
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		invasion.show(g);
		cannon.draw(g);

	}

}
