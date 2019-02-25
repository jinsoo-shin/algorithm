import java.io.*;
import java.util.*;

public class Solution_4371 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		String src = "1\r\n" + "3\r\n" + "1\r\n" + "3\r\n" + "4";
		String src = "3\r\n" + "3\r\n" + "1\r\n" + "3\r\n" + "4\r\n" + "5\r\n" + "1\r\n" + "7\r\n" + "10\r\n" + "13\r\n"
				+ "19\r\n" + "3\r\n" + "1\r\n" + "500000000\r\n" + "999999999";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		// 모든 배들이 항구에 들어온 것 1일차로 지정
		// 한척이라도 항구에 들르면 즐거운날로 이름짓고 즐거운날로 지정
		// 규칙!! 항구에 주기적으로 들른다
		// 주기가 3이면 1 4 7에 방문
		// 즐거운날의 목록이 주어질때 항구에 들렀던 배의 최소 수를 구해라

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int N = Integer.parseInt(br.readLine());// 즐거운날 정보 N개
			int[] fun = new int[N];
			for (int i = 0; i < N; i++) {
				fun[i] = Integer.parseInt(br.readLine());
			} // 즐거운 날의 정보
			int[] arr = new int[N - 1];
			for (int i = 1; i < N; i++) {
				arr[i - 1] = fun[i] - 1;
				// 1 3 4 5 9 라면...
				// 1 3 5 7 9 주기2 주기4 주기8이래요... 결국 주기 2랑 3!!
				// 1 4 7 10 주기3
				// 1 5 9 주기4
				// 결국 주기 2랑 3!!
				// 뭔가 에라토스테네스 체같은 느낌아닌 느낌... 차를 전부 구하고...
				
				//-> 배수제거하는거 맞았다
			}
//			System.out.println(Arrays.toString(arr));
			go: for (int i = 0; i < arr.length; i++) {
				if (arr[i] == -1) {
					continue go;
				}
				for (int j = i + 1; j < arr.length; j++) {

					if (arr[j] % arr[i] == 0) {
						arr[j] = -1;// 배수인거니깐 제거
					}
				}
			}
//			System.out.println("제거제거" + Arrays.toString(arr));
			for (int a : arr) {
				if (a != -1) {
					ans++;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
