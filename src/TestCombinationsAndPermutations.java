/**
 * Tester for CombinationsAndPermutations. Finds the number of ways to choose 10
 * objects from a set of 20 objects, both unordered and ordered.
 * 
 * @author Ian Mays
 */
public class TestCombinationsAndPermutations {
	public static void main(String[] args) {
		CombinationsAndPermutations comsAndPerms = new CombinationsAndPermutations();
		System.out.println("20! = " + comsAndPerms.factorial(20));
		System.out.println("C(20, 10) = " + comsAndPerms.combinations(20, 10));
		System.out.println("P(20, 10) = " + comsAndPerms.permutations(20, 10));
	}
}
