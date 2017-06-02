package sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 
 * @author Ayam
 * 
 */
public class SudokuValidator {
	public static int[][] sudoku = new int[9][9];
	public static boolean valid = true;

	public static void main(String[] args) {
		try {
			String filePath = "F:/Study Matters/LSU/1-2/OS/prog1/sudoku.txt";
			File file = new File(filePath);
			FileReader f = new FileReader(file);
			BufferedReader br = new BufferedReader(f);
			int row = 0;
			String line;
			while ((line = br.readLine()) != null) {
				String[] st = line.split("\\s");
				for (int i = 0; i < st.length; i++) {
					SudokuValidator.sudoku[row][i] = Integer.parseInt(st[i]);
				}
				row++;
			}

			br.close();

			Thread rowThread = new Thread(new SudokuRowValidator());
			Thread columnThread = new Thread(new SudokuColumnValidator());
			Thread gridOne = new Thread(new SudokuGridValidator(1, 1, 3, 3));
			Thread gridTwo = new Thread(new SudokuGridValidator(1, 4, 3, 6));
			Thread gridThree = new Thread(new SudokuGridValidator(1, 7, 3, 9));
			Thread gridFour = new Thread(new SudokuGridValidator(4, 1, 6, 3));
			Thread gridFive = new Thread(new SudokuGridValidator(4, 4, 6, 6));
			Thread gridSix = new Thread(new SudokuGridValidator(4, 7, 6, 9));
			Thread gridSeven = new Thread(new SudokuGridValidator(7, 1, 9, 3));
			Thread gridEight = new Thread(new SudokuGridValidator(7, 4, 9, 6));
			Thread gridNine = new Thread(new SudokuGridValidator(7, 7, 9, 9));

			columnThread.start();
			rowThread.start();
			gridOne.start();
			gridTwo.start();
			gridThree.start();
			gridFour.start();
			gridFive.start();
			gridSix.start();
			gridSeven.start();
			gridEight.start();
			gridNine.start();

			Thread.sleep(3000);

			if (valid) {
				System.out.printf("The given sudoku solution is valid.%n");
			} else {
				System.out.printf("The given sudoku solution is NOT valid.%n");
			}
		} catch (Exception e) {
			//TODO
		}

	}
}