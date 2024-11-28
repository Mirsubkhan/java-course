package sha256_1;

public class IsBuzz {

	public static void isBuzz(int value) {
		if (value % 5 == 0) {
			
			if(value % 3 == 0) {
				System.out.println("Fizz Buzz");
			}
			else {
				System.out.println("Buzz");
			}
			return;
		}
		
		System.out.println(value);
	}
	
	public static void main(String[] args) {
		isBuzz(14);
	}

}
