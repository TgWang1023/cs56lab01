/** A class to represent a rational number
    with a numerator and denominator

    @author P. Conrad for CS56 F16

    */

public class Rational {

    private int num;
    private int denom;

    /** 
	greatest common divisor of a and b
	@param a first number
	@param b second number
	@return gcd of a and b
    */
    public static int gcd(int a, int b) {
		if (a==0)
			return b;
		else if (b==0)
			return a;
		else
			return gcd(b%a, a);
    }
    
    public Rational() {
		this.num = 1;
		this.denom = 1;
    }

    public Rational(int num, int denom) {
		if (denom== 0) {
			throw new IllegalArgumentException("denominator may not be zero");
		}
		this.num = num;
		this.denom = denom;
		if (num != 0) {
			int gcd = Rational.gcd(num,denom);
			this.num /= gcd;
			this.denom /= gcd;
		}
    }

    public String toString() {
		if (denom == 1 || num == 0)
			return "" + num;
		return num + "/" + denom;
    }

    public int getNumerator() { return this.num; }
    public int getDenominator() { return this.denom; }

    public Rational times(Rational r) {
		return new Rational(this.num * r.num,
					this.denom * r.denom);
    }

    public static Rational product(Rational a, Rational b) {
		return new Rational(a.num * b.num,
					a.denom * b.denom);
    }

	public static int lcm(int a, int b) {
		return Math.abs(Math.abs(a * b) / gcd(a, b));
	}

	public Rational plus(Rational r) {
		int new_denom = lcm(this.getDenominator(), r.getDenominator());
		int new_nume = (new_denom / this.getDenominator()) * this.getNumerator() + (new_denom / r.getDenominator()) * r.getNumerator();
		return new Rational(new_nume, new_denom);
	}

	public static Rational sum(Rational a, Rational b) {
		return a.plus(b);
	}

	public Rational minus(Rational r) {
		int new_denom = lcm(this.getDenominator(), r.getDenominator());
		int new_nume = (new_denom / this.getDenominator()) * this.getNumerator() - (new_denom / r.getDenominator()) * r.getNumerator();
		return new Rational(new_nume, new_denom);
	}

	public static Rational difference(Rational a, Rational b) {
		return a.minus(b);
	}

	public Rational reciprocalOf() {
		if (this.getDenominator() == 0) {
			throw new ArithmeticException();
		}
		int new_denom = this.getNumerator();
		int new_nume = this.getDenominator();
		return new Rational(new_nume, new_denom);	
	}

	public Rational dividedBy(Rational r) {
		return new Rational(this.num / r.num,
		this.denom / r.denom);
	}

	public static Rational quotient(Rational a, Rational b) {
		return new Rational(a.num / b.num,
					a.denom / b.denom);
    }
    
    /** 
	For testing getters.  
	@param args unused
     */

    public static void main (String [] args) {
		Rational r = new Rational(5,7);
		Rational r2 = new Rational(7, 11);
		Rational r3 = new Rational(-7, 11);
		Rational r4 = new Rational(7, -11);
		Rational r5 = new Rational(0, 1);
		System.out.println("r.getNumerator()=" + r.getNumerator());
		System.out.println("r.getDenominator()=" + r.getDenominator());
		// Testing lcm
		System.out.println("Rational.lcm(6, 15)=" + Rational.lcm(6, 15));
		System.out.println("Rational.lcm(6, -15)=" + Rational.lcm(6, -15));
		System.out.println("Rational.lcm(-6, 15)=" + Rational.lcm(-6, 15));
		// Testing plus
		System.out.println(r.plus(r2));
		System.out.println(r.plus(r3));
		System.out.println(r.plus(r4));
		// Testing sum
		System.out.println(Rational.sum(r, r2));
		System.out.println(Rational.sum(r, r3));
		System.out.println(Rational.sum(r, r4));
		// Testing minus
		System.out.println(r.minus(r2));
		System.out.println(r.minus(r3));
		System.out.println(r.minus(r4));
		// Testing difference
		System.out.println(Rational.difference(r, r2));
		System.out.println(Rational.difference(r, r3));
		System.out.println(Rational.difference(r, r4));
		// testing reciprocalOf
		System.out.println(r.reciprocalOf());
		System.out.println(r2.reciprocalOf());
		System.out.println(r3.reciprocalOf());
		System.out.println(r4.reciprocalOf());
		// System.out.println(r5.reciprocalOf());
		// Testing dividedBy
		System.out.println(r2.dividedBy(r));
		System.out.println(r3.dividedBy(r));
		System.out.println(r4.dividedBy(r));
		// Testing quotient
		System.out.println(Rational.quotient(r2, r));
		System.out.println(Rational.quotient(r3, r));
		System.out.println(Rational.quotient(r4, r));

    }

    
}
