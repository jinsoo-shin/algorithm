import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_2178 {
//	public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/input.txt"));
//		InputStream input = Solution_기본.class.getResourceAsStream("jump.txt");
//		String src = "4 6\r\n" + "101111\r\n" + "101010\r\n" + "101011\r\n" + "111011";
		String src = "2 25\r\n" + "1011101110111011101110111\r\n" + "1110111011101110111011101";
//		String src = "4 6\r\n" + "110110\r\n" + "110110\r\n" + "111111\r\n" + "111101";
//		Scanner sc = new Scanner(new InputStreamReader(System.in));
		Scanner sc = new Scanner(src);

		row = sc.nextInt();
		col = sc.nextInt();
		ans = Integer.MAX_VALUE;
		int[][] arr = new int[row][col];
		for (int i = 0; i < row; i++) {
//			String[] tmp = sc.next().split("");
			String tmp = sc.next();
			for (int j = 0; j < col; j++) {
//				arr[i][j] = Integer.parseInt(tmp[j]);
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}
		dfs(arr, 0, 0, 1, new boolean[row][col]);
		System.out.println(ans);
	}

	static int[][] dxy = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int row, col, ans;

	// 위 오 아 왼
	static void dfs(int[][] arr, int x, int y, int cnt, boolean[][] visited) {
		// 맵, 방문할 좌표, 지금까지 카운트

		// 현재좌표에서 지도 밖으로 나가지않으면서 동서남북으로 이동//
		// 1인값을 가지는 곳 재귀호출

		if (x == row - 1 && y == col - 1) {
			if (ans > cnt) {
				ans = cnt;
			}
			return;
		}
		if (x == 0 && y == 0) {
			visited[x][y] = true;
		}

		for (int i = 0; i < dxy.length; i++) {// 동서남북
			int cx = x + dxy[i][0];
			int cy = y + dxy[i][1];
			if (cx >= 0 && cx < row && cy >= 0 && cy < col) {// 범위안에있고
				if (arr[cx][cy] == 1 && !visited[cx][cy]) {// 방문한적없고 1이라면
					visited[cx][cy] = true;
					dfs(arr, cx, cy, cnt + 1, visited);
					visited[cx][cy] = false;
				}
			}
		}
	}
}