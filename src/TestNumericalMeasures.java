import java.util.ArrayList;

/**
 * Tester for NumericalMeasures. Among other things, tests median with both odd- and
 * even-sized lists.
 * 
 * @author Ian Mays
 */
public class TestNumericalMeasures {
	public static void main(String[] args) {
		NumericalMeasures measures = new NumericalMeasures();
		
		ArrayList<Double> testNumbers = new ArrayList<>();
		
		testNumbers.add(2.0);
		testNumbers.add(4.0);
		testNumbers.add(4.0);
		testNumbers.add(1.0);
		testNumbers.add(3.0);
		
		double mean = measures.findMean(testNumbers);
		double median = measures.findMedian(testNumbers);
		double mode = measures.findMode(testNumbers);
		double variance = measures.variance(testNumbers);
		double stdDev = measures.standardDeviation(testNumbers);
		
		System.out.println("testNumbers = " + testNumbers);
		System.out.println("Average of testNumbers: " + mean);
		System.out.println("Median of testNumbers: " + median);
		System.out.println("Mode of testNumbers: " + mode);
		System.out.println("Variance of testNumbers: " + variance);
		System.out.println("Standard deviation of testNumbers: " + stdDev);
		
		testNumbers.add(6.0);
		median = measures.findMedian(testNumbers);
		System.out.println();
		System.out.println("testNumbers = " + testNumbers);
		System.out.println("Median of testNumbers: " + median);
	}
}