import java.io.*;
import java.util.*;

//시간 오버
public class Solution_D5종구딸 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "2 5\r\n" + "adbfc\r\n" + "dcghi";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			char[][] map = new char[r][c];
			for (int i = 0; i < r; i++) {
				map[i] = br.readLine().toCharArray();
//				System.out.println(Arrays.toString(map[i]));
			}
			StringBuilder sb = new StringBuilder();
			sb.append(map[0][0]);
			ans = null;
			dfs(0, 0, sb, map);
//			System.out.println(list);
//			System.out.println(list);

			System.out.println("#" + tc + " " + ans);
		}
	}

	static String ans;
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };
	static int r, c;
//	static char[][] map;

	static void dfs(int x, int y, StringBuilder sb, char[][] map) {
		if (x == r - 1 && y == c - 1) {
//			sb.append(map[x][y]);
//			System.out.println(ans);
//			System.out.println(sb.toString());
			if (ans == null) {
				ans = sb.toString();
			} else {
				String tmp = sb.toString();
				if (tmp.compareTo(ans) < 0) {
					ans = tmp;
				}
			}
			return;
		}
		int nx = 0;
		int ny = 0;
		char tmp = (char) 123;
		for (int i = 0; i < 2; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (cx < 0 || cy < 0 || cx >= r || cy >= c) {
				continue;
			}
			if (map[cx][cy] < tmp) {
				nx = cx;
				ny = cy;
				tmp = map[cx][cy];
			} else if (map[cx][cy] == tmp) {
				// 같은거니깐 보내기
				sb.append(map[cx][cy]);
				dfs(cx, cy, sb, map);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		sb.append(tmp);
		dfs(nx, ny, sb, map);
		sb.deleteCharAt(sb.length() - 1);

	}
}
