/**
 * Contains methods for calculations related to geometric distributions, including the
 * probabilities of succeeding a certain number of times after a certain number of
 * trials, as well as the expected value and variance.
 * 
 * @author Ian Mays
 */
public class GeometricDistribution {
	/**
	 * Calculates the probability of success after exactly a certain number of trials.
	 * @param y The number of trials
	 * @param p The probability of success in each trial
	 * @return The probability of the first success being on the yth trial
	 */
	public double exactly(int y, double p) {
		return Math.pow(1-p, y-1) * p;
	}
	
	/**
	 * Calculates the probability of success after at least a certain number of trials.
	 * @param y The number of trials
	 * @param p The probability of success in each trial
	 * @return The probability of the first success being on or after the yth trial
	 */
	public double atLeast(int y, double p) {
		return Math.pow(1-p, y-1);
	}
	
	/**
	 * Calculates the probability of success after at most a certain number of trials.
	 * @param y The number of trials
	 * @param p The probability of success in each trial
	 * @return The probability of the first success being on or before the yth trial
	 */
	public double atMost(int y, double p) {
		return 1 - Math.pow(1-p, y);
	}
	
	/**
	 * Calculates the expected number of trials before the first success. This is
	 * actually just equal to the reciprocal of the probability.
	 * @param p The probability of success in each trial
	 * @return The average number of trials before the first success
	 */
	public double expectedValue(double p) {
		return 1/p;
	}
	
	/**
	 * Calculates the variance of the number of trials of trials before the first 
	 * success.
	 * @param p The probability of success in each trial
	 * @return The variance
	 */
	public double variance(double p) {
		return (1-p)/(p*p);
	}
}