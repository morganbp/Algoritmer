package no.morganbp.oblig1;

public class MatrixMultiply {
	
	public static int[][] squareMatrixMultiplyRecursive(int[][] a, int[][] b) {
		int size = a.length;
		int[][] c = new int[size][size];

		if (size == 1) {
			c[0][0] = a[0][0] * b[0][0];
		} else {
			int[][] a11 = new int[size / 2][size / 2];
			int[][] a12 = new int[size / 2][size / 2];
			int[][] a21 = new int[size / 2][size / 2];
			int[][] a22 = new int[size / 2][size / 2];
			int[][] b11 = new int[size / 2][size / 2];
			int[][] b12 = new int[size / 2][size / 2];
			int[][] b21 = new int[size / 2][size / 2];
			int[][] b22 = new int[size / 2][size / 2];
			for (int i = 0; i < (size / 2); i++) {
				for (int j = 0; j < (size / 2); j++) {
					a11[i][j] = a[i][j];
					a12[i][j] = a[i][j + (size / 2)];
					a21[i][j] = a[i + (size / 2)][j];
					a22[i][j] = a[i + (size / 2)][j + (size / 2)];
					b11[i][j] = b[i][j];
					b12[i][j] = b[i][j + (size / 2)];
					b21[i][j] = b[i + (size / 2)][j];
					b22[i][j] = b[i + (size / 2)][j + (size / 2)];

				}
			}

			int[][] c11 = new int[size / 2][size / 2];
			int[][] c12 = new int[size / 2][size / 2];
			int[][] c21 = new int[size / 2][size / 2];
			int[][] c22 = new int[size / 2][size / 2];	
			c11 = addMatrices(squareMatrixMultiplyRecursive(a11, b11),
					squareMatrixMultiplyRecursive(a12, b21));
			c12 = addMatrices(squareMatrixMultiplyRecursive(a11, b12),
					squareMatrixMultiplyRecursive(a12, b22));
			c21 = addMatrices(squareMatrixMultiplyRecursive(a21, b11),
					squareMatrixMultiplyRecursive(a22, b21));
			c22 = addMatrices(squareMatrixMultiplyRecursive(a21, b12),
					squareMatrixMultiplyRecursive(a22, b22));
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(i < (size/2)){
						if(j < (size/2)){
							c[i][j]=c11[i][j];
						}else{
							c[i][j]=c12[i][j-(size/2)];
						}
					}else{
						if(j < (size/2)){
							c[i][j]=c21[i-(size/2)][j];
						}else{
							c[i][j]=c22[i-(size/2)][j-(size/2)];
						}
						
					}
				}
			}
		}

		
		return c;
	}

	private static int[][] addMatrices(int[][] a, int[][] b) {
		int size = a.length;
		int c[][] = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}

		return c;
	}

}
