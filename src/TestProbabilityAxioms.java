/**
 * Tester for ProbabilityAxioms.
 * 
 * @author Ian Mays
 */
public class TestProbabilityAxioms {
	public static void main(String[] args) {
		ProbabilityAxioms probAxioms = new ProbabilityAxioms();
		
		double pA = 0.1;
		double pB = 0.5;
		double pBGivenA = 0.5;
		
		double pIntersection = probAxioms.dependentIntersection(pA, pBGivenA);
		double pUnion = probAxioms.union(pA, pB, pIntersection);
		double pExclusiveUnion = probAxioms.exclusiveUnion(pA, pB, pIntersection);
		
		System.out.println("P(A) = " + pA);
		System.out.println("P(B) = " + pB);
		System.out.println("P(B|A) = " + pBGivenA);
		
		System.out.println("P(A∩B) = " + pIntersection + " (based on P(B|A))");
		System.out.println("P(A∩B) = " + probAxioms.independentIntersection(pA, pB) + " (assuming A and B are independent)");
		System.out.println("P(A∪B) = " + pUnion);
		System.out.println("P(AΔB) = " + pExclusiveUnion);
		System.out.println("A and B are independent? " + probAxioms.areIndependentFromIntersection(pA, pB, pIntersection) + " (based on intersection)");
		System.out.println("A and B are independent? " + probAxioms.areIndependentFromUnion(pA, pB, pUnion) + " (based on union)");
		System.out.println();
		
		double pCIntersectD = 0.05;
		double pD = 0.1;
		
		double pCGivenD = probAxioms.conditionalProbability(pCIntersectD, pD);
		
		System.out.println("P(C∩D) = " + pCIntersectD);
		System.out.println("P(D) = " + pD);
		System.out.println("P(C|D) = " + pCGivenD);
		System.out.println();
		
		double[] pConditionals = {0.5, 0.25, 0.25};
		double[] pFs = {0.2, 0.4, 0.4};
		
		double[] pBayesians = probAxioms.bayesianProbabilities(pConditionals, pFs);
		
		for (int i = 0; i < pFs.length; i++) {
			System.out.printf("P(F%d) = %f\n", i+1, pFs[i]);
		}
		
		for (int i = 0; i < pConditionals.length; i++) {
			System.out.printf("P(E|F%d) = %f\n", i+1, pConditionals[i]);
		}
		
		for (int i = 0; i < pBayesians.length; i++) {
			System.out.printf("P(F%d|E) = %f\n", i+1, pBayesians[i]);
		}
	}
}