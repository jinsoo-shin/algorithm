import java.io.*;
import java.util.*;

public class Main_기본 {
//	public class Main {
	public static void main(String[] args) throws Exception {
		String src = "5 8 \r\n" + "1 2 3 \r\n" + "1 3 7 \r\n" + "2 3 10 \r\n" + "2 4 4 \r\n" + "2 5 8 \r\n"
				+ "3 4 6 \r\n" + "3 5 2 \r\n" + "4 5 17";
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		ans = 0;
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();// 가중치
			

		}
	}

	static int N, M, ans;
	static int[][] map;
}