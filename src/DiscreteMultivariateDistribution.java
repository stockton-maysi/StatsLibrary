/**
 * Contains methods for calculations related to discrete multivariate (specifically
 * bivariate) distributions, particularly the joint probability and joint distribution
 * functions.
 * 
 * @author Ian Mays
 */
public class DiscreteMultivariateDistribution {
	private StatsExceptionChecker checkFor = new StatsExceptionChecker();
	
	/**
	 * 
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
	 * 
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
}
