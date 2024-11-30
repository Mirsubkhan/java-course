package Homework_from_28_11_2024;

import java.util.LinkedList;

public class StudentsAfterOneYear {
	public static void print(LinkedList<String> arr) {
		System.out.println(arr);
	}
	
	public static LinkedList<String> task() {
		LinkedList<String> arr = new LinkedList<String>();
		
		arr.addFirst("Student 1");
		arr.addFirst("Student 2");
		
		print(arr);
		
		arr.removeFirst();
		
		print(arr);
		
		arr.add(1, "Student 2");
		
		return arr;
	}

	public static void main(String[] args) {
		print(task());
	}
}
