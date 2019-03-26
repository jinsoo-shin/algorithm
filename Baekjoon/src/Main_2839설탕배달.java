import java.io.*;
import java.util.*;

public class Main_2839설탕배달 {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "18";
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int W = sc.nextInt();

		int[] dp = new int[W + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for (int i = 3; i <= W; i++) {
			if (i % 3 == 0) {
				dp[i] = i / 3;
			}
		}
		System.out.println(Arrays.toString(dp));

		for (int i = 5; i <= W; i++) {
			if (dp[i - 5] == -1) {// 못만드는거라
				if (dp[i] > 0) {
					continue;
				}
				dp[i] = -1;
			} else {
				dp[i] = dp[i - 5] + 1;
			}
			System.out.println(Arrays.toString(dp));
		}
		System.out.println(dp[W]);
	}

}