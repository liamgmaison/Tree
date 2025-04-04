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
		
	
} // End of SortedTreeSEt