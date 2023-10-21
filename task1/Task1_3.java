package task1;

import java.util.Arrays;

public class Task1_3 {

	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		if( a[0].length != b.length) {
			throw new IllegalArgumentException("Two arrays invalid !");
		}

		int[][] result = new int[a.length][b[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				result[i][j] = 0;
				for (int j2 = 0; j2 < a[0].length; j2++) {
					result[i][j] += a[i][j2] * b[j2][j];
				}
			}

		}
		return result;
	}

	public static void main(String[] args) {
		int[][] arr1 = { { 2, 3, 4 }, { 2, 6, 7 } };
		int[][] arr2 = { { 2, 4 }, { 1, 1 },{2,1}};

		int[][] result = multiply(arr1, arr2);
		for (int i = 0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
}
