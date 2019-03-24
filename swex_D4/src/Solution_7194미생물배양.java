import java.io.*;
import java.util.*;

public class Solution_7194미생물배양 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "10 28 4 2";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ans = -1;

			if (s > t) {
			} else {
				int cnt = 0;
				int tmp = (t / s) / b;
				System.out.println(tmp);
				if (tmp * b < t) {
					cnt += tmp;
					tmp = t - tmp * s * b;
					System.out.println(tmp);
					if (tmp % a == 0) {
						cnt += tmp / a;
						ans = cnt;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int s, t, a, b, ans;

}
