package Exercise7;

public class Main {

	public static final char SUM_OF_CHARS = 'A' + 'B' + 'C';
	public static final String OUTPUT_FORMAT = "Move the %d. ring from %c to %c!\n";

	public static void SolveHanoi(int n) {
		NextMove(n, 'A', 'C');
	}

	public static void NextMove(int n, char stick1, char stick2) {
		if (n == 0)
			return;
		char stick3 = (char) (SUM_OF_CHARS - stick1 - stick2);
		NextMove(n - 1, stick1, stick3);
		System.out.printf(OUTPUT_FORMAT, n, stick1, stick2);
		NextMove(n - 1, stick3, stick2);
	}

	public static void main(String[] args) {
		SolveHanoi(4);
	}

}
