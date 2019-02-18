import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4466 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "2\r\n" + "3 1\r\n" + "100 90 80\r\n" + "3 2\r\n" + "100 90 80";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int ans = 0;
			int arr[] = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			for (int i = N - 1; i >= N - K; i--) {
				ans += arr[i];
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
