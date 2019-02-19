package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6692 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "1\r\n" + "2\r\n" + "1 3\r\n" + "2 5\r\n" + "5\r\n" + "1\r\n" + "2\r\n" + "3\r\n" + "4\r\n" + "5";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int[][] AB = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				AB[i][0] = Integer.parseInt(st.nextToken());
				AB[i][1] = Integer.parseInt(st.nextToken());
			}

			int P = Integer.parseInt(br.readLine());
			System.out.print("#"+tc);
			for (int p = 0; p < P; p++) {
				int ans=0;
				int bus=Integer.parseInt(br.readLine()); //Cj번 버스 정류장
				for(int i=0;i<AB.length;i++) {
					if(bus>=AB[i][0]&&bus<=AB[i][1]) {
						ans++;
					}
				}
				
				System.out.print(" "+ans);
				
				
			}
			System.out.println();

		}
	}
}
