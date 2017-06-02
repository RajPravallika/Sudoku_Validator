package sudoku;

import java.util.ArrayList;

/**
 * 
 * @author Ayam
 *
 */
public class SudokuRowValidator extends Thread {
	@Override
	public void run() {
		try {
			for (int i = 0; i < 9; i++) {
				validateRow(i);
			}
		} catch (InterruptedException e) {
			// TODO
		}
	}

	public void validateRow(int rowNumber) throws InterruptedException {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			if (SudokuValidator.sudoku[rowNumber][i] > 0
					&& SudokuValidator.sudoku[rowNumber][i] <= 9) {
				if (temp.contains(SudokuValidator.sudoku[rowNumber][i])) {
					SudokuValidator.valid = false;
				} else {
					temp.add(SudokuValidator.sudoku[rowNumber][i]);
				}
			} else {
				SudokuValidator.valid = false;
				break;
			}

		}
	}

}
