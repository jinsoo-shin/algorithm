import java.io.*;
import java.util.*;

public class Solution_2948 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "3 3\r\n" + "aa bb cc\r\n" + "dd cc aa";
//		String src = "1\r\n" + "2 3\r\n" + "ab a\r\n" + "a ac ba";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			int aL = Integer.parseInt(st.nextToken());
			int bL = Integer.parseInt(st.nextToken());
			String[] tmp = br.readLine().split(" ");
			Set<String> set = new HashSet<>();
			for (int i = 0; i < aL; i++) {
				set.add(tmp[i]);
			}
			tmp = br.readLine().split(" ");

			for (int i = 0; i < bL; i++) {
				if (set.contains(tmp[i])) {
					ans++;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
