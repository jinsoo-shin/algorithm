import java.io.*;
import java.util.*;

public class Main_7569토마토3차원 {
//	public class Main {
	public static void main(String[] args) throws Exception {
//		String src = "4 3 2\r\n" + "1 1 1 1\r\n" + "1 1 1 1\r\n" + "1 1 1 1\r\n" + "1 1 1 1\r\n" + "-1 -1 -1 -1\r\n"
//				+ "1 1 1 -1";
		// 0
//		String src = "5 3 2\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n"
//				+ "0 0 1 0 0\r\n" + "0 0 0 0 0";
		// 4
		String src = "5 3 1\r\n" + "0 -1 0 0 0\r\n" + "-1 -1 0 1 1\r\n" + "0 0 0 1 1";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H 가 주어진다.
		// M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다.
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		box = new int[R][C][H];

		for (int h = 0; h < H; h++) {// 2
			for (int c = 0; c < C; c++) {// 3
				st = new StringTokenizer(br.readLine());
				for (int r = 0; r < R; r++) {// 4
					box[r][c][h] = Integer.parseInt(st.nextToken());
				}
			}
		}

		// 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
		// 0 0 -1
		// 0 0 1
		// 1 0 0
		// -1 0 0
		// 6개...
//		Queue<int[]> q = new LinkedList<>();
//		q.offer(new int[] { 0, 0, 0 });
		visit = new boolean[R][C][H];
		for (int h = 0; h < H; h++) {// 2
			for (int c = 0; c < C; c++) {// 3
				for (int r = 0; r < R; r++) {// 4
					if (box[r][c][h] > 0 && !visit[r][c][h]) {// 토마토가 있다면 bfs를 돌리자
						bfs(r, c, h);
					}

				}
			}
		}

		int ans = 0;
		go: for (int h = 0; h < H; h++) {// 2
			for (int c = 0; c < C; c++) {// 3
				for (int r = 0; r < R; r++) {// 4
					if (box[r][c][h] == 0) {
						ans = 0;
						break go;
					}
					ans = Math.max(ans, box[r][c][h]);

				}
			}
		}

		System.out.println(ans - 1);
	}

	static int[][] dxyz = { { 0, 0, -1, }, { 0, 0, 1 }, { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 } };
	static int[][][] box;
	static boolean[][][] visit;

	static void bfs(int x, int y, int z) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y, z });
		visit[x][y][z] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 6; i++) {
				int cx = tmp[0] + dxyz[i][0];
				int cy = tmp[1] + dxyz[i][1];
				int cz = tmp[2] + dxyz[i][2];

				if (cx < 0 || cy < 0 || cz < 0 || cx >= box.length || cy >= box[0].length || cz >= box[0][0].length) {
					continue;// 범위넘어갔어
				}
				if (visit[cx][cy][cz]) {
					continue;// 방문한적이 있대
				}
				if (box[cx][cy][cz] == 0) {
					int ccx = tmp[0];
					int ccy = tmp[1];
					int ccz = tmp[2];
					box[cx][cy][cz] = box[ccx][ccy][ccz] + 1;
					q.offer(new int[] { cx, cy, cz });
					visit[cx][cy][cz] = true;
				}

			}

		}
	}
}