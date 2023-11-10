/**
 * Tester for UniformDistribution. Given a distribution and range, shows the
 * probabilities of the value falling within the range, under the maximum of the range,
 * and over the minimum of the range. Also shows expected value and variance.
 * 
 * @author Ian Mays
 */
public class TestUniformDistribution {
	public static void main(String[] args) {
		UniformDistribution uniform = new UniformDistribution();
		
		double theta1 = 20;
		double theta2 = 25;
		double min = 22;
		double max = 24;
		
		System.out.println("a = " + theta1);
		System.out.println("b = " + theta2);
		System.out.println("c = " + min);
		System.out.println("d = " + max);
		System.out.println();
		System.out.println("P(c≤y≤d) = " + uniform.between(theta1, theta2, min, max));
		System.out.println("P(c≤y) = " + uniform.atLeast(theta1, theta2, min));
		System.out.println("P(y≤d) = " + uniform.atMost(theta1, theta2, max));
		System.out.println("E(Y) = " + uniform.expectedValue(theta1, theta2));
		System.out.println("V(Y) = " + uniform.variance(theta1, theta2));
	}
}
