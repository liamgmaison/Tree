/*
Title: PersonOrderedSet.java
Name: William Maison-Bush
Date: 19 March 2025
Purpose: The purpose of PersonOrderedSet.java is to store a set of Person 
        objects while ensuring they are always sorted alphabetically by name 
        and formatted for output in metric units (cm and kg).
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

import java.util.Collections;

// This first establishes PersonOrderedSet as a subclass of PersonSet through
// extends. It inherits all the functions of PersonSet with some overrides to
// these basic methods. We can add people into an array list and also prevent
// any duplications in the add method. We override this add method to sort
// the unduplicated people alphabetically.
public class PersonOrderedSet extends PersonSet {
    // First override allows us to modify the add super method so that we can
    // sort the people as they are added using collections.sort().
    @Override
    public void add(Person p) {
        super.add(p);
        Collections.sort(people);
        } // End of add() method
    
    // This second override method is for the toString() method. We are using
    // string builder to format the heading of the output to be with metric 
    // units rather than good ol' murican units. Then we use the getters to, 
    // well, get the name, height, and weight for output using a for loop
    // for each line. This for loop is the for-each loop because I need to save
    // time.
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-8s %12s %20s%n", "Name", "Height (cm)", "Weight (kg)"));
        
        for (Person p : people) {
            sb.append(String.format("%-8s %12.0f %20.0f%n", p.getName(), 
                p.getHeight(), p.getWeight())); // No decimals
        }
        // This finally converts the sb object containing the information and
        // returns it as a string so we can print it and output it.
        return sb.toString();
    } // End of toString() method
} // End of PersonOrderedSet