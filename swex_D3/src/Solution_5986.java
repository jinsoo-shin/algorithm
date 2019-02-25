import java.io.*;
import java.util.*;

public class Solution_5986 {
	static List<Integer> sosu;
	static List<Integer> list;
//	static List<Integer> list2;
	static int ans;

//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "2\r\n" + "7\r\n" + "11";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		/// 소수만들기
		boolean[] sosuB = new boolean[1000];
		for (int i = 2; i < Math.sqrt(sosuB.length) + 1; i++) {
			if (sosuB[i]) {
				continue;
			}
			for (int j = i + 1; j < sosuB.length; j++) {
				if (j % i == 0) {
					sosuB[j] = true;
				}
			}
		}

		sosu = new LinkedList<>();
		for (int i = 2; i < sosuB.length; i++) {
			if (!sosuB[i]) {
				sosu.add(i);
			}
		}
		System.out.println(sosu);
		/// 소수만들기 끝
//		System.out.println(getIdx(7));
		list = new LinkedList<>();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			int N = Integer.parseInt(br.readLine());
			int idx = getIdx(N)-1;
//			System.out.println(list);
			System.out.println(getIdx(N));
			for (int i = 0; i < idx; i++) {
				for (int j = i; j < idx; j++) {
					for (int k = j; k < idx; k++) {
						if (sosu.get(i) + sosu.get(j) + sosu.get(k) == N) {
							System.out.println(sosu.get(i) + " " + sosu.get(j) + " " + sosu.get(k));
							ans++;
						}
					}
				}
			}

			// 2 3 5 추출했다
			// 중복조합 가즈아
//			list2 = new LinkedList<>();
//			find(list2, 0, N);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static int getIdx(int N) {// 앞의 소수만 뽕
		for (int i = 0; i < sosu.size(); i++) {
			if (N < sosu.get(i))
				return i;
		}
		return -1;
	}

}
