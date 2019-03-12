import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Solution_5642_성하 {
	public static void main(String[] args) throws IOException {
		String src = "1\r\n" + "5\r\n" + "1 3 -8 18 -8";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int totalmax = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (totalmax < arr[i])
					totalmax = arr[i];
			}
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = arr[i];

				if (max < sum)
					max = sum;

				if (sum < 0)
					continue;

				for (int j = i + 1; j < N; j++) {
//					if (sum - arr[j] < totalmax * -1)
					if (sum + totalmax < arr[j])
						break;

					sum += arr[j];

					if (max < sum) {
						max = sum;
					}

				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}
