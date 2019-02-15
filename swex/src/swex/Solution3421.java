package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution3421 {
	static int[][] no;
	static int N;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "3\r\n" + "3 2\r\n" + "1 2\r\n" + "2 3\r\n" + "3 0\r\n" + "3 3\r\n" + "1 2\r\n" + "1 3\r\n"
				+ "2 3";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			no = new int[M][2];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				no[i][0] = Integer.parseInt(st.nextToken()) - 1;
				no[i][1] = Integer.parseInt(st.nextToken()) - 1;
			}
//N은 재료		
			boolean flag[] = new boolean[N];
			ans = 0;
			re(0, flag);
			// M은 조합 ㄴㄴㄴ 배열
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void re(int idx, boolean[] flag) {
		if (idx == N) {
			for (int i = 0; i < no.length; i++) {
				if (flag[no[i][0]] == true && flag[no[i][1]] == true) {
					return;
				}
			}
			ans++;
			return;
		}
		for (int i = 0; i < no.length; i++) {
			if (flag[no[i][0]] == true && flag[no[i][1]] == true) {
				return;
			}
		}
		// check용 만들기 조합 맞는지!!

		flag[idx] = true;
		re(idx + 1, flag);
		flag[idx] = false;
		re(idx + 1, flag);
	}
}
