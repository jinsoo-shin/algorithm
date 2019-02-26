import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {

		String src = "2\r\n" + "2\r\n" + "1 2\r\n" + "3 4\r\n" + "3\r\n" + "9 3 4\r\n" + "6 1 5\r\n" + "7 8 2";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			/// 맵에 입력 끝
			ansLen = 0;
			ansStart = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, 1, map[i][j]);
				}
			}

			// 출력한다
			System.out.println("#" + tc + " " + ansStart + " " + ansLen);
		}
	}

	static int map[][];
	static int[][] dxy = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int ansLen;
	static int ansStart;

//	static void dfs(int x, int y, int cnt, int start) {
//		for (int i = 0; i < 4; i++) {
//			int cx = x + dxy[i][0];
//			int cy = y + dxy[i][1];
//			// 갈수 있는가???
//			if (cx < 0 || cy < 0 || cx >= map.length || cy >= map.length) {
//				continue;
//			}
//			// 범위안이고
//			if (map[x][y] + 1 == map[cx][cy])
//				dfs(cx, cy, cnt + 1, start);
//
//		}
//		if (ansLen <= cnt) {
//			ansLen = cnt;
//			if (ansLen == cnt) {
//				ansStart = Math.min(ansStart, start);
//			}
//		}
//	}
	static void dfs(int x, int y, int sum, int f) {
		boolean isPass = false;

		for (int i = 0; i < 4; i++) {
			int nx = x + dxy[i][0];
			int ny = y + dxy[i][1];

			if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length)
				continue;
			if (map[nx][ny] != map[x][y] + 1)
				continue;
			dfs(nx, ny, sum + 1, f);
			isPass = true;
		}

		if (!isPass) {
			if ((ansLen == sum && ansStart > f) || ansLen < sum) {
				ansLen = sum;
				ansStart = f;
			}
		}

	}
}
