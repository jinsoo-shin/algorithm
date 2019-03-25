import java.io.*;
import java.util.*;

public class Solution_수영장dpver {
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
			plan = new int[13];
			int[] dp = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
				if (plan[i] != 0) {
					dp[i] = Math.min(plan[i] * money[0], money[1]);
				}
			}
			System.out.println("하루~한달" + Arrays.toString(dp));
			int[] dp2 = new int[13];// 누적을 위한 배열 dp는 1달까지의 요금 계산한것
			for (int i = 1; i <= 12; i++) {
				dp2[i] = dp2[i - 1] + dp[i];
				if (i > 2) {
					dp2[i] = Math.min(dp2[i], dp2[i - 3] + money[2]);
				}
				System.out.println("3달" + Arrays.toString(dp2));
			}
			ans = dp2[12] < money[3] ? dp2[12] : money[3];
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int plan[];
	static int[] money;
}
