package homework_from_25_11_2024;

import java.util.Scanner;

public class SumOfDigits2 {
	public static int sumOfDigits2(int num) {
        if (num == 0) return 0;
        return 1 + (num - 1) % 9;
    }

    public static void main(String[] args) {
    	System.out.print("Input some value: ");
    	
        var scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        scanner.close();
        
        System.out.println("Sum of digits -> " + sumOfDigits2(value));
    }
}
