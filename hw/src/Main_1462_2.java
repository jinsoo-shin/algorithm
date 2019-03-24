import java.io.*;
import java.util.*;

public class Main_1462_2 {
	public static void main(String[] args) throws Exception {
		String src = "5 7\r\n" + "WLLWWWL\r\n" + "LLLWLLL\r\n" + "LWLWLWW\r\n" + "LWLWLLL\r\n" + "WLLWLWW";
//		String src = "6 6\r\n" + 
//				"LWLWWL\r\n" + 
//				"LLLWLL\r\n" + 
//				"LLLLWL\r\n" + 
//				"LLWWLL\r\n" + 
//				"LLWWWL\r\n" + 
//				"LLLLLL";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		find = new ArrayList<>();
		xyT = new ArrayList<>();
		map = new String[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().split("");
		}
		// 각 칸은 육지(L)나 바다(W)
		for (String[] row : map) {
			System.out.println(Arrays.toString(row));
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j].equals("L")) {// 육지라면 보낸다...
					findT(i, j);
				}
			}
		}
		for (int i = 0; i < xyT.size(); i++) {
//			System.out.println(Arrays.toString(xyT.get(i)));
			bfs(xyT.get(i)[0], xyT.get(i)[1], new boolean[R][C]);
//			System.out.println("-------------");
		}

		for (int i = 0; i < find.size(); i++) {// cnt랑 지나온 루트xy int[]저장되어있다
			for (int j = i + 1; j < find.size(); j++) {
				if (equals(find.get(i).list, find.get(j).list)) {
//					System.out.println("오오옹" + i + " " + j);
					if (find.get(i).cnt <= find.get(j).cnt) {
						find.remove(j);
//						i--;
					}
				}

			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < find.size(); i++) {
			min = Math.min(min, find.get(i).cnt);
//			System.out.println(find.get(i).cnt);
		}
		System.out.println(min);

	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	// 왼 오른 위 아래
	static boolean[][] visit;
	static String[][] map;
	static List<treasure> find;// 각 에리어에서 최소값들을 저장할 곳
	static List<int[]> xyT;// 보물이 있을것같은 곳의... 위치..?

	static void findT(int x, int y) {
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
			System.out.println(cnt + " i=" + x + " j=" + y);
			xyT.add(new int[] { x, y });
		}
	}

	static void bfs(int x, int y, boolean[][] test) {
		List<int[]> visitXy = new LinkedList<>();
		int cnt = 0;// 4방향 탐색용

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		test[x][y] = true;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			for (int i = 0; i < 4; i++) {
				int cx = tmp[0] + dx[i];
				int cy = tmp[1] + dy[i];

				if (cx < 0 || cy < 0 || cx >= map.length || cy >= map[0].length) {// 범위넘어도 ㄴㄴ
					continue;
				}

				if (test[cx][cy]) {// 간적있으면 ㄴㄴ
					continue;
				}
				if (map[cx][cy].equals("L")) {
//					System.out.println("갈수있어ㅓㅓ" + cx + " " + cy);
					q.offer(new int[] { cx, cy });
					visitXy.add(new int[] { cx, cy });
					cnt++;
				}
				test[cx][cy] = true;

				for (int k = 0; k < xyT.size(); k++) {
					if (cx == xyT.get(k)[0] && cy == xyT.get(k)[1]) {
						System.out.println(cnt + "갸아악" + cx + " " + cy + ":" + x + " " + y);
						find.add(new treasure(cnt, visitXy));
						continue;
					}
				}

			}

		}
//		System.out.println(cnt + "---------");

	}

	static class treasure {
		int cnt;
		List<int[]> list = new ArrayList<>();

		public treasure(int cnt, List<int[]> list) {
			super();
			this.cnt = cnt;
			this.list = list;
		}

		@Override
		public String toString() {
			return "treasure [cnt=" + cnt + ", list=" + list + "]";
		}

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
