import java.io.*;
import java.util.*;

import org.xml.sax.HandlerBase;

public class Solution_스타일리쉬들여쓰기 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		String src = "1\r\n" + "5 4\r\n" + "(Follow.my.style\r\n" + ".........starting.from.round.brackets)\r\n"
//				+ "{then.curly.brackets\r\n" + ".....[.and.finally\r\n" + ".......square.brackets.]}\r\n"
//				+ "(Thank.you\r\n" + "{for.showing.me\r\n" + "[all\r\n" + "the.secrets]})";
//		String src= "1\r\n" +"";
//		String src = "1\r\n" + "4 2\r\n" + "(This.time.I.will.show.you\r\n" + ".........(how.to.use.round.brackets)\r\n"
//				+ ".........[but.not.about.square.brackets]\r\n" + ".........{nor.curly.brackets})\r\n"
//				+ "[I.have.not.learned\r\n" + "how.to.use.square.brackets]";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			P = new String[p];
			Q = new String[q];
			style = new int[p + 1][6];
			com = new int[p];
			for (int i = 0; i < p; i++) {
				P[i] = br.readLine();
//				System.out.println(P[i]);
				int tmp[] = new int[6];

				if (P[i].contains("(")) {
					tmp[0]++;
				}
				if (P[i].contains(")")) {
					tmp[1]++;
				}
				if (P[i].contains("{")) {
					tmp[2]++;
				}
				if (P[i].contains("}")) {
					tmp[3]++;
				}
				if (P[i].contains("[")) {
					tmp[4]++;
				}
				if (P[i].contains("]")) {
					tmp[5]++;
				}
				for (int j = 0; j < 6; j++) {
					style[i + 1][j] = style[i][j] + tmp[j];
				}
				for (int j = 0; j < P[i].length(); j++) {
					if (P[i].charAt(j) == '.') {
						com[i]++;
					} else {
						break;
					}
				}
//				System.out.println(com[i]);
//				System.out.println("줄 abcdef" + Arrays.toString(style[i + 1]));
//				System.out.println("--------------------------------");
			}
			flag = 0;
			ansArr = new int[3];
//			per(new int[3], 0);
//			for (int i = 0; i < 3; i++) {
//				if (style[p][2 * i] + style[p][2 * i + 1] == 0) {
//					ansArr[i] = -10000;
//				}
//			}
//			StringBuilder sb = new StringBuilder();
//			sb.append("#" + tc + " ");
			tmpStyle = new int[q + 1][6];
			for (int i = 0; i < q; i++) {
				Q[i] = br.readLine();
				int tmp[] = new int[6];

				if (Q[i].contains("(")) {
					tmp[0]++;
				}
				if (Q[i].contains(")")) {
					tmp[1]++;
				}
				if (Q[i].contains("{")) {
					tmp[2]++;
				}
				if (Q[i].contains("}")) {
					tmp[3]++;
				}
				if (Q[i].contains("[")) {
					tmp[4]++;
				}
				if (Q[i].contains("]")) {
					tmp[5]++;
				}
				for (int j = 0; j < 6; j++) {
					tmpStyle[i + 1][j] = tmpStyle[i][j] + tmp[j];
				}
			}

			set = new HashSet<>();
			per(new int[3], 0);
			System.out.println(set.size());
			System.out.println(Arrays.toString(ansArr));
			System.out.println("#" + tc + " ");
//			System.out.println(sb.toString());
		}
	}

	static int[][] tmpStyle;
	static Set<String> set;
	static String[] P, Q;
	static int p, q;
	static int flag;
	static int[][] style;
	static int[] com;
	static int[] ansArr;

	static void calQ(int[] arr) {
		String tmpStr = "";
		for (int i = 0; i < q; i++) {
			int tmpC = 0;
			for (int k = 0; k < 3; k++) {
				tmpC += arr[k] * (tmpStyle[i][2 * k] - tmpStyle[i][2 * k + 1]);
			}
			tmpStr += tmpC + " ";
		}
		set.add(tmpStr);
	}

	static void cal(int[] rcs) {
//		System.out.println("----");
		for (int r = 1; r < p; r++) {
			System.out.println("이전 abcdef" + Arrays.toString(style[r]));
			System.out.println("들여쓰기" + com[r]);
			int tmpC = 0;
			for (int i = 0; i < 3; i++) {
				tmpC += rcs[i] * (style[r][2 * i] - style[r][2 * i + 1]);
			}
//			System.out.println(tmpC + "쨔란");
			if (com[r] != tmpC) {
				return;
			}
		}
		System.out.println("찾음" + Arrays.toString(rcs));
//		System.out.println(flag);
		calQ(rcs);
//		for (int i = 0; i < 3; i++) {
//			ansArr[i] = rcs[i];
//		}
	}

	static void per(int[] arr, int idx) {
		if (idx == arr.length) {
			cal(arr);
			return;
		}
		for (int i = 1; i <= 20; i++) {
			arr[idx] = i;
			per(arr, idx + 1);
		}
	}
}
