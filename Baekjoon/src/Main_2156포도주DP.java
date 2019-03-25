import java.io.*;
import java.util.*;

public class Main_2156포도주DP {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "6\r\n" + "6\r\n" + "10\r\n" + "13\r\n" + "9\r\n" + "8\r\n" + "1";
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int n = sc.nextInt();
		int[] podo = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			podo[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(podo));
		int[] dp = new int[n + 1];
		System.out.println(Arrays.toString(dp));

		dp[1] = podo[0];
		dp[2] = podo[1];
		for (int i = 1; i <= n; i++) {
			dp[i] = podo[i] + podo[i - 1];
		}
		System.out.println(Arrays.toString(dp));
		int[] dp2 = new int[n + 1];
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i] + dp[i - 3], dp[i - 3] + podo[i]);
		}
		System.out.println(Arrays.toString(dp));
		int ans = 0;
		for (int i = 0; i <= n; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}

}