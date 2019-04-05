import java.io.*;
import java.util.*;

public class Solution_벌꿀 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "3 3 10\r\n" + "7 2 9\r\n" + "6 6 6\r\n" + "5 5 7";
//		String src = "1\r\n" + "4 2 13\r\n" + "6 1 9 7\r\n" + "9 8 5 8\r\n" + "3 4 5 3\r\n" + "8 2 6 7";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			ans = 0;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
//				System.out.println(Arrays.toString(map[i]));
			}
			for (int row = 0; row < N; row++) {
//			int row = 0;
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < M; i++) {
					sb.append(map[row][i]);
				}
//				System.out.println(sb);
				sel(new boolean[M], 0, sb.toString(), row, M);
				for (int i = M; i < N; i++) {
					sb.deleteCharAt(0);
					sb.append(map[row][i]);
//					System.out.println(sb);
					sel(new boolean[M], 0, sb.toString(), row, i + 1);
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void sel(boolean[] select, int idx, String str, int row, int col) {
		if (idx == M) {
			int sum = 0;
			int cal = 0;
			for (int i = 0; i < M; i++) {
				if (select[i]) {
					int tmp = str.charAt(i) - '0';
					sum += tmp;
					cal += (tmp * tmp);
				}
			}
			if (sum > C) {
//				if (sum == 0 || sum > C) {
				return;
			}
			dfs(row, col, str, cal);
//			System.out.println(sum + " " + cal);
			return;
		}

		select[idx] = true;
		sel(select, idx + 1, str, row, col);

		select[idx] = false;
		sel(select, idx + 1, str, row, col);

	}

	static void dfs(int row, int col, String str, int cal) {
		// idx는 끝나는 부분의 위치
//		System.out.println("줄= " + row + " 다음시작col= " + col + " " + str + " 현재까지계산" + cal);
		if (N - col >= M) {// 같은 줄이어서 갈수있는것
			for (int i = col; i <= N - M; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < M; j++) {
					sb.append(map[row][i + j]);
				}
//				System.out.println(sb);
				sel2(new boolean[M], 0, sb.toString(), cal);
			}
		} // 다음줄 돌린다

		for (int i = row + 1; i < N; i++) {// 다음줄 체크
			for (int j = 0; j <= N - M; j++) {
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < M; k++) {
					sb.append(map[i][k + j]);
				}
//				System.out.println(sb);
				sel2(new boolean[M], 0, sb.toString(), cal);
			}
		}
	}

	static void sel2(boolean[] select, int idx, String str, int cal1) {
		if (idx == M) {
			int sum = 0;
			int cal2 = 0;
			for (int i = 0; i < M; i++) {
				if (select[i]) {
					int tmp = str.charAt(i) - '0';
					sum += tmp;
					cal2 += (tmp * tmp);
				}
			}
			if (sum > C) {
//				if (sum == 0 || sum > C) {
				return;
			}
//			System.out.println(Arrays.toString(select));
//			System.out.println(str + " 쨔잔" + (cal1 + cal2));
			int cal3 = cal1 + cal2;
			ans = Math.max(ans, cal3);
			return;
		}

		select[idx] = true;
		sel2(select, idx + 1, str, cal1);
		select[idx] = false;
		sel2(select, idx + 1, str, cal1);

	}

	static int ans, N, M, C;
	static int[][] map;

	static class Node {
		int row;
		int y1;
		int y2;
		int sum;

		public Node(int x, int y1, int y2, int sum) {
			super();
			this.row = x;
			this.y1 = y1;
			this.y2 = y2;
		}

		@Override
		public String toString() {
			return "Node [row=" + row + ", y1=" + y1 + ", y2=" + y2 + "]";
//			return "Node [row=" + row + ", y1=" + y1 + ", y2=" + y2 + "]\n";
		}

	}
}
