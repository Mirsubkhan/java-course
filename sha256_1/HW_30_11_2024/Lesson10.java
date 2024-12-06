package HW_30_11_2024;

import java.util.Scanner;
import java.util.HashMap;

public class Lesson10 {

	public static void main(String[] args) {
		// I know i could use <String, String>, but I wasn't part of this idea.
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "_");
		map.put(2, "G");
		map.put(3, "A");
		map.put(4, "R");
		map.put(5, "8");
		map.put(6, "S");
		map.put(7, "_");
		map.put(8, "8");
		map.put(9, "_");
		
		var scanner = new Scanner(System.in);
		
		System.out.println("Input card from 1-9 (e.g 5 8)");
		int k1 = scanner.nextInt();
		int k2 = scanner.nextInt();
		scanner.close();
		
		var c1 = map.getOrDefault(k1, "error");
		var c2 = map.getOrDefault(k2, "error");
		
		if (c1 != "error" && c2 != "error") {
			String result = c1 == c2? (k1 + " " + k2 + " are match -> " + c1): (k1 + " " + k2 + " aren't match -> " + c1 + ", " + c2);
					
			System.out.print(result);
			return;
		}
		
		System.out.print("🤨");
	}

}
