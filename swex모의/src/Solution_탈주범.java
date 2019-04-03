import java.io.*;
import java.util.*;

public class Solution_탈주범 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "5 6 2 1 3\r\n" + "0 0 5 3 6 0\r\n" + "0 0 2 0 2 0\r\n" + "3 3 1 3 7 0\r\n"
				+ "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 지하터널지도 세로
			M = Integer.parseInt(st.nextToken());// 지하터널지도 가로
			R = Integer.parseInt(st.nextToken());// 맨홀 뚜껑 위치 세로
			C = Integer.parseInt(st.nextToken());// 맨홀 뚜껑 위치 가로
			L = Integer.parseInt(st.nextToken());// 탈출 후 소요시간
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
//				System.out.println(Arrays.toString(map[i]));
			}
//			System.out.println("뚜껑위치" + R + " " + C);
			ans = 1;
			bfs();
			System.out.println("#" + tc + " " + ans);
		}
	}

	static boolean isOk(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= M) {
			return false;
		}
		return true;
	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		q.add(new Node(R, C, 1));
		visit[R][C] = true;
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			if (tmp.time == L) {
				break;
			}
			int pipe = map[tmp.x][tmp.y];
			for (int i = 0; i < 4; i++) {
				if (pip[pipe].charAt(i) == '1') {
					int cx = tmp.x + dx[i];
					int cy = tmp.y + dy[i];
					if (!isOk(cx, cy))
						continue;
					if (visit[cx][cy])
						continue;
					if (map[cx][cy] > 0 && isConnect(cx, cy, i)) {
						visit[cx][cy] = true;
						ans++;
						q.add(new Node(cx, cy, tmp.time + 1));
					}
				}
			}
		}
	}

	static boolean isConnect(int cx, int cy, int dir) {
		int beforeDir = (dir + 2) % 4;
		int pipe = map[cx][cy];
		for (int i = 0; i < 4; i++) {
			if (pip[pipe].charAt(i) == '1') {
				if (beforeDir == i) {
					return true;
				}
			}
		}
		return false;
	}

	static int[] dx = { 0, -1, 0, 1 };// 왼 위 오 아래
	static int[] dy = { -1, 0, 1, 0 };
	static String[] pip = { "0000", "1111", "0101", "1010", "0110", "0011", "1001", "1100" };
	static int N, M, R, C, L, ans;
	static int[][] map;

	static class Node {
		int x;
		int y;
		int time;

		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}
