package task1;

import java.util.Arrays;

public class Task1_4 {

	// tranpose a matrix
	public static int[][] transpose(int[][] a){
		int[][] arrTranspose= new int[a[0].length][a.length];
		
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				arrTranspose[i][j]= a[j][i];
			}
		}
		
		return arrTranspose;
	}
	
	public static void main(String[] args) {
		int[][] arr1= {{1,2},{3,4},{5,6}};
		int[][] arr2= {{1,3,5},{2,4,6}};
		
		int[][] result1=transpose(arr1);
		int[][] result2=transpose(arr2);
		
        for (int i = 0; i < result1.length; i++) {
			System.out.println(Arrays.toString(result1[i]));
		}
        
        System.out.println("================================");
        
        for (int i = 0; i < result2.length; i++) {
        	System.out.println(Arrays.toString(result2[i]));
        }
        
        
	}
}
