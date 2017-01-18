package br.ufc.deti.ti0052;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JFrame;

public class Sudoku extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private SudokuBoard grade;
	
	public Sudoku() {
		//criar tabuleiro
		grade = new SudokuBoard();
		grade.setBackground(Color.RED);
		//preencher tabuleiro
	}

	public static void main(String[] args) {
		Sudoku app = new Sudoku();
		app.setTitle("Sudoku");
		app.setVisible(true);
		
		Insets insets = app.getInsets();
		//System.out.println("insets = " + insets);
		app.setSize(250+insets.left+insets.right,
				225+insets.top+insets.bottom);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//app.setResizable(false);
		app.setLayout(null);
		
		app.grade.setLocation(0, 0);
		app.add(app.grade);
		
		//SudokuRandom rand = new SudokuRandom();
		//System.out.println(rand);
		

	}

}
