import java.io.*;
import java.util.*;

public class Solution_7272 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		String src = "1\r\n" + "ABCD EFGH";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		Set<Character> set = new HashSet<>();
		set.add('A');
		set.add('D');
		set.add('O');
		set.add('P');
		set.add('Q');
		set.add('R');
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] str = br.readLine().split(" ");
			String ans = "DIFF";
			int[] A = new int[3];
			int[] B = new int[3];
			for (int i = 0; i < str[0].length(); i++) {
				if (str[0].charAt(i) == 'B') {
					A[0]++;
				} else if (set.contains(str[0].charAt(i))) {
					A[1]++;
				} else {
					A[2]++;
				}
			}
			for (int i = 0; i < str[1].length(); i++) {
				if (str[1].charAt(i) == 'B') {
					B[0]++;
				} else if (set.contains(str[1].charAt(i))) {
					B[1]++;
				} else {
					B[2]++;
				}
			}
			if (A[0] == B[0] && A[1] == B[1] && A[2] == B[2] && str[0].length() == str[1].length()) {
				ans = "SAME";
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
