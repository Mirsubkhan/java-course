package sha256_1;

public class MathTest {
	public static void main(String[] args) {
		JMathChild math = new JMathChild();
		
		System.out.println(new JMath().factorial(5));
		System.out.println(math.factorial(5));
		
		System.out.println(math.getMax(1, 2, 3, 4));
		System.out.println(math.getMin(5, 6, 7, 8));
		System.out.println(math.getAvg(9, 10, 11, 12));
		
		System.out.println(math.getMax(1, 2, 3, 4, 5));
		System.out.println(math.getMin(6, 7, 8, 9, 10));
		System.out.println(math.getAvg(11, 12, 13, 14, 15));
	}
}
