import java.io.*;
import java.util.*;

public class Solution_1206 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "100\r\n"
				+ "0 0 225 214 82 73 241 233 179 219 135 62 36 13 6 71 179 77 67 139 31 90 9 37 93 203 150 69 19 137 28 174 32 80 64 54 18 0 158 73 173 20 0 102 107 48 50 161 246 145 225 31 0 153 185 157 44 126 153 233 0 201 83 103 191 0 45 0 131 87 97 105 97 209 157 22 0 29 132 74 2 232 44 203 0 51 0 244 212 212 89 53 50 244 207 144 72 143 0 0";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		for (int tc = 1; tc <= 1; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}//받아왔다
			
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
