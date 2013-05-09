package Exercise6.test;

import Exercise6.stack.*;

public class DebugStackTest {

	public static void main(String[] args) {
		Stack stack1 = new BoundedStack();
		Stack stack2 = new BoundedStack();
		Stack debugStack1 = new DebugStack("stack1", stack1);
		Stack debugStack2 = new DebugStack("stack2", stack2);
		debugStack1.push("Hello");
		debugStack1.push("World");
		debugStack1.push("!");
		System.out.println(debugStack1);
		while(!debugStack1.isEmpty())
			debugStack2.push(debugStack1.pop());
		System.out.println(debugStack2);
		System.out.println(debugStack1);
		System.out.println(debugStack2.peek());
		System.out.println(debugStack2);
		debugStack2.exch();
		System.out.println(debugStack2);
		debugStack2.clear();
		System.out.println(debugStack2);
	}

}
