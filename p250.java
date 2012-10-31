/* 
 * Solution to Project Euler problem 250
 * By Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/project-euler-solutions
 * https://github.com/nayuki/Project-Euler-solutions
 */


public final class p250 implements EulerSolution {
	
	public static void main(String[] args) {
		System.out.println(new p250().run());
	}
	
	
	public String run() {
		long[] numSubsetsRemainder = new long[250];
		numSubsetsRemainder[0] = 1;
		
		for (int i = 1; i <= 250250; i++) {
			int temp = powMod(i, i, 250);
			long[] newArray = numSubsetsRemainder.clone();
			for (int j = 0; j < 250; j++)
				newArray[(j + temp) % 250] = (newArray[(j + temp) % 250] + numSubsetsRemainder[j]) % 10000000000000000L;
			numSubsetsRemainder = newArray;
		}
		
		return Long.toString((numSubsetsRemainder[0] - 1 + 10000000000000000L) % 10000000000000000L);
	}
	
	
	private static int powMod(int x, int y, int m) {
		if (y < 0)
			throw new IllegalArgumentException();
		int z = 1;
		for (; y != 0; y >>>= 1, x = (int)((long)x * x % m)) {
			if ((y & 1) != 0)
				z = (int)((long)z * x % m);
		}
		return z;
	}
	
}
