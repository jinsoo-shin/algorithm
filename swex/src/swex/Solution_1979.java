package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_1979 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		String src = "10\r\n" + 
				"5 3\r\n" + "0 0 1 1 1\r\n" + "1 1 1 1 0\r\n" + "0 0 1 0 0\r\n" + "0 1 1 1 1\r\n" + "1 1 1 0 1\r\n"
				+ "5 3\r\n" + "1 0 0 1 0\r\n" + "1 1 0 1 1\r\n" + "1 0 1 1 1\r\n" + "0 1 1 0 1\r\n" + "0 1 1 1 0 \r\n"
				+ "8 3\r\n" + "1 1 0 1 0 1 1 1\r\n" + "0 1 0 1 0 0 0 1\r\n" + "1 1 1 0 0 1 0 1\r\n"
				+ "0 1 0 1 0 1 1 1\r\n" + "0 0 0 1 0 1 0 1\r\n" + "1 1 1 1 1 1 0 0\r\n" + "0 1 0 0 0 1 0 1\r\n"
				+ "1 1 1 0 1 1 1 1 \r\n" + "8 4\r\n" + "0 1 1 1 0 1 1 1\r\n" + "1 0 0 1 0 1 0 0\r\n"
				+ "1 0 0 1 1 1 0 1\r\n" + "1 1 1 0 0 1 1 1\r\n" + "0 0 1 0 0 1 0 1\r\n" + "1 1 1 1 1 0 0 0\r\n"
				+ "0 1 0 0 1 0 0 0\r\n" + "1 1 1 0 1 1 1 0 \r\n" + "10 3\r\n" + "0 1 0 0 0 1 0 0 0 1\r\n"
				+ "0 1 0 1 0 1 0 1 1 1\r\n" + "1 1 1 1 1 1 1 1 0 1\r\n" + "0 1 0 0 1 0 0 1 0 0\r\n"
				+ "0 1 1 1 1 0 1 1 1 0\r\n" + "0 0 0 1 0 1 0 0 1 0\r\n" + "0 1 1 1 0 1 1 1 1 1\r\n"
				+ "0 1 0 0 0 1 0 0 0 1\r\n" + "1 1 1 0 0 0 0 1 1 1\r\n" + "0 0 1 1 1 0 0 1 0 0 \r\n" + "10 4\r\n"
				+ "0 0 1 0 0 0 1 0 0 1\r\n" + "0 0 1 1 0 0 1 1 1 1\r\n" + "1 1 1 1 1 1 1 1 0 1\r\n"
				+ "0 0 1 0 1 0 0 1 0 0\r\n" + "0 1 1 1 1 1 0 1 1 1\r\n" + "0 0 0 1 0 0 1 0 1 0\r\n"
				+ "0 1 1 1 0 1 1 1 0 1\r\n" + "0 0 1 0 0 0 1 0 0 1\r\n" + "1 1 1 0 0 0 0 1 1 1\r\n"
				+ "0 1 0 1 1 0 1 1 1 0 \r\n" + "12 3\r\n" + "0 1 0 1 0 1 0 1 0 1 0 1\r\n"
				+ "1 1 0 1 1 1 0 1 1 1 0 1\r\n" + "0 1 1 1 0 1 1 1 0 1 1 1\r\n" + "0 0 1 0 0 0 1 0 0 0 1 0\r\n"
				+ "0 1 1 1 0 1 1 1 0 1 1 1\r\n" + "1 1 0 1 1 1 0 1 1 1 0 1\r\n" + "0 1 1 1 0 1 1 1 0 1 1 1\r\n"
				+ "0 0 1 0 0 0 1 0 0 0 1 0\r\n" + "0 1 1 1 0 1 1 1 0 1 1 1\r\n" + "1 1 0 1 1 1 0 1 1 1 0 1\r\n"
				+ "0 1 1 1 0 1 1 1 0 1 1 1\r\n" + "0 0 1 0 0 0 1 0 0 0 1 0 \r\n" + "12 4\r\n"
				+ "0 1 1 1 0 1 1 1 0 1 1 1\r\n" + "1 1 0 1 1 1 0 1 1 1 0 1\r\n" + "1 1 1 1 1 1 1 1 1 1 1 1\r\n"
				+ "1 0 1 0 1 0 1 0 1 0 1 0\r\n" + "0 1 1 1 0 1 1 1 0 1 1 1\r\n" + "1 1 0 1 1 1 0 1 1 1 0 1\r\n"
				+ "1 1 1 1 1 1 1 1 1 1 1 1\r\n" + "1 0 1 0 1 0 1 0 1 0 1 0\r\n" + "0 1 1 1 0 1 1 1 0 1 1 1\r\n"
				+ "1 1 0 1 1 1 0 1 1 1 0 1\r\n" + "1 1 1 1 1 1 1 1 1 1 1 1\r\n" + "1 0 1 0 1 0 1 0 1 0 1 0 \r\n"
				+ "15 3\r\n" + "1 1 1 0 1 1 1 0 1 1 1 0 1 1 1\r\n" + "0 1 1 1 0 1 1 1 0 1 1 1 0 1 1\r\n"
				+ "1 0 1 1 1 0 1 1 1 0 1 1 1 0 1\r\n" + "1 1 0 1 1 1 0 1 1 1 0 1 1 1 0\r\n"
				+ "1 1 1 0 1 1 1 0 1 1 1 0 1 1 1\r\n" + "0 1 1 1 0 1 1 1 0 1 1 1 0 1 1\r\n"
				+ "1 0 1 1 1 0 1 1 1 0 1 1 1 0 1\r\n" + "1 1 0 1 1 1 0 1 1 1 0 1 1 1 0\r\n"
				+ "1 1 1 0 1 1 1 0 1 1 1 0 1 1 1\r\n" + "0 1 1 1 0 1 1 1 0 1 1 1 0 1 1\r\n"
				+ "1 0 1 1 1 0 1 1 1 0 1 1 1 0 1\r\n" + "1 1 0 1 1 1 0 1 1 1 0 1 1 1 0\r\n"
				+ "1 1 1 0 1 1 1 0 1 1 1 0 1 1 1\r\n" + "0 1 1 1 0 1 1 1 0 1 1 1 0 1 1\r\n"
				+ "1 0 1 1 1 0 1 1 1 0 1 1 1 0 1\r\n" + "15 2\r\n" + "1 1 1 0 1 1 1 0 1 1 1 0 1 1 1\r\n"
				+ "0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\r\n" + "1 0 1 1 1 0 1 1 1 0 1 1 1 0 1\r\n"
				+ "0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\r\n" + "1 1 1 0 1 1 1 0 1 1 1 0 1 1 1\r\n"
				+ "0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\r\n" + "1 0 1 1 1 0 1 1 1 0 1 1 1 0 1\r\n"
				+ "0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\r\n" + "1 1 1 0 1 1 1 0 1 1 1 0 1 1 1\r\n"
				+ "0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\r\n" + "1 0 1 1 1 0 1 1 1 0 1 1 1 0 1\r\n"
				+ "0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\r\n" + "1 1 1 0 1 1 1 0 1 1 1 0 1 1 1\r\n"
				+ "0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\r\n" +				"1 0 1 1 1 0 1 1 1 0 1 1 1 0 1\r\n";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int answer = 0;
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}

			}
			for(int[] row:arr)
			System.out.println(Arrays.toString(row));
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						cnt++;
					} else {
						cnt = 0; // 초기화
					}
					if (cnt == K && j + 1 < N && arr[i][j + 1] == 0) {
						answer++;
					}else if(cnt ==K && j+1==N) {
						answer++;
					}
				}

			}

			for (int j = 0; j < N; j++) {
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					if (arr[i][j] == 1) {
						cnt++;
					} else if(arr[i][j] ==0) {
						cnt = 0;
					}
					if (cnt == K && i + 1 < N && arr[i + 1][j] == 0) {
						answer++;
					}else if(cnt ==K && i+1==N) {
						answer++;
					}
				}

			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
