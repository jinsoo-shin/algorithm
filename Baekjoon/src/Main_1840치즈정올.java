import java.io.*;
import java.util.*;

public class Main_1840치즈정올 {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "13 12\r\n" + "0 0 0 0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0 0 0\r\n"
				+ "0 0 0 0 0 0 0 1 1 0 0 0\r\n" + "0 1 1 1 0 0 0 1 1 0 0 0\r\n" + "0 1 1 1 1 1 1 0 0 0 0 0\r\n"
				+ "0 1 1 1 1 1 0 1 1 0 0 0\r\n" + "0 1 1 1 1 0 0 1 1 0 0 0\r\n" + "0 0 1 1 0 0 0 1 1 0 0 0\r\n"
				+ "0 0 1 1 1 1 1 1 1 0 0 0\r\n" + "0 0 1 1 1 1 1 1 1 0 0 0\r\n" + "0 0 1 1 1 1 1 1 1 0 0 0\r\n"
				+ "0 0 1 1 1 1 1 1 1 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0 0 0 0";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R + 2][C + 2];
		holeVisit = new boolean[R + 2][C + 2];
		list = new ArrayList<>();

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		for (int[] row : map) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("-----------------------");
		findhole(0, 0);// 구멍 찾기
		for (int[] row : map) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("-----------------------");
		///////////////////////
		findLine();
//		while (!queue.isEmpty()) {
//			Node tmp = queue.poll();
//
//		}
		for (int[] row : map) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("-----------------------");
		int cnt = 0;
		if (cnt == 0) {
			System.out.println("끝끝끝");
		}
		meltCh();
		///////////////////////
		for (int[] row : map) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("-----------------------");

	}

	static int R;
	static int C;
	static boolean[][] visit;
	static boolean[][] holeVisit;
	static int[][] map;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static List<Node> list;

	static void findLine() {
		Queue<Node> queue = new LinkedList<>();
		holeVisit = new boolean[R + 2][C + 2];// 재탕한다
		for (int i = 0; i < R; i++) {
			go: for (int j = 0; j < C; j++) {
				if (map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int cx = i + dx[k];
						int cy = j + dy[k];
						if (cx >= R + 2 || cy >= C + 2 || cx < 0 || cy < 0) {
							continue;
						}
						if (holeVisit[cx][cy]) {
							continue;
						}
						if (map[cx][cy] == -1) {
							map[i][j] = 2;
							queue.offer(new Node(i, j));
							holeVisit[cx][cy] = true;
							continue go;
						}
					}
				}
			}
		}
	}

	static void findhole(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		holeVisit[x][y] = true;
		map[x][y] = -1;
		while (!q.isEmpty()) {
			Node tmp = q.poll();

			for (int i = 0; i < 4; i++) {
				int cx = tmp.x + dx[i];
				int cy = tmp.y + dy[i];
				if (cx >= R + 2 || cy >= C + 2 || cx < 0 || cy < 0) {
					continue;
				}
				if (holeVisit[cx][cy]) {
					continue;
				}
				if (map[cx][cy] == 0) {
					map[cx][cy] = -1;
					q.offer(new Node(cx, cy));
				}

			}

		}
	}

	static void meltCh() {
		int cX = 0;
		int cY = 0;
		int cnt = 0;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] == 2) {
					cX = i;
					cY = j;
					map[i][j] = 0;
				}

			}
		}
	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}

	}
}