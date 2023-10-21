package task1;

import java.util.Arrays;

public class Task1_1 {

	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		if (a.length != b.length || a[0].length != b[0].length) {
			throw new IllegalArgumentException("Two arrays invalid !");
		}

		int[][] result = new int[a.length][a[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] arr1 = { { 7, 2 }, { 5, 3 } };
		int[][] arr2 = { { 2, 1 },{3,1}};

		int[][] result = add(arr1, arr2);

			for (int i = 0; i < result.length; i++) {
				System.out.println(Arrays.toString(result[i]));
			}
		}

	}

