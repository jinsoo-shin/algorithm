import java.io.*;
import java.util.*;

import org.xml.sax.HandlerBase;

public class Solution_스타일리쉬들여쓰기2 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "5 4\r\n" + "(Follow.my.style\r\n" + ".........starting.from.round.brackets)\r\n"
				+ "{then.curly.brackets\r\n" + ".....[.and.finally\r\n" + ".......square.brackets.]}\r\n"
				+ "(Thank.you\r\n" + "{for.showing.me\r\n" + "[all\r\n" + "the.secrets]})";
//		String src= "1\r\n" +"";
//		String src = "1\r\n" + "4 2\r\n" + "(This.time.I.will.show.you\r\n" + ".........(how.to.use.round.brackets)\r\n"
//				+ ".........[but.not.about.square.brackets]\r\n" + ".........{nor.curly.brackets})\r\n"
//				+ "[I.have.not.learned\r\n" + "how.to.use.square.brackets]";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			P = new String[p];
			Q = new String[q];
			for (int i = 0; i < p; i++) {
				P[i] = br.readLine();
			}
			for (int i = 0; i < q; i++) {
				Q[i] = br.readLine();
			}
			int result[] = new int[q];
			Arrays.fill(result, -100);
			for (int i = 1; i <= 20; i++) {
				for (int j = 1; j <= 20; j++) {
					for (int k = 1; k <= 20; k++) {
						if (isOk(P, i, j, k)) {
							calIndent(i, j, k, result);
						}
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			for (int i = 0; i < q; i++) {
				sb.append(result[i]).append(" ");
			}
			System.out.println(sb.toString());
		}
	}

	static void calIndent(int r, int c, int s, int[] result) {
		int rCnt = 0;
		int cCnt = 0;
		int sCnt = 0;
		for (int i = 0; i < q; i++) {
			int indent = r * rCnt + c * cCnt + s * sCnt;
			if (result[i] == -100) {
				result[i] = indent;
			} else {
				if (result[i] != indent) {
					result[i] = -1;
				}
			}
			for (int j = 0; j < Q[i].length(); j++) {
				switch (Q[i].charAt(j)) {
				case '(':
					rCnt++;
					break;
				case ')':
					rCnt--;
					break;
				case '{':
					cCnt++;
					break;
				case '}':
					cCnt--;
					break;
				case '[':
					sCnt++;
					break;
				case ']':
					sCnt--;
					break;
				}
			}
		}
	}

	static boolean isOk(String[] P, int r, int c, int s) {
		int tmp[] = new int[6];
		int rCnt = 0;
		int cCnt = 0;
		int sCnt = 0;
		for (int i = 0; i < p; i++) {
			int indent = r * rCnt + c * cCnt + s * sCnt;
			int comma = 0;
			for (int k = 0; k < P[i].length(); k++) {
				if (P[i].charAt(k) == '.') {
					comma++;
				} else {
					break;
				}
			}
			if (comma != indent) {
				return false;
			}
			for (int j = 0; j < P[i].length(); j++) {
				switch (P[i].charAt(j)) {
				case '(':
					rCnt++;
					break;
				case ')':
					rCnt--;
					break;
				case '{':
					cCnt++;
					break;
				case '}':
					cCnt--;
					break;
				case '[':
					sCnt++;
					break;
				case ']':
					sCnt--;
					break;
				}
			}
		}
		return true;
	}

	static String[] P, Q;
	static int p, q;

}
