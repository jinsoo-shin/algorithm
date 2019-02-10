package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_6855 {

	static int[] arr;
	static int N, K;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		String str = "1\r\n7 3\r\n" + "4 7 11 18 22 27 29";
//		String str="1\r\n25 10\r\n1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25";
		String str="6\r\n" + 
				"5 2\r\n" + 
				"20 40 50 80 110\r\n" + 
				"7 3\r\n" + 
				"4 7 11 18 22 27 29\r\n" + 
				"1 1\r\n" + 
				"105\r\n" + 
				"2 1\r\n" + 
				"0 100\r\n" + 
				"3 5\r\n" + 
				"33 77 99\r\n" + 
				"6 4\r\n" + 
				"0 100 200 300 400 500";
//		String str = "1\r\n6 4\r\n" + "0 100 200 300 400 500";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(str));
		int T = Integer.parseInt(br.readLine());
		int answer;
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(Arrays.toString(arr));
			if (N <= K) {
				answer = 0;
			} else {
				re(0, 0, 0, 0);
				answer = min;
			}

			System.out.println("#" + tc + " " + answer);
		}
	}

	// k는 발전소..쪼갠거
	static void re(int start, int end, int k, int sum) {
		if (sum > min) {
			System.out.println();
			return;
		}
		if (k == K - 1) {// 끝인 경우
			end = arr.length - 1;
			sum += arr[end] - arr[start];
			if (sum > min) {
				System.out.println();
				return;
			}
			System.out.print(start + ":" + end + " / " + min+" ");
			min=Math.min(sum, min);
//			min = min > sum ? sum : min;
			System.out.println(min);
			return;
		}
		if (k < K && (end >= arr.length - 1 || start >= arr.length-1)) { // 작은데
			System.out.println();
			return;
		} // 탈출 조건
		System.out.print(start + ":" + end + " / ");
		// 더한것
		re(end + 1, end + 2, k + 1, sum + (arr[end] - arr[start]));
		// 안더한것
		re(start, end + 1, k, sum);

	}

}
