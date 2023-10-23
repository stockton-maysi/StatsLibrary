/**
 * Contains methods for calculations related to Poisson distributions, including the
 * probabilities of succeeding a certain number of times after a certain number of
 * trials, as well as the expected value and variance.
 * 
 * @author Ian Mays
 */
public class PoissonDistribution {
	private CombinationsAndPermutations comsAndPerms = new CombinationsAndPermutations();
	private StatsExceptionChecker checkFor = new StatsExceptionChecker();
	
	/**
	 * Calculates the probability of exactly a certain number of occurrences within
	 * a given time period.
	 * @param lambda The average number of occurrences in a given time period
	 * @param y The desired number of successes
	 * @return The probability of exactly y events occurring during the time period
	 * @throws StatsException if either lambda or y are negative
	 */
	public double exactly(double lambda, int y) {
		checkFor.negativeOccurrenceRate(lambda);
		checkFor.negativeSuccesses(y);
		
		return Math.pow(lambda, y) / comsAndPerms.factorial(y).doubleValue() * Math.pow(Math.E, -lambda);
	}
	
	/**
	 * Calculates the probability of at least a certain number of occurrences within
	 * a given time period.
	 * @param lambda The average number of occurrences in a given time period
	 * @param y The minimum desired number of successes
	 * @return The probability of at least y events occurring during the time period
	 * @throws StatsException if either lambda or y are negative
	 */
	public double atLeast(double lambda, int y) {
		checkFor.negativeOccurrenceRate(lambda);
		checkFor.negativeSuccesses(y);
		
		double totalProb = 1;
		
		for (int i = 0; i < y; i++) {
			totalProb -= exactly(lambda, i);
		}
		
		return totalProb;
	}
	
	/**
	 * Calculates the probability of at most a certain number of occurrences within
	 * a given time period.
	 * @param lambda The average number of occurrences in a given time period
	 * @param y The maximum desired number of successes
	 * @return The probability of no more than y events occurring during the time
	 * period
	 * @throws StatsException if either lambda or y are negative
	 */
	public double atMost(double lambda, int y) {
		checkFor.negativeOccurrenceRate(lambda);
		checkFor.negativeSuccesses(y);
		
		double totalProb = 0;
		
		for (int i = 0; i <= y; i++) {
			totalProb += exactly(lambda, i);
		}
		
		return totalProb;
	}
	
	/**
	 * Calculates the expected value for the Poisson distribution. By definition, this
	 * is just equal to lambda, but it is included here for consistency.
	 * @param lambda The average number of occurrences per time period
	 * @return The average number of occurrences per time period
	 * @throws StatsException if lambda is negative
	 */
	public double expectedValue(double lambda) {
		checkFor.negativeOccurrenceRate(lambda);
		
		return lambda;
	}
	
	/**
	 * Calculates the variance for the Poisson distribution. This is also just equal
	 * to lambda.
	 * @param lambda The average number of occurrences per time period
	 * @return The variance in the number of occurrences in a given time period
	 * @throws StatsException if lambda is negative
	 */
	public double variance(double lambda) {
		checkFor.negativeOccurrenceRate(lambda);
		
		return lambda;
	}
}