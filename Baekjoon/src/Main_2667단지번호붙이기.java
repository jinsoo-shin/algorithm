import java.io.*;
import java.util.*;

public class Main_2667단지번호붙이기 {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "7\r\n" + "0110100\r\n" + "0110101\r\n" + "1110101\r\n" + "0000111\r\n" + "0100000\r\n"
				+ "0111110\r\n" + "0111000";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		// 지도가 있고
		// 1이 집이다
		// 0가 집이 없는곳
		int N = Integer.parseInt(br.readLine());// 맵
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		visit = new boolean[N][N];
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					bfs(i, j);
//					System.out.println("--------------------");
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()).append("\n");

		while (!pq.isEmpty()) {
			sb.append(pq.poll() + " \n");
		}
		System.out.println(sb.toString());

	}

	static Queue<Integer> pq;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visit;
	static int[][] map;

	static void bfs(int x, int y) {
		if (visit[x][y]) {
			return;
		}

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y, 0 });
		visit[x][y] = true;
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
//			System.out.println("뿅뿅" + Arrays.toString(tmp));
			for (int i = 0; i < 4; i++) {
				int cx = tmp[0] + dx[i];
				int cy = tmp[1] + dy[i];

				if (cx < 0 || cy < 0 || cx >= map.length || cy >= map.length) {
					continue;
				}
				if (visit[cx][cy]) {
					continue;
				}

				if (map[cx][cy] == 1) {
					cnt++;
					q.offer(new int[] { cx, cy, tmp[2] + 1 });
				}
				visit[cx][cy] = true;
			}
//			cnt = tmp[2];
		}
//		System.out.println("갸야아아악" + cnt);
		pq.offer(cnt);
//		System.out.println(cnt);
	}
}