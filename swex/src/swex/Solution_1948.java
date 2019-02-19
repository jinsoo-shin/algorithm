package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_1948 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		String src = "3\r\n" + "3 1 3 31\r\n" + "5 5 8 15\r\n" + "7 17 12 24 ";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		
		int[] cal= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int [][]q=new int[2][2];
			for(int i=0;i<2;i++) {
				q[i][0]= Integer.parseInt(st.nextToken());
				q[i][1]= Integer.parseInt(st.nextToken());
			}
			
			for(int i=q[0][0];i<q[1][0];i++) {
				ans+=cal[i];
			}
			ans+=q[1][1]-q[0][1]+1;

			System.out.println("#" + tc + " " + ans);
		}
	}
}
