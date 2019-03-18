import java.io.*;
import java.util.*;

public class Solution_숫자만들기 {
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
			suf = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int idx = 0;
			for (int i = 0; i < 4; i++) {
				int tmp = Integer.parseInt(st.nextToken());// + - * /
				for (int j = 0; j < tmp; j++) {
					suf.add(s.charAt(i));
					idx++;
				}
			}
			check = new HashMap<>();
			set = new TreeSet<>();
			st = new StringTokenizer(br.readLine());
			num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < suf.size(); i++) {
				boolean[] useS = new boolean[suf.size()];
				useS[i] = true;
				String tmpKey = String.valueOf(num[0]) + suf.get(i) + num[1];
				if (check.containsKey(tmpKey)) {
//					System.out.println("중복");
					cal(check.get(tmpKey), 2, useS);
				} else {
					int tmpNum = calculate(num[0], num[1], suf.get(i));
					check.put(tmpKey, tmpNum);
					cal(tmpNum, 2, useS);//
				}

			}
			List<Integer> list = new ArrayList<>(set);
			int ans = list.get(list.size() - 1) - list.get(0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static HashMap<String, Integer> check;
	static List<Character> suf;
	static Set<Integer> set;
	static int[] num;
//	static String[] s = { "+", "-", "*", "/" };
	static String s = "+-*/";

	static void cal(int numCal, int idx, boolean[] useS) {
		if (idx == num.length) {
			if (!set.contains(numCal))
				set.add(numCal);
			return;
		}

		for (int i = 0; i < suf.size(); i++) {
			if (useS[i]) {
				continue;
			} else {
				if (num[idx] == 0 && i == 3) {
					continue;
				}
				useS[i] = true;
				String tmpKey = String.valueOf(numCal) + suf.get(i) + num[idx];
				if (check.containsKey(tmpKey)) {
					cal(check.get(tmpKey), idx + 1, useS);
				} else {
					int tmpNum = calculate(numCal, num[idx], suf.get(i));
					check.put(tmpKey, tmpNum);
					cal(tmpNum, idx + 1, useS);//
				}
				useS[i] = false;
			}
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
