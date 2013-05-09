package Exercise8;

public class BinarySearchTree {

	private static final String NO_ELEMENT_IN_THE_TREE_STRING = "Sorry, there is no such element in the tree!";
	private static final String NO_ELEMENT_ON_THE_LEAF_STRING = ". This leaf is empty. Sorry, there is no such element in the tree!";
	private static final String ROOT_STRING = "Root: ";
	private static final String LEFT_STRING = " Left ";
	private static final String RIGHT_STRING = " Right ";
	private static final String EMPTY_STRING = "";
	
	private TreeElement root;
	
	private String binarySearch(int n, TreeElement leaf)
	{
		int value = leaf.getValue();
		if (value == n) return EMPTY_STRING;
		if (n < value) {
			TreeElement leftLeaf = leaf.getLeft();
			return LEFT_STRING + ((leftLeaf == null) ? NO_ELEMENT_ON_THE_LEAF_STRING : leftLeaf.getValue() + binarySearch(n, leftLeaf));
		}
		TreeElement rightLeaf = leaf.getRight();
		return RIGHT_STRING + ((rightLeaf == null) ? NO_ELEMENT_ON_THE_LEAF_STRING : rightLeaf.getValue() + binarySearch(n, rightLeaf));
	}

	public BinarySearchTree() {
		root = null;
	}

	public boolean isEmpty() {
		if (root == null) return true;
		return false;
	}
	
	public String search(int n)
	{
		if (root == null) return NO_ELEMENT_IN_THE_TREE_STRING;
		return ROOT_STRING + root.getValue() + binarySearch(n , root);
	}

	public String toString() { // ranging over the tree by "inorder" manner
		if (root == null) return "";
		return root.toString();
	}

	public void insert(int value) {
		boolean inserted = false;
		TreeElement newElement = new TreeElement(value);

		if (root == null) {
			root = newElement;
		} else {
			TreeElement tmp = root;
			while (!inserted) {

				if (tmp.getValue() == value) {
					inserted = true;
				} else if (tmp.getValue() > value) {
					if (tmp.getLeft() != null) {
						tmp = tmp.getLeft();
					} else {
						tmp.setLeft(newElement);
						inserted = true;
					}
				} else {
					if (tmp.getRight() != null) {
						tmp = tmp.getRight();
					} else {
						tmp.setRight(newElement);
						inserted = true;
					}
				}
			}
		}
	}
}