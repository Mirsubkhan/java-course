package Homework_from_28_11_2024;

import java.util.ArrayList;

public class StringToInt {
	public static ArrayList<Integer> toInt(String str) {
		// Ooops, i saw the hint about String.split("") when the method was ready :D
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(Character c: str.toCharArray()) {
			if(Character.isDigit(c)) {
				arr.add(Character.getNumericValue(c));
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = toInt("8 8 8");
		
		// I convert each Integer in the stream to an int. 
		System.out.println("Arr -> " + arr + "\nSum of Values -> " + arr.stream().mapToInt(Integer::intValue).sum());
	}
}
