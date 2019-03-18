import java.io.*;
import java.util.*;

public class Solution_수영장 {
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
			month = new int[13];
			int[] dp = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
				if (month[i] != 0) {
					dp[i] = month[i] * money[0];
				}
			}
			System.out.println("하루" + Arrays.toString(dp));
			for (int i = 1; i <= 12; i++) {
				if (dp[i] != 0 && dp[i] > money[1]) {
					dp[i] = money[1];
				}
			}
			System.out.println("한달" + Arrays.toString(dp));
			List<int[]> list = new ArrayList<>();
			for (int i = 12; i >= 3; i--) {
//				if (dp[i] != 0 && dp[i + 1] != 0 && dp[i + 2] != 0) {
				if (dp[i] != 0) {
					int tmp = dp[i] + dp[i - 1] + dp[i - 2];
					if (tmp > money[2]) {
						list.add(new int[] { i, tmp });
					}
				}
			}
			Collections.sort(list, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[0] - o2[0] <= 2) {
						return o2[1] - o1[1];
					}

					return o1[0] - o2[0];
				}
			});
			for (int i = 0; i < list.size(); i++) {
				System.out.println(Arrays.toString(list.get(i)));
			}
			for (int i = 0; i < list.size(); i++) {
				int idx = list.get(i)[0];
				if (dp[idx] != 0) {
					dp[idx] = money[2];
					dp[idx - 1] = 0;
					dp[idx - 2] = 0;
				}
			}
			int sum = 0;
			for (int i = 1; i <= 12; i++) {
				sum += dp[i];
			}
			if (sum > money[3]) {
				ans = money[3];
			} else {
				ans = sum;
			}
			System.out.println(Arrays.toString(dp));

			System.out.println("#" + tc + " " + ans);
		}
	}

	static int month[];
	static int[] money;
}
