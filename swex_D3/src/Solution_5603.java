import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5603 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n" + "4\r\n" + "2\r\n" + "10\r\n" + "7\r\n" + "1";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			int[] arr = new int[N];
			int tmp = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				tmp += arr[i];
			}
			tmp = tmp / N;
			for (int i = 0; i < N; i++) {
				ans += Math.abs(arr[i] - tmp);
			}
			System.out.println("#" + tc + " " + ans / 2);
		}
	}
}
