/**
 * A library of probability calculators based on doubles.<p>
 * WARNING: These are prone to floating point errors.
 * 
 * @author Ian Mays
 */
public class ProbabilityAxioms {
	/**
	 * Calculates the probability of two events intersecting, assuming the probability
	 * of one given another is known.
	 * @param pA The probability of event A
	 * @param pBGivenA The probability of event B, given that A has occurred
	 * @return The intersection probability
	 */
	public double dependentIntersection(double pA, double pBGivenA) {
		return pA*pBGivenA;
	}
	
	/**
	 * Calculates the probability of two events intersecting, assuming that they are
	 * known to be independent.
	 * @param pA The probability of event A
	 * @param pB The probability of event B
	 * @return The intersection probability
	 */
	public double independentIntersection(double pA, double pB) {
		return pA*pB;
	}
	
	/**
	 * Calculates the probability of the union of two events, assuming that the
	 * probability of their intersection is known.
	 * @param pA The probability of event A
	 * @param pB The probability of event B
	 * @param pIntersection The probability of the intersection of A and B
	 * @return The union probability
	 */
	public double union(double pA, double pB, double pIntersection) {
		return pA+pB-pIntersection;
	}
	
	/**
	 * Calculates the probability of the disjunctive union (i.e. A XOR B) of two
	 * events, assuming that probability of their intersection is known.
	 * @param pA The probability of event A
	 * @param pB The probability of event B
	 * @param pIntersection The probability of the intersection of A and B
	 * @return The disjunctive union probability
	 */
	public double exclusiveUnion(double pA, double pB, double pIntersection) {
		return pA+pB-2*pIntersection;
	}
	
	/**
	 * Determines whether two events are independent, based on the probability of
	 * their intersection.
	 * @param pA The probability of event A
	 * @param pB The probability of event B
	 * @param pIntersection The probability of the intersection of A and B
	 * @return true if the events are found to be independent, false otherwise
	 */
	public boolean areIndependentFromIntersection(double pA, double pB, double pIntersection) {
		return pIntersection == pA*pB;
	}
	
	/**
	 * Determines whether two events are independent, based on the probability of
	 * their union.<p>
	 * Seems to be somewhat less reliable than the intersection method, so use at your
	 * own risk.
	 * @param pA The probability of event A
	 * @param pB The probability of event B
	 * @param pIntersection The probability of the union of A and B
	 * @return true if the events are found to be independent, false otherwise
	 */
	public boolean areIndependentFromUnion(double pA, double pB, double pUnion) {
		return (1-pUnion) == (1-pA)*(1-pB);
	}
	
	/**
	 * Calculates the conditional probability of one event given another, assuming
	 * the probability of intersection is known.
	 * @param pIntersection The probability of the intersection of A and B
	 * @param pB The probability of event B
	 * @return The probability of A, given that B has occurred
	 */
	public double conditionalProbability(double pIntersection, double pB) {
		return pIntersection/pB;
	}
	
	/**
	 * Operates on arrays of doubles. Uses Bayes' rule to calculate a set of
	 * conditional probabilities.<p>
	 * Throws an ArrayIndexOutOfBoundsException if the input arrays are not of equal
	 * length.
	 * @param pConditionals An array of conditional probabilities for A given that
	 * each of events B1, B2, ..., Bk have occurred
	 * @param pBs An array of probabilities for events B1, B2, ..., Bk
	 * @return An array of conditional probabilities for each of B1, B2, ..., Bk given
	 * that A has occurred
	 */
	public double[] bayesianProbabilities(double[] pConditionals, double[] pBs) {
		double[] probabilities = new double[Math.max(pConditionals.length, pBs.length)];
		
		for (int i = 0; i < probabilities.length; i++) {
			double denominator = 0;
			
			for (int j = 0; j < probabilities.length; j++) {
				denominator += pConditionals[j]*pBs[j];
			}
			
			probabilities[i] = pConditionals[i]*pBs[i]/denominator;
		}
		
		return probabilities;
	}
}