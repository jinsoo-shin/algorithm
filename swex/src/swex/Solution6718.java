package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6718 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "3\r\n" + "99\r\n" + "100\r\n" + "10000000";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] tmp=br.readLine().split("");
			int ans=tmp.length-2;
			if(ans<0) {
				ans=0;
			}else if(ans>5) {
				ans=5;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
