import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution_벽돌깨기 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		String src = "1\r\n" + "3 10 10\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "1 0 1 0 1 0 0 0 0 0\r\n"
//				+ "1 0 3 0 1 1 0 0 0 1\r\n" + "1 1 1 0 1 2 0 0 0 9\r\n" + "1 1 4 0 1 1 0 0 1 1\r\n"
//				+ "1 1 4 1 1 1 2 1 1 1\r\n" + "1 1 5 1 1 1 1 2 1 1\r\n" + "1 1 6 1 1 1 1 1 2 1\r\n"
//				+ "1 1 1 1 1 1 1 1 1 5\r\n" + "1 1 7 1 1 1 1 1 1 1";
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
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			blocks = 0;
			height = new int[C];
			map = new int[C][R];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					map[j][i] = Integer.parseInt(st.nextToken());
					if (map[j][i] != 0) {
						height[j]++;
						blocks++;
					}
				}
			}
//			System.out.println("총블럭수" + blocks);
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
//			System.out.println("높이" + Arrays.toString(height));
			ans = 987654321;
//			System.out.println("---");
			pow(new int[N], 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int[] height;
	static int[][] map;
	static int N, C, R, ans, blocks;

	static void pow(int[] flag, int idx) {
		if (idx == N) {
//			System.out.println(Arrays.toString(flag));
			block(flag);
			return;
		}
		for (int i = 0; i < C; i++) {
			flag[idx] = i;
			pow(flag, idx + 1);
		}
	}

	static void block(int[] arr) {
		int tmpBlock = blocks;
		int[] tmpH = new int[C];
		int[][] tmpMap = new int[C][R];
		for (int i = 0; i < C; i++) {// 복사
			tmpH[i] = height[i];
			for (int j = 0; j < R; j++) {
				tmpMap[i][j] = map[i][j];
			}
		}
//		System.out.println("시작");
//		for (int[] row : tmpMap) {
//			System.out.println(Arrays.toString(row));
//		}
		for (int i = 0; i < arr.length; i++) {
			
			int x = arr[i];
			if (tmpH[x] <= 0) {
				continue;
			}
			int y = R - tmpH[x];
			int cnt = tmpMap[x][y];
			tmpH[x]--;
			Queue<Node> q = new LinkedList<>();
//			System.out.println("시작" + x + " " + y + " cnt" + cnt);
			for (int j = 0; j < 4; j++) {// 4방향
				for (int k = 1; k < cnt; k++) {// 이동이동
					int cx = x + dx[j] * k;
					int cy = y + dy[j] * k;
					if (cx >= C || cx < 0 || cy < 0 || cy >= R) {
						continue;
					}
//					System.out.println(cx + " " + cy);
					if (tmpMap[cx][cy] > 0) {
						q.add(new Node(cx, cy, tmpMap[cx][cy]));
						tmpMap[cx][cy] = 0;
						tmpH[cx]--;
						tmpBlock--;
					}
				}
			}
			while (!q.isEmpty()) {
				Node tmp = q.poll();
//				System.out.println(tmp);
				for (int j = 0; j < 4; j++) {// 4방향
					for (int k = 1; k < tmp.cnt; k++) {// 이동이동
						int cx = tmp.x + dx[j] * k;
						int cy = tmp.y + dy[j] * k;
						if (cx >= C || cx < 0 || cy < 0 || cy >= R) {
							continue;
						}
						if (tmpMap[cx][cy] > 0) {
							q.add(new Node(cx, cy, tmpMap[cx][cy]));
							tmpMap[cx][cy] = 0;
							if (tmpH[cx] > 0)
								tmpH[cx]--;
							tmpBlock--;
//							System.out.println("연쇄" + cx + " " + cy);
						}
					}
				}
			}
//			System.out.println("---");
			for (int c = 0; c < C; c++) {
				List<Integer> list = new ArrayList<>();
//				System.out.println(Arrays.toString(tmpMap[c]));
				for (int r = R - 1; r >= 0; r--) {
					if (tmpMap[c][r] == 0) {
						continue;
					}
					list.add(tmpMap[c][r]);
				}
//					System.out.println(list + " 갸악");
				int[] tmpArr = new int[R];
				int index = 0;
				for (int j = R - 1; j >= R - list.size(); j--) {
					tmpArr[j] = list.get(index++);
				}
				tmpMap[c] = tmpArr;
			}
//			System.out.println("--------------");
//			for (int[] row : tmpMap) {
//				System.out.println(Arrays.toString(row));
//			}
//			System.out.println("------------------------");
//			System.out.println("높이" + Arrays.toString(tmpH));
		}

//		System.out.println("결과블럭" + tmpBlock);
		if (ans > tmpBlock) {
			ans = tmpBlock;
		}
	}

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
