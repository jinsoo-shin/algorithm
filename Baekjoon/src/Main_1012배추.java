import java.io.*;
import java.util.*;

public class Main_1012배추 {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "2\r\n" + 
				"10 8 17\r\n" + 
				"0 0\r\n" + 
				"1 0\r\n" + 
				"1 1\r\n" + 
				"4 2\r\n" + 
				"4 3\r\n" + 
				"4 5\r\n" + 
				"2 4\r\n" + 
				"3 4\r\n" + 
				"7 4\r\n" + 
				"8 4\r\n" + 
				"9 4\r\n" + 
				"7 5\r\n" + 
				"8 5\r\n" + 
				"9 5\r\n" + 
				"7 6\r\n" + 
				"8 6\r\n" + 
				"9 6\r\n" + 
				"10 10 1\r\n" + 
				"5 5";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());// 가로
			int N = Integer.parseInt(st.nextToken());// 세로
			int K = Integer.parseInt(st.nextToken());// 배추 개수
			visit = new boolean[M][N];
			map = new boolean[M][N];
			cabbage = new int[K][2];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = true;
				cabbage[i][0] = a;
				cabbage[i][1] = b;
			}
			for (int i = 0; i < K; i++) {
				int x = cabbage[i][0];
				int y = cabbage[i][1];
				if (!visit[x][y]) {
					bfs(x, y);
//					System.out.println("--------------");
				}
			}
			System.out.println(ans);
		}
	}

	static int ans;
	static int[][] cabbage;
	static boolean[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static void bfs(int x, int y) {
		int cnt = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
//			System.out.println(Arrays.toString(tmp));
			for (int i = 0; i < 4; i++) {
				int cx = tmp[0] + dx[i];
				int cy = tmp[1] + dy[i];
				if (cx < 0 || cy < 0 || cx >= map.length || cy >= map[0].length) {
					continue;
				}

				if (visit[cx][cy]) {// 방문한적이 있다!
					continue;
				}

				if (map[cx][cy]) {// 여기에 있다!!!
					cnt++;
					q.offer(new int[] { cx, cy });
				}
				visit[cx][cy] = true;

			}

		}
		if (cnt != 0) {
			ans++;
		}
//		System.out.println("갸아아아악" + cnt);
	}

}