import java.util.HashMap;
import java.util.Map;
public class RSA_encrypt {
	static Map<Integer, Integer> ls = new HashMap<>();
	public static int phi(int n) {

		int to_return = 1;
		if (n == 1) {
			return 1;
		} else if (ls.get(n) != null) {
			return (ls.get(n));
		}
		else if (Factorization.isPrime(n)) {
			ls.put(n, n - 1);
			return n - 1;
		} else {
			HashMap<Long, Integer> factorization = new HashMap<Long, Integer>();
			factorization = Factorization.primefactorization(n, factorization);
			for (Long i : factorization.keySet()) {
				int pow = factorization.get(i);
				System.out.println(i + " happens " + pow + " times");
				to_return *= (Math.pow(i, pow) - Math.pow(i, pow - 1));
			}
			ls.put(n, to_return);
			return to_return;
		}
	}
	public static void main (String[] args) {
		System.out.println(phi(171));
	}
}
