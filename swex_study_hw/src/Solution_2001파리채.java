
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2001파리채 {
	// public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n" + "5 2\r\n" + "1 3 3 6 7\r\n" + "8 13 9 12 8\r\n" + "4 16 11 12 6\r\n" + "2 4 1 23 2\r\n"
				+ "9 13 4 7 3";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					ans = Math.max(ans, cal(arr, i, j, M));
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans;

	static int cal(int[][] arr, int x, int y, int M) {
		int sum = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				sum += arr[x + i][y + j];
			}
		}
		return sum;
	}
}
