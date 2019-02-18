import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5162 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
		String src = "2\r\n" + "3 5 28\r\n" + "6 8 20	";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int ans = 0;
			// 현재 C원을 갖고있고
			// 그냥 많은 빵을 사기
			// 현미빵 A원 단호박 B원
			int big = 0, small = 0;
			if (A > B) {
				big = A;
				small = B;
			} else {
				big = B;
				small = A;
			}
			for (int i = 0; i < big / C; i++) {
				// i는 작은 빵의 갯수
				if (small * i - C == 0) {
					ans = i;
					break;
				}

			}
			if (ans == 0) {
				ans = C / small;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
