import java.io.*;
import java.util.*;

public class Solution_보호필름 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		String src = "1\r\n" + "6 8 3\r\n" + "0 0 1 0 1 0 0 1\r\n" + "0 1 0 0 0 1 1 1\r\n" + "0 1 1 1 0 0 0 0\r\n"
//				+ "1 1 1 1 0 0 0 1\r\n" + "0 1 1 0 1 0 0 1\r\n" + "1 0 1 0 1 1 0 1";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());// 두께D
			C = Integer.parseInt(st.nextToken());// 가로W
			K = Integer.parseInt(st.nextToken());// 합격기준
			ans = 987654321;
//			A = new int[C];
//			B = new int[C];
//			Arrays.fill(B, 1);
			int[][] map = new int[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
//				System.out.println(Arrays.toString(map[i]));
			}
			// 동일 특성이 K개 이상 연속으로있는 경우 (세로로) 성능검사 통과함
			// 특정막에 약품투입하면 그줄전체 A/B로 변함
			// 약품투입횟수 최소로 통과할방법
			/////////////////////
//			System.out.println(check(map));
			dfs(map, 0, 0);
			/////////////////////
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void dfs(int[][] map, int idx, int cnt) {
		if (cnt > ans) {
			return;
		}
		if (check(map)) {
			ans = Math.min(ans, cnt);
			return;
		}
		if (idx == R) {
			if (check(map)) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		int[] origin = new int[C];
		for (int i = 0; i < C; i++) {
			origin[i] = map[idx][i];
		}
		Arrays.fill(map[idx], 0);
		dfs(map, idx + 1, cnt + 1);
		Arrays.fill(map[idx], 1);
		dfs(map, idx + 1, cnt + 1);
		for (int i = 0; i < C; i++) {
			map[idx][i] = origin[i];
		}
		dfs(map, idx + 1, cnt);

	}
	static boolean check(int[][] map) {

		next: for (int j = 0; j < C; j++) {
			int cnt = 1;
			for (int i = 1; i < R; i++) {
				if (map[i - 1][j] == map[i][j]) {
					cnt++;
				} else {
					cnt = 1;
				}
				if (cnt == K) {// 연속으로 무언가가 K개가 나왔으면 그 줄은 통과
//					System.out.println("통과  :" + j + "열");
					continue next;
				}
			}
			if (cnt < K) {
				return false;
			}
		}

		return true;
	}

	static int ans, R, C, K;
}
