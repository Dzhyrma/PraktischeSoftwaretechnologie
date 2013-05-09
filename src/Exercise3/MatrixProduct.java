package Exercise3;
public class MatrixProduct {
	private static final int[][] A = {{1, 2, 3, 4, 5},
									  {2, 2, 3, 4, 5},
									  {3, 2, 3, 4, 5},
									  {4, 2, 3, 4, 5}};
	private static final int[][] B = {{1, 2, 3, 4},
							   		  {1, 2, 3, 4},
							   		  {1, 2, 3, 4},
							   		  {1, 2, 3, 4},
							   		  {1, 2, 3, 4}};
	private static int[][] Mult(int[][] a, int[][] b)
	{
		if(a.length == 0 || b.length == 0 || a[0].length != b.length)
			return null;
		int[][] c;
		c = new int[a.length][b[0].length];
		for(int i = 0; i < a.length; i++)
			for(int j = 0; j < b[0].length; j++)
			{
				int cell = 0;
				for(int k = 0; k < b.length; k++)
					cell += a[i][k] * b[k][j];
				c[i][j] = cell;
			}
		return c;
	}
	private static void PrintMatrix(int[][] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
				System.out.printf("%5d", a[i][j]);
			System.out.println();
		}
	}
	public static void main(String args[]) {
		PrintMatrix(Mult(A,B));
	}
}
