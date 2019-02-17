
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1976시간 {
	// public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "3\r\n" + "3 17 1 39\r\n" + "8 22 5 10\r\n" + "6 53 2 12";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int[][] time = new int[2][2];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					time[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int hour = 0;
			int min = 0;
			min += time[0][1] + time[1][1];
			if ((min / 60) != 0) {
				hour += min / 60;
				min = min % 60;
			}
			hour = (hour+time[1][0] + time[0][0]) % 12;

			System.out.println("#" + tc + " " + hour + " " + min);
		}
	}
}
