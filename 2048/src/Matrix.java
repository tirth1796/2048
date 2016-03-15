import java.util.Random;

public class Matrix {
	private boolean temp = false;
	private Random r = new Random();
	private int n;
	private int[][] grid;

	public int[][] getGrid() {
		return this.grid;
	}

	public Matrix(int n) {
		this.n = n;
		grid = new int[n][n];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = 0;
			}
		}
		generateRandom();
	}

	public void left() {
		// nullify 0s
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length - 1; j++) {
				if (grid[i][j] == 0) {
					for (int j2 = j; j2 < grid.length; j2++) {
						if (grid[i][j2] != 0) {
							temp = true;
							grid[i][j] = grid[i][j2];
							grid[i][j2] = 0;
							break;
						}
					}
				}
			}
		}

		// for each row scan column n the next from left to right
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length - 1; j++) {
				if (grid[i][j] == grid[i][j + 1] && grid[i][j] != 0) {
					temp = true;
					grid[i][j] *= 2;
					for (int j2 = j + 1; j2 < grid.length - 1; j2++) {
						grid[i][j2] = grid[i][j2 + 1];
					}
					grid[i][n - 1] = 0;
				}
			}
		}
		if (temp)
			generateRandom();

	}

	public void right() {

		// nullify 0s
		for (int i = 0; i < grid.length; i++) {
			for (int j = grid.length - 1; j > 0; j--) {
				if (grid[i][j] == 0) {
					for (int j2 = j - 1; j2 >= 0; j2--) {
						if (grid[i][j2] != 0) {
							temp = true;
							grid[i][j] = grid[i][j2];
							grid[i][j2] = 0;
							break;

						}
					}
				}
			}
		}

		// for each column scan row and the previous from right to left
		for (int i = 0; i < grid.length; i++) {
			for (int j = grid.length - 1; j > 0; j--) {
				if (grid[i][j] == grid[i][j - 1] && grid[i][j] != 0) {
					temp = true;
					grid[i][j] *= 2;
					for (int j2 = j - 1; j2 > 0; j2--) {
						grid[i][j2] = grid[i][j2 - 1];
					}
					grid[i][0] = 0;
				}
			}
		}
		if (temp)
			generateRandom();

	}

	public void up() {
		// nullify 0s
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length - 1; j++) {
				if (grid[j][i] == 0) {
					for (int j2 = j; j2 < grid.length; j2++) {
						if (grid[j2][i] != 0) {
							temp = true;
							grid[j][i] = grid[j2][i];
							grid[j2][i] = 0;
							break;
						}
					}
				}
			}
		}
		// for each column scan row and the next from top to bottom
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length - 1; j++) {
				if (grid[j][i] == grid[j + 1][i] && grid[j][i] != 0) {
					temp = true;
					grid[j][i] *= 2;
					for (int j2 = j + 1; j2 < grid.length - 1; j2++) {
						grid[j2][i] = grid[j2 + 1][i];
					}
					grid[n - 1][i] = 0;

				}
			}
		}
		if (temp)
			generateRandom();

	}

	public void down() {

		// nullify 0s
		for (int i = 0; i < grid.length; i++) {
			for (int j = grid.length - 1; j > 0; j--) {
				if (grid[j][i] == 0) {
					for (int j2 = j - 1; j2 >= 0; j2--) {
						if (grid[j2][i] != 0) {
							temp = true;
							grid[j][i] = grid[j2][i];
							grid[j2][i] = 0;
							break;
						}
					}

				}
			}
		}
		// for each column scan row and the previous from bottom to top
		for (int i = 0; i < grid.length; i++) {
			for (int j = grid.length - 1; j > 0; j--) {
				if (grid[j][i] == grid[j - 1][i] && grid[j][i] != 0) {
					temp = true;
					grid[j][i] *= 2;
					for (int j2 = j - 1; j2 > 0; j2--) {
						grid[j2][i] = grid[j2 - 1][i];
					}
					grid[0][i] = 0;

				}
			}
		}
		if (temp == true) {
			generateRandom();
		}

	}

	public int generateRandom() {
		int[] positionsLeft = new int[n * n];
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == 0) {
					positionsLeft[count] = n * i + j;
					count++;
				}
			}
		}
		int pos = positionsLeft[r.nextInt(count)];
		this.grid[pos / n][pos % n] = (r.nextInt(13) / 12) * 2 + 2;
		displayMatrix();
		return pos;

	}

	private void displayMatrix() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		temp = false;
	}
}
