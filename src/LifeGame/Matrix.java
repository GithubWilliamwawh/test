package LifeGame;

public class Matrix {
	private int height;
	private int width;
	private int[][] matrix;

	Matrix(int height, int width, int[][] matrix) {
		this.height = height;
		this.width = width;
		this.matrix = matrix;
	}

	public void transform() {
		int[][] nextMatrix = new int[height][width];
		for (int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix[0].length; x++) {
				nextMatrix[y][x] = 0;
				int num = findLifedNum(y, x);
				//if(num>0)System.out.print(num+" ");
				if (num < 2 || num > 3)
					nextMatrix[y][x] = 0;
				else if (num == 2)
					nextMatrix[y][x] = matrix[y][x];
				else if (num == 3)
					nextMatrix[y][x] = 1;
			}
			//System.out.println(" ");
		}
		matrix = nextMatrix;
		
		/*for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println(" ");
		}*/
			
	}

	public int findLifedNum(int y, int x) {
		int num = 0;
		// ×ó±ß
		if (x != 0) {
			num += matrix[y][x - 1];
		}
		// ×óÉÏ½Ç
		if (x != 0 && y != 0) {
			num += matrix[y - 1][x - 1];
		}
		// ÉÏ±ß
		if (y != 0) {
			num += matrix[y - 1][x];
		}
		// ÓÒÉÏ
		if (x != width - 1 && y != 0) {
			num += matrix[y - 1][x + 1];
		}
		// ÓÒ±ß
		if (x != width - 1) {
			num += matrix[y][x + 1];
		}
		// ÓÒÏÂ
		if (x != width - 1 && y != height - 1) {
			num += matrix[y + 1][x + 1];
		}
		// ÏÂ±ß
		if (y != height - 1) {
			num += matrix[y + 1][x];
		}
		// ×óÏÂ
		if (x != 0 && y != height - 1) {
			num += matrix[y + 1][x - 1];
		}
		return num;
		
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int[][] getMatrix() {

		return matrix;
	}

}
