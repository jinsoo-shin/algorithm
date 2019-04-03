import java.io.*;
import java.util.*;

public class Solution_3289서로소 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "7 8\r\n" + "0 1 3\r\n" + "1 1 7\r\n" + "0 7 6\r\n" + "1 7 1\r\n" + "0 3 7\r\n"
				+ "0 4 2\r\n" + "0 1 1\r\n" + "1 1 1\r\n";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans = 0;
			parents = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}
//			System.out.println(Arrays.toString(parents));
			StringBuilder sb = new StringBuilder("#").append(tc).append(" ");
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				if (a == 0) {
					if (b == c) {
						continue;
					}
					union(b, c);
				} else {
					if (findP(b) == findP(c)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			System.out.println(sb);
//			System.out.println(Arrays.toString(parents));
//			System.out.println("#" + tc + " " + ans);
		}
	}

	static int findP(int x) {
		if (parents[x] == x) {
			return x;
		} else {
			int cx = parents[x];
			return findP(cx);
		}
	}

	static void union(int x, int y) {
		int cx = findP(x);
		int cy = findP(y);

		if (cx < cy) {
			parents[cy] = cx;
		} else {
			parents[cx] = cy;
		}
	}

	static int[] parents;
	static int N, M, ans;
}
