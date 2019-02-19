import java.io.*;
import java.util.*;

public class Solution_4299 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
		String src = "3\r\n" + "14 23 59\r\n" + "11 11 11\r\n" + "11 3 7";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken()) - 11;
			int H = Integer.parseInt(st.nextToken()) - 11;
			int M = Integer.parseInt(st.nextToken()) - 11;
//			System.out.println(D + " " + H + " " + M);
			ans = (D * 1440) + (H * 60) + M;
			if (ans < 0) {
				ans = -1;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
