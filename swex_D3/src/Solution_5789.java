import java.io.*;
import java.util.*;

public class Solution_5789 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "5 2\r\n" + "1 3\r\n" + "2 4";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		// 1번부터 N번까지 N개의 상자
		// 숫자 새길수있는데 첨에는 모두 0
		// Q회동안 일정 범위의 연속한 상자를 동일한 숫자로 변경
		// i번째 작업에 대해 L번부터 R번상자까지 값을 i로 변경
		// Q회동안 위의 작업을 순서대로 한다음
		// N개의 상자에 적혀있는 값들을 순서대로 출력하는 프로그램

		int T = Integer.parseInt(br.readLine());// 테케
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());// 5
			int Q = Integer.parseInt(st.nextToken());// 2
			int[] arr = new int[N];

			for (int i = 1; i <= Q; i++) {
				st = new StringTokenizer(br.readLine());
				int L = Integer.parseInt(st.nextToken()) - 1;
				int R = Integer.parseInt(st.nextToken()) - 1;

				for (int j = L; j <= R; j++) {
					arr[j] = i;
				}
			}
			System.out.println(Arrays.toString(arr));
			System.out.println("#" + tc + " ");
		}
	}
}
