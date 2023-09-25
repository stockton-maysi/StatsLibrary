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
	}
}