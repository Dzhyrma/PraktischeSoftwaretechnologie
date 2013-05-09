package Exercise8;

public class TreeElement {
  private int value;
  private TreeElement left, right;

  public TreeElement(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public int getValue() {
    return value;
  }

  public TreeElement getLeft() {
    return left;
  }

  public TreeElement getRight() {
    return right;
  }

  public void setLeft(TreeElement left) {
    this.left=left;
  }

  public void setRight(TreeElement right) {
    this.right=right;
  }

  public String toString() { 
    StringBuilder sb = new StringBuilder();
    if (left != null) sb.append(left.toString());
    sb.append(value+" ");    
    if (right != null) sb.append(right.toString());       
    return sb.toString(); 
  } 
}