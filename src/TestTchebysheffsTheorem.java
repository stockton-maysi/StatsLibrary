/**
 * Tester for TchebysheffsTheorem. Based on a PoissonDistribution, finds the standard
 * deviation of the distribution and finds the bounds on the probability of a given
 * value falling inside or outside of a range of two standard deviations from the mean.
 * 
 * @author Ian Mays
 */
public class TestTchebysheffsTheorem {
	public static void main(String[] args) {
		PoissonDistribution poisson = new PoissonDistribution();
		TchebysheffsTheorem tchebysheff = new TchebysheffsTheorem();
		
		double lambda = 10;
		
		System.out.println("λ = " + lambda);
		System.out.println();
		System.out.println("y   P(Y=y)    P(Y>=y)   P(Y<=y)");
		
		for (int i = 0; i <= 20; i++) {
			System.out.printf("%-3d %-9f %-9f %-9f \n", i, poisson.exactly(lambda, i), poisson.atLeast(lambda, i), poisson.atMost(lambda, i));
		}
		
		System.out.println();
		System.out.println("E(Y) = " + poisson.expectedValue(lambda));
		System.out.println("V(Y) = " + poisson.variance(lambda));
		System.out.println();
		
		double stdDev = Math.sqrt(lambda)*3;
		double maxDev = 2*stdDev;
		
		System.out.println("σ = " + stdDev);
		System.out.println("maxDev = " + maxDev);
		System.out.println();
		System.out.printf("Within range:  ≥%-9f\n", tchebysheff.withinRange(stdDev, maxDev));
		System.out.printf("Outside range: ≤%-9f\n", tchebysheff.outsideRange(stdDev, maxDev));
	}
}
