package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6485 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n" + "2\r\n" + "0.3 100\r\n" + "0.7 1";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
//			double num[][] = new double[N][2];
			double ans=0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				ans+=Double.parseDouble(st.nextToken())*Double.parseDouble(st.nextToken());
				System.out.println(ans);
//				num[i][0] = Double.parseDouble(st.nextToken());
//				num[i][1] = Double.parseDouble(st.nextToken());
			}

			System.out.println(String.format("#%d %.6f", tc,ans));
		}
	}
}
