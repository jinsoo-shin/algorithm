import java.io.*;
import java.util.*;

public class Solution_보급로2 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		String src = "1\r\n" + "4\r\n" + "0100\r\n" + "1110\r\n" + "1011\r\n" + "1010";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			map = new int[N][N];
			visit = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(visit[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			visit[0][0] = 0;
			bfs(0, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int[][] visit;
	static int N, ans;
	static int map[][];
	static int[] dx = { 0, 1, -1, 0 };
	static int[] dy = { 1, 0, 0, -1 };

	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			if (tmp.x == N - 1 && tmp.y == N - 1) {
				if (ans > visit[tmp.x][tmp.y]) {
					ans = visit[tmp.x][tmp.y];
				}
			}

			for (int i = 0; i < 4; i++) {
				int cx = tmp.x + dx[i];
				int cy = tmp.y + dy[i];
				if (cx >= N || cy >= N || cy < 0 || cx < 0) {
					continue;
				}

				if (visit[cx][cy] > map[cx][cy] + visit[tmp.x][tmp.y]) {
					q.offer(new Node(cx, cy));
					visit[cx][cy] = map[cx][cy]+visit[tmp.x][tmp.y];
				}

			}

		}

	}

	static class Node {
		int x;
		int y;

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
