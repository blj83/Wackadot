import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * This class molds the top panel of the interface which is 
 * resposible for starting the game, keeping score and time.
 */

public class WackadotTopPanel extends JPanel {
	
	/*
	 * The instance variables for this class. Includes the labels
	 * button, int variables and timer needed to implement what is
	 * needed in the interface
	 */
	
	private int time, score, highScore;
	private JButton play;
	private JLabel scoreKeeper, timeKeeper, highScoreKeeper;
	private javax.swing.Timer timer;
	private boolean playing;
	
	/*
	 * Pre: This is the constructor for this panel. Before the instance variables
	 * are not initiated.
	 * 
	 * Post: It initializes the variables and adds the labels and buttons to the
	 * panel. It also makes the color gray and sets the dimensions.
	 */
	
	public WackadotTopPanel(){
		time = 30;
		score = 0;
		highScore = 0;
		
		play = new JButton("Play");
		play.setSelected(false);
		playing = false;
		play.addActionListener(new playListener());
		
		timeKeeper = new JLabel("Time Left: " + time);
		scoreKeeper = new JLabel("Score: " + score);
		highScoreKeeper = new JLabel("High Score: " + highScore);
		
		add(timeKeeper);
		add(play);
		add(scoreKeeper);
		add(highScoreKeeper);
		
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(500, 50));

	}
	
	/*
	 * The listener for the play button. When the button is pushed this method
	 * will be implemented. It will then change variables needed and creates a 
	 * timer and starts that timer.
	 */
	
	private class playListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			play.setText("...playing");
			play.setSelected(true);
			playing = true;
			setScore(0);
			timer = new javax.swing.Timer(1000, new timeListener());
			timer.start();
		}
	}
	
	/*
	 * This listener is for the Timer and will implemented every second.
	 * It will check to see if the time variable is zero then change the 
	 * variables as it is appropriate. If it is not zero then it will decrease 
	 * time by one and print it out on the screen.
	 */
	
	private class timeListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			if (time == 0){
				timer.stop();
				play.setSelected(false);
				playing = false;
				play.setText("Retry");
				repaint();
				time = 30;
				score = 0;
				return;
			}
			time = time - 1;
			timeKeeper.setText("Time Left: " + time);
			repaint();
		}
	}
	
	/*
	 * The getter for the play variable. returns play.
	 */
	
	public JButton getPlay(){
		return play;
	}
	
	/*
	 * The setter for the score variable. Takes the parameter
	 * and sets it equal to score and prints the score and 
	 * repaints the panel.
	 */
	
	public void setScore(int temp){
		score = temp;
		scoreKeeper.setText("Score: " + score);
		repaint();
	}
	
	/*
	 *  The setter for the high score variable. It takes the 
	 *  parameter and sets high score equal to it. It then reprints 
	 *  the panel.
	 */
	
	public void setHighScore(int temp){
		highScore = temp;
		highScoreKeeper.setText("High Score: " + highScore);
		repaint();
	}
	
	/*
	 * Getter for boolean variable playing. returns playing.
	 */
	
	public boolean playing(){
		return playing;
	}
	
	/*
	 * Getter for int variable time. returns time.
	 */
	
	public int getTime(){
		return time;
	}
	
	/*
	 * Getter for int variable score. returns score.
	 */
	
	public int getScore(){
		return score;
	}
}
