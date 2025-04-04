/*
Title: PersonImperialSet.java
Name: William Maison-Bush
Date: 19 March 2025
Purpose: The PersonImperialSet class extends PersonSet and converts a Person 
		object’s height from centimeters to inches and weight from kilograms to 
		pounds, ensuring the data is stored in imperial units while preserving 
		the original metric values.

Sources: Java - How to Program - Late Objects 11th Edition Deitel et al
https://www.w3schools.com/java/java_interface.asp
https://www.w3schools.com/java/java_arraylist.asp
https://www.w3schools.com/java/java_polymorphism.asp
https://youtu.be/GhslBwrRsnw?si=WRK-p3-LHWTUA205
https://youtu.be/2hkngtWLGvE?si=jtTT5PVTLpsXpzGk
2251 Example Files
https://www.geeksforgeeks.org/overriding-equals-method-in-java/
}"
*/

// PersonSet already prevents duplicates and has the add() and toString() 
// methods for this class to work with in order to change the metric values
// into Imperial values.
public class PersonImperialSet extends PersonSet {
	
	// Our first override is to change those metric values into proper American
	// values with unit converstions and multiplication.
	@Override
	public void add(Person p)
	{
		// This is where the American Imperialism happens...
		Double heightInch = p.getHeight() * (1.0/2.54);
		Double weightPound = p.getWeight() * 2.20462;
		
		// After experiencing ample eagle noises, we now create a new Person
		// object that does not modify the orignal metric object and instead
		// is a new object that stores imperial information.
		Person convertedPerson = new Person(p.getName(),
			heightInch, weightPound);
		
		// Now we use the add method to the array list which has stored the 
		// imperial values.
		super.add(convertedPerson);
	} // End of add() method
	
	// This is the override for the toString() method. This creates a header
	// that has imperial values rather than metric values. Queue even more
	// eagle noises that are actually not even real eagle noises...
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-8s %12s %20s%n", "Name", "Height (in)", 
			"Weight (lbs)"));
		
		// Uses a for-each loop to add the information for each person so we
		// can print them and store them.
		for (Person p : people) {
			sb.append(String.format("%-8s %12.2f %20.2f%n", p.getName(), 
				p.getHeight(), p.getWeight()));
		} // End of the for-each loop
		
		// We need this a normal string so that we can print and output the
		// information
		return sb.toString();
	} // End of toString() method
	
} // End of PersonOrderedSet