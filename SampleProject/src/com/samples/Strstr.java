package com.samples;

public class Strstr {

	public static void main(String[] args) {
		System.out.println(findFirstOccurance("aaaaaaaaab", "aaaaaab"));

	}
	
	public static int findFirstOccurance(final String input, final String keyword){
		  
		for(int i=0; i<input.length(); i++){
	        if(i + keyword.length() > input.length())
	            return -1;
	 
	        int m = i;
	        for(int j=0; j<keyword.length(); j++){
	            if(keyword.charAt(j)==input.charAt(m)){
	                if(j==keyword.length()-1)
	                    return i;
	                m++;
	            }else{
	                break;
	            }
	 
	        }   
		}
		return -1;
	}
	
}
