import javax.swing.tree.*;

public class SortedTreeSet implements SortedTreeSetInterface {
	
	// I am creating a node structure for a tree. This node has a person
	// object and has two "children" pointers to its left and right. I took
	// this general structure from multiple resource recommendations.
	private class TreeNode {
		// Holds a person object named person
		Person person;
		// And has pointers to left and right
		TreeNode left;
		TreeNode right;
	// This is the constructor for this node which when created stores a 
	// default person and starts with no left or right "children." Still
	// weird to type that.
		TreeNode(Person person) {
			this.person = person;
			left = null;
			right = null;
		} // End of constructor
	} // End of TreeNode class
	
	// We start with the root of the tree. All these tree metaphors are 
	// really . . . interesting. Anyway, we create a private TreeNode
	// called root.
	private TreeNode root;
	// onstructor for the SortedTreeSet class that initializes the root
	// to be null, empty, void, like space ever eternal. 
	public SortedTreeSet() {
		root = null;
	} // End of SortedTreeSet Constructor.

	@Override
	public void add(Person person) {
		root = insertPerson(root, person);
	} // End of add() method
	
	// Node is the current node we are dealing with and person is the uh 
	// person object that we want to store in that node.
	private TreeNode insertPerson(TreeNode node, Person person) {
		if (node == null) {
			// This creates the node with information imbedded.
			return new TreeNode(person);
		}
		// node.person from TreeNode using getter method from Person returns
		// the name of the current name in the tree right now that the person
		// in question's name is being compared to and we store a value into
		// compareNode. If person.getName() is alphabetically earlier than 
		// node.person.getName(), compareNode will be negative. 
		// If person.getName() is alphabetically later than 
		// node.person.getName(), compareNode is positive. If they are equal
		// than compareNode == 0. We will have it so negative values go left
		// and positive values go right. Duplicates, when compareNode == 0, are
		// eliminated in real time.
		int compareNode = person.getName().compareToIgnoreCase(node.person.getName());
		
		// The comparative part of this program as explained above
		if (compareNode < 0) {
			node.left = insertPerson(node.left, person);
		} else if (compareNode > 0) {
			node.right = insertPerson(node.right, person);
		}
		return node;
	} // End of insertPerson()
	
	// This is the toString() method that returns a print of the storted string
	// stored in the entire tree. It uses string builder and requires the help
	// of buildString to walk along the tree and create a string to print.
	@Override
	public String toString() {
		StringBuilder stringBuild = new StringBuilder();
		stringBuild.append(String.format("%-8s %12s %20s%n", "Name", "Height (in)", 
			"Weight (lbs)"));
		buildString(root, stringBuild);
		stringBuild.append("\nThank you!\n");
		return stringBuild.toString();
	}
	
	// This is the helper method buildString that works as long as the node
	// is not null and slowly walks along the tree and assorts the nodes.
	// String builder was recommended over concatenation.
	private void buildString(TreeNode node, StringBuilder stringBuild) {
		if (node != null) {
			buildString(node.left, stringBuild);
			stringBuild.append(node.person.toString()).append("");
			buildString(node.right, stringBuild);
		} // End of if statement
	} // End of buildString
	
} // End of SortedTreeSEt