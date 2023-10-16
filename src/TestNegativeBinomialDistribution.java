/**
 * Tester for NegativeBinomialDistribution. Produces a table showing the probability of
 * exactly, at least, and at most y successes for each possible value of y. Also shows
 * expected value and variance.
 * 
 * @author Ian Mays
 */
public class TestNegativeBinomialDistribution {
	public static void main(String[] args) {
		NegativeBinomialDistribution negativeBinomial = new NegativeBinomialDistribution();
		
		int r = 3;
		double p = 0.1;
		
		System.out.println("r = " + r);
		System.out.println("p = " + p);
		System.out.println();
		System.out.println("y   P(Y=y)    P(Y>=y)   P(Y<=y)");
		
		for (int i = r; i <= 50; i++) {
			System.out.printf("%-3d %-9f %-9f %-9f \n", i, negativeBinomial.exactly(i, r, p), negativeBinomial.atLeast(i, r, p), negativeBinomial.atMost(i, r, p));
		}
		
		System.out.println();
		System.out.println("E(Y) = " + negativeBinomial.expectedValue(r, p));
		System.out.println("V(Y) = " + negativeBinomial.variance(r, p));
	}
}
