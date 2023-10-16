/**
 * Tester for HypergeometricDistribution. Produces a table showing the probability of
 * exactly, at least, and at most y successes for each possible value of y. Also shows
 * expected value and variance.
 * 
 * @author Ian Mays
 */
public class TestHypergeometricDistribution {
	public static void main(String[] args) {
		HypergeometricDistribution hypergeometric = new HypergeometricDistribution();
		
		int bigN = 10;
		int r = 5;
		int n = 3;
		
		System.out.println("N = " + bigN);
		System.out.println("r = " + r);
		System.out.println("n = " + n);
		System.out.println();
		System.out.println("y   P(Y=y)    P(Y>=y)   P(Y<=y)");
		
		for (int i = 0; i <= n; i++) {
			System.out.printf("%-3d %-9f %-9f %-9f \n", i, hypergeometric.exactly(bigN, r, n, i), hypergeometric.atLeast(bigN, r, n, i), hypergeometric.atMost(bigN, r, n, i));
		}
		
		System.out.println();
		System.out.println("E(Y) = " + hypergeometric.expectedValue(bigN, r, n));
		System.out.println("V(Y) = " + hypergeometric.variance(bigN, r, n));
	}
}