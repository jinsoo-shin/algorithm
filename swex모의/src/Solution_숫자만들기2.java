import java.io.*;
import java.util.*;

public class Solution_숫자만들기2 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		String src = "1\r\n" + "5\r\n" + "2 1 0 1\r\n" + "3 5 3 7 9";
//		String src = "1\r\n" + "6\r\n" + "4 1 0 0\r\n" + "1 2 3 4 5 6 ";
		String src = "10\r\n" + "5\r\n" + "2 1 0 1\r\n" + "3 5 3 7 9\r\n" + "6\r\n" + "4 1 0 0\r\n" + "1 2 3 4 5 6 \r\n"
				+ "5\r\n" + "1 1 1 1\r\n" + "9 9 9 9 9 \r\n" + "6\r\n" + "1 4 0 0\r\n" + "1 2 3 4 5 6 \r\n" + "4\r\n"
				+ "0 2 1 0\r\n" + "1 9 8 6\r\n" + "6\r\n" + "2 1 1 1\r\n" + "7 4 4 1 9 3 \r\n" + "7\r\n" + "1 4 1 0\r\n"
				+ "2 1 6 7 6 5 8 \r\n" + "8\r\n" + "1 1 3 2\r\n" + "9 2 5 3 4 9 5 6 \r\n" + "10\r\n" + "1 1 5 2\r\n"
				+ "8 5 6 8 9 2 6 4 3 2 \r\n" + "12\r\n" + "2 1 6 2\r\n" + "2 3 7 9 4 5 1 9 2 5 6 4 ";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());// 수 5개
			int[] suf = new int[4];
			set = new TreeSet<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				suf[i] = Integer.parseInt(st.nextToken());// + - * /
			}
			System.out.println(Arrays.toString(suf));
			st = new StringTokenizer(br.readLine());
			num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(Arrays.toString(num));
			int ans = 0;
			System.out.println("#" + tc + " " + ans);
		}
	}

	static Set<Integer> set;
	static int[] num;
//	static String[] s = { "+", "-", "*", "/" };

	static void cal(int[] suf, int tmpSum, int Idx) {

		if (suf[0] > 0) {

		}

	}

	static int calculate(int num1, int num2, Character suffix) {
		int tmpNum = 0;
		switch (suffix) {
		case '+':
			tmpNum = num1 + num2;
			break;
		case '-':
			tmpNum = num1 - num2;
			break;
		case '*':
			tmpNum = num1 * num2;
			break;
		case '/':
			tmpNum = num1 / num2;
			break;
		}
		return tmpNum;
	}
}
