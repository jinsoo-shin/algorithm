import java.io.*;
import java.util.*;

public class Solution_양팔저울 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		String src = "1\r\n" + "9\r\n" + "1 2 3 5 6 4 7 8 9";
//		String src = "1\r\n" + "4\r\n" + "1 2 4 6";
//		String src = "3\r\n" + "3\r\n" + "1 2 4\r\n" + "3\r\n" + "1 2 3\r\n" + "9\r\n" + "1 2 3 5 6 4 7 8 9";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = 0;
			st = new StringTokenizer(br.readLine());
			num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			set = new HashSet<>();
//			comb(new boolean[N], 0, 0, 0);
			per(num, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans, N;
	static int num[];
	static Set<String> set;

	static void comb(boolean[] flag, int idx, int sumL, int sumR) {
		if (sumL < sumR) {
			return;
		}
		if (idx == N) {
			ans++;
			return;
		}
		flag[idx] = true;
		comb(flag, idx + 1, sumL + num[idx], sumR);
		flag[idx] = false;
		comb(flag, idx + 1, sumL, sumR + num[idx]);
	}

	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	static void per(int[] arr, int idx) {
		if (idx == arr.length) {
//			System.out.println("-------------");
//			System.out.println(Arrays.toString(arr));
			comb(new boolean[N], 0, 0, 0);
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			swap(arr, i, idx);
			per(arr, idx + 1);
			swap(arr, i, idx);

		}
	}
}
