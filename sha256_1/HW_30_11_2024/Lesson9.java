package HW_30_11_2024;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Lesson9 {
	
	public static HashMap<String, Integer> counter(String txt) {
		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<String> words = new ArrayList<>(Arrays.asList(txt.split(" ")));
		
		for (String word : words) {
		    map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		return map;
	}

	public static void main(String[] args) {
		System.out.print("Input some text: ");
    	
        var scanner = new Scanner(System.in);
        String txt = scanner.nextLine();
        scanner.close();
        
        System.out.println("Sum of digits -> " + counter(txt));
    }

}
