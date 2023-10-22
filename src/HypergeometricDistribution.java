/**
 * Contains methods for calculations related to hypergeometric distributions, including
 * the probabilities of succeeding a certain number of times after a certain number of
 * trials, as well as the expected value and variance.
 * 
 * @author Ian Mays
 */
public class HypergeometricDistribution {
	private CombinationsAndPermutations comsAndPerms = new CombinationsAndPermutations();
	private StatsExceptionChecker checkFor = new StatsExceptionChecker();
	
	/**
	 * Calculates the probability of getting exactly a certain number of items from
	 * the desired subset.
	 * @param bigN The total number of items in the set
	 * @param n The total number of items to draw
	 * @param r The number of items in the subset
	 * @param y The desired number of items to draw from the subset
	 * @return The probability of drawing exactly y items from the subset, out of n
	 * items from the full set
	 * @throws StatsException if any of the parameters are negative, if r > bigN, if
	 * n > bigN, or if y > n
	 */
	public double exactly(int bigN, int n, int r, int y) {
		checkFor.negativeItems(bigN);
		checkFor.negativeItems(n);
		checkFor.negativeItems(r);
		checkFor.negativeItems(y);
		checkFor.tooManyItems(bigN, r);
		checkFor.tooManyItems(bigN, n);
		checkFor.tooManyItems(n, y);
		
		double choicesA = comsAndPerms.combinations(r, y).doubleValue();
		double choicesB = comsAndPerms.combinations(bigN-r, n-y).doubleValue();
		double totalChoices = comsAndPerms.combinations(bigN, n).doubleValue();
		
		return choicesA * choicesB / totalChoices;
	}
	
	/**
	 * Calculates the probability of getting at least a certain number of items from
	 * the desired subset.
	 * @param bigN The total number of items in the set
	 * @param n The total number of items to draw
	 * @param r The number of items in the subset
	 * @param y The minimum desired number of items to draw from the subset
	 * @return The probability of drawing at least y items from the subset, out of n
	 * items from the full set
	 * @throws StatsException if any of the parameters are negative, if r > bigN, if
	 * n > bigN, or if y > n
	 */
	public double atLeast(int bigN, int n, int r, int y) {
		checkFor.negativeItems(bigN);
		checkFor.negativeItems(n);
		checkFor.negativeItems(r);
		checkFor.negativeItems(y);
		checkFor.tooManyItems(bigN, r);
		checkFor.tooManyItems(bigN, n);
		checkFor.tooManyItems(n, y);
		
		double totalProb = 0;
		
		for (int i = y; i <= r; i++) {
			totalProb += exactly(bigN, n, r, i);
		}
		
		return totalProb;
	}
	
	/**
	 * Calculates the probability of getting at most a certain number of items from
	 * the desired subset.
	 * @param bigN The total number of items in the set
	 * @param n The total number of items to draw
	 * @param r The number of items in the subset
	 * @param y The maximum desired number of items to draw from the subset
	 * @return The probability of drawing at most y items from the subset, out of n
	 * items from the full set
	 * @throws StatsException if any of the parameters are negative, if r > bigN, if
	 * n > bigN, or if y > n
	 */
	public double atMost(int bigN, int n, int r, int y) {
		checkFor.negativeItems(bigN);
		checkFor.negativeItems(n);
		checkFor.negativeItems(r);
		checkFor.negativeItems(y);
		checkFor.tooManyItems(bigN, r);
		checkFor.tooManyItems(bigN, n);
		checkFor.tooManyItems(n, y);
		
		double totalProb = 0;
		
		for (int i = 0; i <= y; i++) {
			totalProb += exactly(bigN, n, r, i);
		}
		
		return totalProb;
	}
	
	/**
	 * Calculates the expected number of items drawn from the subset.
	 * @param bigN The total number of items in the set
	 * @param n The total number of items to draw
	 * @param r The number of items in the subset
	 * @return The average number of items in the selection that will be from the
	 * subset
	 * @throws StatsException if any of the parameters are negative, if bigN = 0, if
	 * r > bigN, or if n > bigN
	 */
	public double expectedValue(int bigN, int n, int r) {
		checkFor.negativeItems(bigN);
		checkFor.negativeItems(n);
		checkFor.negativeItems(r);
		checkFor.zero(bigN);
		checkFor.tooManyItems(bigN, r);
		checkFor.tooManyItems(bigN, n);
		
		return (double) n*r/bigN;
	}
	
	/**
	 * Calculates the variance of the number of items drawn from the subset.
	 * @param bigN The total number of items in the set
	 * @param n The total number of items to draw
	 * @param r The number of items in the subset
	 * @return The variance of the number of items in the selection that will be from
	 * the subset
	 * @throws StatsException if any of the parameters are negative, if bigN = 0 or 1,
	 * if r > bigN, or if n > bigN
	 */
	public double variance(int bigN, int n, int r) {
		checkFor.negativeItems(bigN);
		checkFor.negativeItems(n);
		checkFor.negativeItems(r);
		checkFor.zero(bigN);
		checkFor.zero(bigN-1);
		checkFor.tooManyItems(bigN, r);
		checkFor.tooManyItems(bigN, n);
		
		return (double) n * r/bigN * (bigN-r)/bigN * (bigN-n)/(bigN-1);
	}
}