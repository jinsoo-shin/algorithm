import java.io.*;
import java.util.*;

public class Solution_수영장2 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		String src = "1\r\n" + "10 40 100 300\r\n" + "0 0 2 9 1 5 0 0 0 0 0 0";
		String src = "1\r\n" + "10 100 50 300\r\n" + "0 0 0 0 0 0 0 0 6 2 7 8";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			money = new int[4];// 1일 1달 3달 1년
			month = new int[12];
			int[] dp = new int[12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}

//			System.out.println("요금" + Arrays.toString(money));
//			System.out.println("계획" + Arrays.toString(month));
			//////////////////
			for (int i = 0; i < 12; i++) {
				if (month[i] != 0) {
					dp[i] = month[i] * money[0];
				}
			}
//			System.out.println("하루" + Arrays.toString(dp));
			for (int i = 0; i < 12; i++) {
				if (dp[i] != 0 && dp[i] > money[1]) {
					dp[i] = money[1];
				}
			}
//			System.out.println("한달" + Arrays.toString(dp));
			min = Integer.MAX_VALUE;
			dfs(dp, 0, 0);
//			System.out.println(min);
			if (min > money[3]) {
				ans = money[3];
			} else {
				ans = min;
			}
			//////////////////
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int min;
	static int[] month;
	static int[] money;

	static void dfs(int[] dp, int idx, int sum) {
		if (idx >= month.length) {
			min = Math.min(min, sum);
			return;
		}

		int tmp = 0;
		for (int i = 0; i < 3; i++) {
			if (idx + i >= month.length) {
				min = Math.min(min, sum+tmp);
//				System.out.println(sum);
				return;
			}
			tmp += dp[idx + i];
		}
		if (tmp > money[2]) {
			dfs(dp, idx + 3, sum + money[2]);//얜 더한거고 
			dfs(dp, idx + 1, sum + dp[idx]);//다음꺼 체크한거고
		} else {
			dfs(dp, idx + 1, sum + dp[idx]);
		}

	}
}
