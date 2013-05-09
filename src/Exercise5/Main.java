package Exercise5;

public class Main {

	public static void main(String[] args) {
		DebugStack stack1 = new DebugStack("stack1");
		DebugStack stack2 = new DebugStack("stack2");
		stack1.push("Hello");
		stack1.push("World");
		stack1.push("!");
		System.out.println(stack1);
		while(!stack1.isEmpty())
			stack2.push(stack1.pop());
		System.out.println(stack2);
	}

}
