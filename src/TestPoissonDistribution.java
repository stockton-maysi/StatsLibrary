/**
 * Tester for PoissonDistribution. Produces a table showing the probability of exactly,
 * at least, and at most y successes for each possible value of y. Also shows expected
 * value and variance.
 * 
 * @author Ian Mays
 */
public class TestPoissonDistribution {
	public static void main(String[] args) {
		PoissonDistribution poisson = new PoissonDistribution();
		
		double lambda = 2;
		
		System.out.println("λ = " + lambda);
		System.out.println();
		System.out.println("y   P(Y=y)    P(Y>=y)   P(Y<=y)");
		
		for (int i = 0; i <= 10; i++) {
			System.out.printf("%-3d %-9f %-9f %-9f\n", i, poisson.exactly(lambda, i), poisson.atLeast(lambda, i), poisson.atMost(lambda, i));
		}
		
		System.out.println();
		System.out.println("E(Y) = " + poisson.expectedValue(lambda));
		System.out.println("V(Y) = " + poisson.variance(lambda));
	}
}
