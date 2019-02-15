package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_6913 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		String src = "4\r\n" + "3 5\r\n" + "1 0 0 1 0\r\n" + "1 1 1 0 0\r\n" + "0 0 0 1 0\r\n" + "4 4\r\n"
				+ "1 1 1 1\r\n" + "1 1 1 1\r\n" + "1 1 1 1\r\n" + "1 1 1 1\r\n" + "4 4\r\n" + "0 1 1 1\r\n"
				+ "1 0 1 1\r\n" + "1 1 0 1\r\n" + "1 1 1 0\r\n" + "1 1\r\n" + "0";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] cnt = new int[M]; // 여기에 i번째사람이 푼거 갯수세서 넣기
			for (int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split(" ");
				int tmpcnt = 0;
				for (String s : tmp) {
					if (s.equals("1")) {
						tmpcnt++;
					}
				}
				cnt[i] = tmpcnt;
			}
			// 여기까지 넣었다ㅏ
			System.out.println(Arrays.toString(cnt));
			Arrays.sort(cnt);
			int ans1 = cnt[cnt.length - 1];// 1등이 푼 문제의 수
			int ans2 = 1;
			for (int i = 0; i < cnt.length - 1; i++) {
				if (cnt[i] == ans1) {
					ans2++;
				}
			}
			System.out.println("#" + tc + " " + ans2 + " " + ans1);
		}
	}
}
