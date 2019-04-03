import java.io.*;
import java.util.*;

public class Solution_4672팰린드롬 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "zzzzasdf";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] str = br.readLine().split("");
			Arrays.sort(str);
			ans = 0;
			check(str);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void check(String[] str) {
		int cnt = 0;
		for (int len = 1; len <= str.length; len++) {
			next: for (int start = 0; start <= str.length - len; start++) {// 0 1
				for (int i = 0; i < (len + 1) / 2; i++) {// 0>01
					if (!str[start + i].equals(str[start + len - i - 1])) {
						continue next;
					}
				}
				cnt++;
			}
		}
		ans = cnt;
	}

	static int ans;
}
