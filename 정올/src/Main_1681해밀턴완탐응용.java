import java.io.*;
import java.util.*;

public class Main_1681해밀턴완탐응용 {
//	public class Main {
	public static void main(String[] args) throws Exception {
//		String src = "5\r\n" + "0 14 4 10 20\r\n" + "14 0 7 8 7\r\n" + "4 5 0 7 16\r\n" + "11 7 9 0 2\r\n"
//				+ "18 7 17 4 0";
//		String src = "3\r\n" + "0 86 0 \r\n" + "69 0 83 \r\n" + "45 97 0 ";
//		String src = "6\r\n" + "0 93 23 32 39 46 \r\n" + "0 0 7 58 59 13 \r\n" + "40 98 0 14 33 98 \r\n"
//				+ "3 39 0 0 13 16 \r\n" + "51 25 19 88 0 47 \r\n" + "65 81 63 0 6 0 ";
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		N = sc.nextInt();
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		memo = new int[1 << N][N];
		System.out.println(dfs(map, 0, 0, 0));

	}

	static int[][] memo;
	static int N;

	static int dfs(int[][] map, int status, int idx, int current) {
		// sum은 int로 들고다님
		// boolean대신 status로 방문체크
		if (idx == map.length - 1) {
			if (map[current][0] == 0) {
				return 987654321;
			} else {
				return map[current][0];
			}
		}
		if (memo[status][current] != 0) {
			return memo[status][current];
		}
		int opt = 987654321;
		for (int i = 1; i < N; i++) {
			// 아직 안간곳이면서 갈수있으면
			int mask = 1 << i;// 1을 i만큼 민 비트마스크
			if ((mask & status) == 0 && map[current][i] != 0) {
				int tmp = dfs(map, status | mask, idx + 1, i) + map[current][i];
				opt = Math.min(opt, tmp);
			}

		}
		memo[status][current] = opt;
		return opt;

	}
}