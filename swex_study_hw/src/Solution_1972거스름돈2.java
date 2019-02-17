import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1972거스름돈2 {
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
			int[] num = { 5000, 1000, 500, 100, 50, 10, 5, 1 };
			int[] ans = new int[8];
			for (int i = 0; i < num.length; i++) {
				if (N / num[i] != 0) {
					ans[i] += N / num[i];
					N = N % num[i];
				}
			}
			System.out.println("#" + tc);
			for (int a : ans) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
}
