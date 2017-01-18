package br.ufc.deti.ti0052;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumericTextField extends JTextField implements KeyListener
{
	private static final long serialVersionUID = -5250593409701620636L;
	private boolean isValidKey;
	private String oldText;
	
	public NumericTextField() {
		super();
		isValidKey = true;
		oldText = "";
		addKeyListener(this);
	}

	public NumericTextField(String text) {
		super(text);
		isValidKey = true;
		oldText = "";
		addKeyListener(this);
	}	
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		if(!isValidKey) {
			setText(oldText);
			setBackground(Color.WHITE);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		oldText = getText();
		isValidKey = validateKeyPressed(arg0);
		if(!isValidKey) {
			setBackground(Color.RED);
		}
	}
	
	/** Valida teclas pressionadas
	 * 
	 * @param arg0 evento capturado
	 * @return
	 */
	public boolean validateKeyPressed(KeyEvent arg0, SudokuBoard board) {
		
		if((arg0.getKeyCode() >= 49 && arg0.getKeyCode() <= 57) //1-9
				|| arg0.getKeyCode() == 8)	//backspace
		{
			if(arg0.getKeyCode() == 8) return true;
			else {
				int pair[] = board.getFocusedBox();
				int i = arg0.getKeyCode() - 48;
				if(pair != null)
					if(!board.existsInColumn(pair[0], i) &&
							!board.existsInRow(pair[1], i) &&
							!board.existsInSubgrid(pair[0], pair[1], i))
						return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		JFrame app = new JFrame();
		NumericTextField num = new NumericTextField();
		BoxLength leng = new BoxLength();
		leng.setMax(1);
		num.setDocument(leng);
		app.setVisible(true);
		app.setSize(30, 30);
		app.add(num);
	}
	
	public static class BoxLength extends PlainDocument {

		private static final long serialVersionUID = 1L;
		
		private int max;

		@Override
		public void insertString(int offs, String str, AttributeSet a)
				throws BadLocationException {
			if(str != null && (getLength() + str.length() <= max))
				super.insertString(offs, str, a);
		}
		
		public void setMax(int max) {
			this.max = max;
		}
		
	}
}
