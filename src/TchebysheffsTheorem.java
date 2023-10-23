/**
 * Contains methods for calculating the results of Tchebysheff's inequality.
 * 
 * @author Ian Mays
 */
public class TchebysheffsTheorem {
	StatsExceptionChecker checkFor = new StatsExceptionChecker();
	
	/**
	 * Finds the bound on the probability of a value falling inside of the range.
	 * @param stdDev The standard deviation of the distribution
	 * @param maxDev The maximum allowed deviation
	 * @return The minimum probability of a value falling inside the maximum deviation
	 * @throws StatsException if either stdDev or maxDev = 0
	 */
	public double withinRange(double stdDev, double maxDev) {
		checkFor.zero(stdDev);
		checkFor.zero(maxDev);
		
		double k = maxDev/stdDev;
		
		return 1 - 1/k/k;
	}
	
	/**
	 * Finds the bound on the probability of a value falling outside of the range.
	 * @param stdDev The standard deviation of the distribution
	 * @param maxDev The maximum allowed deviation
	 * @return The maximum probability of a value falling outside the maximum deviation
	 * @throws StatsException if either stdDev or maxDev = 0
	 */
	public double outsideRange(double stdDev, double maxDev) {
		checkFor.zero(stdDev);
		checkFor.zero(maxDev);
		
		double k = maxDev/stdDev;
		
		return 1/k/k;
	}
}
