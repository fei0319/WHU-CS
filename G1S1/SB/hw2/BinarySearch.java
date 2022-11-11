import java.util.*;

/**
 * This program is a demonstration of binary searching.
 * @homework_id G1S1.SB.HW2
 */

class BinarySearch
{
	public static final double EPS = 1e-7;
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		System.out.printf("Enter two numbers l, r, seperated by a space:");
		double l = in.nextDouble(), r = in.nextDouble();
		
		while(r - l > EPS){
			double mid = (l + r) / 2;
			if((f(l) < 0) != (f(mid) < 0))
				r = mid;
			else
				l = mid;
		}
		
		System.out.printf("One solution of equation f(x) = 0 is %.6f.", l);
	}
	
	private static double f(double x)
	{
		return x * x + Math.log(x * x + 1) + x - 32;
	}
}