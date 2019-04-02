import java.io.*;
import java.util.*;

public class Solution_방범 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		String src = "1\r\n" + "7 7\r\n" + "0 0 0 1 0 0 0\r\n" + "0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0\r\n"
//				+ "1 0 0 0 0 0 1\r\n" + "0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0\r\n" + "0 0 0 1 0 0 0";
//		String src = "1\r\n" + "8 3\r\n" + "0 0 0 0 0 1 0 0\r\n" + "0 1 0 1 0 0 0 1\r\n" + "0 0 0 0 0 0 0 0\r\n"
//				+ "0 0 0 1 0 1 0 0\r\n" + "0 0 1 1 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 1 0 1 0\r\n"
//				+ "1 0 0 0 0 0 0 0";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		costArr = new int[25];
		for (int i = 1; i < 25; i++) {
			costArr[i] = (i * i) + (i - 1) * (i - 1);
		}
//		System.out.println("운영 비용" + Arrays.toString(costArr));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
//				System.out.println(Arrays.toString(map[i]));
			}
//			System.out.println(house);
			ans = 0;
//			cal(house, 1);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cal(i, j);
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void cal(int x, int y) {
//		int s = N + 1;
		for (int size = 1; size <= N + 1; size++) {
			int cnt = 0;
			//////////////
			for (int i = -size + 1; i < size; i++) {// 행
				int len = Math.abs(size - Math.abs(i));
				for (int j = -len + 1; j < len; j++) {
					int cx = x + i;
					int cy = y + j;
					if (!isOk(cx, cy)) {
						continue;
					}
					if (map[cx][cy] == 1) {
						cnt++;
					}
				}
			}
			//////////////
			int cost = M * cnt - costArr[size];
			if (cost >= 0) {
//				System.out.println(x + " " + y + "수익:" + cost + " 사이즈:" + size + " 제공집:" + cnt);
				ans = Math.max(ans, cnt);
			}
		}
	}

	static boolean isOk(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N) {
			return false;
		}
		return true;
	}

	static void dia(int x, int y, int size) {
		for (int i = -size + 1; i < size; i++) {// 행
//			System.out.println(i);
			int len = Math.abs(size - Math.abs(i));
//			System.out.println(len);
			for (int j = -len + 1; j < len; j++) {
				System.out.println((x + i) + " " + (y + j));
			}
			System.out.println("----");
		}
	}

	static int[] costArr;
	static int N, M, ans;
	static int[][] map;

	static class Node {
		int x;
		int y;

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]\n";
		}

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
