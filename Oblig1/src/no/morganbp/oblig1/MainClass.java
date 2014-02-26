package no.morganbp.oblig1;

public class MainClass {

	public static void main(String[] args) {
		int size = 16;
		int[][] a = new int[size/2][size/2];
		int[][] b = new int[size/2][size/2];
		for(int i = 0; i < size/2; i++){
			for(int j = 0; j < size/2; j++){
				a[i][j] = (int)(Math.random()*5)+1;
				b[i][j] = (int)(Math.random()*5)+1;
				System.out.println(" a: " + a[i][j] + " b: " + b[i][j]);
			}
		}
		
		int[][] c = MatrixMultiply.squareMatrixMultiplyRecursive(a, b);
		System.out.println();
		for(int i = 0; i < a.length;i++){
			for(int j = 0; j < a.length;j++){
				System.out.print(c[i][j] + " ");
			}
		}
	}

}