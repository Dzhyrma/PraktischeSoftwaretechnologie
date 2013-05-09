package Exercise6.stack;

public class DebugStack implements Stack {
	private static final String INIT_FORMAT_STRING = "DebugStack %s is initialized\n";
	private static final String PUSH_FORMAT_STRING = "String %s is inserted into the DebugStack %s\n";
	private static final String POP_FORMAT_STRING = "String %s is removed from the DebugStack %s\n";
	private static final String IS_EMPTY_FORMAT_STRING = "DebugStack %s method \"isEmpty\" returns value \"%s\"\n";
	private static final String CLEAR_FORMAT_STRING = "DebugStack %s method \"clear\" is invoked\n";
	private static final String EXCH_FORMAT_STRING = "DebugStack %s method \"exch\" is invoked\n";
	private static final String PEEK_FORMAT_STRING = "String %s is peeked from the DebugStack %s\n";
	private static final String TO_STRING_FORMAT_STRING = "DebugStack %s method \"toString\" is invoked\n";
	private String _name;
	private Stack _delegate;

	public DebugStack(String name, Stack delegate) {
		_name = name;
		_delegate = delegate;
		System.out.printf(INIT_FORMAT_STRING, name);
	}

	public void push(String s) {
		_delegate.push(s);
		System.out.printf(PUSH_FORMAT_STRING, s, _name);
	}

	public String pop() {
		String s = _delegate.pop();
		System.out.printf(POP_FORMAT_STRING, s, _name);
		return s;
	}

	public boolean isEmpty() {
		boolean isEmpty = _delegate.isEmpty();
		System.out.printf(IS_EMPTY_FORMAT_STRING, _name, isEmpty);
		return _delegate.isEmpty();
	}

	public void clear() {
		_delegate.clear();
		System.out.printf(CLEAR_FORMAT_STRING, _name);
	}

	public void exch() {
		_delegate.exch();
		System.out.printf(EXCH_FORMAT_STRING, _name);
	}

	public String peek() {
		String s = _delegate.peek();
		System.out.printf(PEEK_FORMAT_STRING, s, _name);
		return s;
	}
	
	public String toString() {
		System.out.printf(TO_STRING_FORMAT_STRING, _name);
		return _delegate.toString();
	}
}
