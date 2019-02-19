package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6730 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "5\r\n" + "5\r\n" + "10 70 30 50 90\r\n" + "2\r\n" + "30 100\r\n" + "2\r\n" + "100 20\r\n"
				+ "3\r\n" + "40 40 40\r\n" + "7\r\n" + "12 345 678 901 23 45 6";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			int N=Integer.parseInt(br.readLine());
			int h[]=new int[N];
			StringTokenizer st= new StringTokenizer(br.readLine(), " ");
			for(int i=0;i<N;i++) {
				h[i]=Integer.parseInt(st.nextToken());
			}
			
			int up=0;
			int down=0;
			for(int j=1;j<N;j++) {
				int tmp=h[j]-h[j-1];
				if(tmp>0) {
					up=Math.max(up, tmp);
				}else if(tmp<0) {
					down=Math.max(down, Math.abs(tmp));
				}
			}
			System.out.println("#" + tc + " " + up+" "+down);
		}
	}
}
