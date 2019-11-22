package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//urlenyeket reprezentalo osztaly
public class Alien implements Drawable {

   
	int xPos, yPos;
	Invasion invasion;// az invayio aminek a tagja az urleny
	Direction moveDirection = Direction.RIGHT;
	int step = 1;
	 static BufferedImage image;

	public static Dimension dimension = new Dimension(40, 40);// az urhalyo merete

	public Alien(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}

	public Alien() {
		this.xPos = -1;
		this.yPos = -1;

	}

	public Alien(Invasion invasion) {
		this.invasion = invasion;
		
		if(!(image==null))return;
		try {
			image = ImageIO.read(new File("alien.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//kirajzolja az urlenyt
	@Override
	public void draw(Graphics g) {
		//g.fillRect(xPos, yPos, dimension.width, dimension.height);
		g.drawImage(image, xPos,yPos,dimension.width,dimension.height,null);
	}

	/*
	 * az uleny mozog a kivalasztott iranyba amig a palya syelet el nem eri. Ekkor
	 * szol az invayionak,hogy iranyt kell valtani az urleny aki a fordulast
	 * eszreveszi mar au uj iranyba lep ,hogy ne maradjon le a tarsaitol
	 */
	public void move() {

		switch (moveDirection) {
		case RIGHT:
			if (xPos + dimension.width + step >= Space.size.width) {
				invasion.changeDirection(Direction.LEFT);
				xPos -= step;
			} else {
				xPos += step;
			}
			break;
		case LEFT:
			if (xPos - step <= 0) {
				invasion.changeDirection(Direction.RIGHT);
				xPos += step;
			} else {
				xPos -= step;
			}
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + moveDirection);
		}

	}

	/*
	 * beallitja az urleny elhelyeykedeset az atvaltasra azert van szukseg,mert
	 * egyes helyek szamitasanal kialakulhat double ertek de rajzolo fuggvenyek csak
	 * az int tipust fogadjak el parameternel
	 */

	public void setPositon(double d, double e) {
		// TODO Auto-generated method stub
		this.xPos = (int) Math.round(d);
		this.yPos = (int) Math.round(e);

	}

	public void setDirection(Direction direction) {
		this.moveDirection = direction;
	}

}