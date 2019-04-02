import java.io.*;
import java.util.*;

public class Solution_탈주범 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
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
			ans = 0;
			bfs();
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void bfs() {
		boolean[][] visit = new boolean[N][M];
		visit[R][C] = true;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(R, C, 1, -1));

		while (!q.isEmpty()) {
			Node tmp = q.poll();
//			System.out.println(tmp);
			// 왼 오 위 아래
			if (tmp.time == L) {
				break;
			}
			switch (map[tmp.x][tmp.y]) {// 이동해온곳 위치의 모양
			case 1:// 상하좌우
				for (int i = 0; i < 4; i++) {
					int cx = tmp.x + dx[i];
					int cy = tmp.y + dy[i];
					if (cx < 0 || cy < 0 || cx >= N || cy >= M || visit[cx][cy]) {
						continue;
					}
					if (map[cx][cy] > 0) {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.time + 1, i / 2));
					}
				}
				break;
			case 2:// 상하
				for (int i = 2; i <= 3; i++) {
					int cx = tmp.x + dx[i];
					int cy = tmp.y + dy[i];
					if (cx < 0 || cy < 0 || cx >= N || cy >= M || visit[cx][cy]) {
						continue;
					}
					if (map[cx][cy] > 0) {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.time + 1, i / 2));
					}
				}
				break;
			case 3:// 좌우
				for (int i = 0; i <= 1; i++) {
					int cx = tmp.x + dx[i];
					int cy = tmp.y + dy[i];
					if (cx < 0 || cy < 0 || cx >= N || cy >= M || visit[cx][cy]) {
						continue;
					}
					if (map[cx][cy] > 0) {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.time + 1, i / 2));
					}
				}
				break;
			case 4:// ㄴ 모양 위 오른
				if (tmp.dir == 0) {// 왼쪽으로 모양은 위로
					int cx = tmp.x + dx[0];
					int cy = tmp.y + dy[0];
					if (cx < 0 || cy < 0 || cx >= N || cy >= M || visit[cx][cy]) {
						break;
					}
					if (map[cx][cy] > 0) {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.time + 1, 1));
					}
				} else if (tmp.dir == 1) {// 아래로 모양은 0
					int cx = tmp.x + dx[3];
					int cy = tmp.y + dy[3];
					if (cx < 0 || cy < 0 || cx >= N || cy >= M || visit[cx][cy]) {
						break;
					}
					if (map[cx][cy] > 0) {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.time + 1, 0));
					}
				} else {// 양쪽 다가보도록
					int cx = tmp.x + dx[0];
					int cy = tmp.y + dy[0];
					if (cx < 0 || cy < 0 || cx >= N || cy >= M || visit[cx][cy]) {
						break;
					}
					if (map[cx][cy] > 0) {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.time + 1, 1));
					}
					int ccx = tmp.x + dx[3];
					int ccy = tmp.y + dy[3];
					if (ccx < 0 || ccy < 0 || ccx >= N || ccy >= M || visit[ccx][ccy]) {
						break;
					}
					if (map[ccx][ccy] > 0) {
						visit[ccx][ccy] = true;
						q.add(new Node(ccx, ccy, tmp.time + 1, 0));
					}

				}
				break;
			case 5:// 아래 오른
				if (tmp.dir == 0) {// 왼쪽으로 모양은 아래로
					int cx = tmp.x + dx[0];
					int cy = tmp.y + dy[0];
					if (cx < 0 || cy < 0 || cx >= N || cy >= M || visit[cx][cy]) {
						break;
					}
					if (map[cx][cy] > 0) {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.time + 1, 1));
					}
				} else if (tmp.dir == 1) {// 위로 모양은 0
					int cx = tmp.x + dx[2];
					int cy = tmp.y + dy[2];
					if (cx < 0 || cy < 0 || cx >= N || cy >= M || visit[cx][cy]) {
						break;
					}
					if (map[cx][cy] > 0) {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.time + 1, 0));
					}
				} else {// 양쪽 다가보도록
					int cx = tmp.x + dx[0];
					int cy = tmp.y + dy[0];
					if (cx < 0 || cy < 0 || cx >= N || cy >= M || visit[cx][cy]) {
						break;
					}
					if (map[cx][cy] > 0) {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.time + 1, 1));
					}
					int ccx = tmp.x + dx[2];
					int ccy = tmp.y + dy[2];
					if (ccx < 0 || ccy < 0 || ccx >= N || ccy >= M || visit[ccx][ccy]) {
						break;
					}
					if (map[ccx][ccy] > 0) {
						visit[ccx][ccy] = true;
						q.add(new Node(ccx, ccy, tmp.time + 1, 0));
					}

				}
				break;
			case 6:// 왼 아래
				if (tmp.dir == 0) {// 오른 1
					int cx = tmp.x + dx[1];
					int cy = tmp.y + dy[1];
					if (cx < 0 || cy < 0 || cx >= N || cy >= M || visit[cx][cy]) {
						break;
					}
					if (map[cx][cy] > 0) {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.time + 1, 1));
					}
				} else if (tmp.dir == 1) {// 위 0
					int cx = tmp.x + dx[2];
					int cy = tmp.y + dy[2];
					if (cx < 0 || cy < 0 || cx >= N || cy >= M || visit[cx][cy]) {
						break;
					}
					if (map[cx][cy] > 0) {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.time + 1, 0));
					}
				} else {// 양쪽 다가보도록
					int cx = tmp.x + dx[1];
					int cy = tmp.y + dy[1];
					if (cx < 0 || cy < 0 || cx >= N || cy >= M || visit[cx][cy]) {
						break;
					}
					if (map[cx][cy] > 0) {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.time + 1, 1));
					}
					int ccx = tmp.x + dx[2];
					int ccy = tmp.y + dy[2];
					if (ccx < 0 || ccy < 0 || ccx >= N || ccy >= M || visit[ccx][ccy]) {
						break;
					}
					if (map[ccx][ccy] > 0) {
						visit[ccx][ccy] = true;
						q.add(new Node(ccx, ccy, tmp.time + 1, 0));
					}

				}
				break;
			case 7:// 왼 위
				if (tmp.dir == 0) {// 오 1
					int cx = tmp.x + dx[1];
					int cy = tmp.y + dy[1];
					if (isOk(cx, cy) || visit[cx][cy]) {
						break;
					}
					if (map[cx][cy] > 0) {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.time + 1, 1));
					}
				} else if (tmp.dir == 1) {// 아 0
					int cx = tmp.x + dx[3];
					int cy = tmp.y + dy[3];
					if (cx < 0 || cy < 0 || cx >= N || cy >= M || visit[cx][cy]) {
						break;
					}
					if (map[cx][cy] > 0) {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.time + 1, 0));
					}
				} else {// 양쪽 다가보도록
					int cx = tmp.x + dx[1];
					int cy = tmp.y + dy[1];
					if (cx < 0 || cy < 0 || cx >= N || cy >= M || visit[cx][cy]) {
						break;
					}
					if (map[cx][cy] > 0) {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.time + 1, 1));
					}
					int ccx = tmp.x + dx[3];
					int ccy = tmp.y + dy[3];
					if (ccx < 0 || ccy < 0 || ccx >= N || ccy >= M || visit[ccx][ccy]) {
						break;
					}
					if (map[ccx][ccy] > 0) {
						visit[ccx][ccy] = true;
						q.add(new Node(ccx, ccy, tmp.time + 1, 0));
					}

				}
				break;
			}
		}
		for (boolean[] row : visit) {
			System.out.println(Arrays.toString(row));
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j]) {
					ans++;
				}
			}
		}
	}

	static boolean isOk(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= M) {
			return false;
		}
		return true;
	}

	static int[] dx = { 0, 0, -1, 1 };// 왼 오 위 아래
	static int[] dy = { -1, 1, 0, 0 };
	static int N, M, R, C, L, ans;
	static int[][] map;

	static class Node {
		int x;
		int y;
		int time;
		int dir;// 0이면 가로 1이면 세로

		public Node(int x, int y, int time, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", time=" + time + ", dir=" + dir + "]";
		}

	}
}
