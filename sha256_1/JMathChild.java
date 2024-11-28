package sha256_1;

public class JMathChild extends JMath {
	@Override
	public long factorial(long n) {
		long f = super.factorial(n);
		return f / 2;
	}
}
