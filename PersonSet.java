/*
Title: PersonList.java
Name: William Maison-Bush
Date: 10 March 2025
Purpose: The PersonSet.java file manages a collection of Person objects from 
		 hr.txt, ensuring uniqueness by preventing duplicates in the stored 
		 data.
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

// We will be using an arraylist so we need to import it...
import java.util.ArrayList;
import java.lang.StringBuilder;

// This PersonSet class will implement PersonList to retrieve the add and get
// methods. We will override the add method in order to implement a duplicate
// checking function.
public class PersonSet implements PersonList {
	
	// Protected because it is safe.
	protected ArrayList<Person> people;
	
	// Constructor to create an empty array list to populate.
	public PersonSet()
	{
		people = new ArrayList<>();
	}
	
	// This method allows the adding of a person if and only if that person
	// as not been added already based off a Boolean that matches the name,
	// weight, and height. These three need to match because an employee
	// might have the same name but are different people with different 
	// attributes.
	@Override
	public void add(Person person)
	{
		if (equals(person) == false)
		{
			people.add(person);
		}
	} // End of add method
	
	// This method retrieves an individual with the index. It can only be 
	// called with System.out.print(). 
	public Person get(int index)
	{
		// This sets the index rules that the index has to be zero or greater
		// than zero and the index must be less than size of the array list. If
		// these conditions are not met, the method will return "null" into the
		// terminal.
		if (index >=0 && index < people.size())
		{
			return people.get(index);
		}
		return null;
	} // End of get() method.
	
	// This method is the Boolean necessary to prevent duplicates. It takes in
	// an object, iterates through the array list, and if a duplicate is 
	// suspected, it will return true. Otherwise it will return false and this
	// condition is used by the add method to either reject or accept an object
	// accordingly.
	private boolean equals(Person person)
	{
		for (int i = 0; i < people.size(); i++)
		{
			Person p = people.get(i);
			
			// Here is the logic for the reject/accept mechanism. We compare
			// the names and use Double.compare() because I was running into
			// errors using a simple == comparison which I found was because
			// of errors inherent to the nature of comparing doubles. I took
			// this from the provided link to geeksforgeeks.org
			if (p.name.equalsIgnoreCase(person.name) &&
				Double.compare(p.height, person.height) == 0 &&
				Double.compare(p.weight, person.weight) == 0)
			{
				return true; // If there is a duplicate suspected
			}
		}
		return false; // If there are no duplicates suspected
	}
	
	// This is just a printer method. It prints.
	public void printPeople()
	{
		for (int i = 0; i < people.size(); i++)
		{
			System.out.println(people.get(i));
		}
	} // End of printPeople()
	
	// Ovveride toString()
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-8s %12s %20s%n", "Name", 
			"Height (cm)", "Weight (kg)"));
			for (Person p : people) {
				sb.append(p.toString());
			}
			return sb.toString();
	}	
}

// UNMOD