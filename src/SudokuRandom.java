

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Random;

public class SudokuRandom extends Random {

	private static final long serialVersionUID = 1L;

	public SudokuRandom() {
		this(new GregorianCalendar().getTimeInMillis());
		
	}

	public SudokuRandom(long seed) {
		super(seed);
		
	}

	@Override
	public String toString() {
		return "SudokuRandom [StandardNumbers()="
				+ Arrays.toString(StandardNumbers()) + "]";
	}
	
	public int Randomize() {
		return (Math.abs(nextInt()) % 9);
		
	}

	public int[] StandardNumbers() {
		int number, i = 0, k;
		int numbers[] = new int[38];
		int counter[] = new int[9];
		while(i < 27) {
			number = 1 + Randomize();
			for(k = 0; k < 9; k++)
				if(number == k+1)
					counter[k]++;
			if(counter[0] > 3 && number == 1 ||
					counter[1] > 3 && number == 2 ||
					counter[2] > 3 && number == 3 ||
					counter[3] > 3 && number == 4 ||
					counter[4] > 3 && number == 5 ||
					counter[5] > 3 && number == 6 ||
					counter[6] > 3 && number == 7 ||
					counter[7] > 3 && number == 8 ||
					counter[8] > 3 && number == 9)
				continue;
			numbers[i] = number;
			i++;
		}
		for(k = 0; k < 9; k++)
			counter[k] = 0;
		while(i < 38) {
			number = 1 + Randomize();
			for(k = 0; k < 9; k++)
				if(number == k+1)
					counter[k]++;
			if(counter[0] > 2 && number == 1 ||
					counter[1] > 2 && number == 2 ||
					counter[2] > 2 && number == 3 ||
					counter[3] > 2 && number == 4 ||
					counter[4] > 2 && number == 5 ||
					counter[5] > 2 && number == 6 ||
					counter[6] > 2 && number == 7 ||
					counter[7] > 2 && number == 8 ||
					counter[8] > 2 && number == 9)
				continue;
			numbers[i] = number;
			i++;
		}
		return numbers;

	}

}
