/*
Title: Main.java
Name: William Maison-Bush
Date: 10 March 2025
Purpose: The Main.java file processes data from hr.txt, using PersonList and 
		 PersonSet to manage Person objects while handling duplicates.
Sources: Java - How to Program - Late Objects 11th Edition Deitel et al
https://www.w3schools.com/java/java_interface.asp
https://www.w3schools.com/java/java_arraylist.asp
https://www.w3schools.com/java/java_polymorphism.asp
https://youtu.be/GhslBwrRsnw?si=WRK-p3-LHWTUA205
https://youtu.be/2hkngtWLGvE?si=jtTT5PVTLpsXpzGk
2251 Example Files
ChatGPT: "What am I doing wrong because this code is not getting rid of
		  duplicates?" Response: Fix: Use == 0 for Exact Comparison
https://www.geeksforgeeks.org/overriding-equals-method-in-java/
}"
*/

// Imports
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;


public class Main 
{
	public static void main(String[] args) 
	{
		
		// A: Create a test person object
		
//		Person testPerson = new Person("Vault Dweller", 180.0, 180.0);
//		System.out.println(testPerson);
		
		// B: Create a PersonSet object
		
		// We will be using this PersonSet object to store Person objects that
		// contains information gathered by the while loop below. The output
		// is to simply confirm that the PersonSet object has been created. It
		// is important to remember that the PersonSet object uses an ArrayList
		// to store the Person objects that are created by the while loop.
		SortedTreeSet personSet = new SortedTreeSet();
		
		// C: Read in data from hr.txt
		
		// Now we can read in any file without hard coding hr.txt.
		String inputFile = args[0];
		
		// Created two sets. orderedSet will store alphabetically sorted
		// information.
//		PersonOrderedSet orderedSet = new PersonOrderedSet();
		SortedTreeSet orderedSet = new SortedTreeSet();
		// imperialSet will store height and weight in inches and pounds.
		PersonImperialSet imperialSet = new PersonImperialSet();
		
		
		// The try loop is for exception handling which is important when 
		// gathering data input from an external file. I didn't know I could
		// condense the code by instantiating in the try block. So cool!
		try (Scanner fileReader = new Scanner (new File(inputFile)))
		{
			// This if statement skips the header.
			// It first checks if the document has an empty line immediately
			// with .hasNextLine(), but if not, it skips the line and starts 
			// entering information.
			if (fileReader.hasNextLine())
			{
				fileReader.nextLine();
			} // End of if statement
			
			// This while loop takes in the ifnormation and stores it it as a 
			// string for name, double for height, and double for weight. It
			// takes this information and creates a Person object named
			// newPerson and adds the information into that object. It then
			// adds the newPerson object tot he personSet using the personSet
			// add method.
			while (fileReader.hasNextLine())
			{
				// These are the attributes that will be stored in the object
				// newPerson.
				String name = fileReader.next();
				Double height = fileReader.nextDouble();
				Double weight = fileReader.nextDouble();
				
//				// Once we have the attributes, we will pass them into a Person
//				// object that is called newPerson.
//				Person newPerson = new Person(name, height, weight);
//				// Then we will add this Person object to personSet, which is
//				// an object that is also an array list. We use the add method
//				// that is in PersonSet that has been inherited from PersonList
//				// but has been overriden to check for duplicates.
//				personSet.add(newPerson);
				
				// We create two new objects, personMetric and personCopy.
				// personMetric will store the metric values as the original. 
				// This is so I can simply use it to sort and not modify it
				// when converting. The second copy is what I need to modify
				// the original code and turn the values into imperial values.
				Person personMetric = new Person(name, height, weight);
				Person personCopy = new Person(personMetric);
				
				// We use the add methods which will either modify the data
				// or sort automatically. Really cool!
				orderedSet.add(personMetric);
				imperialSet.add(personCopy);
				
			} // End of while loop
			
			// Once all the data has been entered into personSet, we close the 
			// scanner.
			fileReader.close();
			
			// This is the catch part of the try-catch. My IDE automatically
			// filled in the block, so I modified it a little. I also added 
			// System.exit(1) to allow the program to simply exit without 
			// breaking.
		} catch (Exception e) {
			// Prints the error in case hr.text is not found.
			System.out.println("\nERROR: FILE NOT FOUND!\n");
			// Exits the program with the error message instead of the 
			// terminal default error codes.
			System.exit(1);
		} // End of try catch.
		
		// Here we are writing out the outputs into text documents in the root
		// directory where main is located. They are modified and formatted. 
		// They also have no duplicates.
		writeToFile("hr_ordered_set_output.txt", orderedSet);
//		writeToFile("hr_imperial_set_output.txt", imperialSet);
		
		// Informs the user to check their directory for the file outputs.
//		System.out.println("\nTwo files have been made. Check directory.");
		System.out.println("\nOne file have been made. Check directory.");
		
		// Print both sets to the console for the user to see a preview of what
		// they ordered.
		System.out.println("\nOrdered Tree Set:");
		System.out.println(orderedSet);
		
//		System.out.println("\nImperial Set (USA! USA!):");
//		System.out.println(imperialSet);
	} // End of main...whew!
	
	// A new method to write to file. It first opens a new file named filename
	// and then it writes using the toString method. There is a try and catch
	// loop in this if somehow the writer fails.
	private static void writeToFile(String filename, Object set)
	{
		try (BufferedWriter shakespeare = new BufferedWriter(new FileWriter(filename)))
		{
			shakespeare.write(set.toString());
		} catch (IOException e)
		{
			e.printStackTrace();
		} // End of try-catch
	} // End of writeToFile
	
} // End of Main

/*
Overall Feedback
Code is mostly great, but I would like the output formatted the same as hr.txt, like this:

return String.format("%-8s %12.0f %20.0f\n", name, height, weight);

Also, I should be able to load in different files from the command prompt with something like java Main hr.txt, which means that the input file should not be hard coded like this: File file = new File("hr.txt"); but should use the input arguments: File file = new File(args[0]);
*/