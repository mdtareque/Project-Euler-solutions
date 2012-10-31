/* 
 * Solution to Project Euler problem 204
 * By Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/project-euler-solutions
 * https://github.com/nayuki/Project-Euler-solutions
 */


public final class p204 implements EulerSolution {
	
	public static void main(String[] args) {
		System.out.println(new p204().run());
	}
	
	
	public String run() {
		return Integer.toString(count(0, 1));
	}
	
	
	private static long LIMIT = Library.pow(10, 9);
	
	private static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
	
	
	private static int count(int primeIndex, long product) {
		if (primeIndex == primes.length)
			return product <= LIMIT ? 1 : 0;
		
		else {
			int count = 0;
			while (product <= LIMIT) {
				count += count(primeIndex + 1, product);
				product *= primes[primeIndex];
			}
			return count;
		}
	}
	
}
