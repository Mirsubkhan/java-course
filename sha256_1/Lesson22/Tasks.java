package Lesson22;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Tasks {

	public static void main(String[] args) {
		// Task 1
		System.out.println("Task 1");
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		nums = nums.stream().
				filter(num -> num % 2 == 0).
				collect(Collectors.toList());
		
		System.out.println("Amount of even nums: " + nums.size() + "\n" + nums);
		
		// Task 2
		System.out.println("Task 2");
		List<Integer> nums2 = Arrays.asList(1, 2, 14, 40, 40, 2, 14, 9, 0);
		
		
		List<Integer> moreThan10 = nums2.stream().
				filter(num -> num > 10).
				toList();
		System.out.println("Amount of nums that are more than 10: " + moreThan10.size() + "\n" + moreThan10);
		
		String uniqueNums = moreThan10.stream()
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining("$ "));
		System.out.println("Unique nums: " + uniqueNums + "$");
	}

}
