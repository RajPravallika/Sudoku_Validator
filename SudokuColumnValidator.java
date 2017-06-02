package sudoku;

import java.util.ArrayList;

public class SudokuColumnValidator extends Thread {
	@Override
	public void run() {
		try {
			for (int i = 0; i < 9; i++) {
				validateColumn(i);
			}
		} catch (InterruptedException e) {
			// TODO
		}

	}

	public void validateColumn(int columnNumber) throws InterruptedException {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			if (SudokuValidator.sudoku[i][columnNumber] > 0
					&& SudokuValidator.sudoku[i][columnNumber] <= 9) {
				if (temp.contains(SudokuValidator.sudoku[i][columnNumber])) {
					SudokuValidator.valid = false;
				} else {
					temp.add(SudokuValidator.sudoku[i][columnNumber]);
				}
			} else {
				SudokuValidator.valid = false;
			}
		}

	}

}
