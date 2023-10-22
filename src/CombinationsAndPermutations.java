import java.math.BigInteger;

/**
 * This class contains methods for calculating the number of combinations as well as
 * the number of permutations of certain numbers of objects. Uses BigInteger as a way
 * of working with large numbers.
 * 
 * @author Ian Mays
 */
public class CombinationsAndPermutations {
	private StatsExceptionChecker checkFor = new StatsExceptionChecker();
	
	/**
	 * Computes the factorial of a number.
	 * @param n The integer to find the factorial of
	 * @return The factorial
	 * @throws StatsException if n is negative
	 */
	public BigInteger factorial(int n) {
		checkFor.negativeItems(n);
		
		BigInteger result = BigInteger.ONE;
		
		for (int i = 2; i <= n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		
		return result;
	}
	
	/**
	 * Finds the number of combinations (i.e. unordered subsets) of r objects that
	 * can be taken from a set of n objects.
	 * @param n The number of objects in the set
	 * @param r The number of objects to choose from the set
	 * @return The number of ways to choose r objects from n objects
	 * @throws StatsException if either n or are are negative, or if r > n
	 */
	public BigInteger combinations(int n, int r) {
		checkFor.negativeItems(n);
		checkFor.negativeItems(r);
		checkFor.tooManyItems(n, r);
		
		return factorial(n).divide(factorial(r)).divide(factorial(n-r));
	}
	
	/**
	 * Finds the number of permutations (i.e. ordered arrangements) of r objects that
	 * can be taken from a set of n objects.
	 * @param n The number of objects in the set
	 * @param r The number of objects to choose from the set
	 * @return The number of ways to choose r objects from n objects, with ordering
	 * @throws StatsException if either n or are are negative, or if r > n
	 */
	public BigInteger permutations(int n, int r) {
		checkFor.negativeItems(n);
		checkFor.negativeItems(r);
		checkFor.tooManyItems(n, r);
		
		return factorial(n).divide(factorial(n-r));
	}
}