package Exercise5;

public class Stack {
	private static final String BRACKETS_STRING = "[]";
	private static final String COMA_AND_SPACE_STRING = ", ";
	private Stack _last = null;
	private String _value = null;
	private Stack(String value, Stack last) {
		_value = value;
		_last = last;
	}
	private String toString2() {
		return (_last == null) ? "" : (_last.toString2() + _last._value + COMA_AND_SPACE_STRING);
	}
	
	public Stack() {
	}
	
	public void push(String s) {
		_last = new Stack(s, _last);
	}
	
	public String pop() {
		if (_last == null)
			return null;
		String result = _last._value;
		_last = _last._last;
		return result;
	}
	
	public boolean isEmpty() {
		return _last == null;
	}
	
	public String toString() {
		return (_last == null) ? BRACKETS_STRING : '[' +_last.toString2() + _last._value + ']';
	}
}
