package Exercise8;

public class Test {
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();

    tree.insert(47);
    tree.insert(74);
    tree.insert(21);
    tree.insert(99);
    tree.insert(51);
    tree.insert(15);
    tree.insert(65);
    tree.insert(36);
    tree.insert(83);
    tree.insert(59);
        
    System.out.println("The content of the tree by an \"inorder\" ranging is " + tree);
    
    System.out.println("The path of searching number 59 is: " + tree.search(59));
    System.out.println("The path of searching number 22 is: " + tree.search(22));

  }
}
