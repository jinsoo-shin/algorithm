import java.io.*;
import java.util.*;

public class Main_9095더하기dp2 {
//	public class Main {
	public static void main(String[] args) throws Exception {
//		String src = "3\r\n" + "4\r\n" + "7\r\n" + "10";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int arr[] = { 1, 2, 3 };
			num = Integer.parseInt(br.readLine());
			ans = 1;
			int[] dp = new int[num + 1];
			for (int i = 1; i <= num; i++) {
				dp[i] = i;
			}

			for (int i = 1; i < arr.length; i++) {
				int cnt = 1;
				for (int j = arr[i]; j <= num; j++) {
					if (dp[j] > dp[j - arr[i]] + 1) {
						cnt++;
						dp[j] = dp[j - arr[i]] + 1;
					}
				}
//				System.out.println(cnt);
				ans += cnt;
			}

			System.out.println(ans);

		}
	}

	static int ans, num;

}