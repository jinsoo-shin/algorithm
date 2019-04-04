import java.io.*;
import java.util.*;

public class Main_가스관2 {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "3 7\r\n" + ".......\r\n" + ".M-.-Z.\r\n" + ".......";
//		String src = "3 5\r\n" + "..1-M\r\n" + "1-+..\r\n" + "Z.23.";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		ans = 0;
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
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '0') {
					int tmp = check(i, j);
					String ans = null;
					if (tmp != 0) {
						if (tmp <= 4) {
							ans = tmp + "";
						} else if (tmp == 5) {
							ans = "|";
						} else if (tmp == 6) {
							ans = "-";
						} else if (tmp == 7) {
							ans = "7";
						}
						System.out.println((i + 1) + " " + (j + 1) + " " + ans);
					}
				}
			}
		}
//		check(1, 3);
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
//		if (nextDir > 7) {
//			return t;
//		}
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
	static int ans, R, C, cnt;
	static int[] dx = { 0, -1, 0, 1 };// 왼 위 오 아래
	static int[] dy = { -1, 0, 1, 0 };
	static String[] pipe = { "0000", "0011", "0110", "1100", "1001", "0101", "1010", "1111" };

	static class Node {
		int x;
		int y;
		boolean change;
		int dir;
		int cx;
		int cy;
		int cdir;

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