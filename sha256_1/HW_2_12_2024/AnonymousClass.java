package HW_2_12_2024;

public class AnonymousClass {
	public static void main(String[] args) {
		// Task number 1.1
		IMath additionClazz = new IMath() {

			@Override
			public int operate(int a, int b) {
				return a + b;
			}
			
		};
		
		int result1 = additionClazz.operate(5, 3);
		System.out.println("Result of 5 + 3 -> " + result1);
		
		// Task number 1.2
		IMath addition = (int a, int b) -> a + b;
		IMath minus = (int a, int b) -> a - b;
		IMath multiply = (int a, int b) -> a * b;
		
        int result = addition.operate(5, 3);
        int result2 = minus.operate(5, 3);
        int result3 = multiply.operate(5, 3);
        
        System.out.println("Result of 5 + 3 -> " + result);
        System.out.println("Result of 5 / 3 -> " + result2);
        System.out.println("Result of 5 * 3 -> " + result3);
	}
}
