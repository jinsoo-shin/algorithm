import java.io.*;
import java.util.*;

public class Main_1681해밀턴완탐 {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "5\r\n" + "0 14 4 10 20\r\n" + "14 0 7 8 7\r\n" + "4 5 0 7 16\r\n" + "11 7 9 0 2\r\n"
				+ "18 7 17 4 0";
//		String src = "3\r\n" + "0 86 0 \r\n" + "69 0 83 \r\n" + "45 97 0 ";
//		String src = "6\r\n" + "0 93 23 32 39 46 \r\n" + "0 0 7 58 59 13 \r\n" + "40 98 0 14 33 98 \r\n"
//				+ "3 39 0 0 13 16 \r\n" + "51 25 19 88 0 47 \r\n" + "65 81 63 0 6 0 ";
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		N = sc.nextInt();
		map = new int[N][N];
		ans = 987654321;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		boolean[] visit = new boolean[N];
		visit[0] = true;
		dfs(visit, 0, 0, 1);
		System.out.println(ans);
	}

	static int N, ans;
	static int[][] map;

	static void dfs(boolean[] visit, int sum, int idx, int cnt) {
		if (sum > ans) {
			return;
		}
		if (cnt == N) {
			if (map[idx][0] == 0) {
				return;
			}
			ans = Math.min(sum + map[idx][0], ans);
			return;
		}
		for (int i = 1; i < N; i++) {
			if (visit[i]) {
				continue;
			}
			if (map[idx][i] == 0) {
				continue;
			}
			visit[i] = true;
			dfs(visit, sum + map[idx][i], i, cnt + 1);
			visit[i] = false;
		}
	}
}