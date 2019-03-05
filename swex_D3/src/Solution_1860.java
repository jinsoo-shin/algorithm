import java.io.*;
import java.util.*;

public class Solution_1860 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "4\r\n" + "2 2 2\r\n" + "3 4\r\n" + "2 2 2\r\n" + "1 2\r\n" + "2 2 1\r\n" + "4 2\r\n" + "2 2 1\r\n"
				+ "3 2";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		/*
		 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
		 * 
		 * 각 테스트 케이스의 첫 번째 줄에는 세 자연수 N, M, K(1 ≤ N, M, K ≤ 100)가 공백으로 구분되어 주어진다.
		 * 
		 * 두 번째 줄에는 N개의 정수가 공백으로 구분되어 주어지며,
		 * 
		 * 각 정수는 각 사람이 언제 도착하는지를 초 단위로 나타낸다. 각 수는 0이상 11,111이하이다.
		 */

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
//			M초의 시간을 들이면 K개의 붕어빵을 만들 수 있다.
			int N = Integer.parseInt(st.nextToken());// 손님
			int M = Integer.parseInt(st.nextToken());// M초의 시간마다
			int K = Integer.parseInt(st.nextToken());// K개의 붕어빵
			int[] people = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				people[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(people);
			int[] ppang = new int[people[N - 1] + 1];
			for (int i = M; i < ppang.length; i++) {
				ppang[i] = ppang[i - 1];
				if (i % M == 0)
					ppang[i] += K;
			}
//			System.out.println(Arrays.toString(people));
//			System.out.println(Arrays.toString(ppang));
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if (ppang[people[i]] == 0) {
					flag = true;// 불가능하다
					break;
				} else if (ppang[people[i]] > 0) {
					for (int j = people[i]; j < ppang.length; j++) {
						ppang[j]--;
					}
				}
//				System.out.println(people[i] + "초에 사람 " + Arrays.toString(ppang));
			}
			if (flag) {
				sb.append("#" + tc + " " + "Impossible\n");
//				System.out.println("#" + tc + " " + "Impossible");
			} else {
				sb.append("#" + tc + " " + "Possible\n");
//				System.out.println("#" + tc + " " + "Possible");
			}
		}
		System.out.println(sb);
	}
}
