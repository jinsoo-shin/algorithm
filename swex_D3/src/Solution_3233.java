import java.io.*;
import java.util.*;

public class Solution_3233 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
		String src = "2\r\n" + "4 1\r\n" + "3 3";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			double ans = 0;
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			System.out.println(A + " " + B);
			int tmpA = A;
			int tmpB = B;
			while (tmpB != 1) {
				tmpA = tmpA / B;
				tmpB = tmpB / B;
			}
			if (tmpA == tmpB) {
				ans = 1;
			} else {
				ans = Math.pow(tmpA, 2);
			}
			System.out.println(tmpA + " " + tmpB);
			// 1 1이면 1
			// 2 1이면 4고
			// 4 1이면 4*4
			// 3 1이면 4+5=9
			// 9 3이면 9*9

			System.out.println("#" + tc + " " + (long) ans);
		}
	}
}
