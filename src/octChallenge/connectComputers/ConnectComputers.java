package octChallenge.connectComputers;
import java.util.Scanner;
import java.lang.Math;

public class ConnectComputers {
	static Long[] s = new Long[2];
	static Long xorshift128plus() {
		Long x = s[0];
		final Long y = s[1];
		x ^= x << 23;
		s[1] = x ^ y ^ (x >>> 17) ^ (y >>> 26);
		return s[0] = y;
	}
	
	static final int MX = 1000;
	static int[][] C = new int[MX][MX];
	static int[][] H = new int[MX][MX];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int t = 0; t < T; t++) {
			int n = scan.nextInt();
			int Cmax = scan.nextInt();
			int Hmax = scan.nextInt();
			for (int i = 0; i < n; i++) {
				C[i][i] = 0;
				String seed1 = scan.next();
				String seed2 = scan.next();
				s[0] = Long.parseUnsignedLong(seed1);
				s[1] = Long.parseUnsignedLong(seed2);
				for (int j = i + 1; j < n; j++) {
					Long value = Long.remainderUnsigned(xorshift128plus(), Cmax + 1);
					C[i][j] = C[j][i] = Math.toIntExact(value);
				}
			}
			
			for (int i = 0; i < n; i++) {
				String seed1 = scan.next();
				String seed2 = scan.next();
				s[0] = Long.parseUnsignedLong(seed1);
				s[1] = Long.parseUnsignedLong(seed2);
				for (int j = 0; j < n; j++) {
					Long value = Long.remainderUnsigned(xorshift128plus(), Hmax + 1);
					H[i][j] = Math.toIntExact(value);
				}
			}
			
			// solve here
			
		}
	}
}
