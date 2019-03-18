import java.io.*;
import java.util.*;

public class Solution_요리사 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "14\r\n" + "0 6759 419 8099 7845 4710 3475 1397 7405 1244 7354 5647 6006 1387\r\n"
				+ "9802 0 3077 7064 1529 8966 8596 7348 8761 2943 104 750 4492 1211\r\n"
				+ "4172 5855 0 517 2715 5271 7893 4242 8841 18 8665 1687 1297 6508\r\n"
				+ "4298 5555 3509 0 8500 8064 7627 7653 8585 1695 9449 1831 5509 340\r\n"
				+ "5791 3397 9348 3097 0 440 4476 7285 9915 4417 2600 2457 1809 3043\r\n"
				+ "6905 4642 5300 1361 9838 0 1778 4926 512 4994 824 4156 4972 1487\r\n"
				+ "1165 4974 721 3975 2272 3028 0 1127 3052 2649 6005 4245 1092 3540\r\n"
				+ "2283 1097 7528 8376 1825 530 1123 0 641 8386 3981 9362 9051 1898\r\n"
				+ "3693 8834 2530 1077 2396 5337 8038 6168 0 1344 8333 5492 987 679\r\n"
				+ "9557 3610 3592 7376 3677 7215 5463 1592 6974 0 59 6715 8573 3622\r\n"
				+ "5372 1217 9520 9330 5338 2435 1624 4886 2286 1058 0 3007 6893 1602\r\n"
				+ "6361 5073 673 521 7996 4491 7009 2596 6194 220 9300 0 5746 1411\r\n"
				+ "6673 9617 9615 2690 1211 3784 2154 3673 3699 8440 2745 1195 0 8535\r\n"
				+ "5812 4670 7352 2441 263 6531 4064 4587 9550 7000 7277 7927 5908 0";
//		String src = "1\r\n" + "6\r\n" + "0 37 26 52 77 20\r\n" + "32 0 15 26 75 16\r\n" + "54 33 0 79 37 90\r\n"
//				+ "92 10 66 0 92 3\r\n" + "64 7 89 89 0 21\r\n" + "80 49 94 68 5 0";
//		String src = "1\r\n" + "4\r\n" + "0 5 3 8\r\n" + "4 0 4 1\r\n" + "2 5 0 3\r\n" + "7 2 3 0";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = i;
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
//				System.out.println(Arrays.toString(S[i]));
			}
			ans = Integer.MAX_VALUE;
			set = new HashMap<>();
			powerSet(new boolean[N], 0, 0, N);

			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans;
	static HashMap<String, Integer> set;

	static void powerSet(boolean[] visit, int idx, int cnt, int N) {
		if (idx == N) {
			if (cnt == N / 2) {
				int[] arr1 = new int[N / 2];
				int[] arr2 = new int[N / 2];
				int idx1 = 0;
				int idx2 = 0;
				for (int i = 0; i < N; i++) {
					if (visit[i]) {
						arr1[idx1++] = i;
					} else {
						arr2[idx2++] = i;
					}
				}
				cal(arr1, arr2);
//				cal(str1, str2);
//				System.out.println("---------------------");
			}
			return;
		}

		visit[idx] = true;
		powerSet(visit, idx + 1, cnt + 1, N);
		visit[idx] = false;
		powerSet(visit, idx + 1, cnt, N);
	}

	static void cal(int[] arr1, int[] arr2) {
		String str1 = arr1.toString();
		String str2 = arr2.toString();
		if (set.containsKey(str1)) {
			return;
		}
//		if (set.containsKey(str2)) {
//			return;
//		}
		int cal1 = 0;
		int cal2 = 0;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				cal1 += S[arr1[i]][arr1[j]];
				cal2 += S[arr2[i]][arr2[j]];
			}
		}
		int tmp = Math.abs(cal1 - cal2);
		ans = Math.min(ans, tmp);
		set.put(str1, tmp);
		set.put(str2, tmp);
//		System.out.println(cal1);
//		System.out.println("----");
//		System.out.println(cal2);
	}

	static int[][] S;
}
