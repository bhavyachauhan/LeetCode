package com.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArraySamples {

	public static void main(String[] args) {
//		System.out.println(generate(10));
		
//		System.out.println(removeDuplicates(new int[] { 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4 }));

//		int[] input = new int[] { 1, 2, 3, 4, 5, 6 };
//		rotateArray(input, 2);
//		System.out.println("2  : " + Arrays.toString(input));
//		input = new int[] { 1, 2, 3, 4, 5, 6 };
//		rotateArray(input, 201);
//		System.out.println("201: " + Arrays.toString(input));
//		input = new int[] { 1, 2, 3, 4, 5, 6 };
//		rotateArray(input, 0);
//		System.out.println("0  : " + Arrays.toString(input));
//		input = new int[] { 1, 2, 3, 4, 5, 6 };
//		rotateArray(input, 60);
//		System.out.println("60 : " + Arrays.toString(input));

//		System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 3, 4, 5 })));
//		System.out.println(Arrays.toString(plusOne(new int[] { 5, 6, 7, 8, 9 })));
//		System.out.println(Arrays.toString(plusOne(new int[] { 9 })));
//		System.out.println(Arrays.toString(plusOne(new int[] { 0 })));
//		System.out.println(Arrays.toString(plusOne(new int[] { 0, 9 })));
//		System.out.println(Arrays.toString(plusOne(new int[] { 9, 9, 9, 9, 9 })));

//		System.out.println(removeElement(new int[]{1,5,2,5,3,5,4,5}, 5));

//		System.out.println(summaryRanges(new int[]{1, 2, 2, 4, 6, 7, 7, 8}));
//		System.out.println(summaryRanges(new int[]{}));
//		System.out.println(summaryRanges(new int[]{1, 3, 9}));
//		System.out.println(summaryRanges(new int[]{3, 4, 4, 5, 6}));
//		System.out.println(summaryRanges(new int[]{1, 2, 3, 4, 5, 6}));
//		System.out.println(summaryRanges(new int[]{1, 1, 3, 3, 6, 6}));

//		System.out.println(getRow(3));
//		System.out.println(getRow(6));
//		System.out.println(getRow(8));
//		System.out.println(getRow(0));
		
//		int[] arr1 = new int[15];
//		arr1[0] = 2;
//		arr1[1] = 4;
//		arr1[2] = 7;
//		arr1[3] = 10;
//		arr1[4] = 11;
//		arr1[5] = 12;		
//		int[] arr2 = new int[]{1,3,5,6,8,9};
//		System.out.println(Arrays.toString(arr1));
//		System.out.println(Arrays.toString(arr2));
//		merge(arr1, 6, arr2, arr2.length);
		
//		System.out.println(containsNearbyDuplicate(new int[]{1,2,3,4,1,5,6,7,8}, 5));
//		System.out.println(containsNearbyDuplicate(new int[]{1,2,3,4,1,5,6,7,8}, 2));
		
		System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
		System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 18)));
		System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 17)));
		System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 22)));
		System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 13)));
	}
	
	//Pascal's Triangle
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

	public boolean containsDuplicate(int[] nums) {
		if (nums.length == 0) {
			return false;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!set.add(nums[i])) {
				return true;
			}
		}
		return false;
	}

	public static int[] plusOne(int[] digits) {
		if (digits.length == 0) {
			return digits;
		}

		int length = digits.length;
		int lastDigit = digits[length - 1];

		if (lastDigit + 1 < 10) {
			digits[length - 1] = lastDigit + 1;
			return digits;
		}
		if (length == 1) {
			int[] newArr = new int[length + 1];
			newArr[0] = 1;
			newArr[1] = 0;
			return newArr;
		}
		boolean flag = false;
		int remainder = 0;
		for (int i = length - 1; i >= 0; i--) {
			if (i == 0 && digits[i] == 9) {
				flag = true;
				digits[i] = 0;
			} else {
				if (i == length - 1) {
					digits[i] = 0;
					remainder = 1;
				} else {
					int sum = digits[i] + remainder;
					digits[i] = sum % 10;
					remainder = sum / 10;
				}
			}
		}

		if (flag) {
			int[] newArr = new int[length + 1];
			newArr[0] = 1;
			for (int i = 0; i < length; i++) {
				newArr[i + 1] = digits[i];
			}
			return newArr;
		}
		return digits;
	}
	
    public static int removeElement(int[] nums, int val) {
    	int i = 0; 
    	int j = 0;
    	
    	while(j < nums.length){
    		if(nums[j] != val){
    			nums[i] = nums[j];
    			i++;
    		}
    		j++;
    	}
    	System.out.println(Arrays.toString(nums));
    	return i;
    }

    public static List<String> summaryRanges(int[] nums){
    	List<String> result = new ArrayList<String>();
		if (nums.length == 0) {
			return result;
		}

		StringBuilder sb = new StringBuilder();
		int temp = nums[0];
		boolean range = false;
		for (int i = 0; i < nums.length; i++) {
			//Check last element
			if (i == nums.length - 1) {
				if (range) { //If last element is part of a range
					sb.delete(sb.length() - 1, sb.length());
					sb.append("-" + nums[i]);
					return Arrays.asList(sb.toString().split(","));
				} else {
					sb.append(nums[i]);
					return Arrays.asList(sb.toString().split(","));
				}
			}
			
			if (!range) {
				sb.append(nums[i] + ",");
				temp = nums[i];
			}
			if (nums[i + 1] == temp + 1) {
				range = true;
			} else if (nums[i + 1] == temp) { //Handle duplicates
				i++;
			}
			if (range) { //End of Range
				if (nums[i + 1] != temp + 1) {
					range = false;
					sb.delete(sb.length() - 1, sb.length());
					sb.append("-" + nums[i] + ",");
				} else {
					temp++;
				}
			}
		}
		return Arrays.asList(sb.toString().split(","));
	}
    
    public static List<Integer> getRow(int rowIndex){
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	 
    	if (rowIndex < 0)
    		return result;
     
    	result.add(1);
    	
    	for (int i = 1; i <= rowIndex; i++) {
    		for (int j = result.size() - 2; j >= 0; j--) {
    			result.set(j + 1, result.get(j) + result.get(j + 1));
    		}
    		result.add(1);
    	}
    	
    	return result;
    }
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while(k >= 0){
        	if(j < 0 || (i >= 0 && nums1[i] > nums2[j])){
        		nums1[k--] = nums1[i--]; 
        	} else {
        		nums1[k--] = nums2[j--];
        	}
        }
        System.out.println(Arrays.toString(nums1));
    }
    
    public static int majorityElement(int[] nums) {
//    	if(nums.length == 0){
//    		throw new IllegalArgumentException("Array is Empty");
//    	}
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for(int i = 0; i < nums.length; i++){
//        	int count = 0;
//        	if(map.containsKey(nums[i])){
//        		count = map.get(nums[i]);
//        	} 
//        	map.put(nums[i], ++count);
//        }
//        int prevVal = 0;
//        int majorityElement = 0;
//        for(int key : map.keySet()){
//            System.out.println("Key: " + key + ", val: " + map.get(key));
//        	if(map.get(key) > prevVal){
//        	    prevVal = map.get(key);
//        		majorityElement = key;
//        	}
//        }
//        return majorityElement;   
    	if(nums.length == 0){
    		throw new IllegalArgumentException("Array is Empty");
    	}
    	if (nums.length == 1) {
    		return nums[0];
    	}
    	Arrays.sort(nums);
    	return nums[nums.length/2];
    }
    
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0;i < nums.length; i++){
			if(map.containsKey(nums[i])){
				int prevIndex = map.get(nums[i]);
				if(i - prevIndex <= k){
					return true;
				}
			}
			map.put(nums[i], i);
		}
		return false;
	}
	
    public static int[] twoSum(int[] nums, int target) {
    	int[] result = new int[2];
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i < nums.length; i++){
    		if(map.containsKey(target - nums[i])){
    			result[0] = map.get(target - nums[i]) + 1;
    			result[1] = i + 1;
    			break;
    		}
    		map.put(nums[i], i);
    	}    	
    	return result;
    }

}
