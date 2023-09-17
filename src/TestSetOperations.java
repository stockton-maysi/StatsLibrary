import java.util.ArrayList;

/**
 * Tester for SetOperations.
 * 
 * @author Ian Mays
 */
public class TestSetOperations {
	public static void main(String[] args) {
		SetOperations sets = new SetOperations();
		
		ArrayList<String> planets = new ArrayList<>();
		ArrayList<String> elements = new ArrayList<>();
		ArrayList<String> metals = new ArrayList<>();
		ArrayList<String> cats = new ArrayList<>();
		
		planets.add("Mercury");
		planets.add("Venus");
		planets.add("Earth");
		elements.add("Mercury");
		elements.add("Carbon");
		elements.add("Tungsten");
		metals.add("Mercury");
		metals.add("Tungsten");
		cats.add("Carbon");
		cats.add("Tungsten");
		cats.add("Bootsy");
		
		System.out.println("planets = " + planets);
		System.out.println("elements = " + elements);
		System.out.println("cats = " + cats);
		System.out.println();
		System.out.println("planets ∪ elements = " + sets.union(planets, elements));
		System.out.println("planets ∪ cats = " + sets.union(planets, cats));
		System.out.println("elements ∪ cats = " + sets.union(elements, cats));
		System.out.println();
		System.out.println("planets ∩ elements = " + sets.intersection(planets, elements));
		System.out.println("planets ∩ cats = " + sets.intersection(planets, cats));
		System.out.println("elements ∩ cats = " + sets.intersection(elements, cats));
		System.out.println();
		System.out.println("elements \\ metals (complement of metals) = " + sets.complement(elements, metals));
	}
}