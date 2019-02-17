
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1215 {
	// public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "4\r\n" + "CBBCBAAB\r\n" + "CCCBABCB\r\n" + "CAAAACAB\r\n" + "BACCCCAC\r\n" + "AABCBBAC\r\n"
				+ "ACAACABC\r\n" + "BCCBAABC\r\n" + "ABBBCCAA\r\n" + "4\r\n" + "BCBBCACA\r\n" + "BCAAACAC\r\n"
				+ "ABACBCCB\r\n" + "AACBCBCA\r\n" + "ACACBAAA\r\n" + "ACCACCCB\r\n" + "AACAAABA\r\n" + "CACCABCB\r\n"
				+ "3\r\n" + "BABBBACB\r\n" + "ABCAACCB\r\n" + "CCACBCBA\r\n" + "CACACBCA\r\n" + "CCABACCB\r\n"
				+ "CCBAAAAA\r\n" + "BBACBACA\r\n" + "CBCCBABC\r\n" + "4\r\n" + "ACBBCCCA\r\n" + "CCBCBACB\r\n"
				+ "ACBCABAA\r\n" + "BABCCAAA\r\n" + "ACCCCCBB\r\n" + "AABBCCBC\r\n" + "CCABBACA\r\n" + "CAACBCCC\r\n"
				+ "7\r\n" + "AAACACAB\r\n" + "CCABCCCC\r\n" + "CABCAAAA\r\n" + "BBBCBBBA\r\n" + "ABCCACCC\r\n"
				+ "ABACBCBB\r\n" + "CBABACAB\r\n" + "BBBBBABB\r\n" + "3\r\n" + "ABCBCBCA\r\n" + "ABCBCCCB\r\n"
				+ "ABACCCCA\r\n" + "BBABBBAC\r\n" + "BBACBCCC\r\n" + "AAACACCA\r\n" + "BABCCCBC\r\n" + "ACCBCBCA\r\n"
				+ "7\r\n" + "CACBCCBA\r\n" + "CBCCBCCA\r\n" + "CCBCBCAB\r\n" + "BBCCABAA\r\n" + "CACCBCCC\r\n"
				+ "BCCACCBB\r\n" + "CBCCCBBC\r\n" + "CBACBCBC\r\n" + "5\r\n" + "BCBABCBA\r\n" + "CBBABABC\r\n"
				+ "BCACBAAA\r\n" + "BBABACAB\r\n" + "BCBCCBAC\r\n" + "CBBCBBBB\r\n" + "CBBAACAB\r\n" + "ACCBCBCC\r\n"
				+ "3\r\n" + "BBBBCCAA\r\n" + "BCBBCACC\r\n" + "BBCAAAAB\r\n" + "ABABBABB\r\n" + "BACAAABA\r\n"
				+ "ABACCBCA\r\n" + "ACCAABCB\r\n" + "BACCACBA\r\n" + "5\r\n" + "BCCCACCB\r\n" + "CABCACAB\r\n"
				+ "BAACCCAC\r\n" + "BBABBABC\r\n" + "CCABABCA\r\n" + "CABABACC\r\n" + "CBACACAB\r\n" + "CBCCCBAB\r\n"
				+ "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			int ans = 0;
			int N = Integer.parseInt(br.readLine());
			String[][] map = new String[8][8];
			for (int i = 0; i < 8; i++) {
				map[i] = br.readLine().split("");
				go: for (int j = 0; j < 8 - N + 1; j++) {
					for (int k = 0; k < (N / 2); k++) {
						if (!map[i][j + k].equals(map[i][j + N-1 - k])) {
							continue go;
						}
					}
					ans++;
				}
			}

//			for (int i = 0; i < 8; i++) {
//				go: for (int j = 0; j < 8 - N + 1; j++) {
//					for (int k = 0; k < (N / 2); k++) {
//						if (!map[i][j + k].equals(map[i][j + 3 - k])) {
//							continue go;
//						}
//					}
//					ans++;
//				}
//			}
			for (int i = 0; i < 8; i++) {
				go: for (int j = 0; j < 8 - N + 1; j++) {
					for (int k = 0; k < (N / 2); k++) {
						if (!map[j + k][i].equals(map[j + N-1  - k][i])) {
							continue go;
						}
					}
					ans++;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
