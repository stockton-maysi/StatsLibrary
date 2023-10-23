import java.util.ArrayList;

/**
 * Contains methods that throw a StatsException if the input is not valid in a given
 * context.<p>
 * Many of these methods differ from each other only cosmetically. The purpose of this
 * is to provide error messages that are as descriptive as possible.
 * 
 * @author Ian Mays
 */
public class StatsExceptionChecker {
	/**
	 * @param p The probability
	 * @throws StatsException if probability is not in the range 0 ≤ p ≤ 1
	 */
	public void probabilityOutOfRange(double p) {
		if (p < 0 || p > 1) {
			throw new StatsException("Invalid probability " + p + "; must be between 0 and 1, inclusive");
		}
	}
	
	/**
	 * Used in contexts where division is needed. Normally, dividing by zero would
	 * throw an ArithmeticException instead.
	 * @param p The number to check; does not necessarily have to be a probability
	 * @throws StatsException if p = 0
	 */
	public void zero(double p) {
		if (p == 0) {
			throw new StatsException("Cannot divide by zero");
		}
	}
	
	/**
	 * @param bigN The number of items in the main set
	 * @param r The number of items in the subset
	 * @throws StatsException if r > bigN
	 */
	public void tooManyItems(int bigN, int r) {
		if (r > bigN) {
			throw new StatsException("Cannot have " + r + " objects in subset of " + bigN + " objects");
		}
	}
	
	/**
	 * @param n The number of trials
	 * @param y The number of desired successes
	 * @throws StatsException if y > n
	 */
	public void tooManySuccesses(int n, int y) {
		if (y > n) {
			throw new StatsException("Cannot have " + y + " successes in " + n + " trials");
		}
	}
	
	/**
	 * @param n The number of trials
	 * @throws StatsException if n is negative
	 */
	public void negativeTrials(int n) {
		if (n < 0) {
			throw new StatsException("Number of trials cannot be negative");
		}
	}
	
	/**
	 * @param n The number of successes
	 * @throws StatsException if n is negative
	 */
	public void negativeSuccesses(int n) {
		if (n < 0) {
			throw new StatsException("Number of successes cannot be negative");
		}
	}
	
	/**
	 * @param n The number of items
	 * @throws StatsException if n is negative
	 */
	public void negativeItems(int n) {
		if (n < 0) {
			throw new StatsException("Number of items cannot be negative");
		}
	}
	
	/**
	 * @param n The average number of occurrences per time period
	 * @throws StatsException if n is negative
	 */
	public void negativeOccurrenceRate(double n) {
		if (n < 0) {
			throw new StatsException("Occurrence rate cannot be negative");
		}
	}
	
	/**
	 * @param n The number of trials
	 * @throws StatsException if n = 0
	 */
	public void zeroTrials(int n) {
		if (n == 0) {
			throw new StatsException("Number of trials cannot be zero");
		}
	}
	
	/**
	 * @param n The number of successes
	 * @throws StatsException if n = 0
	 */
	public void zeroSuccesses(int n) {
		if (n == 0) {
			throw new StatsException("Number of successes cannot be zero");
		}
	}
	
	/**
	 * @param array1 The first array of doubles
	 * @param array2 The second array of doubles
	 * @throws StatsException The arrays are of different lengths
	 */
	public void arraysNotEqualLength(double[] array1, double[] array2) {
		if (array1.length != array2.length) {
			throw new StatsException("Arrays must be of equal length");
		}
	}
	
	/**
	 * @param userInputNumbers The ArrayList to check
	 * @param minSize The minimum array size
	 * @throws StatsException if the array is not of sufficient length
	 */
	public void arrayNotBigEnough(ArrayList<Double> userInputNumbers, int minSize) {
		if (userInputNumbers.size() < minSize) {
			throw new StatsException("ArrayList must have length of at least " + minSize);
		}
	}
}