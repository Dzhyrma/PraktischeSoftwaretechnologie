package Exercise6.stack;

public abstract class AbstractStack implements Stack {

	public abstract void push(String s);

	public abstract String pop();

	public abstract boolean isEmpty();

	public abstract String toString();

	public void clear() {
		while (!isEmpty())
			pop();
	}

	public void exch() {
		if (!isEmpty()) {
			String s1 = pop();
			if (!isEmpty()) {
				String s2 = pop();
				push(s1);
				push(s2);
			} else
				push(s1);
		}
	}

	public String peek() {
		if (isEmpty()) return null;
		String result = pop();
		push(result);
		return result;
	}

}