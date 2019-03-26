import java.io.*;
import java.util.*;

public class Main_2579계단오르기 {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "6\r\n" + "10\r\n" + "20\r\n" + "15\r\n" + "25\r\n" + "10\r\n" + "20";
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int n = sc.nextInt();
		int[] score = new int[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			score[i] = sc.nextInt();
		}
		dp[1] = score[1];
		dp[2] = score[2] + dp[1];

		System.out.println(Arrays.toString(score));
		System.out.println(Arrays.toString(dp));

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 3] + score[i] + score[i - 1], dp[i - 2] + score[i]);
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
	}

}