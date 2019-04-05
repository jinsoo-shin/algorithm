import java.io.*;
import java.util.*;

public class Main_가스관 {
	// 해냈다ㅏㅏ
//	public class Main {
	public static void main(String[] args) throws Exception {
//		String src = "3 7\r\n" + ".......\r\n" + ".M-.-Z.\r\n" + ".......";
		String src = "3 5\r\n" + "..1-M\r\n" + "1-+..\r\n" + "Z.23.";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		start = new int[2];
		end = new int[2];
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == 'M') {
					start[0] = i;
					start[1] = j;
					map[i][j] = '7';
				}
				if (map[i][j] == 'Z') {
					end[0] = i;
					end[1] = j;
					map[i][j] = '7';
				}
				if (map[i][j] == '|')
					map[i][j] = '5';
				if (map[i][j] == '-')
					map[i][j] = '6';
				if (map[i][j] == '+')
					map[i][j] = '7';
				if (map[i][j] == '.')
					map[i][j] = '0';
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		ans = new int[3];
		bfs(start[0], start[1]);

		String str = null;
		if (ans[2] <= 4) {
			str = ans[2] + "";
		} else if (ans[2] == 5) {
			str = "|";
		} else if (ans[2] == 6) {
			str = "-";
		} else if (ans[2] == 7) {
			str = "+";
		}
		System.out.println((ans[0] + 1) + " " + (ans[1] + 1) + " " + str);
	}

	static int[] ans;

	static void bfs(int startX, int startY) {

		Queue<Node> q = new LinkedList<>();
		boolean[][] visit = new boolean[R][C];
		visit[startX][startY] = true;
		q.add(new Node(startX, startY, false, 7));// 맨처음껀 사방을 탐색해보도록

		while (!q.isEmpty()) {
			Node tmp = q.poll();

			int cur = tmp.dir;

			if (cur == 0) {// 공백일때
				if (tmp.change) {
					continue;// 이미 바꾼적이 있다.
				}
				int dir = check(tmp.x, tmp.y);// 주변탐색해서 얻은것
				// 여기에 for문으로 보내고 add할때 방향을 넣어서....
				if (dir == 0) {// 갈수있는곳이 없어
					continue;
				}
				String strD = pipe[dir];
				for (int i = 0; i < 4; i++) {
					if (strD.charAt(i) == '1') {// 보내보자
						int cx = tmp.x + dx[i];
						int cy = tmp.y + dy[i];
						if (!isOk(cx, cy)) {
							continue;
						} // 범위 넘어감
						if (visit[cx][cy]) {
//							continue;// 방문한적이있다.
						}
						if (dir != 7) {
							visit[cx][cy] = true;
						}
						ans[0] = tmp.x;
						ans[1] = tmp.y;
						ans[2] = dir;
						continue;
						// 바꾼거 모양을 담아서 던져준다.
					}
				}

			} else {// 보내기
				String strD = pipe[cur];
				for (int i = 0; i < 4; i++) {
					if (strD.charAt(i) == '1') {// 연결되어있고
						int cx = tmp.x + dx[i];
						int cy = tmp.y + dy[i];
						if (!isOk(cx, cy)) {
							continue;
						} // 범위 넘어감
						if (visit[cx][cy]) {
							continue;// 방문한적이있다.
						}
//						if (tmp.change) {
//							if (isConnect(cx, cy, i)) {// 연결되어있어
//								visit[cx][cy] = true;
//								q.add(new Node(cx, cy, tmp.change, map[cx][cy] - '0', tmp.visit, tmp.cx, tmp.cy,
//										tmp.cdir));// 바꾼거 모양을 담아서 던져준다.
//							}
//						} else {
						visit[cx][cy] = true;
						q.add(new Node(cx, cy, tmp.change, map[cx][cy] - '0'));// 바꾼거
																				// 던져준다.
//						}
					}
				}
			}

		}
	}

	// . 일때 주변연결되는거 검색용 String으로 리턴한다.
	static int check(int x, int y) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (!isOk(cx, cy)) {
				sb.append(0);
				continue;
			}
			if (map[cx][cy] - '0' != 0 && isConnect(cx, cy, i)) {
				sb.append(1);
			} else {
				sb.append(0);
			}
		}
//		System.out.println(sb);
//		return sb.toString();
		for (int i = 1; i < 8; i++) {
			if (pipe[i].equals(sb.toString())) {
				return i;
			}
		}
		return 0;
	}

	static boolean isOk(int x, int y) {
		if (x < 0 || y < 0 || x >= R || y >= C)
			return false;
		return true;
	}

	static boolean isConnect(int cx, int cy, int dir) {
		int beforeDir = (dir + 2) % 4;
		int nextDir = map[cx][cy] - '0';
		for (int i = 0; i < 4; i++) {
			if (pipe[nextDir].charAt(i) == '1') {
				if (i == beforeDir) {
					return true;
				}
			}
		}
		return false;
	}

	static int[] start, end;
	static char[][] map;
	static int R, C, cnt;
	static int[] dx = { 0, -1, 0, 1 };// 왼 위 오 아래
	static int[] dy = { -1, 0, 1, 0 };
	static String[] pipe = { "0000", "0011", "0110", "1100", "1001", "0101", "1010", "1111" };

	static class Node {
		int x;
		int y;
		boolean change;
		int dir;

		public Node(int x, int y, boolean change, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.change = change;
			this.dir = dir;

		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", change=" + change + ", dir=" + dir + "]";
		}

	}

}