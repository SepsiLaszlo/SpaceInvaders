package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;





public class App {

	public static void main(String[] args) {
		
		try {
			FileWriter fw=new FileWriter("new.txt");
			PrintWriter pw=new PrintWriter(fw);
			pw.println("ez");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		SpaceFrame sf= new SpaceFrame();
		
		Space space=new Space();
		
		
		
		sf.add(space);
		sf.pack();
		
		
		sf.setLocationRelativeTo(null);
		
		sf.setVisible(true);
		
		
		AnimatorThread at =new AnimatorThread(space);
		at.start();
		
		 
		
		
		
		
		
		
	}

}
