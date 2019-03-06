import java.io.*;
import java.util.*;

public class Main_7569토마토3차원 {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "4 3 2\r\n" + "1 1 1 1\r\n" + "1 1 1 1\r\n" + "1 1 1 1\r\n" + "1 1 1 1\r\n" + "-1 -1 -1 -1\r\n"
				+ "1 1 1 -1";
		// 0
//		String src = "5 3 2\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n"
//				+ "0 0 1 0 0\r\n" + "0 0 0 0 0";
		// 4
//		String src = "5 3 1\r\n" + "0 -1 0 0 0\r\n" + "-1 -1 0 1 1\r\n" + "0 0 0 1 1";
//		String src = "3 3 1\r\n" + "1 1 0 \r\n" + "0 0 0\r\n" + "0 0 0";// 3
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H 가 주어진다.
		// M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다.
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		box = new int[R][C][H];

		q = new LinkedList<>();

		int tomato = 0;
		int no = 0;

		for (int h = 0; h < H; h++) {// 2
			for (int c = 0; c < C; c++) {// 3
				st = new StringTokenizer(br.readLine());
				for (int r = 0; r < R; r++) {// 4
					int tmp = Integer.parseInt(st.nextToken());
					if (tmp == 1) {
						q.offer(new int[] { r, c, h });
						tomato++;
					} else if (tmp == -1) {
						no++;
					}
					box[r][c][h] = tmp;
				}
			}
		}
		int ans = 0;

		int all = R * C * H;

		if (all == (no + tomato)) {
			ans = 0;
		} else {
			bfs();
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
			ans--;
		}
//		print();
		System.out.println(ans);
	}

	static Queue<int[]> q;
	static int[][] dxyz = { { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 }, { 0, 0, -1, }, { 0, 0, 1 } };
	static int[][][] box;
	static boolean[][][] visit;

	static void bfs() {

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < dxyz.length; i++) {
				int cx = tmp[0] + dxyz[i][0];
				int cy = tmp[1] + dxyz[i][1];
				int cz = tmp[2] + dxyz[i][2];

				if (cx < 0 || cy < 0 || cz < 0 || cx >= box.length || cy >= box[0].length || cz >= box[0][0].length) {
					continue;// 범위넘어갔어
				}
				if (box[cx][cy][cz] != 0) {
					continue;
				}
				int ccx = tmp[0];
				int ccy = tmp[1];
				int ccz = tmp[2];
				if (box[cx][cy][cz] == 0) {
					box[cx][cy][cz] = box[ccx][ccy][ccz] + 1;
					q.offer(new int[] { cx, cy, cz });
				}

			}
		}
	}

	static void print() {
		int R = box.length;
		int C = box[0].length;
		int H = box[0][0].length;
		System.out.println("------------------------------");
		for (int h = 0; h < H; h++) {
			for (int c = 0; c < C; c++) {
				for (int r = 0; r < R; r++) {
					System.out.print(box[r][c][h] + "   ");
				}
				System.out.println();
			}
			System.out.println("----------------층나누기");
		}

	}
}