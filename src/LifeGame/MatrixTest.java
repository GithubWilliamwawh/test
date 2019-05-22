package LifeGame;

import static org.junit.jupiter.api.Assertions.*;
import LifeGame.Init;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatrixTest {
	private static int  height=3;
	private static int  width=3;
	int [][]array= {{1,0,1},{1,0,0},{1,1,1}};
	
	private Matrix matrix1=new Matrix(height, width, array);
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testMatrix() {
		for (int y = 0; y < matrix1.getMatrix().length; y++) {
			for (int x = 0; x < matrix1.getMatrix()[0].length; x++) {
				System.out.print(matrix1.getMatrix()[y][x]+" ");
			}
			System.out.println("");
		}
		System.out.println(" ");
	}

	@Test
	void testTransform() {
		int[][] nextMatrix = new int[height][width];
		for (int y = 0; y < matrix1.getMatrix().length; y++) {
			for (int x = 0; x < matrix1.getMatrix()[0].length; x++) {
				nextMatrix[y][x] = 0;
				int num = 2;  //��������2��3��1
				//if(num>0)System.out.print(num+" ");
				if (num < 2 || num > 3)
					nextMatrix[y][x] = 0;
				else if (num == 2)
					nextMatrix[y][x] = matrix1.getMatrix()[y][x];
				else if (num == 3)
					nextMatrix[y][x] = 1;
				System.out.print(nextMatrix[y][x]+" ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}

	@Test
	void testFindLifedNum() {
		int num = 0;
		int y=1;
		int x=1;
		// ���
		if (x != 0) {
			num += matrix1.getMatrix()[y][x - 1];
		}
		// ���Ͻ�
		if (x != 0 && y != 0) {
			num += matrix1.getMatrix()[y - 1][x - 1];
		}
		// �ϱ�
		if (y != 0) {
			num += matrix1.getMatrix()[y - 1][x];
		}
		// ����
		if (x != width - 1 && y != 0) {
			num += matrix1.getMatrix()[y - 1][x + 1];
		}
		// �ұ�
		if (x != width - 1) {
			num += matrix1.getMatrix()[y][x + 1];
		}
		// ����
		if (x != width - 1 && y != height - 1) {
			num += matrix1.getMatrix()[y + 1][x + 1];
		}
		// �±�
		if (y != height - 1) {
			num += matrix1.getMatrix()[y + 1][x];
		}
		// ����
		if (x != 0 && y != height - 1) {
			num += matrix1.getMatrix()[y + 1][x - 1];
		}
		System.out.println(num);
	}

}
