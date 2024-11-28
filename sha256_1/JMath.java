package sha256_1;

public class JMath {
	public long factorial(long n) {
		if(n <= 1) {
			return 1;
		}
		return n * factorial(n-1);
	}
	
	public int getMax(int a, int b, int c, int d) {
		return Math.max(Math.max(a, b), Math.max(c, d));
	}
	
	public int getMin(int a, int b, int c, int d) {
		return Math.min(Math.min(a, b), Math.min(c, d));
	}
	
	public double getAvg(int a, int b, int c, int d) {
		return (a + b + c + d) / 4.0;
	}
	
	public int getMax(int a, int b, int c, int d, int e) {
		return Math.max(getMax(a, b, c, d), e);
	}
	
	public int getMin(int a, int b, int c, int d, int e) {
		return Math.min(getMin(a, b, c, d), e);
	}
	
	public double getAvg(int a, int b, int c, int d, int e) {
		return (a + b + c + d + e) / 5.0;
	}
}
