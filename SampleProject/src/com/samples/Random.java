package com.samples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Random {
	public static void main(String[] args) {
		
//		"bbaabbbabbbbabbbaaabababbbabbababbbabaaabbbbaabaabaaaa", "*b**b*a**abbaab*aba***"
		/*System.out.println("isMatch(bbaabbbabbbbabbbaaabababbbabbababbbabaaabbbbaabaabaaaa, *b**b*a**abbaab*aba***): " + isMatch("bbaabbbabbbbabbbaaabababbbabbababbbabaaabbbbaabaabaaaa", "*b**b*a**abbaab*aba***"));
		System.out.println("isMatch(a, aa): " + isMatch("a","aa") );
		System.out.println("isMatch(aa, a): " + isMatch("aa","a") );
		System.out.println("isMatch(aa, aa): " + isMatch("aa","aa") );
		System.out.println("isMatch(aaa, aa): " + isMatch("aaa","aa") );
		System.out.println("isMatch(aa, *): " + isMatch("aa", "*") ); 
		System.out.println("isMatch(aa, a*): " + isMatch("aa", "a*") );
		System.out.println("isMatch(aa, ?*): " + isMatch("ab", "?*") );
		System.out.println("isMatch(aab, c*a*b): " + isMatch("aab", "c*a*b") ); */
		
//		BigInteger bi1 = new BigInteger("152");
//		BigInteger bi2 = new BigInteger("21");
//		System.out.println("Sum: " + add(bi1, bi2));
		
		System.out.println(Arrays.toString(readFile("C:/Users/Bhavya/Desktop/New Text Document.txt")));
	}
	
	public static boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		
		//Base case for recursion when
		//first char is not '*' or '?' or doesn't match the first char in pattern
		if (p.charAt(0) != '*') {
			if (s.isEmpty()) {
				return false;
			}
			if (p.charAt(0) != '?' && p.charAt(0) != s.charAt(0)) {
				return false;
			}
			return isMatch(s.substring(1), p.substring(1));
		}

		while (p.length() > 1 && p.charAt(1) == '*') {
			p = p.substring(1);
		}
		for (int i = 0; i <= s.length(); i++) {
			if (isMatch(s.substring(0), p.substring(1))) {
				return true;
			}
		}

		return false;
	}

/*	public static boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		
		if (p.charAt(0) != '*') {
			if (s.isEmpty()) {
				return false;
			}
			if (p.charAt(0) != '?' && p.charAt(0) != s.charAt(0)) {
				return false;
			}
			return isMatch(s.substring(1), p.substring(1));
		}

		while (p.length() > 1 && p.charAt(1) == '*') {
			p = p.substring(1);
		}
		
		for (int i = 0; i <= s.length(); i++) {
			if (isMatch(s.substring(0), p.substring(1))) {
				return true;
			}
		}
		return false;
	}*/
	
	public static BigInteger add(final BigInteger bi1, final BigInteger bi2){
		System.out.println("bi1:" + bi1);
		System.out.println("bi2:" + bi2);
		System.out.println(bi1.add(bi2));
		byte[] b1, b2, result;
		if(bi1.toByteArray().length > bi2.toByteArray().length){
			b1 = bi1.toByteArray();
			b2 = bi2.toByteArray();	
		} else {
			b2 = bi1.toByteArray();
			b1 = bi2.toByteArray();
		}
		
		int remainder = 0;
		int l1 = b1.length;
		int l2 = b2.length;
		result = new byte[l1 + 1];
		for(int i = 0; i < l1; i++){
			int d1 = b1[i];
			int d2 = i >= l2 ? 0 : b2[i]; 
			int sum = d1 + d2 + remainder;
			remainder = sum > 9 ? 1 : 0;
			result[i] = (byte)(sum %10);
		}
		result[l1] = (byte)(remainder); 
		System.out.println("bi1: " + Arrays.toString(b1));
		System.out.println("bi2: " + Arrays.toString(b2));
		System.out.println("result: " + Arrays.toString(result));
		return new BigInteger(result);
	}
	
	public static String[] readFile(String filepath){
		final File file = new File(filepath);
		final List<String> result = new ArrayList<String>();
		try{
			FileInputStream inputStream = new FileInputStream(filepath);
			byte[] buffer = new byte[(int)file.length()];
			int total = 0;
			int read = 0;
			while((read = inputStream.read(buffer)) != -1){
				result.add(new String(buffer));
				total += read;
			}
			inputStream.close();
			
		} catch(FileNotFoundException e){
			System.out.println("Cannot find the file: " + filepath);
		} catch(IOException e){
			System.out.println("Error reading file: " + filepath);
		}
		return (String[])result.toArray();
	}
	
	/*
	 * // A stream of numbers. Write a method to return the medium you have recieved

//3, 1, 9, 7, 5, ...

public class RunningMedian(){

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public RunningMedian(){
        maxHeap = new PriorityQueue<Integer>(10, 
            new Comparator<Integer>(){
                
                @Override
                public int compare(){
                    
                }

            });
        minHeap = new PriorityQueue<Integer>();
 
    }

    public void addNumber(int num) {
        if(num >= minHeap.peek()){
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
  
        if(minHeap.size() - maxHeap.size() == 2){
            maxHeap.add(minHeap.poll());
        } else if(maxHeap.size() - minHeap.size() == 2){
            minHeap.add(maxHeap.poll);
        }
    }
    
    public int findMedian(){
        
        if(minHeap.size() == maxHeap.size()){
            return ((minHeap.peek() + maxHeap.peek())/2.0)
        } else if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }

}
	 */
	
}
