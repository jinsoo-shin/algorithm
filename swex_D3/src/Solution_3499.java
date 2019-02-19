import java.io.*;
import java.util.*;

public class Solution_3499 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n" + "7\r\n" + "A B C D E F G";
//		String src = "1\r\n" + "5\r\n" + "ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		// A B C D E F면
		// 0 1 2 3 4 5
		// A D B E C F
		// 0 3 1 4 2 5로 셔플된다

		// N=5일때
		// ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA
		// 0 3 1 4 2
		// ALAKIR LORD-JARAXXUS ALEXSTRASZA AVIANA DR-BOOM

		int T = Integer.parseInt(br.readLine());// 테케수
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());// 카드 수
			String[] tmp = br.readLine().split(" ");

			StringBuilder sb = new StringBuilder();
			int idx = N / 2;
			if (N % 2 == 1) {
				idx += 1;
			}
			for (int i = 0; i < N / 2; i++) {
				sb.append(" " + tmp[i] + " " + tmp[idx + i]);
			}
			if (N % 2 == 1) {
				sb.append(" " + tmp[idx - 1]);
			}

			System.out.println("#" + tc + sb.toString());
		}
	}
}
