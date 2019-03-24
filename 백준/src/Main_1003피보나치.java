import java.io.*;
import java.util.*;

public class Main_1003피보나치 {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "3\r\n" + "0\r\n" + "1\r\n" + "3";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int dp[] = new int[41];
		int dp2[] = new int[41];// 0출력
		int dp3[] = new int[41];// 1출력
		dp[0] = 0;
		dp[1] = 1;
		dp2[0] = 1;
		dp3[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
			if (i == 2) {
				dp2[i] = 1;
				dp3[i] = 1;
				continue;
			}
			dp2[i] = dp2[i - 1] + dp2[i - 2];
			dp3[i] = dp3[i - 1] + dp3[i - 2];

		}
//		System.out.println(Arrays.toString(dp));
//		System.out.println(Arrays.toString(dp2));
//		System.out.println(Arrays.toString(dp3));
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp2[n] + " " + dp3[n]);
		}

	}

}