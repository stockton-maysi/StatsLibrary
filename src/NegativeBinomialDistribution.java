/**
 * Contains methods for calculations related to negative binomial distributions, 
 * including the probabilities of succeeding a certain number of times after a certain
 * number of trials, as well as the expected value and variance.
 * 
 * @author Ian Mays
 */
public class NegativeBinomialDistribution {
	private CombinationsAndPermutations comsAndPerms = new CombinationsAndPermutations();
	
	/**
	 * Calculates the probability of the rth success occurring after exactly a certain
	 * number of trials.
	 * @param y The number of trials
	 * @param r The number of desired successes
	 * @param p The probability of success on each trial
	 * @return The probability of the rth success occurring on the yth trial
	 */
	public double exactly(int y, int r, double p) {
		return comsAndPerms.combinations(y-1, r-1).doubleValue() * Math.pow(p, r) * Math.pow(1-p, y-r);
	}
	
	/**
	 * Calculates the probability of the rth success occurring after at least a certain
	 * number of trials.
	 * @param y The number of trials
	 * @param r The number of desired successes
	 * @param p The probability of success on each trial
	 * @return The probability of the rth success occurring on or after the yth trial
	 */
	public double atLeast(int y, int r, double p) {
		double totalProb = 1;
		
		for (int i = r; i < y; i++) {
			totalProb -= exactly(i, r, p);
		}
		
		return totalProb;
	}
	
	/**
	 * Calculates the probability of the rth success occurring after at most a certain
	 * number of trials.
	 * @param y The number of trials
	 * @param r The number of desired successes
	 * @param p The probability of success on each trial
	 * @return The probability of the rth success occurring on or before the yth trial
	 */
	public double atMost(int y, int r, double p) {
		double totalProb = 0;
		
		for (int i = r; i <= y; i++) {
			totalProb += exactly(i, r, p);
		}
		
		return totalProb;
	}
	
	/**
	 * Calculates the expected number of trials before r successes occur. This is
	 * actually just equal to r divided by the probability.
	 * @param r The number of desired successes
	 * @param p The probability of success on each trial
	 * @return The average number of trials before r successes occur
	 */
	public double expectedValue(int r, double p) {
		return r/p;
	}
	
	/**
	 * Calculates the variance in the number of trials before r successes occur.
	 * @param r The number of desired successes
	 * @param p The probability of success on each trial
	 * @return The variance in the number of trials before r successes occur
	 */
	public double variance(int r, double p) {
		return r*(1-p)/(p*p);
	}
}
