import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1984 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "3\r\n" + "3 17 1 39 8 41 2 32 99 2 \r\n" + "22 8 5 123 7 2 63 7 3 46 \r\n"
				+ "6 63 2 3 58 76 21 33 8 1 ";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int[] N = new int[10];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				N[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(N);
			double sum = 0;
			for (int i = 1; i < N.length - 1; i++) {
				sum += N[i];
			}
			System.out.println(String.format("#%d %.0f", tc, sum / 8));
		}
	}
}
