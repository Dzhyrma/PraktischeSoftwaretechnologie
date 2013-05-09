package Exercise4;

public class Main {

	public static void main(String[] args) {
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		stack1.push("Hello");
		stack1.push("World");
		stack1.push("!");
		System.out.println(stack1);
		while(!stack1.isEmpty())
			stack2.push(stack1.pop());
		System.out.println(stack2);
	}

}
