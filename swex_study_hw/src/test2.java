import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.function.ToDoubleBiFunction;

public class test2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = 4;
		int arr[][] = new int[N][N];

		int t = 1;
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
////				System.out.print(i + ":" + j + "=" + t + " ");
//				arr[i][j] = t++;
//			}
////			System.out.println();
//		}

//		for(int[] row:arr)
//		System.out.println(Arrays.toString(row));
		boolean flag1 = true;// true면 +
		boolean flag2 = true;// true면 +

		int x = 0;
		int y = -1;
		for (int i = 1; i <= 2 * N - 1; i++) {
			if (i % 2 == 1) {// 열 +-
				if (flag1) {// +

					for (int j = 1; j <= N - (i / 2); j++) {
//						System.out.println(arr[x][y + j]);
						arr[x][y + j] = t++;
					}
					y = y + (N - i / 2);
					flag1 = false;
				} else {// -
					for (int j = 1; j <= N - (i / 2); j++) {
//						System.out.println(arr[x][y - j]);
						arr[x][y - j] = t++;
					}
					y = y - (N - i / 2);
					flag1 = true;
				}
				System.out.println("i=" + i + " x=" + x + " y=" + y);
			} else {// 행+-
				if (flag2) {
					for (int j = 1; j <= N - (i / 2); j++) {
//						System.out.println(arr[x + j][y]);
						arr[x + j][y] = t++;
					}
					x = x + (N - i / 2);
					flag2 = false;
				} else {
					for (int j = 1; j <= N - (i / 2); j++) {
//						System.out.println(arr[x - j][y]);
						arr[x - j][y] = t++;

					}
					x = x - (N - i / 2);
					flag2 = true;
				}
//				System.out.println("i=" + i + " x=" + x + " y=" + y);
			}

		}
		for(int[] row:arr) {
			System.out.println(Arrays.toString(row));
		}
	}

}
