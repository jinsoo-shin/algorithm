package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_1961 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		String src = "10\r\n" + "3\r\n" + "1 2 3\r\n" + "4 5 6\r\n" + "7 8 9\r\n" + "6\r\n" + "6 9 4 7 0 5\r\n"
				+ "8 9 9 2 6 5\r\n" + "6 8 5 4 9 8\r\n" + "2 2 7 7 8 4\r\n" + "7 5 1 9 7 9\r\n" + "8 9 3 9 7 6\r\n"
				+ "7\r\n" + "9 3 1 8 5 0 5\r\n" + "1 1 1 7 9 1 8\r\n" + "3 6 1 4 7 7 4\r\n" + "3 1 8 5 3 0 7\r\n"
				+ "2 5 2 5 7 6 8\r\n" + "2 8 5 2 6 7 0\r\n" + "0 5 5 9 3 6 0\r\n" + "3\r\n" + "6 0 4\r\n" + "7 9 3\r\n"
				+ "8 1 2\r\n" + "6\r\n" + "1 6 4 0 8 1\r\n" + "0 8 0 4 1 2\r\n" + "7 7 6 8 4 3\r\n" + "8 6 3 8 0 0\r\n"
				+ "5 7 7 7 6 4\r\n" + "9 1 8 1 7 1\r\n" + "3\r\n" + "4 1 9\r\n" + "9 9 7\r\n" + "8 0 1\r\n" + "5\r\n"
				+ "1 0 2 2 7\r\n" + "5 2 4 8 5\r\n" + "4 7 8 2 3\r\n" + "9 6 2 8 5\r\n" + "9 6 1 6 6\r\n" + "3\r\n"
				+ "4 8 3\r\n" + "4 6 3\r\n" + "3 9 6\r\n" + "3\r\n" + "4 9 7\r\n" + "0 1 3\r\n" + "4 4 3\r\n" + "5\r\n"
				+ "1 1 7 4 1\r\n" + "0 7 9 3 5\r\n" + "5 2 5 8 6\r\n" + "6 1 9 0 6\r\n" + "7 0 1 3 9";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			String[][] ans = new String[N][3];
//			for (int i = 0; i < N; i++) {
			int i = 0;
			int j = 0;// i j 는 ans 용!!!!
			for (int a = 0; a < N; a++) {// 90
				sb = new StringBuilder();
				for (int b = N - 1; b >= 0; b--) {
					sb.append(arr[b][a]);
				}
				ans[j++][i] = sb.toString();
			}
			j = 0;
			i++;
			for (int a = N - 1; a >= 0; a--) {// 180
				sb = new StringBuilder();
				for (int b = N - 1; b >= 0; b--) {
					sb.append(arr[a][b]);
				}
				ans[j++][i] = sb.toString();
			}
			j = 0;
			i++;
			for (int a = N - 1; a >= 0; a--) {// 270
				sb = new StringBuilder();
				for (int b = 0; b < N; b++) {
					sb.append(arr[b][a]);
				}
				ans[j][i] = sb.toString();
				j++;
			}
			System.out.println("#" + tc);

			for (int a = 0; a < N; a++) {
				sb = new StringBuilder();
				for (int b = 0; b < 3; b++) {
					sb.append(ans[a][b] + " ");
				}
				System.out.println(sb.toString());
			}
		}
	}
}
