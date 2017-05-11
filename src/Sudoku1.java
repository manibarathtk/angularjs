import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


 public class Sudoku1 {
	
	public static int squareN = 0;
	public static int smallSquareN = 0;
	public static boolean allZero= false;
	public static int zeroCount = 0;
	public static boolean firstCell = false;
	public static int firstCount = 0;
	public static boolean startFirst = false;
		
	public static int SolveMagicSquare(int[][]  matrix) {		
		
		squareN = matrix.length;
		smallSquareN = (int) Math.ceil(Math.sqrt(squareN));
		//System.out.println(squareN + " - " + smallSquareN);
		if(smallSquareN == 1){return 0;}
		if(checkValues(matrix,0,squareN)){
			if(allZero){
				return 1;
			}
		if (matrix[0][0] == 1) {
			firstCell = true;
			if(squareN*squareN - zeroCount == 1){
				return 1;
			}
			if (solve(0, 0, matrix)){
				System.out.println(" --- solve 1--- ");
				writeMatrix(matrix);
				if(checkMagicSudoku(matrix)){
					System.out.println(" --- solve checkMagicSudoku 2--- ");
					writeMatrix(matrix);
					return 1;
				}else{
					System.out.println(" --- solve checkMagicSudoku 3--- ");
					writeMatrix(matrix);
					return 0;
				}
				}
			else
				return 0;
		} else {
			if (solve(0, 0, matrix)){
				System.out.println(" --- solve 4--- ");
				writeMatrix(matrix);
				if(matrix[0][0] == 1 && checkMagicSudoku(matrix)){
					System.out.println(" --- solve checkMagicSudoku 5--- ");
					writeMatrix(matrix);
					return 1;
				}else{
					System.out.println(" --- solve checkMagicSudoku 6--- ");
					writeMatrix(matrix);
					return 0;
				}
			}
			else
				return 0;
		}
		}else{
			return 0;
		}
		
	}

	static boolean solve(int i, int j, int[][] cells) throws Exception {
		if (i == squareN) {
			i = 0;
			if (++j == squareN)
				return true;
		}
		if (cells[i][j] != 0)
			return solve(i + 1, j, cells);

		for (int val = 1; val <= squareN; ++val) {
			if (legal(i, j, val, cells)) {
				cells[i][j] = val;
				if (solve(i + 1, j, cells))
					return true;
			}
			if(i == 0 && j == 0 && val != 1){
				throw new Exception("Invaild 1");
			}
		}		
		cells[i][j] = 0;		
		return false;
	}

	static boolean legal(int i, int j, int val, int[][] cells) {
		for (int k = 0; k < squareN; ++k)
			if (val == cells[k][j])
				return false;

		for (int k = 0; k < squareN; ++k)
			if (val == cells[i][k])
				return false;

		int boxRowOffset = (i / smallSquareN) * smallSquareN;
		int boxColOffset = (j / smallSquareN) * smallSquareN;
		for (int k = 0; k < smallSquareN; ++k)
			for (int m = 0; m < smallSquareN; ++m)
				if (val == cells[boxRowOffset + k][boxColOffset + m])
					return false;

		return true;
	}

	public static boolean checkMagicSudoku(int[][] cells) {
		for (int baseRow = 0; baseRow < squareN; baseRow += smallSquareN) {
			for (int baseCol = 0; baseCol < squareN; baseCol += smallSquareN) {
				boolean checkRow = false;
				if (baseCol + smallSquareN < squareN) {
					int[][] grid = new int[squareN][squareN]; 
					//writeMatrix(grid);
					grid =	(int[][]) Arrays.stream(cells).map(i -> i.clone()).toArray($ -> cells.clone());//cells.clone();
					System.out.println(" --- checkMagicSudoku 4 grid before swapRight--- ");
					writeMatrix(grid);
					swapRight(grid, baseRow, baseCol);
					System.out.println(" --- checkMagicSudoku 4 grid after swapRight--- ");
					writeMatrix(grid);
					if (checkSudoku(grid)) {
						checkRow = true;
					}
				}else{
					return false;
				}
				if (checkRow && baseRow + smallSquareN < squareN) {
					int[][] grid = new int[squareN][squareN]; 
					//writeMatrix(grid);
					grid =	(int[][]) Arrays.stream(cells).map(i -> i.clone()).toArray($ -> cells.clone());//cells.clone();	
					System.out.println(" --- checkMagicSudoku 4 grid before swapdown--- ");
					writeMatrix(grid);
					swapdown(grid, baseRow, baseCol);
					System.out.println(" --- checkMagicSudoku 4 grid after swapdown--- ");
					writeMatrix(grid);
					if (checkSudoku(grid)) {
						return true;
					}
				}else{
					return false;
				}
			}
		}
		return false;
	}

	private static void swapRight(int[][] cells, int baseRow, int baseCol) {
		for (int row = baseRow; row < (baseRow + smallSquareN); ++row) {
			for (int col = baseCol; col < (baseCol + smallSquareN); ++col) {
				int temp = cells[row][col];
				cells[row][col] = cells[row][col + smallSquareN];
				cells[row][col + smallSquareN] = temp;
			}
		}

	}

	private static void swapdown(int[][] cells, int baseRow, int baseCol) {
		for (int row = baseRow; row < (baseRow + smallSquareN); ++row) {
			for (int col = baseCol; col < (baseCol + smallSquareN); ++col) {
				int temp = cells[row][col];
				cells[row][col] = cells[row + smallSquareN][col];
				cells[row + smallSquareN][col] = temp;
			}
		}

	}

	public static boolean checkSudoku(int[][] grid) {
		final int size = grid.length;

		for (int col = 0; col < size; ++col) {
			if (!checkColumn(grid, col)) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkValues(int[][] cells, int min, int max) {
		
		for (int row = 0; row < cells.length; ++row) {
			for (int col = 0; col < cells[0].length; ++col) {
				if (cells[row][col] < min || cells[row][col] > max) {
					return false;
				}
				if(cells[row][col] == 0){
					zeroCount ++;
				}
			}
		}
		if(zeroCount == squareN*squareN){
			allZero = true;
		}
		return true;
	}

	private static boolean checkColumn(int[][] cells, int whichCol) {
		final int size = cells.length;
		boolean[] found = new boolean[size];
		for (int row = 0; row < size; ++row) {

			int index = cells[row][whichCol] - 1;
			if (!found[index]) {
				found[index] = true;
			} else {

				return false;
			}
		}

		return true;
	}

	static void writeMatrix(int[][] solution) {
		for (int i = 0; i < squareN; ++i) {
			if (i % smallSquareN == 0)
				System.out.println(" -----------------------");
			for (int j = 0; j < squareN; ++j) {
				if (j % smallSquareN == 0)
					System.out.print("| ");
				System.out.print(solution[i][j] == 0 ? " " : Integer.toString(solution[i][j]));

				System.out.print(' ');
			}
			System.out.println("|");
		}
		System.out.println(" -----------------------");
	}
	
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int output = 0;
        int ip1_rows = 0;
        int ip1_cols = 0;
        ip1_rows = Integer.parseInt(in.nextLine().trim());
        ip1_cols = Integer.parseInt(in.nextLine().trim());
        
        int[][] ip1 = new int[ip1_rows][ip1_cols];
        for(int ip1_i=0; ip1_i<ip1_rows; ip1_i++) {
            for(int ip1_j=0; ip1_j<ip1_cols; ip1_j++) {
                ip1[ip1_i][ip1_j] = in.nextInt();
                
            }
        }
        output = SolveMagicSquare(ip1);
        System.out.println(String.valueOf(output));
    }

}