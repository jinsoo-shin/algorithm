import java.io.*;
import java.util.*;

public class Solution_기본 {
//	public class Solution {
	public static void main(String[] args) throws Exception{
		String src = "3\r\n" + 
				"3 17 1 39 8 41 2 32 99 2\r\n" + 
				"22 8 5 123 7 2 63 7 3 46\r\n" + 
				"6 63 2 3 58 76 21 33 8 1\r\n";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			st = new StringTokenizer(br.readLine());

			System.out.println("#" + tc + " " + ans);
		}
	}
}
