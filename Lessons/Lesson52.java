package Lessons;

import java.util.Arrays;
import java.util.HashSet;

public class Lesson52 {
	
	// This method accepts an array, not a collection as you said :)
	public static void getTwoMaxValues(int[] arr){
		if (isUnique(arr)) {
			int max = Integer.MIN_VALUE;
			int secondMax = Integer.MIN_VALUE;
			
			Arrays.sort(arr);
			
			// Or use this :)
			//for (int i = 0; i < arr.length - 1; i++) { 
	        //    for (int j = 0; j < arr.length - i - 1; j++) { 
	        //        if (arr[j] < arr[j + 1]) {
	        //            int temp = arr[j];
	        //            arr[j] = arr[j + 1];
	        //            arr[j + 1] = temp;
	        //        }
	        //    }
	        //}
			
			for (int num : arr) {
	            if (num > max) { 
	                secondMax = max;
	                max = num;
	            } else if (num > secondMax && num < max) { 
	                secondMax = num;
	            }
	        }
			System.out.println("Max: " + max);
            System.out.println("Second Max: " + secondMax);
            return;
		}
		
		throw new IllegalArgumentException("Your array is not unique!!!!!!!!!!!!!!!!!!!!!");
	}
	
	public static boolean isUnique(int[] arr) {
		HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
        	set.add(num);
        	
            if (set.size() >= 2) {
                return true;
            }
        }
        return false;
	}

	public static void main(String[] args) {
		int[] arr = {5, 1, 0, 2, 7, 69, 96};
		int[] arr3 = {8, 8, 8, 9, 8, 8, 8};
		int[] arr2 = {8, 8, 8, 8, 8, 8, 8};
		
		getTwoMaxValues(arr);
		getTwoMaxValues(arr3);
		
		// This throws my exception :)
		System.out.println();
		getTwoMaxValues(arr2);
	}

}
