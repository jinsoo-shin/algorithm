import java.io.*;
import java.util.*;

public class Solution_4676 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "2\r\n" + "wow\r\n" + "3\r\n" + "2 3 2\r\n" + "hoi\r\n" + "3\r\n" + "0 0 0";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] tmp = br.readLine().split("");
			int H = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			// 문자열길이는 1이상 20이하
			int[] pos = new int[tmp.length + 1];
			for (int i = 0; i < H; i++) {
				int idx = Integer.parseInt(st.nextToken());
				pos[idx]++;
			}
			// 012
			// wow
			// 2 3 2위치
			// wo--w-
			// 01
			System.out.println(Arrays.toString(pos));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i <= tmp.length; i++) {
				if (pos[i] != 0) {
					for (int j = 0; j < pos[i]; j++) {
						sb.append("-");
					}
				}
				if (i != tmp.length) {
					sb.append(tmp[i]);
				}
			}

			System.out.println("#" + tc + " " + sb.toString());
		}
	}
}
