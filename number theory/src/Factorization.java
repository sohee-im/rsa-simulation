import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Factorization
{
	private static ArrayList<Integer> primes = new ArrayList<Integer>();
	
	public static boolean isPrime (long num) {
		int bound = (int) Math.sqrt((double) num);
		for (int i = 2 ; i <= bound ; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static long[] Fermat (long value) {
		long[] factors = new long[2];
		
		int s = (int) Math.sqrt(value);
		int t = (int) Math.sqrt(Math.pow(((int) s), 2) - value);
		while ((Math.pow(s, 2) != value + Math.pow(t, 2))) {
			s ++;
			t = (int) (Math.sqrt(Math.pow(((int) s), 2) - value));
		}
		factors[0] = s + t;
		factors[1] = Math.abs(s - t);
		return factors;
	}
	
	public static HashMap<Long, Integer> primefactorization (long value, HashMap<Long, Integer> output) {
		
		if (isPrime(value)) {
			if (output.containsKey(value)) {
				output.put(value, 1 + output.get(value));
			}
			else {
				output.put(value, 1);
			}
		} else {
			if (value % 2 == 0) {
				if (output.containsKey(2)) {
					output.put((long)2, output.get(2) + 1);
				} else {
					output.put((long)2, 1);
				}
				primefactorization(value/2, output);
			}
			else {
				long[] factors = Fermat(value);
				primefactorization(factors[0], output);
				primefactorization(factors[1], output);
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		System.out.println("Type number: ");
		Scanner s = new Scanner(System.in);
		int start = s.nextInt();
		long [] factor = Fermat(start);
		System.out.println("Factor of : " + start + " are\n " + factor[0] + " and " + factor[1]);
		s.close();
		System.out.println(isPrime(start));
	}
}
