import java.io.*;
import java.util.*;

public class Solution_4530 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
//		String src = "3\r\n" + "-1 1\r\n" + "-5 3\r\n" + "-123123123123 789789789789\r\n";
		String src = "1\r\n" + "1 45\r\n";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		arr = new long[13];
		int a = 9;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i - 1] * (10 - 1) + (long) Math.pow(10, i - 1);
			System.out.println(Arrays.toString(arr));
		}

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			String startS = st.nextToken();
			String endS = st.nextToken();

			boolean flagS = false;
			if (startS.charAt(0) == '-') {
				flagS = true;
				startS = startS.substring(1, startS.length());
			}
			boolean flagE = false;
			if (endS.charAt(0) == '-') {
				flagE = true;
				endS = endS.substring(1, endS.length());
			}
			long four = make(startS);
			long four2 = make(endS);

			long ans = 0;
			long startF = Long.parseLong(startS);
			long endF = Long.parseLong(endS);
			if (flagS && flagE) {// 둘다 - -
				if (startF > endF) {
					ans = startF - endF;
					ans -= (four - four2);
				} else {
					ans = endF - startF;
					ans -= (four2 - four);
				}

			} else if (flagS && !flagE) {// - +
				ans = endF + startF - 1;
				ans -= (four2 + four);
			} else if (!flagS && flagE) {// + -
				ans = endF + startF - 1;
				ans -= (four2 + four);
			} else if (!flagS && !flagE) {// + +
				if (startF < endF) {
					ans = endF - startF;
					ans -= (four2 - four);
				} else {
					ans = startF - endF;
					ans -= (four - four2);
				}
			}

//			System.out.println(four + " " + four2);
//			System.out.println(four + " 4의 갯수");
			System.out.println("#" + tc + " " + ans);
		}
	}

	static long[] arr;

	static long make(String startS) {
		long four = 0;// 4의 갯수를 저장한다.

		int startLen = startS.length();
//		System.out.println("길이" + startLen + " " + startS);// 2면 십의자리인데... arr[3]꺼 써야해
		for (int i = 0; i < startS.length(); i++) {
			int firstNum = (startS.charAt(i) - '0');// 첫자리수...
			if (firstNum < 4) {// 첫자리가 4보다 작다면...
//				System.out.println(startLen - i - 1);
				four += arr[startLen - i - 1] * (firstNum);
			} else {// 4보다 크다면...
				four += arr[startLen - i - 1] * (firstNum - 1);
				four += (long) Math.pow(10, startLen - i - 1);
			}
		}
		return four;
	}
}
