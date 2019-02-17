import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1972거스름돈 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "2\r\n" + "32850\r\n" + "160";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			N = N / 10;

			int[] ans = new int[8];
			int cnt = 0;
			if (N / 5000 != 0) {
				ans[cnt] += N / 5000;
				N = N % 5000;
			}
			cnt += 1;
			if (N / 1000 != 0) {
				ans[cnt] += N / 1000;
				N = N % 1000;
			}
			cnt += 1;
			if (N / 500 != 0) {
				ans[cnt] += N / 500;
				N = N % 500;
			}
			cnt += 1;
			if (N / 100 != 0) {
				ans[cnt] += N / 100;
				N = N % 100;
			}
			cnt += 1;
			if (N / 50 != 0) {
				ans[cnt] += N / 50;
				N = N % 50;
			}
			cnt += 1;


			if (N / 10 != 0) {
				ans[cnt] += N / 10;
				N = N % 10;
			}
			cnt += 1;

			if (N / 5 != 0) {
				ans[cnt] += N / 5;
				N = N % 5;
			}
			cnt += 1;
			ans[cnt] += N;

			System.out.println("#" + tc);
			for (int a : ans) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
}
