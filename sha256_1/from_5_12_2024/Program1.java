package from_5_12_2024;

import java.util.Scanner;

@FunctionalInterface
interface ITriFunction<T, U, V, R> {
	R define(T t, U u, V v);
}

public class Program1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Input three prime numbers: ");
        
        try {
            int num1 = readAndValidatePrime(scanner);
            int num2 = readAndValidatePrime(scanner);
            int num3 = readAndValidatePrime(scanner);
            
            ITriFunction<Integer, Integer, Integer, Integer> maxFunc = (a, b, c) -> Math.max(a, Math.max(b, c));
            ITriFunction<Integer, Integer, Integer, Integer> minFunc = (a, b, c) -> Math.min(a, Math.min(b, c));
            
            System.out.println("Max: " + maxFunc.define(num1, num2, num3));
            System.out.println("Min: " + minFunc.define(num1, num2, num3));
        }
        catch (IllegalArgumentException e){
        	System.out.println("You've got an error: " + e.getMessage());
        }
		
        finally {
        	scanner.close();
        }
	}
	
	private static int readAndValidatePrime(Scanner scanner) {
        int number = scanner.nextInt();
        if (!isPrime(number)) {
        	// I've added "!".repeat(10000) for fun :)
            throw new IllegalArgumentException("The value " + number + " isn't prime" + "!".repeat(888));
        }
        return number;
    }
	
	private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
