/* 
 * Solution to Project Euler problem 114
 * By Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/project-euler-solutions
 * https://github.com/nayuki/Project-Euler-solutions
 */


public final class p114 implements EulerSolution {
	
	public static void main(String[] args) {
		System.out.println(new p114().run());
	}
	
	
	public String run() {
		long[] ways = new long[51];  // Memoization
		ways[0] = 1;
		ways[1] = 1;
		ways[2] = 1;
		for (int i = 3; i <= 50; i++) {
			ways[i] += ways[i - 1];
			for (int j = 3; j < i; j++)
				ways[i] += ways[i - j - 1];  // Dynamic programming
			ways[i] += ways[0];
		}
		return Long.toString(ways[50]);
	}
	
}
