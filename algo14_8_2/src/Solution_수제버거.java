import java.util.*;
import java.io.*;

public class Solution_수제버거 {
	public static void main(String[] args) throws IOException {

		String src = "1\r\n" + "3 2\r\n" + "1 2\r\n" + "2 3";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());// 재료의 수
			int M = Integer.parseInt(st.nextToken());// ㄴㄴ쌍
			int[] no1 = new int[M];
			int[] no2 = new int[M];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				no1[i] = Integer.parseInt(st.nextToken()) - 1;
				no2[i] = Integer.parseInt(st.nextToken()) - 1;
			} // 조건을 받아왔다
			ans = 0;
			re(new boolean[N], 0, no1, no2);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans;

	static void re(boolean[] flag, int idx, int[] no1, int[] no2) {
		if (idx == flag.length) {
			for (int i = 0; i < no1.length; i++) {
				if (flag[no1[i]] && flag[no2[i]]) {
					return;
				}
			}
			ans++;
			return;
		}
		for (int i = 0; i < no1.length; i++) {
			if (flag[no1[i]] && flag[no2[i]]) {
				return;
			}
		}
		flag[idx] = true;
		re(flag, idx + 1, no1, no2);
		flag[idx] = false;
		re(flag, idx + 1, no1, no2);
	}
}
