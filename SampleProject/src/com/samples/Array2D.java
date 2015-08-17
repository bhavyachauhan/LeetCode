package com.samples;

public class Array2D {

	public static void main(String[] args) {
		/*
		 * int[][] m = { { 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0
		 * }, { 0, 0, 0, 0, 0 } };//1 print2DArray(m); System.out.println(
		 * "Expected 1, Actual: " + numIslands(m) + "\n"); int[][] m1 = { { 1,
		 * 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 }
		 * };//3 print2DArray(m1); System.out.println("Expected 3, Actual: " +
		 * numIslands(m1));
		 */
//		int[][] matrix = { { 1, 2, 3, 4 }, { 2, 3, 4, 5 }, { 3, 4, 5, 6 }, { 4, 5, 6, 7 } };
//		System.out.println("Before: ");
//		print2DArray(matrix);
//		System.out.println("\n\nAfter: ");
//		rotateMatrix(matrix);

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.println("3  : " + searchMatrix(matrix, 3));
		System.out.println("19 : " + searchMatrix(matrix, 19));
		System.out.println("7  : " + searchMatrix(matrix, 7));
	}

	public static void print2DArray(final int[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				System.out.print(" " + input[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int numIslands(int[][] input) {
		int count = 0;
		if (input == null || input.length == 0 || input[0].length == 0) {
			return count;
		}
		for (int row = 0; row < input.length; row++) {
			for (int col = 0; col < input[0].length; col++) {
				if (input[row][col] == 1) {
					count++;
					mergeIslands(input, row, col);
				}
			}
		}
		return count;
	}

	public static void mergeIslands(int[][] input, int row, int col) {
		if (row < 0 || col < 0 || row > input.length - 1 || col > input[0].length - 1) {
			return;
		}

		if (input[row][col] != 1) {
			return;
		}

		input[row][col] = 0;

		mergeIslands(input, row - 1, col);
		mergeIslands(input, row + 1, col);
		mergeIslands(input, row, col - 1);
		mergeIslands(input, row, col + 1);
	}

	public static void rotateMatrix(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = temp;
			}
		}
		print2DArray(matrix);
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;

		int m = matrix.length;
		int n = matrix[0].length;

		int i = 1;
		int start = 0;
		int end = m * n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int midX = mid / n;
			int midY = mid % n;
			
			System.out.println(i++ + ". mid: " + mid + ", midX: " + midX + ", midY: " + midY);
			
			if (matrix[midX][midY] == target)
				return true;

			if (matrix[midX][midY] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			System.out.println("\tstart: " + start + ", end: " + end);
			
		}

		return false;
	}
}
