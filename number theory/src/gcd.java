import java.util.Scanner;
public class gcd {
	/* the bigger int is a and smaller int b */
	public static int euclidean(int a, int b) {
		int r = a % b;
		if (r == 0) {
			return b;
		}
		else {
			return euclidean(b, r);
		}
	}
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Type in the first number");
		int a = s.nextInt();
		System.out.println("Type in the second number");
		int b = s.nextInt();
		if (Math.max(a, b) == a) {
			System.out.println(euclidean(a, b));
		} else {
			System.out.println(euclidean(b,a));
		}
	}
}
