import java.io.*;
import java.util.*;

public class Main_2156포도주DP {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "6\r\n" + "6\r\n" + "10\r\n" + "13\r\n" + "9\r\n" + "8\r\n" + "1";
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int n = sc.nextInt();
		int[] podo = new int[10001];
		for (int i = 1; i <= n; i++) {
			podo[i] = sc.nextInt();
		}
		System.out.println("포도주" + Arrays.toString(podo));
		int[] dp = new int[10001];
		dp[1] = podo[1];
		dp[2] = podo[2] + dp[1];
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 2] + podo[i], dp[i - 3] + podo[i] + podo[i - 1]);
			dp[i] = Math.max(dp[i - 1], dp[i]);
			System.out.println(Arrays.toString(dp));
		}
		System.out.println(dp[n]);
	}

}