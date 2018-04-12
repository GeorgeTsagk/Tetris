import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.*;

public class Main {
	
	private JFrame j;
	private Drawer dr;
	public static void main (String[] args) {
		
		Main a = new Main();
		a.run();	
	}
	
	public void run() {
		setup();	
	}
	public void setup() {
		j = new JFrame();
		j.setSize(360, 560);
		j.setVisible(true);
		j.setResizable(true);
		j.setLocation(300, 100);
		j.setLayout(j.getLayout());
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setBackground(Color.BLACK);
		dr = new Drawer();
		dr.setSize(210,520);
		dr.setBackground(Color.BLACK);
		j.add(dr);
		j.addKeyListener( 
				new KeyListener() {

					@Override
					public void keyPressed(KeyEvent arg0) {
						if(arg0.getKeyCode()==KeyEvent.VK_A)if(dr.sy > 0) { dr.sy--; dr.dynamicClearRight(); }
						if(arg0.getKeyCode()==KeyEvent.VK_D)if(dr.sy<6) { dr.sy++; dr.dynamicClearLeft(); }
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				}
				);
	}
}
