package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_2007 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		String src = "3\r\n" + "KOREAKOREAKOREAKOREAKOREAKOREA\r\n" + "SAMSUNGSAMSUNGSAMSUNGSAMSUNGSA\r\n"
				+ "GALAXYGALAXYGALAXYGALAXYGALAXY";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String tmp = br.readLine();
			int ans = 0;

			go:for(int i=1;i<=10;i++) {
				int idx=0;
				while(tmp.substring(idx, idx+i).equals(tmp.substring(idx+i, idx+i+i))) {
					if(idx==tmp.length()/i) {
						ans=i;
						break go;
					}
					idx++;
				}
				
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
