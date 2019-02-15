package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_1959 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		String src = "1\r\n" + "3 5\r\n" + "1 5 3\r\n"+"3 6 -7 5 4";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int A[], B[], big[], small[];
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int lenA = Integer.parseInt(st.nextToken());
			int lenB = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			A = new int[lenA];
			for (int i = 0; i < lenA; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			B = new int[lenB];
			for (int i = 0; i < lenB; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			if (lenA > lenB) {
				big = A;
				small = B;
			} else {
				big = B;
				small = A;
			}

			for (int i = 0; i < big.length-small.length+1; i++) {
				int tmp = 0;
				for (int j = 0; j < small.length; j++) {
					tmp += big[i + j] * small[j];
				}
				ans=Math.max(tmp, ans);
			}


			System.out.println("#" + tc + " " + ans);
		}
	}
}
