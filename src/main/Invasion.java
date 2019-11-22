package main;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.stream.Stream;
//az urlenyeket iranyito osztaly
public class Invasion {

	private Direction alienDirection;
	private Alien[][] aliens = new Alien[5][11];
	double spacing = 1.5f;

	//letrehozza a kezdetben a hangarban levo urlenyeket(-1,-1),majd csatapoyici=ba rendezi oket
	public Invasion() {
		// TODO Auto-generated constructor stub
		createAliens();
		getInPosition();
	}

	public void createAliens() {
		for (int x = 0; x < aliens.length; x++) {
			for (int y = 0; y < aliens[x].length; y++) {
				aliens[x][y] = new Alien(this);
			}
		}
	}
	/* a panel meretehey aranyosan, egymastol azonos tavolsagra elhelzez
	az urlenyeket*/
	public void getInPosition() {

		int alienWidth = Alien.dimension.width;
		int alienHight = Alien.dimension.width;
		int frameWidth = Space.size.width;
		int frameHeight = Space.size.width;

		double spaceingHorizontally = frameWidth * (0.8f) / 11;
		double spaceingVertically = frameHeight * (0.2f) / 5;
		double offsetHorizontally = frameWidth * (0.2f) / 2;

		for (int y = 0; y < aliens.length; y++) {
			for (int x = 0; x < aliens[y].length; x++) {
				aliens[y][x].setPositon(offsetHorizontally + x * spaceingHorizontally, y * spaceingVertically);
			}
		}
	}
/*megjelenti as osszes urlenyt
	SpacePanel paintComponentje parameterzi fel*/
	public void show(Graphics g) {

		for (int y = 0; y < aliens.length; y++) {
			for (int x = 0; x < aliens[y].length; x++) {
				aliens[y][x].draw(g);
			}
		}
	}
/*mozgatja az osszes urlenyt 
 *fontos,hogy mindig a haladsi irany szerinti elso
 *sor mozogjon elosszor, mert ha nem osszecsusznak a sorok 
 * */
	public void move() {
		if(alienDirection==Direction.LEFT) {
		for (int x = 0; x < aliens[0].length; x++) {
			for (int y = 0; y < aliens.length; y++) {

				aliens[y][x].move();
			}
		}
		}
		else {
			for (int x = aliens[0].length-1; x >=0 ; x--) {
				for (int y = 0; y < aliens.length; y++) {

					aliens[y][x].move();
				}
			}
		}
	}
	/*ha egy urleny elerte a palya valmelyik szelet 
	 * szol, ekkor az osszes hajo megfordul*/
	public void changeDirection(Direction direction) {
		alienDirection=direction;
		for (int y = 0; y < aliens.length; y++) {
			for (int x = 0; x < aliens[y].length; x++) {
				aliens[y][x].setDirection(direction);
			}
		}
	}

}
