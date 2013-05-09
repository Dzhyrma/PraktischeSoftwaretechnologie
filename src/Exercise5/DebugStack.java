package Exercise5;

public class DebugStack extends Stack {
	private static final String INIT_FORMAT_STRING = "DebugStack %s is initialized\n";
	private static final String PUSH_FORMAT_STRING = "String %s is inserted into the DebugStack %s\n";
	private static final String POP_FORMAT_STRING = "String %s is removed from the DebugStack %s\n";
	private String _name;

	public DebugStack(String name) {
		_name = name;
		System.out.printf(INIT_FORMAT_STRING, name);
	}

	public void push(String s) {
		super.push(s);
		System.out.printf(PUSH_FORMAT_STRING, s, _name);
	}

	public String pop() {
		String s = super.pop();
		System.out.printf(POP_FORMAT_STRING, s, _name);
		return s;
	}
}
