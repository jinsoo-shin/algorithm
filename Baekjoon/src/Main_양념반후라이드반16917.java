import java.io.*;
import java.util.*;

public class Main_양념반후라이드반16917 {
//	public class Main {
	public static void main(String[] args) throws Exception {
//		String src = "1500 2000 500 90000 100000";// 100000000
//		String src = "1500 2000 1600 3 2";//7900
		String src = "1500 2000 1900 3 2";// 8500
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());// 양념가격
		int B = Integer.parseInt(st.nextToken());// 후라이드 가격
		int C = Integer.parseInt(st.nextToken());// 반반 가격
		int x = Integer.parseInt(st.nextToken());// 최소 양념
		int y = Integer.parseInt(st.nextToken());// 최소 후라이드

		int ans = 0;
		if ((A + B) > 2 * C) {// 양념 후라이드 사는것보다 반반 2마리가 싸다면...
			if (x >= y) {
				ans += C * y * 2;
				x = x - y;
				y = 0;
				if (A > 2 * C) {
					ans += C * 2 * x;
				} else {
					ans += A * x;
				}
			} else {
				ans += C * x * 2;
				y = y - x;
				x = 0;
				if (B > 2 * C) {
					ans += C * y * 2;
				} else {
					ans += B * y;
				}
			}
		} else {// 각각 사는게 더 싸다면...
			ans += A * x + B * y;
		}

		System.out.println(ans);
//답 7900
	}

}