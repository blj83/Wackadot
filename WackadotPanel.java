import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/*
 * This is the class that creates the panel where the gameplay
 * takes place.
 */

public class WackadotPanel extends JPanel{
	
	/*
	 * The variables needed throughout the class and methods. Includes
	 * dot objects, int, Rectangle objects, and the top panel.
	 */
	
	private Dot dot1, dot2, dot3;
	private int ranX, ranY, mouseX, mouseY, score, colorChanger, highScore;
	private Rectangle one, two, three;
	private WackadotTopPanel top; 
	
	/*
	 * The constructor
	 * It initializes the variables to the appropriate values. It sets the
	 * background to black and the dimensions. It adds the top panel to the
	 * panel. It then calls a method to genrate random numbers and Initializes the
	 * ots at random spot. There is one blue dot and one red dot. The dot that
	 * follows the mouse is blue as well. It then creates the listener for the
	 * mouse.
	 */
	
	public WackadotPanel(){
		setBackground(Color.black);
		setPreferredSize(new Dimension(500, 500));
		
		colorChanger = 0;
		highScore = 0;
		score = 0;
		
		top = new WackadotTopPanel();
		add(top);
		generateRandom();
		dot1 = new Dot(50, Color.red, ranX, (ranY-50));
		one = new Rectangle((ranX - 25 ) , (ranY - 25) , 50, 50);
		
		generateRandom();
		dot2 = new Dot(50, Color.blue, ranX,(ranY-50));
		two = new Rectangle((ranX - 25) , (ranY - 25), 50, 50);
		
		dot3 = new Dot(50, Color.blue, 0, 0);
		three = new Rectangle((mouseX-50), mouseY ,50 ,50);
		checkDots();
		
		addMouseMotionListener(new motionListener());
	}
	
	/*
	 * Implements the listener for the mouse. It will then determine
	 * if the button is pressed then it gets the coordinates of the
	 * mouse and paints a dot at the appropriate position. It will 
	 * call the methods needed. If it is not presses it will check 
	 * the high score and set it if needed. 
	 */
	
	private class motionListener implements MouseMotionListener{
		public void mouseMoved(MouseEvent event){
			if (top.playing()){
				mouseX = event.getX();
				mouseY = event.getY();
				changeColor();
				checkCollision();
				repaint();
			}
			else {
				if (score > highScore){
					highScore = score;
					top.setHighScore(highScore);
					 
				}
				score = 0;
				colorChanger = 0;
			}
			
		}
		
		/*
		 * Empty method that must be added to implement the interface
		 */
		
		public void mouseDragged(MouseEvent e) {
			
		}
	}
	
	/*
	 * This method calls Graphics object and paints the dot 
	 * objects on the screen using the method draw defined in the 
	 * dot class.
	 */
	
	 public void paintComponent (Graphics page){
		 super.paintComponent(page);

	     dot1.draw(page);
	     dot2.draw(page);
	     dot3.draw(page);
	 }
	 
	 /*
	  * Generates two random numbers and assigns the numbers to 
	  * the variables ranX and ranY.
	  */
	 
	 public void generateRandom(){
		 ranX = (int)(Math.random()*450);
		 ranY = 100 + (int)(Math.random()* 400);
	 }
	 
	 /*
	  * This method will check to see if the two dots not controlled by
	  * the mouse overlap and if they do it draws a new dot in another random 
	  * spot.
	  */
	 
	 public void checkDots(){
		 while (one.intersects(two)){
				generateRandom();
				dot2 = new Dot(50, Color.blue, ranX,(ranY-50));
				two = new Rectangle((ranX - 25) , (ranY - 25), 50, 50);
			}
	 }
	 
	 /*
	  * This method uses the variable colorchanger to dtermine what color
	  * to make the dot controlled by the mouse. If the variable is even it
	  * will draw a blue dot. If it is odd it will create a red dot.
	  */
	 
	 public void changeColor(){
		 if ((colorChanger % 2) == 0){
			 dot3 = new Dot(50, Color.blue, (mouseX - 25), (mouseY - 25));
			 three = new Rectangle((mouseX-50), mouseY ,50 ,50);
		 }
		 else {
			 dot3 = new Dot(50, Color.red, (mouseX - 25), (mouseY - 25));
			 three = new Rectangle((mouseX-50), mouseY ,50 ,50);
		 }
	 }
	 
	 /*
	  * This method uses the intersects method of the Rectangle class to 
	  * detemine if the the two objects are in the same spot. It will go 
	  * through a loop while the button is pressed and there is a collision.
	  * It will then go through decision statements to determine which of the 
	  * dots intersects and increase or decrease the score appropriately and 
	  * sends the score to the top panel and it will redraw the panel.
	  */
	 
	 public void checkCollision(){
		// while ((three.intersects(one) || three.intersects(two)) && top.playing()){
				if (three.intersects(one)) {
					generateRandom();
					dot1 = new Dot(50, Color.red, ranX, (ranY-50));
					one = new Rectangle((ranX - 25 ) , (ranY - 25) , 50, 50);
					
					if (dot3.getColor().equals(Color.red)){
						score++;
						colorChanger++;
						top.setScore(score);
					}
					else{
						score--;
						top.setScore(score);
					}
					checkDots();
				}
				else if (three.intersects(two)){
					generateRandom();
					dot2 = new Dot(50, Color.blue, ranX,(ranY-50));
					two = new Rectangle((ranX - 25) , (ranY - 25), 50, 50);
					
					if (dot3.getColor().equals(Color.blue)){
						score++;
						colorChanger++;
						top.setScore(score);
					}
					else{
						score--;
						top.setScore(score);
					}
					checkDots();
				}
				
			//}
	 }
}
