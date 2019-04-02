import java.io.*;
import java.util.*;

public class Solution_무선충전 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
		String src = "1\r\n" + "20 3\r\n" + "2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3\r\n"
				+ "4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3\r\n" + "4 4 1 100\r\n" + "7 10 3 40\r\n" + "6 3 2 70";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			ans = 0;
			people = new ArrayList[2];
			for (int i = 0; i < 2; i++) {
				people[i] = new ArrayList<>();
			}
			people[0].add(new Node(0, 0));
			people[1].add(new Node(9, 9));
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int dir = Integer.parseInt(st.nextToken());
					int cx = people[i].get(j).x + dx[dir];
					int cy = people[i].get(j).y + dy[dir];
					people[i].add(new Node(cx, cy));
				}
//				System.out.println(people[i]);
			}

			ap = new ArrayList<>();
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int[] tmp = new int[4];
				for (int j = 0; j < 4; j++) {
					tmp[j] = Integer.parseInt(st.nextToken());
				}
				ap.add(new AP(tmp[1] - 1, tmp[0] - 1, tmp[2], tmp[3]));
			}
//			System.out.println(ap);
			dfs(0, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void dfs(int time, int sum) {
//		System.out.println("시간" + time);
		if (time == M + 1) {
			ans = sum;
			return;
		}
		int cntA = 0;
		int cntB = 0;
		int[][] visit = new int[2][A];
		for (int i = 0; i < A; i++) {
			int distA = Math.abs(ap.get(i).x - people[0].get(time).x) + Math.abs(ap.get(i).y - people[0].get(time).y);
			if (distA <= ap.get(i).size) {
				visit[0][i]++;
				cntA++;
			}
			int distB = Math.abs(ap.get(i).x - people[1].get(time).x) + Math.abs(ap.get(i).y - people[1].get(time).y);
			if (distB <= ap.get(i).size) {
				visit[1][i]++;
				cntB++;
			}
		}
//		for (int i = 0; i < 2; i++) {
//			System.out.println(Arrays.toString(visit[i]));
//		}
//		System.out.println(cntA + " " + cntB);
		List<Node> select = new ArrayList<>();
		if (cntA == 0 || cntB == 0) {
			int cal = 0;
			if (cntA == 0) {
				for (int i = 0; i < A; i++) {
					int tmp = 0;
					if (visit[1][i] == 1) {
						cal = Math.max(cal, ap.get(i).P);
					}
				}
			}
			if (cntB == 0) {
				for (int i = 0; i < A; i++) {
					int tmp = 0;
					if (visit[0][i] == 1) {
						cal = Math.max(cal, ap.get(i).P);
					}
				}
			}
//			System.out.println(cal + " 계산");
			dfs(time + 1, sum + cal);
		} else {// 이거 여러개 겹친경우
			for (int i = 0; i < A; i++) {
				for (int j = 0; j < A; j++) {
					if (visit[0][i] + visit[1][j] == 2) {
						boolean flag = false;
						if (i == j) {
							flag = true;
						}
						select.add(new Node(i, j, flag));
					}
				}
			}

			int cal = 0;
			for (int i = 0; i < select.size(); i++) {
				int tmp = 0;
				tmp += ap.get(select.get(i).x).P;// 첫번째사람
				tmp += ap.get(select.get(i).y).P;// 두번째사람
				if (select.get(i).same) {
					tmp = tmp / 2;
				}
				cal = Math.max(cal, tmp);
			}
//			System.out.println(cal + " 계산");
//			System.out.println(select);
			dfs(time + 1, sum + cal);
		}
	}

	static int ans, M, A;
	static List<AP> ap;
	static List<Node>[] people;

	static int calD(int x1, int x2, int y1, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);

	}

	static int[] dx = { 0, -1, 0, 1, 0 };// 위 오른 아래 왼쪽
	static int[] dy = { 0, 0, 1, 0, -1 };

	static class Node {
		int x;
		int y;
		boolean same;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Node(int x, int y, boolean same) {
			super();
			this.x = x;
			this.y = y;
			this.same = same;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", same=" + same + "]\n";
		}

	}

	static class AP {
		int x;
		int y;
		int size;
		int P;

		@Override
		public String toString() {
			return "AP [x=" + x + ", y=" + y + ", size=" + size + ", P=" + P + "]\n";
		}

		public AP(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			size = c;
			P = p;
		}

	}
}
