package swex;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_6855_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc < t + 1; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int arr[] = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			if (N <= K) {
				System.out.println("#" + tc + " " + 0);
			} else {
				int sum = 0;
				int ans[] = new int[N];
				
				for (int i = 0; i < N; i++) {
					if (i != 0) {
						ans[i] = arr[i] - arr[i - 1];
					}
				}
				ans[0] = 0;
				Arrays.sort(ans);
				System.out.println(Arrays.toString(ans));
				
				//큰거 버리고 나머지 더하기!(버리는건 제일 큰거인데 K-1개만큼)
				for (int i = 0; i < K - 1; i++) {
					ans[N - 1 - i] = 0;
				}
				for (int i : ans) {
					sum += i;
				}
				System.out.println("#" + tc + " " + sum);
			}
		}
	}

}