import java.io.*;
import java.util.*;

public class Main_가스관 {
//	public class Main {
	public static void main(String[] args) throws Exception {
//		String src = "3 7\r\n" + ".......\r\n" + ".M-.-Z.\r\n" + ".......";
		String src = "3 5\r\n" + "..1-M\r\n" + "1-+..\r\n" + "Z.23.";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		ans = 0;
		int[] start = new int[2];
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == 'M') {
					start[0] = i;
					start[1] = j;
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
			System.out.println(Arrays.toString(map[i]));
		}
		bfs(start[0], start[1]);

	}

	static void bfs(int startX, int startY) {

		Queue<Node> q = new LinkedList<>();
		boolean[][] visit = new boolean[R][C];
		visit[startX][startY] = true;
		q.add(new Node(startX, startY, false));

		while (!q.isEmpty()) {
			Node tmp = q.poll();
			System.out.println(tmp);
			if (map[tmp.x][tmp.y] == 'Z') {
				System.out.println("도착");
				break;
			}
			int cur = map[tmp.x][tmp.y] - '0';
			if (cur == 0) {// 공백일때
				if (tmp.change) {
					continue;// 이미 바꾼적이 있다.
				}
				String tmpStr = check(tmp.x, tmp.y);// 주변탐색해서 얻은것
				// 여기에 for문으로 보내고 add할때 tmpStr넣어서...
			} else {// 보내기

			}

		}
	}

	// . 일때 주변연결되는거 검색용 String으로 리턴한다.
	static String check(int x, int y) {
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
		System.out.println(sb);
		return sb.toString();
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

	static char[][] map;
	static int ans, R, C, cnt;
	static int[] dx = { 0, -1, 0, 1 };// 왼 위 오 아래
	static int[] dy = { -1, 0, 1, 0 };
	static String[] pipe = { "0000", "0011", "0110", "1100", "1001", "0101", "1010", "1111" };

	static class Node {
		int x;
		int y;
		boolean change;
		String str;

		public Node(int x, int y, boolean change) {
			super();
			this.x = x;
			this.y = y;
			this.change = change;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", change=" + change + ", str=" + str + "]";
		}

	}

}