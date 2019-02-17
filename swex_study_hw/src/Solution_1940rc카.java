
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1940rc카 {
	// public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n" + "30\r\n" + "2 1\r\n" + "2 2\r\n" + "2 2\r\n" + "1 1\r\n" + "1 2\r\n" + "2 1\r\n"
				+ "0\r\n" + "1 1\r\n" + "0\r\n" + "0\r\n" + "1 2\r\n" + "1 2\r\n" + "2 1\r\n" + "0\r\n" + "0\r\n"
				+ "2 2\r\n" + "2 1\r\n" + "1 2\r\n" + "0\r\n" + "1 1\r\n" + "2 2\r\n" + "1 2\r\n" + "2 2\r\n" + "0\r\n"
				+ "1 2\r\n" + "2 1\r\n" + "2 2\r\n" + "0\r\n" + "1 1\r\n" + "2 2";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[][] com = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 2) {
					tmp = -1;
				}
				com[i][0] = tmp;
				while (st.hasMoreTokens()) {
					com[i][1] = Integer.parseInt(st.nextToken());
				}
			}
			int cur = 0;
			int ans = 0;
			for (int i = 0; i < N; i++) {
				if (com[i][0] == 1) {
					cur += com[i][0] * com[i][1];
				} else if (com[i][0] == -1) {
					if (cur <= com[i][1]) {
						cur = 0;
					} else {
						cur += com[i][0] * com[i][1];
					}
				}
				ans += cur;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
