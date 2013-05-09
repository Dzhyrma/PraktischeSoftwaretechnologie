package Exercise2;
public class Hallo {
	private static final String AND_STRING = " and ";
	private static final String COMA_STRING = ", ";
	private static final String HALLO_STRING = "Hallo";
	private static final String WHO_IS_THERE_STRING = "Who is there?";
	public static void main(String args[]) {
		String result = "";
		if(args.length == 0)
			result += WHO_IS_THERE_STRING;
		else if(args.length == 1)
			result += HALLO_STRING + ' ' + args[0] + '!';
		else 
		{
			result += HALLO_STRING + ' ' + args[0];
			for(int i = 0; i < args.length - 2; i++)
				result += COMA_STRING + args[1 + i];
			result += AND_STRING + args[args.length - 1] + '!';
		}
		System.out.println(result);
    }
}
