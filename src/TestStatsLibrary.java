import java.util.ArrayList;

/**
 * Tester for StatsLibrary. Among other things, tests median with both odd- and
 * even-sized lists.
 * 
 * @author Ian Mays
 */
public class TestStatsLibrary {
	public static void main(String[] args) {
		StatsLibrary stats = new StatsLibrary();
		
		ArrayList<Double> testNumbers = new ArrayList<>();
		
		testNumbers.add(2.0);
		testNumbers.add(4.0);
		testNumbers.add(4.0);
		testNumbers.add(1.0);
		testNumbers.add(3.0);
		
		double mean = stats.findMean(testNumbers);
		double median = stats.findMedian(testNumbers);
		double mode = stats.findMode(testNumbers);
		double stdDev = stats.standardDeviation(testNumbers);
		
		System.out.println("testNumbers = " + testNumbers);
		System.out.println("Average of testNumbers: " + mean);
		System.out.println("Median of testNumbers: " + median);
		System.out.println("Mode of testNumbers: " + mode);
		System.out.println("Standard deviation of testNumbers: " + stdDev);
		
		testNumbers.add(6.0);
		median = stats.findMedian(testNumbers);
		System.out.println();
		System.out.println("testNumbers = " + testNumbers);
		System.out.println("Median of testNumbers: " + median);
	}
}