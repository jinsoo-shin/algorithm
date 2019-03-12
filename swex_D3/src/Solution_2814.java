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
			N = Integer.parseInt(st.nextToken());// 점
			M = Integer.parseInt(st.nextToken());// 선
			list = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				list[from].add(to);
				list[to].add(from);
			}

			ans = 0;
			if (M != 0) {
				// 굴리기
				boolean[] visit = new boolean[N];
				visit[0] = true;
				bfs(visit, 0, 1);
//				for (int i = 0; i < N; i++) {
//				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	static List<Integer>[] list;
	static int ans, N, M;

	static void bfs(boolean[] visit, int idx, int cnt) {
		int check = 0;
		if (cnt == N) {
			System.out.println(cnt + " dddd");
			return;
		}
		System.out.println(idx);
		for (int i = 0; i < list[idx].size(); i++) {
			int tmp = list[idx].get(i);
			if (visit[tmp]) {
				check++;
				System.out.println(cnt + " dddd");
				continue;
			}

			visit[tmp] = true;
			bfs(visit, tmp, cnt + 1);
			visit[tmp] = false;
			bfs(visit, tmp, cnt);
		}
		System.out.println(list[idx].size());
		if (check == list[idx].size()) {
			System.out.println("호우");
			return;
		}
	}
}
