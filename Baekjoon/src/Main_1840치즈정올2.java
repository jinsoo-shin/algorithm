import java.io.*;
import java.util.*;

public class Main_1840치즈정올2 {
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
		map = new int[R][C];
		holeVisit = new boolean[R][C];
		list = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println("-----------------------");

		time = 0;
		flag = false;
		while (true) {
			findhole(0, 0);// 구멍 찾기 -1로 바꾸기
			findLine();// 테두리 2로 바꾸기
			meltCh();// 녹이기
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
//			System.out.println(time + "-----------------------");
			if (flag) {
				break;
			}
			time++;
		}
		///////////////////////
		System.out.println(time);
		System.out.println(cheeze);
	}

	static boolean flag;
	static int time, cheeze;
	static int R;
	static int C;
	static boolean[][] visit;
	static boolean[][] holeVisit;
	static int[][] map;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static List<Node> list;

	static void findLine() {// 1을 2로 바꾸기
		Queue<Node> queue = new LinkedList<>();
		holeVisit = new boolean[R][C];// 재탕한다
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			go: for (int j = 0; j < C; j++) {
				if (map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int cx = i + dx[k];
						int cy = j + dy[k];
						if (cx >= R || cy >= C || cx < 0 || cy < 0) {
							continue;
						}
						if (holeVisit[cx][cy]) {
							continue;
						}
						if (map[cx][cy] == -5) {
							map[i][j] = 2;
							queue.offer(new Node(i, j));
							holeVisit[i][j] = true;
							cnt++;
							continue go;
						}
					}
				}
			}
		}
		if (cnt == 0) {
			flag = true;
		} else {
			cheeze = cnt;
		}
	}

	static void findhole(int x, int y) {// 0을 -1로 바꾸기
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		holeVisit = new boolean[R][C];// 재탕한다
		holeVisit[x][y] = true;
		map[x][y] = -5;
		while (!q.isEmpty()) {
			Node tmp = q.poll();

			for (int i = 0; i < 4; i++) {
				int cx = tmp.x + dx[i];
				int cy = tmp.y + dy[i];
				if (cx >= R || cy >= C || cx < 0 || cy < 0) {
					continue;
				}
				if (holeVisit[cx][cy]) {
					continue;
				}

				if (map[cx][cy] == 0) {
					map[cx][cy] = -5;
					holeVisit[cx][cy] = true;
					q.offer(new Node(cx, cy));
				}
				if (map[cx][cy] == -5) {
					holeVisit[cx][cy] = true;
					q.offer(new Node(cx, cy));
				}
			}

		}
	}

	static void meltCh() {// 2를 녹이기
		int cX = 0;
		int cY = 0;
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 2) {
					cX = i;
					cY = j;
					map[i][j] = -5;
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