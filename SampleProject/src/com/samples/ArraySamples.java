package com.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySamples {

	public static void main(String[] args) {
		// System.out.println(generate(5));
		// System.out.println(removeDuplicates(new int[]
		// {1,1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4}));
/*		int[] input = new int[] { 1, 2, 3, 4, 5, 6 };
		rotateArray(input, 2);
		System.out.println("2  : " + Arrays.toString(input));
		input = new int[] { 1, 2, 3, 4, 5, 6 };
		rotateArray(input, 201);
		System.out.println("201: " + Arrays.toString(input));
		input = new int[] { 1, 2, 3, 4, 5, 6 };
		rotateArray(input, 0);
		System.out.println("0  : " + Arrays.toString(input));
		input = new int[] { 1, 2, 3, 4, 5, 6 };
		rotateArray(input, 60);
		System.out.println("60 : " + Arrays.toString(input));
*/	
		
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows <= 0) {
			return result;
		}

		List<Integer> prevRow = new ArrayList<Integer>();
		prevRow.add(1);
		result.add(prevRow);

		for (int i = 2; i <= numRows; i++) {
			List<Integer> currRow = new ArrayList<Integer>();
			currRow.add(1); // first 1
			// sum up and add middle elements to current list from prev list
			for (int j = 0; j < prevRow.size() - 1; j++) {
				currRow.add(prevRow.get(j) + prevRow.get(j + 1));
			}
			currRow.add(1);// last 1;

			result.add(currRow);
			prevRow = currRow;
		}
		return result;
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}

		int i = 1;
		int j = 0;
		while (i < nums.length) {
			if (nums[i] == nums[j]) {
				i++;
			} else {
				j++;
				nums[j] = nums[i];
				i++;
			}
		}

		System.out.println(Arrays.toString(nums));
		return j + 1;
	}

	public static void rotateArray(int[] input, int rotation) {
		rotation = rotation % input.length;
		System.out.println(rotation);
		if (input == null || rotation < 0) {
			throw new IllegalArgumentException("Input is null");
		}
		if (rotation == 0) {
			return;
		}

		int tempLength = input.length - rotation;
		reverseArray(input, 0, tempLength - 1);
		reverseArray(input, tempLength, input.length - 1);
		reverseArray(input, 0, input.length - 1);
	}

	public static void reverseArray(int[] input, int start, int end) {
		if (input == null || input.length == 1) {
			return;
		}

		while (start < end) {
			int temp = input[start];
			input[start] = input[end];
			input[end] = temp;
			start++;
			end--;
		}
		return;
	}
}
