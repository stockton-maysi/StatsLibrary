/**
 * An exception thrown in various cases throughout this StatsLibrary.
 * StatsExceptionChecker checks for all of these cases and throws errors when they are
 * found.
 * 
 * @author Ian Mays
 */
public class StatsException extends RuntimeException {
	/**
	 * Constructs a new StatsException as a RuntimeException.
	 * @param s The text to show for the exception
	 */
	public StatsException(String s) {
		super(s);
	}
}