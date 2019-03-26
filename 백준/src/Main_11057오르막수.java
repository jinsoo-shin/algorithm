import java.io.*;
import java.util.*;

public class Main_11057오르막수 {
//	public class Main {
	public static void main(String[] args) throws Exception {
//		String src = "3";
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = sc.nextInt();
		int mod = 10007;
		long[][] dp = new long[1001][10];
		Arrays.fill(dp[1], 1);
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= j; k++) {
					dp[i][j] += dp[i - 1][k];
					dp[i][j] %= mod;
				}
			}
		}

		System.out.println(sum(dp[N]) % mod);

	}

	static long sum(long[] arr) {
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += arr[i];
		}
		return sum;
	}
}