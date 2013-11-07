import java.awt.*;

/*
 * This class molds the dot object. This will create the methods 
 * necessary to create the dots seen on the screen.
 */

public class Dot {
	
	/*
	 * Instance variables needed for the class
	 */
	
	private int diameter, x, y;
	private Color color;
	/*
	 * The constructor for the dot class. passes the parameters to the
	 * appropriate variables.
	 */
	
	public Dot(int size, Color shade, int upperX, int upperY)
	{
		diameter = size;
	    color = shade;
	    x = upperX;
	    y = upperY;
	}
	
	/*
	 * This method will call Graphics and use it to draw the dot
	 * and fill it with the appropriate color.
	 */
	
	public void draw (Graphics page){
		page.setColor (color);
		page.fillOval (x, y, diameter, diameter);
	}
	
	/*
	 * Getter for color variable. Returns variable color
	 */
	
	public Color getColor(){
		return color;
	}
	

	
}
