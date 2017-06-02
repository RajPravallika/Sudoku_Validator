package sudoku;

import java.util.ArrayList;

/**
 * 
 * @author Ayam
 *
 */
public class SudokuGridValidator implements Runnable {
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	@Override
	public void run() {
		try {
			validateGrid();
		} catch (InterruptedException e) {
			//TODO
		}

	}

	SudokuGridValidator(int x1, int x2, int y1,
			int y2) {
		this.x1 = x1 - 1;
		this.y1 = x2 - 1;
		this.x2 = y1 - 1;
		this.y2 = y2 - 1;
	}

	public void validateGrid() throws InterruptedException {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				if (SudokuValidator.sudoku[i][j] > 0
						&& SudokuValidator.sudoku[i][j] <= 9) {
					if (!temp.contains(SudokuValidator.sudoku[i][j])) {
						temp.add(SudokuValidator.sudoku[i][j]);
					} else {
						SudokuValidator.valid = false;
					}

				} else {
					SudokuValidator.valid = false;
				}
			}
		}

	}

}
