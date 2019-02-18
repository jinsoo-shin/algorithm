import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5515 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
		String src = "2\r\n" + "1 1\r\n" + "12 31";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int[] cal = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int ans = 0;
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			int day = 0;
			for (int i = 1; i < m; i++) {
				day += cal[i];
			}
			day += d;

			ans = (day+3) % 7;
			System.out.println("#" + tc + " " + ans);
		}
	}
}
