/**
 * Contains methods for calculations related to uniform distributions, including the
 * probability of a value falling within a certain range, as well as the expected value
 * and variance.
 * 
 * @author Ian Mays
 */
public class UniformDistribution {
	private StatsExceptionChecker checkFor = new StatsExceptionChecker();
	
	/**
	 * Calculates the probability of a value falling within a certain range given a
	 * uniform distribution between two other values.
	 * @param theta1 The overall minimum value of the distribution
	 * @param theta2 The overall maximum value of the distribution
	 * @param min The minimum value of the range
	 * @param max The maximum value of the range
	 * @return The probability of the value falling between min and max
	 * @throws StatsException if theta2 is not strictly greater than theta1, or if max
	 * is not greater than or equal to min
	 */
	public double between(double theta1, double theta2, double min, double max) {
		checkFor.badRange(theta1, theta2, false);
		checkFor.badRange(min, max, true);
		
		double actualMin = Math.max(theta1, min);
		double actualMax = Math.min(theta2, max);
		
		return (actualMax - actualMin) / (theta2 - theta1);
	}
	
	/**
	 * Calculates the probability of a value falling above a certain other value given
	 * a uniform distribution.
	 * @param theta1 The overall minimum value of the distribution
	 * @param theta2 The overall maximum value of the distribution
	 * @param min The minimum value of the range
	 * @return The probability of the value falling above min
	 * @throws StatsException if theta2 is not strictly greater than theta1
	 */
	public double atLeast(double theta1, double theta2, double min) {
		checkFor.badRange(theta1, theta2, false);
		checkFor.badRange(min, theta2, true);
		
		return between(theta1, theta2, min, theta2);
	}
	
	/**
	 * Calculates the probability of a value falling below a certain other value given
	 * a uniform distribution.
	 * @param theta1 The overall minimum value of the distribution
	 * @param theta2 The overall maximum value of the distribution
	 * @param max The maximum value of the range
	 * @return The probability of the value falling below max
	 * @throws StatsException if theta2 is not strictly greater than theta1
	 */
	public double atMost(double theta1, double theta2, double max) {
		checkFor.badRange(theta1, theta2, false);
		checkFor.badRange(theta1, max, true);
		
		return between(theta1, theta2, theta1, max);
	}
	
	/**
	 * Calculates the expected value for a uniform distribution.
	 * @param theta1 The overall minimum value of the distribution
	 * @param theta2 The overall maximum value of the distribution
	 * @return The mean value
	 * @throws StatsException if theta2 is not strictly greater than theta1
	 */
	public double expectedValue(double theta1, double theta2) {
		checkFor.badRange(theta1, theta2, false);
		
		return (theta1 + theta2)/2;
	}
	
	/**
	 * Calculates the variance of a uniform distribution.
	 * @param theta1 The overall minimum value of the distribution
	 * @param theta2 The overall maximum value of the distribution
	 * @return The variance
	 * @throws StatsException if theta2 is not strictly greater than theta1
	 */
	public double variance(double theta1, double theta2) {
		checkFor.badRange(theta1, theta2, false);
		
		return Math.pow(theta2 - theta1, 2)/12;
	}
}