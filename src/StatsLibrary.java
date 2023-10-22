import java.util.ArrayList;

/**
 * A library of statistical operations on ArrayLists. To be expanded as the semester
 * progresses.
 * 
 * @author Ian Mays
 */
public class StatsLibrary {
	private ArrayListSorter sorter = new ArrayListSorter();
	private StatsExceptionChecker checkFor = new StatsExceptionChecker();
	
	/**
	 * Finds the mean (average) of a list of numbers.
	 * @param userInputNumbers The list of numbers
	 * @return The average of the list
	 * @throws StatsException if the list is empty
	 */
	public double findMean(ArrayList<Double> userInputNumbers) {
		checkFor.arrayNotBigEnough(userInputNumbers, 1);
		
		double sum = 0;
		
		for (double singleElement : userInputNumbers) {
			sum += singleElement;
		}
		
		double result = sum / userInputNumbers.size();
		
		return result;
	}
	
	/**
	 * Finds the median of a list of numbers, i.e. the middle value when the list is
	 * sorted in ascending order. If there is an even number of values, the median is
	 * the average of the middle two values.
	 * @param userInputNumbers The list of numbers
	 * @return The median
	 * @throws StatsException if the list is empty
	 */
	public double findMedian(ArrayList<Double> userInputNumbers) {
		checkFor.arrayNotBigEnough(userInputNumbers, 1);
		
		ArrayList<Double> sortedNumbers = sorter.sort(userInputNumbers);
		
		if (sortedNumbers.size() % 2 == 0) {
			double leftSide = sortedNumbers.get(sortedNumbers.size()/2 - 1);
			double rightSide = sortedNumbers.get(sortedNumbers.size()/2);
			
			return (leftSide+rightSide)/2;
		} else {
			return sortedNumbers.get(sortedNumbers.size()/2);
		}
	}
	
	/**
	 * Finds the mode of a list of numbers, i.e. the most commonly occurring value.
	 * For now, multimodal distributions, where there is a tie between two or
	 * more distinct values, will return the smallest such value.
	 * @param userInputNumbers The list of numbers
	 * @return The mode
	 * @throws StatsException if the list is empty
	 */
	public double findMode(ArrayList<Double> userInputNumbers) {
		checkFor.arrayNotBigEnough(userInputNumbers, 1);
		
		ArrayList<Double> sortedNumbers = sorter.sort(userInputNumbers);
		
		int maxCount = 0;
		int maxCountIndex = 0;
		int currentCount = 0;
		double lastNumber = sortedNumbers.get(0);
		
		for (int i = 0; i < sortedNumbers.size(); i++) {
			double currentNumber = sortedNumbers.get(i);
			
			if (i != 0) {
				lastNumber = sortedNumbers.get(i-1);
			}
			
			if (currentNumber == lastNumber) {
				currentCount++;
				
				if (currentCount > maxCount) {
					maxCount = currentCount;
					maxCountIndex = i;
				}
			} else {
				currentCount = 1;
			}
		}
		
		return sortedNumbers.get(maxCountIndex);
	}
	
	/**
	 * Finds the variance of a list of numbers. This is calculated as follows: <p>
	 * 1. Find the mean. <p>
	 * 2. Find each value's absolute deviation from the mean. <p>
	 * 3. Square each absolute deviation from step 2. <p>
	 * 4. Add up the squares from step 3. <p>
	 * 5. Subtract one from the total number of values in the list. <p>
	 * 6. Divide the sum from step 4 by the divisor from step 5.
	 * 
	 * @param userInputNumbers The list of numbers
	 * @return The variance
	 * @throws StatsException if the list does not contain at least two elements
	 */
	public double variance(ArrayList<Double> userInputNumbers) {
		checkFor.arrayNotBigEnough(userInputNumbers, 2);
		
		double mean = findMean(userInputNumbers);
		
		double sum = 0;
		for (double singleElement : userInputNumbers) {
			double deviation = singleElement - mean;
			sum += deviation * deviation;
		}
		
		double result = sum / (userInputNumbers.size() - 1);
		
		return result;
	}
	
	/**
	 * Finds the standard deviation of a list of numbers. This is just the square root
	 * of the variance.
	 * @param userInputNumbers The list of numbers
	 * @return The standard deviation
	 * @throws StatsException if the list does not contain at least two elements
	 */
	public double standardDeviation(ArrayList<Double> userInputNumbers) {
		return Math.sqrt(variance(userInputNumbers));
	}
}