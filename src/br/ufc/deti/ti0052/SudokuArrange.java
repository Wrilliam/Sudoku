package br.ufc.deti.ti0052;

import java.util.Arrays;

public class SudokuArrange {
	
	private SudokuBoard board;
	private SudokuRandom rand;
	private int[] numbers;
	
	public SudokuArrange() {
		//preenchimento do tabuleiro e validacao dos numeros
		rand = new SudokuRandom();
		numbers = rand.StandardNumbers();
	}

	public SudokuRandom getRand() {
		return rand;
	}

	@Override
	public String toString() {
		return "SudokuArrange [board=" + board + ", rand=" + rand
				+ ", numbers=" + Arrays.toString(numbers) + "]";
	}

}
