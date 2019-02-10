package swex;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_6719 {

	static int refor(int N, int K) {
		if (K == 0) {
			return 1;
		}
		return N * refor(N - 1, K - 1);
	}

	
	static void test1(int N, int K) {
		for(int i=0;i<(1<<N);i++) {
			for(int j=0;j<N;j++) {
				if((i&(1<<j))!=0) {
					System.out.print(j+" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {

		// Scanner sc=new Scanner(System.in);
		int[] arr = { 1, 2, 3, 4 };

		int N = 4;
		int K = 2;
		System.out.println(1 << N);

		int nk = refor(N, K);
		int[][] tmp = new int[nk][K]; //조합!!
		
		test1(N,K);
//		test(N, K, tmp);
//		
//		for(int[] row:tmp) {
//			
//			System.out.println(Arrays.toString(row));
//		}
	}

}
