import java.io.*;
import java.util.*;

public class Solution_수영장dpver2 {
//	public class Solution { 수정해애애애애애애
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "10 40 100 300\r\n" + "0 0 2 9 1 5 0 0 0 0 0 0";
//		String src = "1\r\n" + "10 100 50 300\r\n" + "0 0 0 0 0 0 0 0 6 2 7 8";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			money = new int[4];// 1일 1달 3달 1년
			plan = new int[13];
			int[] dp = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= 12; i++) {
				if (plan[i - 1] == 0) {
					dp[i] = dp[i - 1];
					continue;
				}
				dp[i] = Math.min(dp[i - 1] + plan[i] * money[0], dp[i - 1] + money[1]);
				if (i >= 3) {
					dp[i] = Math.min(dp[i - 1] + money[2], dp[i]);
				}
			}
			System.out.println(Arrays.toString(dp));
			ans = Math.min(money[3], dp[12]);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int plan[];
	static int[] money;
}
