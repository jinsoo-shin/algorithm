import java.io.*;
import java.util.*;

public class Main_동전11047 {
//	public class Main {
	public static void main(String[] args) throws Exception {
//		String src = "10 4200\r\n" + "1\r\n" + "5\r\n" + "10\r\n" + "50\r\n" + "100\r\n" + "500\r\n" + "1000\r\n"
//				+ "5000\r\n" + "10000\r\n" + "50000";
		String src = "10 4790\r\n" + 
				"1\r\n" + 
				"5\r\n" + 
				"10\r\n" + 
				"50\r\n" + 
				"100\r\n" + 
				"500\r\n" + 
				"1000\r\n" + 
				"5000\r\n" + 
				"10000\r\n" + 
				"50000";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 동전 종류
		int K = Integer.parseInt(st.nextToken());// 합!!! 동전개수의 최소...
		int[] arr = new int[K + 1];
		for (int i = 0; i < N; i++) {
			int coin = Integer.parseInt(br.readLine());
			if (i == 0) {
				for (int j = coin; j <= K; j++) {
					arr[j] = arr[j - 1] + 1;
				}

			} else {
				for (int j = coin; j <= K; j++) {
					arr[j] = Math.min(arr[j], arr[j - coin] + 1);
				}
			}
//			System.out.println(Arrays.toString(arr));
		}
		System.out.println(arr[K]);
	}

}