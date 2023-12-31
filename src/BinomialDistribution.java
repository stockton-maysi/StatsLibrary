/**
 * Contains methods for calculations related to binomial distributions, including the
 * probabilities of succeeding a certain number of times after a certain number of
 * trials, as well as the expected value and variance.
 * 
 * @author Ian Mays
 */
public class BinomialDistribution {
	private CombinationsAndPermutations comsAndPerms = new CombinationsAndPermutations();
	private StatsExceptionChecker checkFor = new StatsExceptionChecker();
	
	/**
	 * Calculates the probability of succeeding exactly a certain number of times.
	 * @param n The number of trials
	 * @param y The number of desired successes
	 * @param p The probability of success
	 * @return The probability of exactly y successes in n trials
	 * @throws StatsException if either n or y are negative, if y > n, or if the
	 * probability is not in the range 0 ≤ p ≤ 1
	 */
	public double exactly(int n, int y, double p) {
		checkFor.negativeTrials(n);
		checkFor.negativeSuccesses(y);
		checkFor.tooManySuccesses(n, y);
		checkFor.probabilityOutOfRange(p);
		
		double choices = comsAndPerms.combinations(n, y).doubleValue();
		double individualProbs = Math.pow(p, y) * Math.pow(1-p, n-y);
		
		return choices * individualProbs;
	}
	
	/**
	 * Calculates the probability of succeeding at least a certain number of times.
	 * @param n The number of trials
	 * @param y The number of desired successes
	 * @param p The probability of success
	 * @return The probability of at least y successes in n trials
	 * @throws StatsException if either n or y are negative, if y > n, or if the
	 * probability is not in the range 0 ≤ p ≤ 1
	 */
	public double atLeast(int n, int y, double p) {
		checkFor.negativeTrials(n);
		checkFor.negativeSuccesses(y);
		checkFor.tooManySuccesses(n, y);
		checkFor.probabilityOutOfRange(p);
		
		double totalProb = 0;
		
		for (int i = y; i <= n; i++) {
			totalProb += exactly(n, i, p);
		}
		
		return totalProb;
	}
	
	/**
	 * Calculates the probability of succeeding at most a certain number of times.
	 * @param n The number of trials
	 * @param y The number of desired successes
	 * @param p The probability of success
	 * @return The probability of at least y successes in n trials
	 * @throws StatsException if either n or y are negative, if y > n, or if the
	 * probability is not in the range 0 ≤ p ≤ 1
	 */
	public double atMost(int n, int y, double p) {
		checkFor.negativeTrials(n);
		checkFor.negativeSuccesses(y);
		checkFor.tooManySuccesses(n, y);
		checkFor.probabilityOutOfRange(p);
		
		double totalProb = 0;
		
		for (int i = 0; i <= y; i++) {
			totalProb += exactly(n, i, p);
		}
		
		return totalProb;
	}
	
	/**
	 * Calculates the expected number of successes. For a binomial distribution, this
	 * is actually just equal to n*p.
	 * @param n The number of trials
	 * @param p The probability of success
	 * @return The expected number of successes after n trials
	 * @throws StatsException if n is negative, or if the probability is not in the
	 * range 0 ≤ p ≤ 1
	 */
	public double expectedValue(int n, double p) {
		checkFor.negativeTrials(n);
		checkFor.probabilityOutOfRange(p);
		
		return n*p;
	}
	
	/**
	 * Calculates variance. For a binomial distribution, this is actually just equal to
	 * n*p*q, where q = 1-p.
	 * @param n The number of trials
	 * @param p The probability of success
	 * @return The variance
	 * @throws StatsException if n is negative, or if the probability is not in the
	 * range 0 ≤ p ≤ 1
	 */
	public double variance(int n, double p) {
		checkFor.negativeTrials(n);
		checkFor.probabilityOutOfRange(p);
		
		return n*p*(1-p);
	}
}
