package sha256_1;

import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		//Task 1
		
		System.out.println("“Your time is limited,\n\t"
				+ "so don’t waste it\n\t\t"
				+ "living someone else’s life”\n\t\t\t"
				+ "Steve Jobs");
		
		// Task2
		
		Scanner input = new Scanner(System.in);
		
		int percent = input.nextInt();
		int value = input.nextInt();
		double result = (double) value * (percent / 100.0);
		
		System.out.println(percent + "% from " + value + " is equal " + (int) result);
		
		//Task 3
		
        int digit1 = input.nextInt();
        int digit2 = input.nextInt();
        int digit3 = input.nextInt();
        
        StringBuilder stirngResult = new StringBuilder();
        
        stirngResult.append(digit1);
        stirngResult.append(digit2);
        stirngResult.append(digit3);
        
        long number = Long.parseLong(stirngResult.toString());
        
        System.out.println("Your value is: " + number);
        
        input.close();
	}

}
