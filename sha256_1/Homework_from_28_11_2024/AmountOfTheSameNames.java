package Homework_from_28_11_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class AmountOfTheSameNames {
	
	public static void print(TreeMap<String, Integer> arr) {
		System.out.println(arr);
	}

	public static void main(String[] args) {
		ArrayList<String> cars = new ArrayList<>(List.of("Audi", "Audi", "Audi", "Audi", "BMW", "BMW", "Mercedes", "GAR8S"));
		TreeMap<String, Integer> carsTree = new TreeMap<>();
		
		for(String s: cars) {
			carsTree.put(s, carsTree.getOrDefault(s, 0) + 1);
		}
		
		print(carsTree);
	}

}
