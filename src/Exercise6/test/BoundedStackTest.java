package Exercise6.test;

import Exercise6.stack.*;

public class BoundedStackTest {

	public static void main(String[] args) {
		Stack stack1 = new BoundedStack();
		Stack stack2 = new BoundedStack();
		stack1.push("Hello");
		stack1.push("World");
		stack1.push("!");
		System.out.println("Stack1:             " + stack1);
		while(!stack1.isEmpty())
			stack2.push(stack1.pop());
		System.out.println("Stack2:             " + stack2);
		System.out.println("Stack1:             " + stack1);
		System.out.println("Stack2 peek:        " + stack2.peek());
		System.out.println("Stack2 after peek:  " + stack2);
		stack2.exch();
		System.out.println("Stack2 after exch:  " + stack2);
		stack2.clear();
		System.out.println("Stack2 after clear: " + stack2);
	}

}
