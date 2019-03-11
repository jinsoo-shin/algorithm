import java.io.*;
import java.util.*;

public class Solution_5642 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "5\r\n" + "1 3 -8 18 -8";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			int[] tmp = new int[arr.length];
			int max = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				tmp[i] = arr[i];
				max = Math.max(tmp[i], max);
			}
//			System.out.println("원본" + Arrays.toString(arr));
			for (int j = 1; j < N; j++) {// 길이
				if (tmp[j - 1] > 0 && tmp[j] + tmp[j - 1] > 0) {
					tmp[j] += tmp[j - 1];
				}
				if (max < tmp[j]) {
					max = tmp[j];
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}
