/*
Title: PersonList.java
Name: William Maison-Bush
Date: 10 March 2025
Purpose: The PersonList.java file manages a collection of Person objects from 
		 hr.txt, providing methods to store, retrieve, and process the data 
		 while allowing duplicates.
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

// This interface sets the rules or "contract" that PersonSet will used through
// implementation. One of these will be overridden in PersonSet; however, these
// basic methods are necessary.
public interface PersonList {
	// This method takes a Person as input and returns void.
	void add(Person person);
	
	// This method takes an int as input and returns a Person at the
	// corresponding index of the input int.
	Person get(int index);
	
} // End of interface PersonList


// UNMOD