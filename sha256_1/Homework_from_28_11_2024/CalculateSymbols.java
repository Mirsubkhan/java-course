package Homework_from_28_11_2024;

public class CalculateSymbols {

	public static void calculate(String str) {
		int chars = 0;
		int nums = 0;
		int spaces = 0;
		
		for(Character c: str.toCharArray()) {
			if(Character.isDigit(c)) {
				nums++;
			}
			else if(Character.isSpaceChar(c)) {
				spaces++;
			}
			else {
				chars++;
			}
		}
		
		System.out.println("Number of:\nChars -> " + chars + "\nNums -> " + nums + "\nSpaces -> " + spaces);
	}
	
	public static void main(String[] args) {
		calculate("_ G A R 8 S _");
	}

}
