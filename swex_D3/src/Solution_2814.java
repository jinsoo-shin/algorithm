import java.io.*;
import java.util.*;

public class Solution_2814 {
//	public class Solution {
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GOPPaAeMDFAXB&categoryId=AV7GOPPaAeMDFAXB&categoryType=CODE
	public static void main(String[] args) throws Exception {
		String src = "2\r\n" + "1 0\r\n" + "3 2\r\n" + "1 2\r\n" + "3 2\r\n";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());// 점
			int M = Integer.parseInt(st.nextToken());// 선
			List<Integer>[] list = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}

			ans = 0;
			if (M != 0) {
				// 굴리기

			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans;

	static void bfs(int start) {

	}
}
