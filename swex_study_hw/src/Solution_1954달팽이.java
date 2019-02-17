
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1954달팽이 {
	// public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String src = "2\r\n" + "3\r\n" + "4";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int arr[][] = new int[N][N];

			int t = 1;
			boolean flag1 = true;// true면 +
			boolean flag2 = true;// true면 +

			int x = 0;
			int y = -1;
			for (int i = 1; i <= 2 * N - 1; i++) {
				if (i % 2 == 1) {// 열 +-
					if (flag1) {// +

						for (int j = 1; j <= N - (i / 2); j++) {
							arr[x][y + j] = t++;
						}
						y = y + (N - i / 2);
						flag1 = false;
					} else {// -
						for (int j = 1; j <= N - (i / 2); j++) {
							arr[x][y - j] = t++;
						}
						y = y - (N - i / 2);
						flag1 = true;
					}
				} else {// 행+-
					if (flag2) {
						for (int j = 1; j <= N - (i / 2); j++) {
							arr[x + j][y] = t++;
						}
						x = x + (N - i / 2);
						flag2 = false;
					} else {
						for (int j = 1; j <= N - (i / 2); j++) {
							arr[x - j][y] = t++;

						}
						x = x - (N - i / 2);
						flag2 = true;
					}
				}

			}
//			for (int[] row : arr) {
//				System.out.println(Arrays.toString(row));
//			}

			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
