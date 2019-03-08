import java.util.*;
import java.io.*;

public class Algo2_광주_2_신진수2 {
	public static void main(String[] args) throws IOException {
		String src = "3\r\n" + "8\r\n" + "3\r\n" + "1 4 6\r\n" + "7\r\n" + "2\r\n" + "5 3\r\n" + "18\r\n" + "2\r\n"
				+ "5 3\r\n" + "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int W = Integer.parseInt(br.readLine());// 밀가루
			int N = Integer.parseInt(br.readLine());// 봉지 수
			int[] dp = new int[W + 1];
			int[] bag = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				bag[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(bag);
			Arrays.fill(dp, -1);
			dp[0] = 0;
			for (int i = bag[0]; i <= W; i++) {
				if (i % bag[0] == 0) {
					dp[i] = i / bag[0];
				} else {
					dp[i] = dp[i - 1];
				}
			}

			System.out.println(Arrays.toString(dp));

			for (int i = 1; i < N; i++) {// 봉투 돌리기
				for (int j = bag[i]; j <= W; j++) {

					int before = dp[j - bag[i]];
					int cur = dp[j];
					if (before != -1 && before + 1 < cur) {
						dp[j] = before + 1;
					} else if (before == -1) {
						dp[j] = -1;
					}
				}
				System.out.println(Arrays.toString(dp));
			}

			int ans = 0;
			ans = dp[W];
			System.out.println("#" + tc + " " + ans);
		}
	}
}
