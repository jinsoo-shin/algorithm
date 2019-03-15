import java.io.*;
import java.util.*;

public class Solution_등산로 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		String src = "1\r\n" + "5 2\r\n" + "9 3 2 3 2\r\n" + "6 3 1 7 5\r\n" + "3 4 8 9 9\r\n" + "2 3 7 7 7\r\n"
//				+ "7 6 5 5 8\r\n";
//		String src = "1\r\n" + "5 1\r\n" + "9 3 2 3 2\r\n" + "6 3 1 7 5\r\n" + "3 4 8 9 9\r\n" + "2 3 7 7 7\r\n"
//				+ "7 6 5 5 8";
		String src = "1\r\n" + "4 4\r\n" + "8 3 9 5\r\n" + "4 6 8 5\r\n" + "8 1 5 1\r\n" + "4 9 5 5";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			q = new LinkedList<>();
			ans = 0;
			int maxH = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxH = Math.max(maxH, map[i][j]);
				}
//				System.out.println(Arrays.toString(map[i]));
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxH) {
						boolean[][] visit = new boolean[N][N];
						visit[i][j] = true;
						q.add(new Node(i, j, false, map[i][j], visit, 1));
					}
				}
			}
			bfs();

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void bfs() {

		while (!q.isEmpty()) {
			Node tmp = q.poll();
//			System.out.println(tmp);
			ans = Math.max(ans, tmp.cnt);
			for ( int i = 0; i < 4; i++) {
				int cx = tmp.x + dx[i];
				int cy = tmp.y + dy[i];
				if (cx < 0 || cy < 0 || cx >= N || cy >= N) {
					continue;
				}
				if (tmp.visit[cx][cy]) {
					continue;// 방문했었으니
				}
				if (map[cx][cy] < tmp.pre) {// 이전에 방문했던 곳보다 낮은지??
					tmp.visit[cx][cy] = true;// 방문시키고
					q.offer(new Node(cx, cy, tmp.flag, map[cx][cy], tmp.visit, tmp.cnt + 1));
					tmp.visit[cx][cy] = false;// 다시 ㄴㄴ 로..
				} else {
					// 깎자!!
					if (tmp.flag) {
						continue;// 이미 깎은적있으니 ㄴㄴ
					}
					for (int j = 1; j <= K; j++) {
						if (map[cx][cy] - j < tmp.pre && (map[cx][cy] - j) >= 0) {// 작은지 다시 확인
							// 작아서 갈수있으면
							tmp.visit[cx][cy] = true;// 방문시키고
							q.offer(new Node(cx, cy, true, map[cx][cy] - j, tmp.visit, tmp.cnt + 1));
							tmp.visit[cx][cy] = false;// 다시 ㄴㄴ 로..
						}
					}
				}
			}
		}
	}

	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static Queue<Node> q;
	static int N, K, ans;

	static class Node {
		int x;
		int y;
		boolean flag;// 한번 깎았니
		int pre;// 이전에 방문했던 곳
		boolean[][] visit = new boolean[N][N];
		int cnt;

		public Node(int x, int y, boolean flag, int pre, boolean[][] visit, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.flag = flag;
			this.pre = pre;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					this.visit[i][j] = visit[i][j];
				}
			}
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", flag=" + flag + ", pre=" + pre + ", cnt=" + cnt + "]";
		}

	}
}
