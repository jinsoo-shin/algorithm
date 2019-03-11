import java.util.*;
import java.io.*;

public class Main_백준_알파벳_dfs문제 {

	public static void main(String[] args) throws IOException {
//		String src = "3 4\r\n" + "CAAB\r\n" + "ADCB\r\n" + "ABEB";
		String src = "4 4\r\n" + "CADB\r\n" + "BDBB\r\n" + "CAEB\r\n" + "CAFB\r\n";
//		String src = "2 4\r\n" + "CAAB\r\n" + "ADCB";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new String[R][C];
//		List<String> list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().split("");
//			System.out.println(Arrays.toString(map[i]));
		}
//		System.out.println("------");
		ans = 1;
		boolean[][] visit = new boolean[R][C];
		StringBuilder sb = new StringBuilder();
		sb.append(map[0][0]);
		dfs_per(0, 0, visit, sb);
		System.out.println(ans);
	}

	static String[][] map;
	static int R, C;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ans;

	static void dfs_per(int x, int y, boolean[][] visit, StringBuilder sb) {

		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (cx < 0 || cy < 0 || cx >= R || cy >= C) {
				continue;
			}
			if (visit[cx][cy]) {
				continue;
			}
			if (!sb.toString().contains(map[cx][cy])) {
				visit[cx][cy] = true;
				sb.append(map[cx][cy]);
				dfs_per(cx, cy, visit, sb);
				sb.deleteCharAt(sb.length() - 1);
				visit[cx][cy] = false;
			}
		}
//		if (list.size() < ans) {
//			return;
//		}
//		System.out.println(sb);
		ans = Math.max(ans, sb.length());
	}

}
