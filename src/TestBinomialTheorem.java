/**
 * Tester for BinomialTheorem. Produces a table showing the probability of exactly,
 * at least, and at most y successes for each possible value of y. Also shows expected
 * value and variance.
 * 
 * @author Ian Mays
 */
public class TestBinomialTheorem {
	public static void main(String[] args) {
		BinomialTheorem binomialTheorem = new BinomialTheorem();
		
		int n = 4;
		double p = 1.0/3;
		
		System.out.println("n = " + n);
		System.out.println("p = " + p);
		System.out.println();
		System.out.println("y   P(Y=y)    P(Y>=y)   P(Y<=y)");
		
		for (int i = 0; i <= n; i++) {
			System.out.printf("%-3d %-9f %-9f %-9f \n", i, binomialTheorem.exactly(n, i, p), binomialTheorem.atLeast(n, i, p), binomialTheorem.atMost(n, i, p));
		}
		
		System.out.println();
		System.out.println("E(Y) = " + binomialTheorem.expectedValue(n, p));
		System.out.println("V(Y) = " + binomialTheorem.variance(n, p));
	}
}