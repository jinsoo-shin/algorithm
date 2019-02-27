import java.io.*;
import java.util.*;

public class Solution_5986 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "4\r\n" + "5\r\n" + "11\r\n" + "25\r\n" + "13\r\n";
//		String src = "1\r\n" + "7\r\n";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		List<Integer> list = new LinkedList<>();
		for (int j = 2; j < 1000; j++) {
			list.add(j);
		}
		for (int i = 2; i <= 33; i++) {
			for (int k = 0; k < list.size(); k++) {
				if (list.get(k) == i) {
					continue;
				} else {
					if (list.get(k) % i == 0) {
						list.remove(k);
						k = k - 1;
					}
				}
			}
		}
		System.out.println(list);
		// “5보다 큰 모든 홀수는 정확히 세 소수의 합으로 표현될 수 있다. (같은 소수를 합에 사용해도 된다.)”
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			ans = 0;
			int findIdx = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) > N) {
					findIdx = i - 1;
					break;
				}
			}

			System.out.println(findIdx + " ");
			for (int i = 0; i < findIdx; i++) {
				for (int j = i; j < findIdx; j++) {
					for (int k = j; k < findIdx; k++) {
						if (list.get(i) + list.get(j) + list.get(k) == N) {
							System.out.println(list.get(i) + " " + list.get(j) + " " + list.get(k));
							ans++;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
//			System.out.println(findIdx + " " + N);
//			Queue<Integer>[] go = new LinkedList[findIdx];
//			for (int i = 0; i < findIdx; i++) {
//				go[i] = new LinkedList<>();
//				go[i].add(list.get(i));// 소수 넣어두기
//			}
//			for (int i = 0; i < findIdx; i++) {
//
//				// 현재
//				int cnt = 0;
//				int tmp = go[i].poll();
//				int sum = tmp;
//				System.out.println(tmp + " tmp");
//
//				while (!go[i].isEmpty()) {
//					// 돌아간다아ㅏㅏㅏㅏㅏㅏ
//
//					for (int j = 0; j < findIdx; j++) {
//						
//					}
//
//				}
//			}
//
//			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans;

}
