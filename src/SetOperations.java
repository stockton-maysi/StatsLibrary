import java.util.ArrayList;

/**
 * A library of set theory operations on ArrayLists. To be expanded as the semester
 * progresses. <p>
 * Note that some of these methods assume that input ArrayLists will not contain
 * duplicate elements.
 * 
 * @author Ian Mays
 */
public class SetOperations {
	/**
	 * Finds the union of two sets, i.e. the set containing all elements from A
	 * and/or B.
	 * @param a The first ArrayList
	 * @param b The second ArrayList
	 * @return The ArrayList representing the union
	 */
	public ArrayList<String> union(ArrayList<String> a, ArrayList<String> b) {
		ArrayList<String> union = new ArrayList<>();
		String currentElement;
		
		for (int i = 0; i < a.size()+b.size(); i++) {
			if (i >= a.size()) {
				currentElement = b.get(i - a.size());
			} else {
				currentElement = a.get(i);
			}
			
			//Check if the element is already in the union set
			boolean duplicateFound = false;
			
			for (int j = 0; j < union.size(); j++) {
				if (union.get(j).equals(currentElement)) {
					duplicateFound = true;
				}
			}
			
			if (!duplicateFound) {
				union.add(currentElement);
			}
		}
		
		return union;
	}
	
	/**
	 * Finds the intersection of two sets, i.e. the set containing only elements that
	 * are members of both A and B.
	 * @param a The first ArrayList
	 * @param b The second ArrayList
	 * @return The ArrayList representing the intersection
	 */
	public ArrayList<String> intersection(ArrayList<String> a, ArrayList<String> b) {
		ArrayList<String> intersection = new ArrayList<>();
		
		for (int i = 0; i < a.size(); i++) {
			String currentElement = a.get(i);
			boolean intersectionFound = false;
			
			for (int j = 0; j < b.size(); j++) {
				if (b.get(j).equals(currentElement)) {
					intersectionFound = true;
				}
			}
			
			if (intersectionFound) {
				intersection.add(currentElement);
			}
		}
		
		return intersection;
	}
	
	/**
	 * Finds the complement of one set with respect to another, i.e. the set of
	 * elements in A but not B. Despite the parameter names, B does not necessarily
	 * have to be a subset of A for this to work.
	 * @param set The set which elements of the complement must be members of
	 * @param subset The set which elements of the complement must NOT be members of
	 * @return The complement of the subset with respect to the main set
	 */
	public ArrayList<String> complement(ArrayList<String> set, ArrayList<String> subset) {
		ArrayList<String> complement = new ArrayList<>();
		
		for (int i = 0; i < set.size(); i++) {
			String currentElement = set.get(i);
			boolean intersectionFound = false;
			
			for (int j = 0; j < subset.size(); j++) {
				if (subset.get(j).equals(currentElement)) {
					intersectionFound = true;
				}
			}
			
			if (!intersectionFound) {
				complement.add(currentElement);
			}
		}
		
		return complement;
	}
}
