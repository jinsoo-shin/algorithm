import java.io.*;
import java.util.*;

public class Main_1150세일2 {
//	public class Main {
	public static void main(String[] args) throws Exception {
//		String src = "7\r\n" + "10\r\n" + "9\r\n" + "4\r\n" + "2\r\n" + "6\r\n" + "4\r\n" + "3";
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int[] dp = new int[100001];
		dp[1] = arr[n];
		dp[2] = arr[n - 1] + dp[1];
		for (int i = 3; i <= n; i++) {
			if (i % 3 == 0) {
				dp[i] = dp[i - 1];
			} else {
				dp[i] = dp[i - 1] + arr[n - i + 1];
			}
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
	}

}