import java.io.*;
import java.util.*;

public class Solution_5356 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
		String src = "2\r\n" + "ABCDE\r\n" + "abcde\r\n" + "01234\r\n" + "FGHIJ\r\n" + "fghij\r\n" + "AABCDD\r\n"
				+ "afzz\r\n" + "09121\r\n" + "a8EWg6\r\n" + "P5h3kx";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[][] map = new String[5][15];
			int maxN = 0;
			for (int i = 0; i < 5; i++) {
				map[i] = br.readLine().split("");
				maxN = Math.max(map[i].length, maxN);
			}
			String[][] ans = new String[5][maxN];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < maxN; j++) {
					if (j >= map[i].length) {
						ans[i][j] = "#";
					} else {
						ans[i][j] = map[i][j];
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < maxN; j++) {
				for (int i = 0; i < 5; i++) {
					if (!ans[i][j].equals("#"))
						sb.append(ans[i][j]);
				}
			}
			System.out.println("#" + tc + " " + sb.toString());
		}
	}
}
