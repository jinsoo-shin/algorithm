import java.io.*;
import java.util.*;

public class Solution_점심식사시간 {
//	public class Solution {
	public static void main(String[] args) throws Exception{
		String src = "1\r\n" + 
				"5\r\n" + 
				"0 1 1 0 0\r\n" + 
				"0 0 1 0 3\r\n" + 
				"0 1 0 1 0\r\n" + 
				"0 0 0 0 0\r\n" + 
				"1 0 5 0 0";//9
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			int[][]map=new int[N][N];
			st = new StringTokenizer(br.readLine());

			System.out.println("#" + tc + " " + ans);
		}
	}
}
