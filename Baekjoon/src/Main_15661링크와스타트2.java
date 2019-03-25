import java.io.*;
import java.util.*;

public class Main_15661링크와스타트2 {
//	public class Main {
	public static void main(String[] args) throws Exception {
//		String src = "6\r\n" + "0 1 2 3 4 5\r\n" + "1 0 2 3 4 5\r\n" + "1 2 0 3 4 5\r\n" + "1 2 3 0 4 5\r\n"
//				+ "1 2 3 4 0 5\r\n" + "1 2 3 4 5 0";
//		String src = "4\r\n" + "0 1 2 3\r\n" + "4 0 5 6\r\n" + "7 1 0 2\r\n" + "3 4 5 0";
//		br = new BufferedReader(new StringReader(src));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		ans = Integer.MAX_VALUE;
		per(0, 0, new boolean[N]);
		System.out.println(ans);
	}

	static int N, ans;
	static int[][] arr;
	static int[] tmpArr1, tmpArr2;

	static void per(int idx, int cnt, boolean[] flag) {
		if (idx == N) {

			if (0 < cnt && cnt <= N / 2) {
				tmpArr1 = new int[cnt];
				tmpArr2 = new int[N - cnt];
				int idx1 = 0;
				int idx2 = 0;
				for (int i = 0; i < N; i++) {
					if (flag[i]) {
						tmpArr1[idx1++] = i;
					} else {
						tmpArr2[idx2++] = i;
					}
				}
				int tmpA = 0;
				int tmpB = 0;
				for (int i = 0; i < tmpArr1.length - 1; i++) {
					for (int j = i + 1; j < tmpArr1.length; j++) {
						tmpA += arr[tmpArr1[i]][tmpArr1[j]];
						tmpA += arr[tmpArr1[j]][tmpArr1[i]];
					}
				}
				for (int i = 0; i < tmpArr2.length - 1; i++) {
					for (int j = i + 1; j < tmpArr2.length; j++) {
						tmpB += arr[tmpArr2[i]][tmpArr2[j]];
						tmpB += arr[tmpArr2[j]][tmpArr2[i]];
					}
				}
				ans = Math.min(ans, Math.abs(tmpA - tmpB));
			}
			return;
		}
		flag[idx] = true;
		per(idx + 1, cnt + 1, flag);
		flag[idx] = false;
		per(idx + 1, cnt, flag);
	}

}