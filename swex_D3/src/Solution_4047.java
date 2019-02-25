import java.io.*;
import java.util.*;

public class Solution_4047 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n" + "S01D02H03H04";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());// 테스트케이스
		for (int tc = 1; tc <= T; tc++) {
			String answer = " ERROR";
			Boolean flag = false;
			int[][] ans = new int[4][13];// 무늬요
			// S D H C; //1부터 13
			String[] tmp = br.readLine().split("");
			for (int i = 0; i < tmp.length / 3; i++) {
				int idx = 3 * i;
				int row = 0;
				if (tmp[idx].equals("S")) {
					row = 0;
				} else if (tmp[idx].equals("D")) {
					row = 1;
				} else if (tmp[idx].equals("H")) {
					row = 2;
				} else if (tmp[idx].equals("C")) {
					row = 3;
				}
				idx++;
				String tmpStr = tmp[idx] + tmp[idx + 1];
				int tmp1 = Integer.parseInt(tmpStr) - 1;
				if (ans[row][tmp1] == 1) {//이미 있으면
					flag = true;
					break;
				} else {
					ans[row][tmp1]++;
				}
			}

//			for(int[] row:ans) {
//				System.out.println(Arrays.toString(row));
//			}
			if (!flag) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 4; i++) {
					int cnt = 0;
					for (int j = 0; j < 13; j++) {
						if (ans[i][j] == 1) {
							cnt++;
						}
					}
					sb.append(" " + (13 - cnt));
				}
				answer = sb.toString();
			}
			System.out.println("#" + tc + answer);
		}
	}
}
