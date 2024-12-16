package from_5_12_2024;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

@FunctionalInterface
interface IMath<T, U, R> {
	R operate(T t, U u);
}

public class Program2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Input two numbers: ");

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        scanner.close();
        
        IMath<Integer, Integer, Integer> plusFunc = (a, b) -> a + b;
        IMath<Integer, Integer, Integer> multiplyFunc = (a, b) -> a * b;
            
        System.out.println("Plus: " + plusFunc.operate(num1, num2));
        System.out.println("Multiply: " + multiplyFunc.operate(num1, num2));
        
        Runnable getDate = () -> System.out.println("Date: " + LocalDate.now());
        // I just wanted to show current time from Dubai :)
        Runnable getTime = () -> System.out.println("Time: " + LocalTime.now(ZoneId.of("Asia/Dubai")));
        
        getDate.run();
        getTime.run();
	}

}
