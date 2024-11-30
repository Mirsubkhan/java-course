package Homework_from_28_11_2024;

import java.util.HashSet;
import java.util.List;

public class UniqueNames {
	public static void print(HashSet<String> arr) {
		System.out.println(arr);
	}
	
	public static void main(String[] args) {
		HashSet<String> cars = new HashSet<>(List.of("Audi", "Audi", "Audi", "Audi", "BMW", "BMW", "Mercedes", "GAR8S"));
		
		print(cars);
	}
}
