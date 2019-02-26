import java.util.*;
import java.io.*;

public class Solution2 {
	public static void main(String[] args) throws IOException {

		String src = "2\r\n" + "2\r\n" + "1 2\r\n" + "3 4\r\n" + "3\r\n" + "9 3 4\r\n" + "6 1 5\r\n" + "7 8 2";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			/// 맵에 입력 끝

			// 리스트를 생성한다
			list = new LinkedList<>();
			// 완탐을 들어간다
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					search(i, j, map[i][j], 0);
				}
			}

			// 소트한다
//			System.out.println(list);
			Collections.sort(list, new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {

					if (o1.cnt == o2.cnt) {
						return o1.start - o2.start;
					}
					return o2.cnt - o1.cnt;
				}

			});
//			System.out.println(list);
			int roomCnt = list.get(0).cnt + 1;
			int minCnt = list.get(0).start;

			// 출력한다
			System.out.println("#" + tc + " " + minCnt + " " + roomCnt);
		}
	}

	static List<Node> list;
	static int map[][];
	static int count;
	static int[][] dxy = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static void search(int x, int y, int start, int cnt) {

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, map[x][y], map[x][y], cnt));
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			System.out.println(tmp);
			go: for (int i = 0; i < 4; i++) {
				int cx = x + dxy[i][0];
				int cy = y + dxy[i][1];
				// 모든방향 탐색
				if (cx < 0 || cy < 0 || cx >= map.length || cy >= map.length) {
					list.add(tmp);
					continue;
				}
				if (map[tmp.x][tmp.y] + 1 == map[cx][cy]) {// 그 방에도 갈수있다
					q.offer(new Node(cx, cy, start, map[cx][cy], tmp.cnt + 1));
				}

			}
//			list.add(tmp);

		}

	}

	static class Node {
		int x;
		int y;
		int start;
		int visit;
		int cnt;

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", start=" + start + ", visit=" + visit + ", cnt=" + cnt + "]\n";
		}

		public Node(int x, int y, int start, int visit, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.start = start;
			this.visit = visit;
			this.cnt = cnt;
		}

	}
}
