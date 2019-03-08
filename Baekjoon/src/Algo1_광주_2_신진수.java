import java.util.*;
import java.io.*;

public class Algo1_광주_2_신진수 {
	public static void main(String[] args) throws IOException {
//		String src = "2\r\n" + "6\r\n" + "S S S B S W\r\n" + "S W W S S W\r\n" + "A S S C S S\r\n" + "S W S S W S\r\n"
//				+ "S W S W S A\r\n" + "S S S W S S\r\n" + "10\r\n" + "C S S S S S S S S C\r\n"
//				+ "S W S S S S S S W S\r\n" + "S S W S S S S W S S\r\n" + "A S S W S S W S S A\r\n"
//				+ "S S S S S B S S S S\r\n" + "S S S S B S S S S S\r\n" + "A S S W S S W S S A\r\n"
//				+ "S S W S S S S W S S\r\n" + "S W S S S S S S W S\r\n" + "C S S S S S S S S C\r\n" + "";
		String src = "1\r\n" + "6\r\n" + "S S S B S W\r\n" + "S W W S S S\r\n" + "A S S C S S\r\n" + "S W S S W S\r\n"
				+ "S W S W S A\r\n" + "S S S W S S\r\n";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new String[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().split(" ");
				System.out.println(Arrays.toString(map[i]));
			}
			// 값 입력 받음
			ans = 0;
			bfs();
			System.out.println("#" + tc + " " + ans);
		}

	}

	static int ans;
	static String[][] map;
	static int N;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	// 상 좌 우 하

	static void bfs() {
		Queue<Robot> q = new LinkedList<>();
		// 큐 생성
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].equals("A")) {
					q.offer(new Robot(i, j, 0, map[i][j], 0));
				} else if (map[i][j].equals("B")) {
					q.offer(new Robot(i, j, 0, map[i][j], 1));
					q.offer(new Robot(i, j, 0, map[i][j], 2));
				} else if (map[i][j].equals("C")) {
					for (int k = 0; k < 4; k++) {
						q.offer(new Robot(i, j, 0, map[i][j], k));
					}
				}

			}
		}

		while (!q.isEmpty()) {
			Robot tmp = q.poll();
			int cx = tmp.x + dx[tmp.dir];
			int cy = tmp.y + dy[tmp.dir];
			if (cx < 0 || cy < 0 || cx >= N || cy >= N) {
				ans += tmp.dist;
				continue;// 넘어갔음
			}

			if (map[cx][cy].equals("S")) {// 공백이라면..?
				q.offer(new Robot(cx, cy, tmp.dist + 1, tmp.name, tmp.dir));
			} else {
				ans += tmp.dist;
			}
		}

	}

	static class Robot {
		int x;
		int y;
		int dist;
		String name;
		int dir;// 방향

		public Robot(int x, int y, int dist, String name, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.name = name;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Robot [x=" + x + ", y=" + y + ", dist=" + dist + ", name=" + name + ", dir=" + dir + "]";
		}

	}
}
