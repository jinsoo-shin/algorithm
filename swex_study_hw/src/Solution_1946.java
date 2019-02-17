import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1946 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n" + "3\r\n" + "A 10\r\n" + "B 7\r\n" + "C 5     ";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String alpha = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				for (int j = 0; j < num; j++) {
					sb.append(alpha);
				}
			}

			System.out.print("#" + tc);

			String[] tmp = sb.toString().split("");
			for (int i = 0; i < tmp.length; i++) {
				if (i % 10 == 0) {
					System.out.println();
				}
				System.out.print(tmp[i]);
			}
			System.out.println();
		}
	}
}
