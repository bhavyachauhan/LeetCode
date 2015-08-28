package com.samples;

import java.util.PriorityQueue;

public class HeapSamples {

	public static void main(String[] args) {
		// System.out.println("11: " + nthUglyNumber(11));
		System.out.println("[1,2,2,4,6,7,7,8]: " + returnString(new int[] { 1, 2, 2, 4, 6, 7, 7, 8 }));
		System.out.println("[]: " + returnString(new int[] {}));
		System.out.println("[1,3,9]: " + returnString(new int[] { 1, 3, 9 }));
		System.out.println("[3,4,4,5,6]: " + returnString(new int[] { 3, 4, 4, 5, 6 }));
		System.out.println("[1,2,3,4,5,6]: " + returnString(new int[] { 1, 2, 3, 4, 5, 6 }));
		System.out.println("[1,1,3,3,6,6]: " + returnString(new int[] { 1, 1, 3, 3, 6, 6 }));

	}

	public static int nthUglyNumber(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		PriorityQueue<Long> heap = new PriorityQueue<>();
		heap.offer((long) 1);
		int count = 1;
		long uglyNumber = 0;
		while (count != n + 1) {
			while (heap.peek() == uglyNumber) {
				heap.poll();
			}
			uglyNumber = heap.poll();
			heap.offer(uglyNumber * 2);
			heap.offer(uglyNumber * 3);
			heap.offer(uglyNumber * 5);
			count++;
		}

		int[] arr = new int[4];
		System.out.println(arr.length);
		return (int) uglyNumber;
	}

	public static String returnString(int[] arr) {
		if (arr.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();

		int temp = arr[0];
		boolean range = false;
		for (int i = 0; i < arr.length; i++) {

			if (i == arr.length - 1) {
				if (range) {
					sb.delete(sb.length() - 2, sb.length());
					sb.append("-" + arr[i]);
					return sb.toString();
				} else {
					sb.append(arr[i]);
					return sb.toString();
				}
			}

			if (!range) {
				sb.append(arr[i] + ", ");
				temp = arr[i];
			}
			if (arr[i + 1] == temp + 1) {
				range = true;
			} else if (arr[i + 1] == temp) {
				i++;
			}
			if (range) {
				if (arr[i + 1] != temp + 1) {
					range = false;
					sb.delete(sb.length() - 2, sb.length());
					sb.append("-" + arr[i] + ", ");
				} else {
					temp++;
				}

			}
		}
		return sb.toString();
	}

}
