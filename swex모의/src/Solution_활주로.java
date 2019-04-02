import java.io.*;
import java.util.*;

public class Solution_활주로 {
//	public class Solution {
	public static void main(String[] args) throws Exception {
//		String src = "1\r\n" + "6 2\r\n" + "3 3 3 2 1 1\r\n" + "3 3 3 2 2 1\r\n" + "3 3 3 3 3 2\r\n" + "2 2 3 2 2 2\r\n"
//				+ "2 2 3 2 2 2\r\n" + "2 2 2 2 2 2";
//		String src = "1\r\n" + "9 4\r\n" + "4 4 3 3 3 3 2 2 2 \r\n" + "4 4 3 3 1 1 2 2 3 \r\n"
//				+ "3 3 2 2 1 1 1 1 2 \r\n" + "1 1 1 1 1 1 1 1 1 \r\n" + "1 1 1 1 1 1 1 1 1 \r\n"
//				+ "2 2 1 1 1 1 1 1 1 \r\n" + "2 2 1 1 1 1 1 1 1 \r\n" + "2 2 2 2 2 2 1 1 1 \r\n" + "3 3 3 3 2 2 2 2 1 ";// 4
//		String src="1\r\n" + "10 2\r\n" + 
//				"2 2 3 5 3 1 1 1 1 1 \r\n" + 
//				"2 2 3 5 3 1 1 1 1 1 \r\n" + 
//				"3 3 4 5 4 3 2 1 1 2 \r\n" + 
//				"3 3 4 5 4 3 2 1 1 2 \r\n" + 
//				"5 5 5 5 5 5 3 1 1 3 \r\n" + 
//				"4 4 4 5 5 5 4 3 3 3 \r\n" + 
//				"4 4 4 5 5 5 5 5 5 3 \r\n" + 
//				"4 4 4 4 4 5 5 5 5 3 \r\n" + 
//				"4 4 4 4 4 5 5 5 5 3 \r\n" + 
//				"5 5 4 4 4 5 5 5 5 4 \r\n" + 
//				"12 4";//4
//		String src="1\r\n" + "20 3\r\n" + 
//				"3 3 3 2 2 2 2 3 3 3 4 4 4 4 4 4 5 5 5 5 \r\n" + 
//				"3 3 3 2 2 2 2 3 3 3 4 4 4 4 4 4 5 5 5 5 \r\n" + 
//				"5 3 3 2 2 2 2 2 3 3 4 4 4 4 5 5 5 5 5 5 \r\n" + 
//				"4 3 3 1 1 1 1 1 2 3 4 4 4 5 5 5 5 5 5 5 \r\n" + 
//				"4 2 2 1 1 1 1 1 2 3 4 5 5 5 5 5 5 5 5 5 \r\n" + 
//				"4 3 3 2 2 2 2 1 2 3 4 5 5 5 5 5 5 5 5 5 \r\n" + 
//				"4 4 4 4 4 3 3 2 3 4 5 5 5 5 5 5 5 5 5 5 \r\n" + 
//				"4 3 3 3 3 3 3 3 4 4 4 5 5 5 5 5 5 4 4 4 \r\n" + 
//				"4 3 3 3 3 3 3 3 4 4 4 5 5 5 5 5 5 4 4 4 \r\n" + 
//				"4 3 3 3 3 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 \r\n" + 
//				"3 3 3 3 3 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 \r\n" + 
//				"3 3 3 3 3 4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 \r\n" + 
//				"3 3 3 3 4 4 4 4 5 5 5 5 5 5 5 5 5 5 5 5 \r\n" + 
//				"4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 4 4 4 \r\n" + 
//				"4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 4 4 4 \r\n" + 
//				"5 5 5 5 5 5 5 5 5 5 5 5 4 4 4 4 4 4 4 4 \r\n" + 
//				"5 5 5 5 5 5 5 5 5 5 5 5 3 3 3 3 4 4 4 4 \r\n" + 
//				"5 5 5 5 5 5 5 5 5 5 5 5 3 3 2 2 3 3 4 4 \r\n" + 
//				"5 5 5 5 5 5 5 5 5 5 5 5 3 3 2 2 3 3 4 4 \r\n" + 
//				"5 5 5 5 5 5 5 5 4 4 4 4 3 3 3 3 4 4 4 4 ";//8
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());// 경사로 길이
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
//				System.out.println(Arrays.toString(map[i]));
			}
			ans = 0;
//			System.out.println("----------------------------- 행체크");
			row(map, new boolean[N][N]);
//			System.out.println("----------------------------- 열체크");
			col(map, new boolean[N][N]);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void row(int[][] map, boolean[][] check) {
		// 가로
		next: for (int i = 0; i < N; i++) {// 행
			int cnt = 1;
			for (int j = 1; j < N; j++) {// 열
//				System.out.println("오른쪽점" + i + " " + j);
				if (map[i][j] == map[i][j - 1]) {
					cnt++;
				} else {
					if (map[i][j - 1] + 1 == map[i][j]) {// 오르막길
						for (int k = 1; k <= X; k++) {
							if (!isOk(i, j - k)) {
								continue next;
							}
							if (map[i][j - 1] != map[i][j - k]) {
								continue next;
							}
							if (check[i][j - k]) {
								continue next;
							}
							check[i][j - k] = true;
						}
//						System.out.println(i + "설치가능--------------");
					} else if (map[i][j - 1] == map[i][j] + 1) {// 내리막길
						for (int k = 1; k <= X; k++) {
							if (!isOk(i, j - 1 + k)) {// 활주로 범위체크인데 넘어갔다면 설치 ㄴㄴ
//								System.out.println("범위넘어감 " + i + " " + j);
								continue next;
							}
							if (map[i][j] == map[i][j - 1 + k]) {
							} else {
								continue next;
							}
							if (check[i][j - 1 + k]) {
								continue next;
							}
							check[i][j - 1 + k] = true;
						}
//						System.out.println(i + "설치가능--------------");
					} else {
						continue next;// 높이가 완전다르면 ㄴㄴ
					}
				}
//				if (cnt == N) {
//					System.out.println(i + "전부같아서 가능--------------");
//				}
				if (j == N - 1) {
					ans++;
//					System.out.println("------------살아남음" + i);
				}
			}
		}
	}

	static void col(int[][] map, boolean[][] check) {
		// 가로
		next: for (int j = 0; j < N; j++) {// 열
			int cnt = 1;
			for (int i = 1; i < N; i++) {// 행
//				System.out.println("오른쪽점" + i + " " + j);
				if (map[i][j] == map[i - 1][j]) {// 같은 경우
					cnt++;
				} else {
					if (map[i - 1][j] + 1 == map[i][j]) {// 오르막길
						for (int k = 1; k <= X; k++) {
							if (!isOk(i - k, j)) {
								continue next;
							}
							if (map[i - 1][j] != map[i - k][j]) {
								continue next;
							}
							if (check[i - k][j]) {
								continue next;
							}
							check[i - k][j] = true;
						}
//						System.out.println(i + "설치가능--------------");
					} else if (map[i - 1][j] == map[i][j] + 1) {// 내리막길
						for (int k = 1; k <= X; k++) {
							if (!isOk(i - 1 + k, j)) {// 활주로 범위체크인데 넘어갔다면 설치 ㄴㄴ
								continue next;
							}
							if (map[i][j] != map[i - 1 + k][j]) {
								continue next;
							}
							if (check[i - 1 + k][j]) {
								continue next;
							}
							check[i - 1 + k][j] = true;
						}
//						System.out.println(i + "설치가능--------------");
					} else {
						continue next;// 높이가 완전다르면 ㄴㄴ
					}
				}
				if (i == N - 1) {
					ans++;
//					System.out.println("------------살아남음" + j);
				}
			}
		}
	}

	static boolean isOk(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		}
		return true;
	}

	static int ans, N, X;
}
