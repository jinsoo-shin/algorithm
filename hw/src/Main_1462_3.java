import java.io.*;
import java.util.*;

public class Main_1462_3 {
	public static void main(String[] args) throws Exception {
//		String src = "3 7\r\n" + "LLLWLLL\r\n" + "LWLLLWL\r\n" + "LLLWLLL";
		String src = "5 7\r\n" + "WLLWWWL\r\n" + "LLLWLLL\r\n" + "LWLWLWW\r\n" + "LWLWLLL\r\n" + "WLLWLWW";
//		String src = "6 6\r\n" + "LWLWWL\r\n" + "LLLWLL\r\n" + "LLLLWL\r\n" + "LLWWLL\r\n" + "LLWWWL\r\n" + "LLLLLL";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		xyT = new ArrayList<>();
		map = new String[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().split("");
		}
		// 각 칸은 육지(L)나 바다(W)
//		for (String[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//시작점이 될수 있는곳 찾기		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j].equals("L")) {// 육지라면 보낸다...
					findT(i, j);
				}
			}
		}
////////////////////////////보내자ㅏㅏㅏㅏ////////////////////////////////////////////////////////////////////////////////////
		max = Integer.MIN_VALUE;
		if (xyT.isEmpty()) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j].equals("L")) {
						bfs(i, j, new boolean[R][C]);
					}
				}
			}
		} else {
			for (int i = 0; i < xyT.size(); i++) {
//			System.out.println(Arrays.toString(xyT.get(i)));
				bfs(xyT.get(i)[0], xyT.get(i)[1], new boolean[R][C]);
//			System.out.println("-----------------------------------------------------");
			}

		}

		System.out.println(max);

	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	// 왼 오른 위 아래
	static boolean[][] visit;
	static String[][] map;
	static List<int[]> xyT;// 보물이 있을것같은 곳의... 위치..?
	static int max;

	static void findT(int x, int y) {// 보물이 있을것같은 곳의... 위치..?
		int cnt = 0;

		for (int i = 0; i < 4; i++) {// 4방향을 탐색하기...
			int cx = x + dx[i];
			int cy = y + dy[i];

			if (cx < 0 || cy < 0 || cx >= map.length || cy >= map[0].length) {// 범위넘어도 ㄴㄴ
				continue;
			}

			if (map[cx][cy].equals("L")) {
				cnt++;
			}

		}
		if (cnt < 2) {
//			System.out.println(cnt + " i=" + x + " j=" + y);
			xyT.add(new int[] { x, y });
		}
	}

	static void bfs(int x, int y, boolean[][] test) {
		List<int[]> visitXy = new LinkedList<>();// 방문 x,y,cnt인데 찾아서...어음...cnt가 낮으면 걔로 체인지
		int cnt = 0;// 4방향 탐색용

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y, 0 });
		test[x][y] = true;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			for (int i = 0; i < 4; i++) {
				int cx = tmp[0] + dx[i];
				int cy = tmp[1] + dy[i];

				if (cx < 0 || cy < 0 || cx >= map.length || cy >= map[0].length) {// 범위넘어도 ㄴㄴ
					continue;
				}

				if (test[cx][cy]) {// 간적있으면 cnt비교하려면 되려나...? 작은 값을 넣어주자...
//					if (map[cx][cy].equals("L")) {
//						System.out.println("좌표 어디냐-----" + cx + " " + cy);

//					}
//					if (map[cx][cy].equals("L")) {
//						for (int j = 0; j < visitXy.size(); j++) {
//							if (cx == visitXy.get(j)[0] && cy == visitXy.get(j)[1]) {
//								if (cnt >= visitXy.get(j)[2]) {
//									cnt = visitXy.get(j)[2];
//									System.out.println("변경되었다" + cnt);
//									q.offer(new int[] { cx, cy });
//								}
//							}
//
//						}
//					}

					continue;
				}
				if (map[cx][cy].equals("L")) {
//					System.out.println("갈수있어ㅓㅓ" + cx + " " + cy);
					q.offer(new int[] { cx, cy, tmp[2] + 1 });
					cnt++;
					visitXy.add(new int[] { cx, cy, tmp[2] + 1 });
//					System.out.println("방문했어-----------------" + cx + ", " + cy + "/// " + (tmp[2] + 1));
				}
				test[cx][cy] = true;
			}
			cnt = tmp[2];
		}
//		System.out.println(cnt + "---------");
		max = Math.max(cnt, max);

	}

	static boolean equals(List<int[]> a, List<int[]> b) {
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < b.size(); j++) {
				if (a.get(i)[0] == b.get(j)[0] && a.get(i)[1] == b.get(j)[1]) {
					return true;
				}
			}
		}
		return false;
	}

}
