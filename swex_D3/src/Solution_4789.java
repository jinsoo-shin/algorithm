import java.io.*;
import java.util.*;

public class Solution_4789 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
//		String src = "5\r\n" + "11111\r\n" + "00009\r\n" + "110011\r\n" + "1\r\n" + "10200001";
		String src = "1\r\n" + "110011";
		// 0 1 2 0 1답
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		// 특정수가 넘어야만 박수를 친다함
		// 사람마다 기립박수하는 조건을 알게되었다 조건없으면 박수칠거고 조건만족한사람들이 연쇄적으로 기립박수하게됨
		// 몇명을 고용해서 기립박수를 하게할수있는가??
		// 첫번째글자는 아무도없을때 무조건상태에서 기립박수하는 사람의 수
		// i번재 글자는 i-1명이상일때 기립박수하는 사람의 수
//		각 테스트 케이스의 첫 번째 줄에는 ‘0’에서 ‘9’사이의 문자 만으로 이루어진 문자열이 주어진다. 이 문자열의 길이는 1001 이하이다.
//		가장 마지막 문자는 ‘0’이 아니다. (적어도 한 명의 관객이 있음을 의미한다.)

		// 입력 110011
		// 1명이박수치면 뒤이어 1명이박수치고... 0 0 4명이어야 박수치는데 2명이니깐 2명고용해야함!!
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			String[] tmp = br.readLine().split("");
			int N = tmp.length; // 조건
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(tmp[i]);
			}
			System.out.println(Arrays.toString(arr));
			int idx = arr[0];
			for (int i = 1; i < N; i++) {
				if (idx >= i) { //현재idx가 i보다 크다면 박수치는사람 더해주기
					idx += arr[i];
				} else {
					ans += i - idx;//차이
					idx += (i - idx) + arr[i];//차이에 arr[i]만큼 더해주기
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
