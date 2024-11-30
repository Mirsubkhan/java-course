package Homework_from_28_11_2024;

import java.util.ArrayList;

public class Students {
	
	public static void print(ArrayList<String> arr) {
		System.out.println(arr);
	}

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		
		arr.add("Dasha");
		arr.add("Mirshubkhan");
		arr.add("Kamilla");
		arr.add("Liya");
		arr.add("Vadim");
		arr.add("Danil");
		
		print(arr);
		
		System.out.println(arr.get(1));
		arr.remove("Kamilla");
		
		print(arr);
	}

}
