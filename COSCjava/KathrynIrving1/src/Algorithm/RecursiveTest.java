package Algorithm;

public class RecursiveTest {

	public static int A (int x, int y)
	
	{
		if (x == 0) return 1;
		if (x == 1 && y == 0) return 2;
		if (y == 0) return (x+2);
		return A(A(x-1,y), y-1);
	}
}
