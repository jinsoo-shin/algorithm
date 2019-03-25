import java.io.*;
import java.util.*;

public class Main_9095더하기dp {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "3\r\n" + "4\r\n" + "7\r\n" + "10";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int arr[] = new int[4];
			num = Integer.parseInt(br.readLine());
			int[] dp = new int[num + 1];
			ans = 0;
			for (int i = 1; i <= 3; i++) {
				arr[i] = num / i;
			}
//			System.out.println(Arrays.toString(arr));
			re(arr[1], arr[2], arr[3], 0);
			System.out.println(ans);

		}
	}

	static int ans, num;

	static void re(int one, int two, int thr, int sum) {
		if (sum == num) {
			ans++;
			return;
		}
		if (one > 0) {
			re(one - 1, two, thr, sum + 1);
		}
		if (two > 0) {
			re(one, two - 1, thr, sum + 2);
		}
		if (thr > 0) {
			re(one, two, thr - 1, sum + 3);
		}
	}

}