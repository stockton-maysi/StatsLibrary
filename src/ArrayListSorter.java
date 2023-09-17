import java.util.ArrayList;

/**
 * Contains a method for sorting an ArrayList while returning the new list instead
 * of overwriting it.
 * 
 * @author Ian Mays
 */
public class ArrayListSorter {
	/**
	 * Copies the elements of an ArrayList to a new ArrayList, then sorts the new one.
	 * @param unsortedList The original ArrayList
	 * @return The sorted ArrayList
	 */
	public ArrayList<Double> sort(ArrayList<Double> unsortedList) {
		ArrayList<Double> sortedList = new ArrayList<>();
		
		for (int i = 0; i < unsortedList.size(); i++) {
			sortedList.add(unsortedList.get(i));
		}
		
		sortedList.sort(null);
		
		return sortedList;
	}
}
