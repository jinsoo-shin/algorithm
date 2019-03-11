import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_5688 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		BigInteger[] tmp = new BigInteger[1000001];
		for (long i = 0; i < tmp.length; i++) {
			tmp[(int) i] = BigInteger.valueOf(i * i * i);
		}
		for (int t = 1; t <= T; t++) {
			BigInteger n = sc.nextBigInteger();
			int ans = -1;
			for (int i = 0; i < tmp.length; i++) {
				BigInteger tmpnum = tmp[i];
				if (n.equals(tmpnum)) {
					ans = i;
					break;
				}
				if (n.compareTo(tmpnum) == -1) {
					break;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}