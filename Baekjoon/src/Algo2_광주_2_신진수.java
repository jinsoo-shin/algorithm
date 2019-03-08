import java.util.*;
import java.io.*;

public class Algo2_광주_2_신진수 {
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

			for (int i = 0; i < N && bag[i] <= W; i++) {
				dp[bag[i]] = 1;
			}

			// 각 중량별로 최소 값찾기
			for (int i = bag[0] + 1; i <= W; i++) {
				if (dp[i] > 0) {
					continue;// 이미 최소값이다.
				}
				int min = Integer.MAX_VALUE;
				// 최소값을 찾기
				for (int j = 0; j < bag.length; j++) {
					if (i > bag[j] && dp[i - bag[j]] != -1) {
						min = Math.min(dp[i - bag[j]], min);
					}
				}
				dp[i] = (min == Integer.MAX_VALUE) ? -1 : min + 1;

			}
			System.out.println(Arrays.toString(dp));

			int ans = 0;
			ans = dp[W];
			System.out.println("#" + tc + " " + ans);
		}
	}
}
