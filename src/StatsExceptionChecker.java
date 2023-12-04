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
	
	/**
	 * @param min The minimum of a range
	 * @param max The maximum of a range
	 * @param exactlyAllowed Whether the range is allowed to have a size of zero
	 * @throws StatsException if the maximum is less than the minimum
	 */
	public void badRange(double min, double max, boolean exactlyAllowed) {
		if (max < min && exactlyAllowed) {
			throw new StatsException("Maximum of range must be greater than or equal to minimum");
		} else if (max <= min && !exactlyAllowed) {
			throw new StatsException("Maximum of distribution must be strictly greater than minimum");
		}
	}
	
	/**
	 * @param p The bivariate probability function, as an array of arrays of doubles
	 * @throws StatsException if the total probability is not 1, or if the rows in the
	 * array are of unequal lengths
	 */
	public void invalidMultivariate(double[][] p) {
		double totalProb = 0;
		int[] rowLengths = new int[p.length];
		
		for (int i = 0; i < p.length; i++) {
			rowLengths[i] = p[i].length;
			
			for (int j = 0; j < p[i].length; j++) {
				probabilityOutOfRange(p[i][j]);
				totalProb += p[i][j];
			}
		}
		
		// allow tolerance of 0.000001 due to floating point errors
		if (Math.abs(totalProb - 1) > 0.000001) {
			throw new StatsException("Total probability must be equal to 1");
		}
		
		for (int i = 1; i < rowLengths.length; i++) {
			if (rowLengths[i] != rowLengths[0]) {
				throw new StatsException("Rows in probability array must be of equal length");
			}
		}
	}
	
	/**
	 * @param p The bivariate probability function, as an array of arrays of doubles
	 * @param y1 The row index
	 * @param y2 The column index
	 * @throws StatsException if either y1 or y2 are outside the bounds of p
	 */
	public void indicesOutOfRange(double[][] p, int y1, int y2) {
		if (y1 < 0 || y1 >= p.length) {
			throw new StatsException("y1 must be in range of array (between 0 and " + (p.length-1) + ", inclusive");
		}
		
		if (y2 < 0 || y2 >= p[0].length) {
			throw new StatsException("y2 must be in range of array (between 0 and " + (p[0].length-1) + ", inclusive");
		}
	}
}