import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution_3260 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
		String src = "1\r\n" + "169 49";
//		String src = "1\r\n" + "100000000000000000000000001 9";
//		String src = "2\r\n" + "1 2\r\n" + "100000000000000000000000001 9";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			BigInteger A = new BigInteger(st.nextToken());
			BigInteger B = new BigInteger(st.nextToken());
			BigInteger ans = A.add(B);
			System.out.println("#" + tc + " " + ans);
		}
	}
}