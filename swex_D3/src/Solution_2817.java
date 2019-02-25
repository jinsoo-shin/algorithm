import java.io.*;
import java.util.*;

public class Solution_2817 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "4 3\r\n" + "1 2 1 2";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
//A1, A2, ... , AN의 N개의 자연수가 주어졌을 때, 최소 1개 이상의 수를 선택하여 그 합이 K가 되는 경우의 수를 구하는 프로그램을 작성하시오.

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());// 합이 K가 되는 경우의 수
			ans = 0;
			String[] tmp = br.readLine().split(" ");
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(tmp[i]);
			}
			per(arr, 0, K, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans;

	static void per(int[] arr, int idx, int K, int sum) {
		if (sum > K) {
			return;
		}
		if (idx == arr.length) {
			if (sum == K) {
				ans++;
			}
			return;
		}

		per(arr, idx + 1, K, sum + arr[idx]);
		per(arr, idx + 1, K, sum);

	}
}
