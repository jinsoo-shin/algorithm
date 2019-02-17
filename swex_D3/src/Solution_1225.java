import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1225 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		String src = "1\r\n" + "9550 9556 9550 9553 9558 9551 9551 9551";
		String src = "1\r\n" + "9550 9556 9550 9553 9558 9551 9551 9551\r\n" + "2\r\n"
				+ "2419 2418 2423 2415 2422 2419 2420 2415";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		for (int tc = 1; tc <= 2; tc++) {
			br.readLine();
			int[] tmp = new int[8];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				tmp[i] = Integer.parseInt(st.nextToken());
			}
			int idx = 0;
			go: while (true) {

				for (int j = 1; j <= 5; j++) {
					tmp[idx] = tmp[idx] - j;
					if (tmp[idx] <= 0) {
						tmp[idx] = 0;
						break go;
					}
					idx++;
					idx = idx % 8;
				}

			}

			int zeroIdx = 0;
			for (int i = 0; i < 8; i++) {
				if (tmp[i] == 0) {
					zeroIdx = i;
				}
			}
			int tmpIdx = zeroIdx + 1;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 8; i++) {
				sb.append(" " + tmp[tmpIdx]);
				tmpIdx = (tmpIdx + 1) % 8;
			}

			System.out.println("#" + tc + sb.toString());
		}
	}
}
