import java.io.*;
import java.util.*;

public class Solution_보물상자비번 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "16 2\r\n" + "F53586D76286B2D8";
//		String src = "1\r\n" + "12 10\r\n" + "1B3B3B81F75E";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());// 4의 배수
			int K = Integer.parseInt(st.nextToken());
			int ans = 0;
			String num1 = br.readLine();
			String[] num2 = num1.split("");
			Set<String> set = new TreeSet();
			int len = N / 4;
			for (int i = 0; i < len; i++) {// 회전
				for (int j = 0; j < 4; j++) {// 자르기
					String tmp = "";
					for (int k = 0; k < len; k++) {
						int idx = (len * j + i + k) % N;
						tmp += num2[idx];
					}
					set.add(tmp);
				}
			}
			List<String> list = new ArrayList(set);
			int idx = list.size() - K;
			ans = Integer.parseInt(list.get(idx), 16);
			// System.out.println(Integer.toHexString(503).toUpperCase());
//			System.out.println(Integer.parseInt("1F7", 16));
			System.out.println("#" + tc + " " + ans);
		}
	}
}
