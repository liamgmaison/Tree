/*
Title: Person.java
Name: William Maison-Bush
Date: 10 March 2025
Purpose: The Person.java file defines the Person class, representing 
		 individuals from hr.txt with attributes like height and weight, 
		 and includes methods for comparison and data handling.
Sources: Java - How to Program - Late Objects 11th Edition Deitel et al
https://www.w3schools.com/java/java_interface.asp
https://www.w3schools.com/java/java_arraylist.asp
https://www.w3schools.com/java/java_polymorphism.asp
https://youtu.be/GhslBwrRsnw?si=WRK-p3-LHWTUA205
https://youtu.be/2hkngtWLGvE?si=jtTT5PVTLpsXpzGk
https://www.geeksforgeeks.org/comparable-interface-in-java-with-examples/#
2251 Example Files
https://www.geeksforgeeks.org/overriding-equals-method-in-java/
}"
*/

// This the creation of the class Person which holds the attributes name, 
// height, and weight.
public class Person implements Comparable<Person> {
	
	// These attributes are supposed to be public because they need to be 
	// accessed universally.
	public String name;
	public Double height;
	public Double weight;
	
	// Constructor
	// This sets the construction of the class Person with the attributes 
	// for name, height, and weight.
	public Person(String name, Double height, Double weight)
	{
		this.name = name;
		this.height = height;
		this.weight = weight;
	} // End of Constructor
	
	public Person(Person p)
	{
		this.name = p.name;
		this.height = p.height;
		this.weight = p.weight;
	} // NEW: Copy of Constructor. I had some trouble with this program and 
	  // realised that PersonImperialSet required a new person object with the
	 // same values. Otherwise modifying the original version would modify both.
	
	// Getters
	public String getName()
	{
		return name; 
	} // End of getName()
	
	public Double getHeight()
	{
		return height;
	} // End of getHeight()
	
	public Double getWeight()
	{
		return weight;
	} // End of getWeight()
	
	// Setters
	public void setName(String name)
	{
		this.name = name;
	} // End of setName()
	
	public void setHeight(Double height)
	{
		this.height = height;
	} // End of setHeight()
	
	public void setWeight(Double weight)
	{
		this.weight = weight;
	} // End of setWeight()
	
	// This method allows sorting alphabetically and uses collections.sort in
	// PersonOrderedSet to accomplish this.
	@Override
	public int compareTo(Person other)
	{
		return this.name.compareToIgnoreCase(other.name);
	} // End of Override of compareTo() method
	
	// toString() method that can display Name, Height, and Weight
	@Override
	public String toString()
	{
		return String.format("%-8s %-12.2f %20.2f%n", name, height, weight, 
			name, height, weight);
	} // End of Override of toString() method.
	
} // End of class Person

/*
Overall Feedback
Code is mostly great, but I would like the output formatted the same as hr.txt, like this:

return String.format("%-8s %12.0f %20.0f\n", name, height, weight);

Also, I should be able to load in different files from the command prompt with something like java Main hr.txt, which means that the input file should not be hard coded like this: File file = new File("hr.txt"); but should use the input arguments: File file = new File(args[0]);
*/