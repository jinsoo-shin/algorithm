import java.io.*;
import java.util.*;

public class Solution_콩 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
		String src = "1\r\n" + "3 5\r\n";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] dx = { 0, 0, 2, -2 };
			int[] dy = { 2, -2, 0, 0 };
			int ans = 0;
			// true면 못가!
			int map[][] = new int[N][M];
			map[0][0] = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] < 0) {
						continue;
					}
					for (int k = 0; k < 4; k++) {
						int cx = i + dx[k];
						int cy = j + dy[k];
						if (cx < 0 || cy < 0 || cx >= N || cy >= M) {
							continue;
						}
						if (map[cx][cy] == -1) {
							continue;
						}
						map[cx][cy] = -1;
					}
					map[i][j] = 1;
					ans++;
				}
			}
//
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
