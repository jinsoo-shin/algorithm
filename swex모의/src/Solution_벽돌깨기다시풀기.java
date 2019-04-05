import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution_벽돌깨기다시풀기 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "3 10 10\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "1 0 1 0 1 0 0 0 0 0\r\n"
				+ "1 0 3 0 1 1 0 0 0 1\r\n" + "1 1 1 0 1 2 0 0 0 9\r\n" + "1 1 4 0 1 1 0 0 1 1\r\n"
				+ "1 1 4 1 1 1 2 1 1 1\r\n" + "1 1 5 1 1 1 1 2 1 1\r\n" + "1 1 6 1 1 1 1 1 2 1\r\n"
				+ "1 1 1 1 1 1 1 1 1 5\r\n" + "1 1 7 1 1 1 1 1 1 1";
//		String src = "1\r\n" + "2 9 10\r\n" + "0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0\r\n"
//				+ "0 1 0 0 0 0 0 0 0\r\n" + "0 1 0 0 0 0 0 0 0\r\n" + "1 1 0 0 1 0 0 0 0\r\n" + "1 1 0 1 1 1 0 1 0\r\n"
//				+ "1 1 0 1 1 1 0 1 0\r\n" + "1 1 1 1 1 1 1 1 0\r\n" + "1 1 3 1 6 1 1 1 1\r\n" + "1 1 1 1 1 1 1 1 1";
//		String src="1\r\n"+"3 6 7\r\n" + 
//				"1 1 0 0 0 0\r\n" + 
//				"1 1 0 0 1 0\r\n" + 
//				"1 1 0 0 4 0\r\n" + 
//				"4 1 0 0 1 0\r\n" + 
//				"1 5 1 0 1 6\r\n" + 
//				"1 2 8 1 1 6\r\n" + 
//				"1 1 1 9 2 1";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 몇번 구슬?
			C = Integer.parseInt(st.nextToken());// 6
			R = Integer.parseInt(st.nextToken());// 7
			blocks = 0;
			map = new int[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 0) {
						blocks++;
					}
				}
			}
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
//			int[][] map2 = copy(map);
			ans = 987654321;
//			boom(map, blocks, 0, new int[] { 1, 4, 4 });
//			boom(map, blocks, 0, new int[] { 2, 2, 6 });
			pow(0, new int[N]);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void pow(int idx, int[] flag) {
		if (idx == N) {
			int[][] map2 = copy(map);
			boom(map2, blocks, 0, flag);
//			System.out.println(Arrays.toString(flag));
			return;
		}

		for (int i = 0; i < C; i++) {
			flag[idx] = i;
			pow(idx + 1, flag);
		}
	}

	static int[][] copy(int[][] map) {
		int[][] tmpMap = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tmpMap[i][j] = map[i][j];
			}
		}
		return tmpMap;
	}

	static void boom(int[][] map2, int block, int index, int[] arr) {
		if (index == N) {
			ans = Math.min(ans, block);
			return;
		}
		if (block == 0) {
			ans = 0;
			return;
		}
		int block1 = block;

		int delIdx = arr[index];
//		System.out.println(delIdx);
		Queue<Node> q = new LinkedList<>();
		int h = 0;
		for (int i = 0; i < R; i++) {
			if (map2[i][delIdx] != 0) {
				h = i;
				block1--;
				break;
			}
		}
//		if (h == 0) {
//			boom(map2, block1, index + 1, arr);
//		return;
//		}
		q.add(new Node(h, delIdx, map2[h][delIdx]));
		map2[h][delIdx] = 0;
		while (!q.isEmpty()) {
			Node tmp = q.poll();

			for (int dir = 0; dir < 4; dir++) {// 4방향
				for (int d = 1; d < tmp.cnt; d++) {
					int cx = tmp.x + dx[dir] * d;
					int cy = tmp.y + dy[dir] * d;
					if (!isOk(cx, cy)) {
						continue;
					}
					if (map2[cx][cy] == 0) {
						continue;
					} else {
						q.add(new Node(cx, cy, map2[cx][cy]));
						map2[cx][cy] = 0;
						block1--;
					}
				}
			}
		}
//		for (int[] row : map2) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println("-----------------------------------------");
		for (int c = 0; c < C; c++) {// 행
			for (int i = R - 1; i >= 0; i--) {// 열
				if (map2[i][c] != 0) {
					continue;
				}
				int ii = i;
				while (map2[i][c] == 0) {
					if (ii == -1) {
						break;
					}
					if (map2[ii][c] != 0) {
						map2[i][c] = map2[ii][c];
						map2[ii][c] = 0;
					}
					ii--;
				}
			}
		}

//		for (int[] row : map2) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println("-----------------------------------------");

		boom(map2, block1, index + 1, arr);
//
//		System.out.println("블럭수  " + block);
	}

	static boolean isOk(int x, int y) {
		if (x < 0 || y < 0 || x >= R || y >= C) {
			return false;
		}
		return true;
	}

	static int N, C, R, ans, blocks;
	static int[][] map;

	static class Node {
		int x;
		int y;
		int cnt;

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}

	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
}
