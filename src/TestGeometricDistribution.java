/**
 * Tester for GeometricDistribution. Produces a table showing the probability of
 * exactly, at least, and at most y successes for each possible value of y. Also shows
 * expected value and variance.
 * 
 * @author Ian Mays
 */
public class TestGeometricDistribution {
	public static void main(String[] args) {
		GeometricDistribution geometric = new GeometricDistribution();
		
		double p = 0.3;
		
		System.out.println("p = " + p);
		System.out.println();
		System.out.println("y   P(Y=y)    P(Y>=y)   P(Y<=y)");
		
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%-3d %-9f %-9f %-9f \n", i, geometric.exactly(i, p), geometric.atLeast(i, p), geometric.atMost(i, p));
		}
		
		System.out.println();
		System.out.println("E(Y) = " + geometric.expectedValue(p));
		System.out.println("V(Y) = " + geometric.variance(p));
	}
}
