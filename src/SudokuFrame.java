import java.awt.Color;

import javax.swing.JFrame;

public class SudokuFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private int width, height;
	private SudokuPanel panel;

	public SudokuFrame(String title) {
		super(title);
		width = 640;
		height = 480;
		// set the window's size
		setSize(width, height);
		// set the frame's exit button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		panel = new SudokuPanel();
		panel.setBackground(new Color(200, 200, 200));
		panel.setLocation((width-panel.getWidth())/2, (height-panel.getHeight())/2);
		add(panel);
	}

	public static void main(String[] args) {
		SudokuFrame frame = new SudokuFrame("Sudoku 2020");
		frame.setVisible(true);
	}

}
