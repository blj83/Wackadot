/*
 * This is the main method for the Wackadot program. It will create the
 * the frame of the interface. It also adds the panel that contains the 
 * the elements for gameplay. The final thing the main method does is 
 * packs the frame together and makes it visible. The Wackadot program 
 * is a game where you attempt to make the dot on your mouse cursor 
 * make contact with the same color dot that is in the game. It has
 * a 30 second counter, score keeper, and a high score feature.
 */

import java.awt.*;

import javax.swing.JFrame;

public class Wackadot {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Wackadot");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		WackadotPanel panel = new WackadotPanel();
		frame.getContentPane().add(panel);
		
		
		frame.pack();
		frame.setVisible(true);

	}

}
