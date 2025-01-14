package L24;


public class Fraction {
    int a, b;

    public Fraction(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.a = a;
        this.b = b;
        simplify();
    }

    public void add(Fraction f) {
        if (f.b == this.b) {
            this.a += f.a;
        } else {
            int lcm = lcm(this.b, f.b);
            this.a = this.a * (lcm / this.b) + f.a * (lcm / f.b);
            this.b = lcm;
        }
        simplify();
        System.out.println("Result -> " + this.a + "/" + this.b);
    }

    public void subtract(Fraction f) {
        if (f.b == this.b) {
            this.a -= f.a;
        } else {
            int lcm = lcm(this.b, f.b);
            this.a = this.a * (lcm / this.b) - f.a * (lcm / f.b);
            this.b = lcm;
        }
        simplify();
        System.out.println("Result -> " + this.a + "/" + this.b);
    }

    public void multiply(Fraction f) {
        this.a = this.a * f.a;
        this.b = this.b * f.b;
        simplify();
        System.out.println("Result -> " + this.a + "/" + this.b);
    }

    public void divide(Fraction f) {
        if (f.a == 0) {
            throw new IllegalArgumentException("Cannot divide by zero fraction");
        }
        if (f.a == this.a && f.b == this.b) {
        	this.a = 1;
        	this.b = 1;
        }
        else {
        	this.a = this.a * f.b; 
            this.b = this.b * f.a;
        }
        simplify();
        System.out.println("Result -> " + this.a + "/" + this.b); 
    }

    private void simplify() {
        int gcd = gcd(this.a, this.b);
        this.a = this.a / gcd;
        this.b = this.b / gcd;
        if (this.b < 0) {
            this.a = -this.a;
            this.b = -this.b;
        }
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    @Override
    public String toString() {
        return this.a == this.b? "1": this.a + "/" + this.b;
    }
}