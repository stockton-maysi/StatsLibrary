/**
 * Tester for DiscreteMultivariateDistribution. Finds both the joint probability,
 * joint distribution, marginal probability, conditional probability, and conditional
 * distribution outputs for each index in an array, and prints them as a table.
 * 
 * @author Ian Mays
 */
public class TestDiscreteMultivariateDistribution {
	public static void main(String[] args) {
		DiscreteMultivariateDistribution discreteMultivariate = new DiscreteMultivariateDistribution();
		
		double[][] p = {{1.0/9, 2.0/9, 1.0/9}, {2.0/9, 1.0/9, 0}, {1.0/9, 1.0/9, 0}};
		
		System.out.printf("%10s", "p(y1,y2) =");
		
		for (int i = 0; i < p[0].length; i++) {
			System.out.printf("%10d", i);
		}
		
		System.out.println();
		
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%10d", i);
			
			for (int j = 0; j < p[i].length; j++) {
				System.out.printf("%10f", discreteMultivariate.jointProbability(p, i, j));
			}
			
			System.out.println();
		}
		
		System.out.println();
		System.out.printf("%10s", "F(y1,y2) =");
		
		for (int i = 0; i < p[0].length; i++) {
			System.out.printf("%10d", i);
		}
		
		System.out.println();
		
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%10d", i);
			
			for (int j = 0; j < p[i].length; j++) {
				System.out.printf("%10f", discreteMultivariate.jointDistribution(p, i, j));
			}
			
			System.out.println();
		}
		
		System.out.println();
		System.out.printf("%10s%10s\n", "y1", "p1(y1)");
		
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%10d%10f\n", i, discreteMultivariate.marginalProbability1(p, i));
		}
		
		System.out.println();
		System.out.printf("%10s%10s\n", "y2", "p2(y2)");
		
		for (int i = 0; i < p[0].length; i++) {
			System.out.printf("%10d%10f\n", i, discreteMultivariate.marginalProbability2(p, i));
		}
		
		System.out.println();
		System.out.printf("%10s", "p(y1|y2) =");
		
		for (int i = 0; i < p[0].length; i++) {
			System.out.printf("%10d", i);
		}
		
		System.out.println();
		
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%10d", i);
			
			for (int j = 0; j < p[i].length; j++) {
				System.out.printf("%10f", discreteMultivariate.conditionalProbability12(p, i, j));
			}
			
			System.out.println();
		}
		
		System.out.println();
		System.out.printf("%10s", "p(y2|y1) =");
		
		for (int i = 0; i < p[0].length; i++) {
			System.out.printf("%10d", i);
		}
		
		System.out.println();
		
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%10d", i);
			
			for (int j = 0; j < p[i].length; j++) {
				System.out.printf("%10f", discreteMultivariate.conditionalProbability21(p, i, j));
			}
			
			System.out.println();
		}
		
		System.out.println();
		System.out.printf("%10s", "F(y1|y2) =");
		
		for (int i = 0; i < p[0].length; i++) {
			System.out.printf("%10d", i);
		}
		
		System.out.println();
		
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%10d", i);
			
			for (int j = 0; j < p[i].length; j++) {
				System.out.printf("%10f", discreteMultivariate.conditionalDistribution12(p, i, j));
			}
			
			System.out.println();
		}
		
		System.out.println();
		System.out.printf("%10s", "F(y2|y1) =");
		
		for (int i = 0; i < p[0].length; i++) {
			System.out.printf("%10d", i);
		}
		
		System.out.println();
		
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%10d", i);
			
			for (int j = 0; j < p[i].length; j++) {
				System.out.printf("%10f", discreteMultivariate.conditionalDistribution21(p, i, j));
			}
			
			System.out.println();
		}
	}
}
