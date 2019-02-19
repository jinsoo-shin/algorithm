import java.io.*;
import java.util.*;

public class Solution_1221 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n" + "#1 6\r\n" + "TWO NIN TWO TWO FIV FOR";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			br.readLine();

			String[] num = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };
			String[] tmp = br.readLine().split(" ");
			int N = tmp.length;
			System.out.println(N);
			int[] ans = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < num.length; j++) {
					if (tmp[i].equals(num[j])) {
						ans[i] = j;
						break;
					}
				}
			}
			Arrays.sort(ans);
			StringBuilder sb = new StringBuilder();
			for (int a : ans) {
				sb.append(" " + num[a]);
			}
			System.out.println("#" + tc + sb.toString());
		}
	}
}
