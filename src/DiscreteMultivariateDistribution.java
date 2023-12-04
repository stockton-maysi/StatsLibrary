/**
 * Contains methods for calculations related to discrete multivariate (specifically
 * bivariate) distributions. These include the joint probability, joint
 * distribution, marginal probability, and conditional probability/distribution
 * functions.
 * 
 * @author Ian Mays
 */
public class DiscreteMultivariateDistribution {
	private StatsExceptionChecker checkFor = new StatsExceptionChecker();
	
	/**
	 * Calculates the joint probability function for a discrete bivariate distribution.
	 * @param p The bivariate probability function, as an array of arrays of doubles
	 * @param y1 The value for the first random variable
	 * @param y2 The value for the second random variable
	 * @return The probability that Y1 = y1 and Y2 = y2
	 * @throws StatsException if p is not a valid bivariate function, or if y1 or y2
	 * are out of the bounds of p
	 */
	public double jointProbability(double[][] p, int y1, int y2) {
		checkFor.invalidMultivariate(p);
		checkFor.indicesOutOfRange(p, y1, y2);
		
		return p[y1][y2];
	}
	
	/**
	 * Calculates the joint distribution function for a discrete bivariate
	 * distribution.
	 * @param p The bivariate probability function, as an array of arrays of doubles
	 * @param y1 The value for the first random variable
	 * @param y2 The value for the second random variable
	 * @return The probability that Y1 <= y1 and Y2 <= y2
	 * @throws StatsException if p is not a valid bivariate function, or if y1 or y2
	 * are out of the bounds of p
	 */
	public double jointDistribution(double[][] p, int y1, int y2) {
		checkFor.invalidMultivariate(p);
		checkFor.indicesOutOfRange(p, y1, y2);
		
		double totalProb = 0;
		
		for (int i = 0; i <= y1; i++) {
			for (int j = 0; j <= y2; j++) {
				totalProb += p[i][j];
			}
		}
		
		return totalProb;
	}
	
	/**
	 * Calculates the marginal probability for a given y1 value.
	 * @param p The bivariate probability function, as an array of arrays of doubles
	 * @param y1 The value for the first random variable
	 * @return The probability that Y1 = y1
	 * @throws StatsException if p is not a valid bivariate function, or if y1 is
	 * out of the bounds of p
	 */
	public double marginalProbability1(double[][] p, int y1) {
		checkFor.invalidMultivariate(p);
		checkFor.indicesOutOfRange(p, y1, 0);
		
		double totalProb = 0;
		
		for (int i = 0; i < p[y1].length; i++) {
			totalProb += p[y1][i];
		}
		
		return totalProb;
	}
	
	/**
	 * Calculates the marginal probability for a given y2 value.
	 * @param p The bivariate probability function, as an array of arrays of doubles
	 * @param y1 The value for the second random variable
	 * @return The probability that Y2 = y2
	 * @throws StatsException if p is not a valid bivariate function, or if y2 is
	 * out of the bounds of p
	 */
	public double marginalProbability2(double[][] p, int y2) {
		checkFor.invalidMultivariate(p);
		checkFor.indicesOutOfRange(p, 0, y2);
		
		double totalProb = 0;
		
		for (int i = 0; i < p.length; i++) {
			totalProb += p[i][y2];
		}
		
		return totalProb;
	}
	
	/**
	 * Calculates the conditional probability for a given y1 value.
	 * @param p The bivariate probability function, as an array of arrays of doubles
	 * @param y1 The value for the first random variable
	 * @param y2 The value for the second random variable
	 * @return The probability that Y1 = y1 given that Y2 = y2
	 * @throws StatsException if p is not a valid bivariate function, if y1 or y2 are
	 * out of the bounds of p, or if the marginal probability of y2 is 0
	 */
	public double conditionalProbability12(double[][] p, int y1, int y2) {
		checkFor.invalidMultivariate(p);
		checkFor.indicesOutOfRange(p, y1, y2);
		checkFor.zero(marginalProbability2(p, y2));
		
		return jointProbability(p, y1, y2) / marginalProbability2(p, y2);
	}
	
	/**
	 * Calculates the conditional probability for a given y2 value.
	 * @param p The bivariate probability function, as an array of arrays of doubles
	 * @param y1 The value for the first random variable
	 * @param y2 The value for the second random variable
	 * @return The probability that Y2 = y2 given that Y1 = y1
	 * @throws StatsException if p is not a valid bivariate function, if y1 or y2 are
	 * out of the bounds of p, or if the marginal probability of y1 is 0
	 */
	public double conditionalProbability21(double[][] p, int y1, int y2) {
		checkFor.invalidMultivariate(p);
		checkFor.indicesOutOfRange(p, y1, y2);
		checkFor.zero(marginalProbability1(p, y1));
		
		return jointProbability(p, y1, y2) / marginalProbability1(p, y1);
	}
	
	/**
	 * Calculates the conditional distribution function for a given y1 value.
	 * @param p The bivariate probability function, as an array of arrays of doubles
	 * @param y1 The value for the first random variable
	 * @param y2 The value for the second random variable
	 * @return The probability that Y1 <= y1 given that Y2 = y2
	 * @throws StatsException if p is not a valid bivariate function, if y1 or y2 are
	 * out of the bounds of p, or if the marginal probability of y2 is 0
	 */
	public double conditionalDistribution12(double[][] p, int y1, int y2) {
		checkFor.invalidMultivariate(p);
		checkFor.indicesOutOfRange(p, y1, y2);
		checkFor.zero(marginalProbability2(p, y2));
		
		double totalProb = 0;
		
		for (int i = 0; i <= y1; i++) {
			totalProb += conditionalProbability12(p, i, y2);
		}
		
		return totalProb;
	}
	
	/**
	 * Calculates the conditional distribution function for a given y2 value.
	 * @param p The bivariate probability function, as an array of arrays of doubles
	 * @param y1 The value for the first random variable
	 * @param y2 The value for the second random variable
	 * @return The probability that Y2 <= y2 given that Y1 = y1
	 * @throws StatsException if p is not a valid bivariate function, if y1 or y2 are
	 * out of the bounds of p, or if the marginal probability of y1 is 0
	 */
	public double conditionalDistribution21(double[][] p, int y1, int y2) {
		checkFor.invalidMultivariate(p);
		checkFor.indicesOutOfRange(p, y1, y2);
		checkFor.zero(marginalProbability1(p, y1));
		
		double totalProb = 0;
		
		for (int i = 0; i <= y2; i++) {
			totalProb += conditionalProbability21(p, y1, i);
		}
		
		return totalProb;
	}
	
	/**
	 * Determines whether y1 and y2 are independent of each other in a discrete
	 * bivariate distribution.
	 * @param p The bivariate probability function, as an array of arrays of doubles
	 * @return true if y1 and y2 are independent, false if dependent
	 * @throws StatsException if p is not a valid bivariate function
	 */
	public boolean isIndependent(double[][] p) {
		checkFor.invalidMultivariate(p);
		
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {
				if (p[i][j] != marginalProbability1(p, i) * marginalProbability2(p, j)) {
					return false;
				}
			}
		}
		
		return true;
	}
}
