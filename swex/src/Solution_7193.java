import java.io.*;
import java.util.*;

public class Solution_7193 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "3\r\n" + "9 234\r\n" + "5 123\r\n" + "3 102 ";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			long ans = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String[] num = st.nextToken().split("");

//			System.out.println(num.length);

			long tmp = 0;
			for (int i = 0; i < num.length; i++) {
				int tmpN = Integer.parseInt(num[num.length - 1 - i]);
//				System.out.println(Math.pow(N, i));
				if (tmpN != 0) {
					tmp += ((int) Math.pow(N, i) * tmpN) % (N - 1);
//					System.out.println(tmp + " dd");
				}

			}
			ans = tmp % (N - 1);
			System.out.println("#" + tc + " " + ans);
		}
	}
}
